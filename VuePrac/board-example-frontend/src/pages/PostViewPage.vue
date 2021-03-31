<template>
  <div class="post-view-page">
    <post-view v-if="post" :post="post" />
    <p v-else>게시글 불러오는 중...</p>
    <router-link :to="{name: 'PostEditPage', params: {postId}}">수정</router-link>
    <button @click="onDelete">삭제</button>
    <router-link :to="{ name: 'PostListPage' }">목록</router-link>
    <comment-list v-if="post" :comments="post.comments" />
    <comment-form @submit="onCommentSubmit"/>
  </div>
</template>

<script>
import {mapActions, mapState, mapGetters} from 'vuex'
import PostView from '@/components/PostView'
import CommentList from '@/components/CommentList'
import api from '@/api'
import CommentForm from '@/components/CommentForm'

export default {
  name: 'PostViewPage',
  // 1. PostViewPage 컴포넌트의 path에 정의한 동적 세그먼트 값 postId 대한 props 값을 설정한다.
  props: {
    postId: {
      type: String,
      required: true
    }
  },
  computed: {
    ...mapState(['post']),
    ...mapGetters(['isAuthorized'])
  },
  created () {
    //2. fetchPost 액션 실행 시 props를 통해 내려받은 postId 값의 인자와 함께 호출
    this.fetchPost(`/${this.postId}`)
      .catch(err => {
        alert(err.response.data.msg)
        this.$router.back()
      })
  },
  methods: {
    ...mapActions(['fetchPost','createComment']),
    onDelete(){
      const {id} = this.post
      api.delete(`/posts/${id}`)
        .then(res => {
          alert('게시물이 성공적으로 삭제되었습니다.')
          this.$router.push({name: 'PostListPage'})
        })
        .catch(err => {
          if(err.response.status === 401){
            alert('로그인이 필요합니다.')
            this.$router.push({name: 'Signin'})
          } else {
            alert(err.response.data.msg)
          }
        })
    },
    onCommentSubmit(comment){
      if(!this.isAuthorized){
        alert('로그인이 필요합니다!')
        this.$router.push({name: 'Signin'})
      } else{
        this.createComment(comment)
              .then(()=>{
                alert('댓글이 성공적으로 작성되었습니다.')
              })
              .catch(err => {
                alert(err.response.data.msg)
              })
      }
    },
  },
  components: { PostView, CommentList, CommentForm },
}
</script>
