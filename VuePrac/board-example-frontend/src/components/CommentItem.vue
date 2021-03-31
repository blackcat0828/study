<template>
  <div class="comment-item">
      <strong>{{comment.user.name}}</strong><span>{{comment.createdAt}}</span>
      <!-- 댓글을 수정할 수 있는 textarea 태그와 수정 완료 버튼 작성 -->
      <div v-if="isEditing">
        <textarea v-model="editMessage" row="3"></textarea>
        <button @click="onEdit">수정완료</button>
      </div>
      <!-- 댓글의 내용을 노출하던 DOM은 isEditing 값이 거짓일 경우에만 노출한다 -->
      <p v-else>{{comment.contents}}</p>
      <ul v-if="isMyComment">
        <li><button type="button" @click="toggleEditMode">{{editButtonText}}</button></li>
        <li><button type="button" @click="onDelete">삭제</button></li>
      </ul>
  </div>

</template>

<script>
import { mapGetters, mapState } from 'vuex'
export default {
  name: 'CommentItem',
  data(){
    return{
      isEditing: false,
      editMessage: ''
    }
  },
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
    editButtonText(){
      return this.isEditing ? '수정 취소' : '수정'
    },
    isValidComment(){
      // 수정된 댓글이 1자 이상 255자 이하면 참을 반환, 아니면 거짓을 반환
      return this.editMessage.length > 0 && this.editMessage.length < 256
    }
  },
  methods: {
    toggleEditMode(){
      this.isEditing = !this.isEditing
      //수정 모드로 변할 때마다 댓글의 내용을 수정할 메시지에 바인딩해준다.
      if(this.isEditing){
        this.editMessage=this.comment.contents
      }
    },
    onEdit (){
      if (this.isValidComment){
        this.isEditing=false
        const {id} = this.comment
        this.$emit('edit', {id, comment: this.editMessage})
      } else {
        alert('댓글은 1자 이상 255자 이하여야 합니다.')
      }
    },
    onDelete(){
      const id = this.comment.id
      this.$emit('delete', id)
    }
  }
}
</script>
