<template>
  <div class="memo-form">
      <!-- form submit 이벤트가 발생하면 이벤트의 기본 동작을 방지한 후, 
      우리가 아래에 선언한 addMemo 함수가 콜백 함수로 실행된다. -->
    <form @submit.prevent="addMemo">
      <fieldset>
        <div>
          <input class="memo-form__title-form"
                 type="text"
                 v-model="title"
                 placeholder="메모의 제목을 입력해주세요."/>
          <textarea class="memo-form__content-form"
                    v-model="content"
                    placeholder="메모의 내용을 입력해주세요."/>
          <button type="reset"><i class="fas fa-sync-alt"></i></button>
        </div>
        <button type="submit">등록하기</button>
      </fieldset>
    </form>
  </div>
</template>

<script>
export default {
  name: 'MemoForm',
  data () {
      return {
          // 사용자가 입력할 제목과 콘텐츠가 저장될 데이터의 키(key)와 값(value)
          title: '',
          content: '',
      }
  },
  methods: {
      resetFields () {
          // 제목과 내용을 빈 값으로 초기화시켜준다.
          this.title = '';
          this.content = '';
      },
      addMemo(){
          // ** 비구조화 할당(destructuring assignment) 구문 **을 이용하여 변수를 선언한다.
          const {title, content } = this;
          // 데이터의 고유한 식별자를 생성한다.
          // 로컬을 사용하지 않으므로 더이상 id 생성해줄 필요없이 서버에서 생성된 id 사용
          // const id = new Date().getTime();


          //제목이나 내용을 입력하지 않은 경우를 대비하여 방어 코드를 추가한다.
          const isEmpty = title.length <= 0 || content.length <= 0;
          if(isEmpty){
              return false;
          }

          // addMemo 이벤트를 발생시키고 payload로 사용자가 입력한 데이터를 넣어준다.
          // axios 사용시 전달해주는 인자에서 id도 삭제 (서버에서 자동생성)
         this.$emit('addMemo', { title, content});
          // 부모 컴포넌트에 데이터를 전파한 후 데이터를 다시 원상태로 초기화한다.
          this.resetFields();
      }
  }
};
</script>

<style scoped>
  .memo-form {
    margin-bottom: 24px;
    padding-bottom: 40px;
    border-bottom: 1px solid #eee;
  }
  .memo-form form fieldset div {
    position: relative;
    padding: 24px;
    margin-bottom: 20px;
    box-shadow: 0 4px 10px -4px rgba(0, 0, 0, 0.2);
    background-color: #ffffff;
  }
  .memo-form form fieldset div button[type="reset"] {
    position: absolute;
    right: 20px;
    bottom: 20px;
    font-size: 16px;
    background: none;
  }
  .memo-form form fieldset button[type="submit"] {
    float: right;
    width: 96px;
    padding: 12px 0;
    border-radius: 4px;
    background-color: #ff5a00;
    color: #fff;
    font-size: 16px;
  }
  .memo-form form fieldset .memo-form__title-form {
    width: 100%;
    margin-bottom: 12px;
    font-size: 18px;
    line-height: 26px;
  }
  .memo-form form fieldset .memo-form__content-form {
    width: 100%;
    height: 66px;
    font-size: 14px;
    line-height: 22px;
    vertical-align: top;
  }
  .memo-form input:focus {
    outline: none;
  }
</style>

