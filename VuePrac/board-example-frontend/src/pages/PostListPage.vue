<template>
  <div class="post-list-page">
    <h1>포스트 게시글</h1>
    <!-- 자식 컴포넌트 props를 통해 posts 데이터를 내려준다. -->
    <post-list :posts="posts"/>
    <!-- 글쓰기 버튼 추가 -->
    <router-link :to="{name: 'PostCreatePage'}">글쓰기</router-link>
  </div>
</template>

<script>
import PostList from '@/components/PostList'
// 커스텀마이징된 axios 객체를 추가한다.
import { mapActions, mapState } from 'vuex'
export default {
  name: 'PostListPage',
  computed: {
    // mapState 헬퍼 함수를 이용하여 posts 상태에 컴포넌트에 매핑한다.
    ...mapState(['posts'])
  },
  // created 훅에서 API 호출을 한 후, 컴포넌트 내의 데이터에 해당 결괏값을 대입
  created() {
    this.fetchPostList();
  },
  methods: {
    ...mapActions(['fetchPostList'])
  },
  components: { PostList }
}
</script>
