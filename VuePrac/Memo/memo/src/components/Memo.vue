<template>
    <li class="memo-item">
        <!-- 2. 등록된 props의 값을 각 DOM에 위치시킨다. -->
        <strong>{{ memo.title }}</strong>
        <p @dblclick="handleDblClick">
        <!--  1. template 태그를 이용하여 내용 텍스트를 감싸준다. -->
            <template v-if="!isEditing">{{memo.content}}</template>
        <!-- 2. 수정 필드를 위한 태그를 추가해준다. -->
        <input v-else
               type="text"
               ref="content"
               :value = "memo.content"
               @blur="handleBlur"
               @keydown.enter="updateMemo" />
        </p>
        <button type="button" @click="deleteMemo">
            <i class="fas fa-times"></i>
        </button>
    </li>
</template>

<script>
    export default {
        name: 'Memo',
        // data () {
        //     // 현재 메모에 대한 수정 상태에 대한 데이터를 저장한다.
        //     return {
        //         isEditing: false
        //     }
        // },
        props: {
            memo: {
                type: Object
                },
            editingId: {
                type: Number
            }
        },
        computed: {
            isEditing(){
                return this.memo.id === this.editingId;
            }
        },
        methods: {
            deleteMemo(){
                // 부모로부터 props로 내려받은 memo의 id를 부모 컴포넌트의 사용자 정의 이벤트인
                // deleteMemo 함수의 파라미터로 전달해준다.
                const id = this.memo.id;
                this.$emit('deleteMemo', id);
            },
            handleDblClick (){
                //더블 클릭을 했을 때, 클릭한 메모의 수정 상태를 true로 변경한다.
                // this.isEditing=true;
                const { id } = this.memo;
                this.$emit('setEditingId', id);
                this.$nextTick(()=>{
                    this.$refs.content.focus();
                });
            },
            updateMemo(e) {
                const id = this.memo.id
                const content = e.target.value.trim();
                if(content.length <= 0){
                    return false;
                }
                this.$emit('updateMemo', {id, content });
                // this.isEditing = false;
                // 수정 완료 후, 인풋에서 포커스를 제거한다.
                this.$refs.content.blur();
            },
            handleBlur(){
                // this.isEditing = false;
                this.$emit('resetEditingId');
            }


        }
    }
</script>
<style scoped>
  .memo-item {
    overflow: hidden;
    position: relative;
    margin-bottom: 20px;
    padding: 24px;
    box-shadow: 0 4px 10px -4px rgba(0, 0, 0, 0.2);
    background-color: #fff;
    list-style: none;
  }
  .memo-item input[type="text"] {
    border: 1px solid #ececec;
    font-size: inherit;
  }
  .memo-item button {
    position: absolute;
    right: 20px;
    top: 20px;
    font-size: 20px;
    color: #e5e5e5;
    border: 0;
  }
  .memo-item strong {
    display: block;
    margin-bottom: 12px;
    font-size: 18px;
    font-weight: normal;
    word-break: break-all;
  }
  .memo-item p {
    margin: 0;
    font-size: 14px;
    line-height: 22px;
    color: #666;
  }
  .memo-item p input[type="text"] {
    box-sizing: border-box;
    width: 100%;
    font-size: inherit;
  }
  .memo-item p input[type="text"] {
    box-sizing: border-box;
    width: 100%;
    font-size: inherit;
  }
</style>
