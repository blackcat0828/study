import { mount, createLocalVue } from '@vue/test-utils'
import VueRouter from 'vue-router'
import RegisterPage from '@/views/RegisterPage'
import Vuelidate from 'vuelidate'
import registrationService from '@/services/registration'

// vm.$router에 접근할 수 있도록 테스트에 Vue Router 추가하기
// createLocalVue 함수는 이름이 말해주듯 로컬 Vue 클래스를 생성한다. 따라서 로컬 Vue 클래스의 변경 사항은 실제 전역 Vue 클래스에
// 영향을 주지 않는다.
// 또한 VueRouter를 가져온다. beforeEach() 메소드에서는 로컬 Vue 인스턴스와 router 인스턴스를 mount 함수에
// 제공해 wrapper를 생성한다. 여기서 router 인스턴스는 로그인 페이지로 리다이렉션이 발생했는지 확인하는 데 필요하다.
const localVue = createLocalVue()
localVue.use(VueRouter)
localVue.use(Vuelidate)
const router = new VueRouter()

// registrationService의 목
// 위에 import로 가져왔지만 registrationService를 가져오기 전에 jest.mcok() 메소드가 실행된다.
// 왜냐하면 제스트는 jest.mock() 호출을 모듈의 맨 윗부분으로 위치시키기 때문이다. 따라서 가져온 registrationService는
// 사실 이전에 생성했던 __mock__폴더에 있는 목이다.
jest.mock('@/services/registration')
describe('RegisterPage.vue', () => {
  let wrapper
  let fieldUsername
  let fieldEmailAddress
  let fieldPassword
  let buttonSubmit
  let registerSpy

  // beforeEach()를 이용해 변수를 초기화한다.
  beforeEach(() => {
    wrapper = mount(RegisterPage, { localVue, router })
    fieldUsername = wrapper.find('#username')
    fieldEmailAddress = wrapper.find('#emailAddress')
    fieldPassword = wrapper.find('#password')
    buttonSubmit = wrapper.find('form button[type="submit"]')
    // 회원가입 서비스를 위한 스파이 생성
    registerSpy = jest.spyOn(registrationService, 'register')
  })

  it('should render registration form', () => {
    expect(wrapper.find('.logo').attributes().src).toEqual('/static/images/logo.png')
    expect(wrapper.find('.tagline').text()).toEqual('Open source task management tool')
    expect(fieldUsername.element.value).toEqual('')
    expect(fieldEmailAddress.element.value).toEqual('')
    expect(fieldPassword.element.value).toEqual('')
    expect(buttonSubmit.text()).toEqual('Create account')
  })

  // 데이터 모델의 초깃값을 검증하는 테스트
  // wrapper.vm으로 Vue 인스턴스에 접근하며, vm의 모든 메소드와 프로퍼티에 접근할 수 있다.
  // wrapper.vm.form 으로 username, emailAddress, password 프로퍼티에 접근해서 프로퍼티가 빈 문자열로 초기화 됐는지 검증
  it('should contain data model wih initial values', () => {
    expect(wrapper.vm.form.username).toEqual('')
    expect(wrapper.vm.form.emailAddress).toEqual('')
    expect(wrapper.vm.form.password).toEqual('')
  })

  // 폼의 입력과 데이터 모델의 바인딩을 검증하는 테스트
  it('should have form inputs bound with data model', async () => {
    const username = 'sunny'
    const emailAddress = 'sunny@taskagile.com'
    const password = 'VueJsRocks!'

    // 옛날버전 vue/cli에서 사용
    // wrapper.vm.form.username = username
    // wrapper.vm.form.emailAddress = emailAddress
    // wrapper.vm.form.password = password
    await wrapper.setData({
      form: {
        username: username,
        emailAddress: emailAddress,
        password: password
      }
    })
    expect(fieldUsername.element.value).toEqual(username)
    expect(fieldEmailAddress.element.value).toEqual(emailAddress)
    expect(fieldPassword.element.value).toEqual(password)
  })

  // 제출 핸들러의 존재 여부를 확인하는 테스트
  // 제스트를 활용해 stub을 만든다. 그리고 래퍼의 setMethods() API로 기존 제출 핸들러인 submitForm을 만든 스텁으로 대체한다.
  // 그다음 buttonSubmit으로 제출 이벤트를 발생시킨다. 그리고 stub이 호출됐는지 검증한다.
  it('should have form submit event handler `submitForm`', () => {
    const stub = jest.fn()
    wrapper.setMethods({ submitForm: stub })
    buttonSubmit.trigger('submit')
    expect(stub).toBeCalled()
  })

  it('should register when it is a new user', async () => {
    expect.assertions(2)
    const stub = jest.fn()
    // vm.$router의 push() 메소드 스텁을 만들어서 리다이렉트가 발생했는지 확인
    wrapper.vm.$router.push = stub
    await wrapper.setData({
      form: {
        username: 'sunny',
        emailAddress: 'sunny@taskagile.com',
        password: 'Jest!dsfd'
      }
    })
    wrapper.vm.submitForm()
    await expect(registerSpy).toBeCalled()
    // registrationService.register() 메소드는 프로미스 기반이기 때문에 vm.$nextTick()에 expect 구문을 넣어야 한다.
    // 그렇지 않으면 테스트는 항상 실패할 것이다.
    // await wrapper.vm.$nextTick()
    expect(stub).toHaveBeenCalledWith({ name: 'LoginPage' })
  })

  // 회원 가입 실패를 검증하는 테스트
  it('should fail it is not a new user', async () => {
    // 목록에서는 오직 sunny@taskagile.com만 새로운 사용자다
    expect.assertions(3)
    await wrapper.setData({
      form: {
        username: 'ted',
        emailAddress: 'ted@taskagile.com',
        password: 'jest23423'
      }
    })
    expect(wrapper.find('.failed').isVisible()).toBe(false)
    wrapper.vm.submitForm()
    await expect(registerSpy).toBeCalled()
    await wrapper.vm.$nextTick()
    expect(wrapper.find('.failed').isVisible()).toBe(true)
  })

  // 이메일 주소 값이 유효하지 않으면 registrationService.register() 메소드가 호출되지 않는지 검증해 보자
  it('should fail when the email address is invalid', async () => {
    // 스파이 또한 하나의 목 함수다. 스파이는 감시하고 있는 메소드에 대한 호출을 추적할 수 있다.
    // expect(spy).not.toHaveBeenCalled()로 register() 메소드가 호출되지 않은 것을 검증한다.
    // 테스트의 끝부분에서 mockReset()을 호출해서 목에 저장된 모든 메소드 호출을 지우고
    // mockRestore()를 호출해서 register() 메소드를 기존 동작으로 복원한다.
    // const spy = jest.spyOn(registrationService, 'register')
    await wrapper.setData({
      form: {
        username: 'jeffkim',
        emailAddress: 'bad-email-address',
        password: 'sdkfjsdk'
      }
    })
    wrapper.vm.submitForm()
    expect(registerSpy).not.toHaveBeenCalled()
    registerSpy.mockReset()
    registerSpy.mockRestore()
  })

  // 비밀번호 값 유효하지 않으면 registrationService.register() 메소드가 호출되지 않는지 검증해 보자
  it('should fail when the password is invalid', async () => {
    // 스파이 또한 하나의 목 함수다. 스파이는 감시하고 있는 메소드에 대한 호출을 추적할 수 있다.
    // expect(spy).not.toHaveBeenCalled()로 register() 메소드가 호출되지 않은 것을 검증한다.
    // 테스트의 끝부분에서 mockReset()을 호출해서 목에 저장된 모든 메소드 호출을 지우고
    // mockRestore()를 호출해서 register() 메소드를 기존 동작으로 복원한다.
    // const spy = jest.spyOn(registrationService, 'register')
    await wrapper.setData({
      form: {
        useranme: 'jeffkim',
        emailAddress: 'djf@sdfsdf',
        password: '12'
      }
    })
    wrapper.vm.submitForm()
    expect(registerSpy).not.toHaveBeenCalled()
    registerSpy.mockReset()
    registerSpy.mockRestore()
  })

  // 사용자 명이 유효하지 않으면 registrationService.register() 메소드가 호출되지 않는지 검증해 보자
  it('should fail when username is invalid', async () => {
    // 스파이 또한 하나의 목 함수다. 스파이는 감시하고 있는 메소드에 대한 호출을 추적할 수 있다.
    // expect(spy).not.toHaveBeenCalled()로 register() 메소드가 호출되지 않은 것을 검증한다.
    // 테스트의 끝부분에서 mockReset()을 호출해서 목에 저장된 모든 메소드 호출을 지우고
    // mockRestore()를 호출해서 register() 메소드를 기존 동작으로 복원한다.
    // const spy = jest.spyOn(registrationService, 'register')
    await wrapper.setData({
      form: {
        username: 'a',
        emailAddress: 'sdf@dsfdsf',
        password: 'sdfsd12'

      }
    })
    wrapper.vm.submitForm()
    expect(registerSpy).not.toHaveBeenCalled()
    registerSpy.mockReset()
    registerSpy.mockRestore()
  })

  // afterAll() 메소드에서는 jest.restoreAllMocks() 메소드를 호출해서 registrationService를 복구한다.
  // afterAll() 메소드는 파일에 있는 모든 테스트의 실행이 완료되면 호출된다.
  // afterEach() 메소드는 각 테스트가 끝나면 호출한다.
  afterEach(() => {
    jest.restoreAllMocks()
    registerSpy.mockReset()
    registerSpy.mockRestore()
  })

  // it('should render correct contents', () => {
  //   const Constructor = Vue.extend(RegisterPage)
  //   const vm = new Constructor().$mount()
  //   expect(vm.$el.querySelector('.logo').getAttribute('src')).toEqual('/static/images/logo.png')
  //   expect(vm.$el.querySelector('.tagline').textContent).toEqual('Open source task management tool')
  //   expect(vm.$el.querySelector('#username').value).toEqual('')
  //   expect(vm.$el.querySelector('#emailAddress').value).toEqual('')
  //   expect(vm.$el.querySelector('#password').value).toEqual('')
  //   expect(vm.$el.querySelector('form button[type="submit"]').textContent).toEqual('Create account')
  // })
})
