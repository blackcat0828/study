import {
  FETCH_POST_LIST,
  FETCH_POST,
  SET_ACCESS_TOKEN,
  SET_MY_INFO,
  DESTROY_ACCESS_TOKEN,
  DESTROY_MY_INFO,
  UPDATE_COMMENT,
  EDIT_COMMENT,
  DELETE_COMMENT
} from './mutations-types'
import api from '@/api'
import Cookies from 'js-cookie'

export default {
  [FETCH_POST_LIST] (state, posts){
    state.posts = posts
  },
  [FETCH_POST] (state, post){
    state.post = post
  },
  [SET_ACCESS_TOKEN] (state, accessToken){
    // 스토어 상태의 토큰을 업데이트하고
    // api 모듈을 사용하여 HTTP 헤더에 토큰을 심어준다.
    if(accessToken) {
      state.accessToken = accessToken

      //common 필드는 이 Axios 객체에서 어떤 메소드든지 상관없이 헤더에 이 값을 사용한다는 것을 의미
        //defaults.headers.get 으로 사용하면 Axios 객체는 GET 메소드를 사용할때만 이값을 헤더에 사용
        //헤더 안에 여러 필드중 Authorization 필드에 토큰값을 담아주는 것이 목적이므로
        //api.defaults.headers.common.Authorization에 접근한 뒤 Bearer 토큰값과 같은 형식으로 값을
        //담아준다.
      api.defaults.headers.common.Authorization = `Bearer ${accessToken}`

      //쿠키에 토큰을 저장
      Cookies.set('accessToken', accessToken)
    }
  },
  [SET_MY_INFO] (state, me){
    if(me){
      state.me = me
    }
  },
  [DESTROY_ACCESS_TOKEN] (state) {
    state.accessToken=''
    delete api.defaults.headers.common.Authorization
    Cookies.remove('accessToken')
  },
  [DESTROY_MY_INFO] (state) {
    state.me = null
  },
  [UPDATE_COMMENT] (state, payload){
    state.post.comments.push(payload)
  },
  [EDIT_COMMENT](state, payload){
    const {id: commentId, contents, updatedAt} = payload
    const targetComment = state.post.comments.find(comment => comment.id === commentId)
    targetComment.contents = contents
    targetComment.updatedAt = updatedAt
  },
  [DELETE_COMMENT](state, commentId){
    const targetIndex = state.post.comments.findIndex(comment => comment.id===commentId)
    state.post.comments.splice(targetIndex, 1)
  }
}
