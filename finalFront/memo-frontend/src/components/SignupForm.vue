<template>
  <!--
    novalidate 속성은 HTML5의 자체적인 유효성 검사를 하지 않도록 설정한 것이다.
    HTML5의 유효성 검사는 브라우저마다 동작이 동일되지 않기 때문에 우리는 직접 유효성 검사를
    진행할 것이다.
   -->
  <form @submit.prevent="submit" novalidate>
    <fieldset>
      <input type="text" v-model="name" placeholder="이름을 입력해 주세요" />
      <input type="email" v-model="email" placeholder="이메일을 입력해 주세요" />
      <input type="password" v-model="password" placeholder="비밀번호를 입력해 주세요" />
      <input type="password" v-model="passwordConfirm" placeholder="비밀번호를 다시 한번 입력해주세요." />
      <button type="submit">회원가입</button>
    </fieldset>
  </form>
</template>


<script>
export default {
  name: 'SignupForm',
  data(){
    return {
      name: '',
      email: '',
      password: '',
      passwordConfirm: ''
    }
  },
  methods: {
    submit () {
      const { name, email, password, passwordConfirm } = this
      if (!name || !email || !password || !passwordConfirm){
        alert('모든 항목을 입력해주세요.');
        return
      }
      if (password !== passwordConfirm){
        alert('비밀번호가 일치하지 않습니다.')
        return
      }
      this.$emit('submit', { name, email, password })
    }
  }
}
</script>
