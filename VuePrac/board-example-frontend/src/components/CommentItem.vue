<template>
  <div class="comment-item">
      <strong>{{comment.user.name}}</strong><span>{{comment.createdAt}}</span>
      <p>{{comment.contents}}</p>
      <ul v-if="isMyComment">
        <li><button type="button">수정</button></li>
        <li><button type="button">삭제</button></li>
      </ul>
  </div>

</template>

<script>
import { mapGetters, mapState } from 'vuex'
export default {
  name: 'CommentItem',
  props: {
    comment: {
      type: Object,
      required: true,
      validator (comment){
        const isValidCommentId = typeof comment.id === 'number'
        const isValidContents = comment.contents && comment.contents.length
        const isValidUser = !!comment.user
        return isValidCommentId && isValidContents && isValidUser
      }
    }
  },
  computed: {
    ...mapState(['me']),
    ...mapGetters(['isAuthorized']),
    isMyComment (){
      return this.isAuthorized && this.comment.user.id === this.me.id
    },
  }
}
</script>
