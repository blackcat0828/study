import api from '@/api'
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

export default {
  fetchPostList ({ commit }){
    return api.get('/posts')
              .then(res => {
                commit(FETCH_POST_LIST, res.data)
              })
  },
  fetchPost ({ commit }, postId) {
    return api.get(`/posts/${postId}`)
      .then(res => {
        commit(FETCH_POST, res.data)
      })
  },
  signin ({ commit }, payload){
    const {email, password} = payload
    api.post('/auth/signin', { email, password})
      .then(res => {
        console.log(res.data.accessToken)
        const {accessToken} = res.data
        commit(SET_ACCESS_TOKEN, accessToken)
        //토큰을 스토어에 저장하면 api 모듈의 headers에 토큰이 저장되므로 바로 사용자 정보를 불러올 수 있다.
        return api.get('/users/me')
      }).then(res=> {
        //사용자 정보 요청이 성공했다면 변이를 사용하여 스토어에 사용자 정보를 저장한다.
        commit(SET_MY_INFO, res.data)
      })

  },
  signinByToken ({commit}, token){
    // 1. 토큰을 스토어에 커밋한다.
    commit(SET_ACCESS_TOKEN, token)
    // 2. 사용자의 정보를 받아온 후 스토어에 커밋한다.
    return api.get('/users/me')
          .then(res => {
            commit(SET_MY_INFO, res.data)
          })
  },
  signout ({commit}){
    commit(DESTROY_MY_INFO)
    commit(DESTROY_ACCESS_TOKEN)
  },
  createComment({commit, state}, comment){
    const postId = state.post.id
    return api.post(`/posts/${postId}/comments`, {contents: comment})
      .then(res => {
        commit(UPDATE_COMMENT, res.data)
      })
  },
  editComment ({commit, state}, {commentId, comment}){
    const postId = state.post.id
    return api.put(`/posts/${postId}/comments/${commentId}`, {contents: comment})
              .then(res => {
                  commit(EDIT_COMMENT, res.data)
              })
  },
  deleteComment ({commit, state}, commentId){
    const postId = state.post.id
    return api.delete(`/posts/${postId}/comments/${commentId}`)
      .then(res => {
        commit(DELETE_COMMENT, commentId)
      })
  }

}
