import moxios from 'moxios'
import registrationService from '@/services/registration'

describe('services/registration', () => {
  beforeEach(() => {
    // axios 목 생성
    moxios.install()
  })

  afterEach(() => {
    // 사용한 목 제거
    moxios.uninstall()
  })

  it('should pass the response to caller when request succeeded', () => {
    // 제스트 API expect.assertions()는 어설션(assertion)이 호출되는 횟수를 검증한다.
    expect.assertions(2)
    // moxios.wait()메소드로 목 요청이 만들어질 때까지 기다린다. 이 메소드는 setTimeout()을 기반으로 구현된다.
    moxios.wait(() => {
      let request = moxios.requests.mostRecent()
      // 제스트의 toBeTruthy() API로 최근 요청이 존재하는지 검증한다. 따라서 axios의 요청이 정말로 실행되는지 확인할 수 있다.
      // 그다음 moxios의 respondWith() 메소드로 요청에 대한 응답을 지정한다.
      // 따라서 register() 메소드가 성공적인 응답을 받았는지 확인할 수 있다.
      expect(request).toBeTruthy()
      request.respondWith({
        status: 200,
        response: { result: 'success' }
      })
    })
    // register() 메소드를 호출하고 호출한 결과로 반환된 값이 result 프로퍼티가 성공인지 확인한다.
    // 여기서는 프로미스를 활용하기 때문에 프로미스가 이행(resolve)될 때까지 제스트가 기다릴수 있도록
    // 테스트 메소드의 결과로 프로미스를 반환해야 한다. 프로미스가 실패(reject)하면 테스트는 자동으로
    // 실패한다.
    return registrationService.register().then(data => {
      expect(data.result).toEqual('success')
    })
  })

  // HTTP 요청이 실패하는 시나리오
  it('should propagate the error to caller when request failed', () => {
    expect.assertions(2)
    moxios.wait(() => {
      let request = moxios.requests.mostRecent()
      expect(request).toBeTruthy()
      request.reject({
        status: 400,
        response: { message: 'Bad request' }
      })
    })
    return registrationService.register().catch(error => {
      expect(error.response.message).toEqual('Bad request')
    })
  })

})
