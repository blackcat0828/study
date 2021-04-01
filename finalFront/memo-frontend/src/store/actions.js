import api from '@/api'
import {
  SET_ACCESS_TOKEN,
  SET_MY_INFO,
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO,
} from './mutations-types'

export default {
  signin ({ commit }, payload){
    const {email, password} = payload
    api.post(`/auth/signin?email=${email}&&password=${password}`)
      .then(res => {

        const {Authorization} = res.data
        Authorization.trim();
        alert(Authorization)

        commit(SET_ACCESS_TOKEN, Authorization)

        //토큰을 스토어에 저장하면 api 모듈의 headers에 토큰이 저장되므로 바로 사용자 정보를 불러올 수 있다.
        return api.get('/users/me')
      })
      .then(res=> {
        //사용자 정보 요청이 성공했다면 변이를 사용하여 스토어에 사용자 정보를 저장한다.
        alert(res.data.email)
        commit(SET_MY_INFO, res.data)
      })

  },
  // signinByToken ({commit}, token){
  //   // 1. 토큰을 스토어에 커밋한다.
  //   commit(SET_ACCESS_TOKEN, token)
  //   // 2. 사용자의 정보를 받아온 후 스토어에 커밋한다.
  //   return api.get('/users/me')
  //         .then(res => {
  //           commit(SET_MY_INFO, res.data)
  //         })
  // },
  signout ({commit}){
    commit(DESTROY_MY_INFO)
    commit(DESTROY_ACCESS_TOKEN)
  }

}
