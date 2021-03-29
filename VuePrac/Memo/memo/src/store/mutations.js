// 변이 이름을 상수로 선언한다.
// 상수로 선언하지 않아도 되지만 Flux 패턴에서 변이 이름을 상수로 사용하는 것은 일반적인 방법이므로 상수로 선언
// 변이 상수 값만 따로 관리하기위해 mutations-types.js 로 옮김
// const FETCH_MEMOS = 'FETCH_MEMOS';

import {FETCH_MEMOS, ADD_MEMO, DELETE_MEMO, EDIT_MEMO, SET_EDITING_ID, RESET_EDITING_ID} from './mutations-types';

export default {
    // FETCH_MEMOS 변수를 변이 이름으로 가지는 변이 함수를 작성한다.
    [FETCH_MEMOS] (state, payload) {
        state.memos = payload;
    },
    [ADD_MEMO] (state, payload){
        state.memos.push(payload);
    },
    [DELETE_MEMO] (state, id){
        const targetIndex = state.memos.findIndex(v => v.id === id);
        state.memos.splice(targetIndex, 1);
    },
    [EDIT_MEMO] (state, payload){
        const {id, content} = payload;
        const targetIndex = state.memos.findIndex(v => v.id === id);
        const targetMemo = state.memos[targetIndex];
        state.memos.splice(targetIndex, 1, {...targetMemo, content})
    },
    [SET_EDITING_ID] (state, id){
        state.editingId = id
    },
    [RESET_EDITING_ID] (state, id){
        // 수정중인 데이터가 없는 경우 임의의 초기화값 0으로 설정한다.
        state.editingId = 0;
    }

}