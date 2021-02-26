//다음 예제는 아래 링크에서 가져왔다.
//https://vuejs.org/v2.guide/custom-directive.html
// 'v-focus'라는 전역 사용자 정의 지시자를 등록하기
Vue.directive('focus', {
    //바인딩된 요소가 DOM으로 삽입될 때
    inserted: function (el) {
        //요소에 초점을 둔다.
        el.focus(); 
    }
})