import Vue from 'vue'
import Router from 'vue-router'
import PostListPage from '@/pages/PostListPage'
import PostViewPage from '@/pages/PostViewPage'
import Signup from '@/pages/Signup'
import Signin from '@/pages/Signin'
import AppHeader from '@/components/AppHeader'
import PostCreatePage from '@/pages/PostCreatePage'
import store from '@/store'
import PostEditPage from '@/pages/PostEditPage'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'PostListPage',
      components: {
        header: AppHeader,
        default: PostListPage
      }
    },
    {
      // 게시물 생성페이지
      path: '/post/create',
      name: 'PostCreatePage',
      components: {
        header: AppHeader,
        default: PostCreatePage
      },
      beforeEnter (to, from, next){
        const {isAuthorized} = store.getters
        if (!isAuthorized){
          alert('로그인이 필요합니다!')
          //로그인이 안되있으면 로그인 페이지로 이동시킨다.
          next({ name: 'Signin'})
        }
        next()
      }
    },
    {
      path: '/post/:postId',
      name: 'PostViewPage',
      components: {
        header: AppHeader,
        default: PostViewPage
      },
      // props값 역시 대상 components의 이름으로 수정
      props: {default: true}
    },
    {
      path: '/signup',
      name: 'Signup',
      components: {
        header: AppHeader,
        default: Signup
      }
    },
    {
      path: '/signin',
      name: 'Signin',
      // components 속성이 아닌 component를 사용하면 자동으로 이름이 없는 router-view에만 컴포넌트를 랜더한다.
      components: {
        header: AppHeader,
        default: Signin
      }

    },
    {
      path: '/post/:postId/edit',
      name: 'PostEditPage',
      components: {
        header: AppHeader,
        default: PostEditPage
      },
      props: {
        default: true
      },
      beforeEnter (to, from, next){
        const {isAuthorized} = store.getters
        if(!isAuthorized){
          alert('로그인이 필요합니다!')
          next({name: 'Signin'})
          return false;
        }
        store.dispatch('fetchPost', to.params.postId)
          .then(res =>{
            const post = store.state.post
            const isAuthor = post.user.id === store.state.me.id
            if (isAuthor){
              next()
            } else {
              alert('게시물의 작성자만 게시물을 수정할 수 있습니다.')
              next(from)
            }
          })
          .catch(err => {
            // 게시물 데이터 요청이 실패했다면 전 페이지로 돌아간다.
            alert(err.response.data.msg)
            next(from)
          })
      }
    }

  ]
})
