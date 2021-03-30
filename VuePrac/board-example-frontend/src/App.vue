<template>
  <div id="app">
    <!-- header라는 이름을 부여받은 router-view 컴포넌트 -->
    <router-view name="header"/>
    <!-- 이름이 없는 router-view 컴포넌트는 자동으로 default라는 이름을 부여받는다. -->
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
  @import 'http://localhost:8000/assets/index.css';
</style>
