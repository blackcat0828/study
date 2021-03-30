<template>
  <form @submit.prevent="onSubmit">
    <fieldset>
      <label>게시물 번호</label>
      <input :value="post.id" type="text" disabled />
      <label>게시물 생성일</label>
      <input :value="post.createdAt" type="text" disabled />
      <label>제목</label>
      <input v-model="title" type="text" placeholder="게시물 제목을 입력해주세요." />
      <label>내용</label>
      <textarea v-model="contents" rows="5" placeholder="게시물 내용을 입력해주세요.">
      </textarea>
      <button type="submit">수정하기</button>
      <router-link :to="{name: 'PostViewPage', params:{postId: post.id.toString()}}">취소</router-link>
    </fieldset>
  </form>
</template>

<script>
export default {
  name: 'PostEditForm',
  props: {
    post: {
      type: Object,
      required: true,
      validator (post) {
        const isValidPostId = typeof post.id === 'number'
        const isValidTitle = !!post.title && post.title.length
        const isValidContents = post.contents && post.contents.length
        return isValidPostId && isValidTitle && isValidContents
      }
    }
  },
  data(){
    return {
      title: '',
      contents: ''
    }
  },
  // props로 주입받은 데이터는 반응형 데이터로 사용할 수 없기 때문에 컴포넌트의 data 속성에 다시 할당해준다.
  created(){
    this.title = this.post.title
    this.contents = this.post.contents
  },
  methods: {
    onSubmit (){
      const {title, contents} = this
      this.$emit('submit', {title, contents})
    },
  }
}
</script>
