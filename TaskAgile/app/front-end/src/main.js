import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'
import Vuelidate from 'vuelidate'

Vue.config.productionTip = false
Vue.use(Vuelidate)
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

// axios 부트스트랩
// 모든 요청에 /api를 추가하지 않아도 동작하도록 baseURL을 설정한다. 여기서는 응답을 JSON 형식으로만 받는다.
// 그리고 에러를 전파하기 위해 인터셉터를 응답에 추가한다.
axios.defaults.baseURL = '/api'
axios.defaults.headers.common.Accept = 'application/json'
axios.interceptors.response.use(
  response => response,
  (error) => {
    return Promise.reject(error)
  }
)
