import Vue from 'vue'
import App from './App.vue'
// import store from './store' 같이 해당 디렉터까지만 경로를 적어주면 그 디렉터리 내에 있는 index.js 파일을 찾아서 불러온다.
// 단, index.js 파일이 해당 디렉터리 내에 없다면 에러가 발생하니 주의해야 한다.
import store from './store'

new Vue({
  el: '#app',
  // Vue 인스턴스에 store 옵션으로 등록한다.
  store,
  render: h => h(App)
})
