<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="register-form">
        <div class="logo-wrapper">
          <img class="logo" src="/static/images/logo.png">
          <div class="tagline">Open source task management tool</div>
        </div>
        <form @submit.prevent="submitForm">
        <div v-show="errorMessage" class="alert alert-danger failed">{{ errorMessage }}</div>
          <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" v-model="form.username">

          </div>
          <div class="form-group">
            <label for="emailAddress">Email address</label>
            <input type="email" class="form-control" id="emailAddress" v-model="form.emailAddress">

          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" v-model="form.password">

          </div>
             <button type="submit" class="btn btn-primary btn-block">Create account</button>
        </form>
      </div>
    </div>
    <footer class="footer">
      <span class="copyright">&copy; 2018 TaskAgile.com</span>
      <ul class="footer-links list-inline float-right">
        <li class="list-inline-item"><a href="#">About</a></li>
        <li class="list-inline-item"><a href="#">Terms of Service</a></li>
        <li class="list-inline-item"><a href="#">Privacy Policy</a></li>
        <li class="list-inline-item"><a href="https://github.com/taskagile/vuejs.spring-boot.mysql" target="_blank">GitHub</a></li>
      </ul>
    </footer>
  </div>
</template>
<script>
import registrationService from '@/services/registration'
import { required, email, minLength, maxLength, alphaNum } from 'vuelidate/lib/validators'
export default {
  name: 'RegisterPage',
  data: function () {
    return {
      form: {
        username: '',
        emailAddress: '',
        password: ''
      },
      errorMessage: ''
    }
  },
  validations: {
    form: {
      username: {
        required,
        minLength: minLength(2),
        maxLenth: maxLength(50),
        alphaNum
      },
      emailAddress: {
        required,
        email,
        maxLength: maxLength(100)
      },
      password: {
        required,
        minLength: minLength(6),
        maxLength: maxLength(30)
      }
    }
  },
  methods: {
    submitForm () {
      // TODO: 데이터 검증하기
      // Vuelidate가 생성해서 Vue 인스턴스에 추가한 $v 객체로 Vuelidate API에 접근한다.
      // $v 객체는 검증에 대한 현재 상태를 가진다.
      // $v.touch() 메소드를 호출해서 데이터 검증을 시작한다. 그다음 $v.invalid 속성으로 결과를 확인한다.
      // 검증이 실패하면 $v.invalid의 값은 true이며 단순히 회원가입 프로세스를 중단한다.
      this.$v.$touch()
      if (this.$v.$invalid) {
        return
      }
      registrationService.register(this.form).then(() => {
        this.$router.push({ name: 'LoginPage' })
      }).catch((error) => {
        this.errorMessage = 'Failed to register user, Reason: ' + (error.message ? error.message : 'Unknown') + '.'
      })
    }
  }
}
</script>
<style lang="scss" scoped>
.container { max-width: 900px;}
.register-form {margin-top: 50px; max-width: 320px;}
.logo-wrapper {margin-bottom: 40px;}
.footer {width: 100%; line-height: 40px; margin-top: 50px;}
</style>
