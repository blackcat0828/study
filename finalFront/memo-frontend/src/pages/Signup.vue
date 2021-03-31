<template>
  <div class="sign-up-page">
    <h3>회원 가입</h3>
    <signup-form @submit="onSubmit"/>
    <p>이미 가입하셨나요? <router-link :to="{ name: 'Signin'}">로그인하러 가기</router-link></p>
  </div>
</template>

<script>
import SignupForm from '@/components/SignupForm'
import api from '@/api'

export default {
  name: 'Signup',
  components: { SignupForm },
  methods: {
    onSubmit (payload){
      const {email, password, name} = payload
      api.post('/auth/signup', { name, email, password})
        .then(res => {
          // 회원가입이 성공했다면 사용자에게 회원가입이 성공했다는 메시지를 노출하고 메인화면으로 이동
          alert('회원가입이 완료되었습니다.')
          this.$router.push({ name: 'Signin'})
        })
        .catch(err => {
          // 회원가입이 실패했다면 서버로부터 전송받은 메시지를 보여준다.
          alert(err.response.data.msg)
        })
    }
  }
}
</script>
