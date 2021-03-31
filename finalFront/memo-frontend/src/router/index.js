import Vue from 'vue'
import Router from 'vue-router'
import Signup from '@/pages/Signup'
import Signin from '@/pages/Signin'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/signup',
      name: 'Signup',
      components: {

        default: Signup
      }
    },
    {
      path: '/signin',
      name: 'Signin',
      // components 속성이 아닌 component를 사용하면 자동으로 이름이 없는 router-view에만 컴포넌트를 랜더한다.
      components: {

        default: Signin
      }

    },



  ]
})
