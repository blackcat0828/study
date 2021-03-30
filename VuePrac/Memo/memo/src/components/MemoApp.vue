<template>
    <div class="memo-app">
        <!-- @addMemo = "addMemo" 축약형으로 사용가능 -->
        <memo-form v-on:addMemo="addMemo" />
        <ul class="memo-list">
            <memo v-for="memo in memos" :key="memo.id" :memo="abc"
            @deleteMemo="deleteMemo"
            @updateMemo="updateMemo"
            :editingId="editingId"
            @setEditingId="SET_EDITING_ID"
            @resetEditingId="RESET_EDITING_ID"
            />
        </ul>
    </div>
</template>
<script>
import MemoForm from './MemoForm.vue';
import Memo from './Memo.vue';
import axios from 'axios';
// mapActions 헬퍼 함수를 가져온다.
import {mapActions, mapState, mapMutations} from 'vuex';
import { RESET_EDITING_ID, SET_EDITING_ID } from '../store/mutations-types';

const memoAPIcore = axios.create({
    baseURL: 'http://localhost:8000/api/memos'
})

export default {
    name: 'MemoApp',
    computed: {
        ...mapState([
            'memos',
            'editingId'
        ])
    },
    created () {
        // 주입된 actions의 함수를 호출한다.
        this.fetchMemos();


        //만약 기존의 추가된 localStorage에 데이터가 있다면 created 훅에서 localStorage의 데이터를
        //컴포넌트 내의 memos 데이터에 넣어주고, 그렇지 않다면 그대로 빈 배열로 초기화한다.
        // 기존 로컬스토리지를 사용하던 코드는 비활성화
        // this.memos = localStorage.memos ? JSON.parse(localStorage.memos) : [];

        // vuex 사용으로인해 기존 코드 삭제
        // memoAPIcore.get('/')
        // .then(res => {
        //     // 받아온 데이터를 data의 memos에 저장한다.
        //     this.memos = res.data;
        // })
    },
    components: {
        MemoForm,
        Memo

    },
    methods: {
        // addMemo (payload) {
        //     // 로컬 스토리지 사용시 코드
        //     // this.memos.push(payload);
        //     // this.storeMemo();

        //     // 1. axios 객체의 post 메소드를 이용하여 데이터를 추가한다.
        //     memoAPIcore.post('/', payload)
        //         .then(res => {
        //             // 2. 정상적인 메모를 생성 후, 결괏값을 memos에 추가한다.
        //             // 응답에 201 Created 상태코드 예상
        //             this.memos.push(res.data);
        //         });
        // },
        // storeMemo(){
        //     const memosToString = JSON.stringify(this.memos);
        //     localStorage.setItem('memos', memosToString);
        // },
        // deleteMemo (id) {
        //     // 1. 자식 컴포넌트에서 인자로 전달해주는 id에 해당하는 메모 데이터의 인덱스를 찾는다.
        //     const targetIndex = this.memos.findIndex(v => v.id === id);
        //     memoAPIcore.delete(`/${id}`)
        //         .then(() => {
        //             // 요청 후, MemoApp 컴포넌트의 memos 데이터에서도 삭제한다.
        //             this.memos.splice(targetIndex, 1);
        //         })
        //     // 2. 찾은 인덱스 번호에 해당하는 메모 데이터를 삭제한다.
        //     // this.memos.splice(targetIndex, 1);
        //     // 3. 삭제된 후의 데이터를 다시 로컬스토리지에 마찬가지로 저장한다.
        //     // this.storeMemo();
        // },
        // updateMemo (payload) {
        //     // 1. 수정된 메모를 저장한다.
        //     const { id, content } = payload;
        //     const targetIndex = this.memos.findIndex(v => v.id === id);
        //     const targetMemo = this.memos[targetIndex];
        //     // 1. 수정 대상과 일치하는 id값과 수정된 단락에 대한 데이터를 delete put과 함께 요청한다.
        //     memoAPIcore.put(`/${id}`, {content})
        //         .then(() => {
        //             // 2. 요청 후, MemoApp 컴포넌트의 memos 데이터에서도 해당하는 데이터를 업데이트한다.
        //             this.memos.splice(targetIndex, 1, { ...targetMemo, content });

        //         });
        // },
        // mapActions 헬퍼 함수에 사용할 actions 함수를 주입한다.
        ...mapMutations([
            SET_EDITING_ID,
            RESET_EDITING_ID
        ]),
        ...mapActions([
            'fetchMemos',
            'addMemo',
            'deleteMemo',
            'updateMemo'
        ])

    }
}
</script>
<style scoped>
    .memo-list {
        padding: 20px 0;
        margin: 0;
    }
</style>
