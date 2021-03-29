// 사용하려는 axios 라이브러리를 가져온다.
import axios from 'axios';
//FETCH_MEMOS 상수를 가져온다.
import { FETCH_MEMOS, ADD_MEMO, DELETE_MEMO, EDIT_MEMO } from './mutations-types';
// 앞서 MemoApp 컴포넌트에서 사용하던 axios 인스턴스를 동일하게 가져온다.
const memoAPICore = axios.create({
    baseURL: 'http://localhost:8000/api/memos'
});

// 사용할 함수를 'fetchMemos' 라는 이름의 함수로 정의한다.
export function fetchMemos ({ commit }){
    // MemoAPP의 created 훅에서 실행되는 함수를 가져온다.
    memoAPICore.get('/')
        .then(res => {
            // API 호출 결과를 데이터와 함께 FETCH_MEMOS라는 이름의 mutation의 커밋을 한다.
            commit(FETCH_MEMOS, res.data);
        });
}

export function addMemo ({ commit }, payload) {
    memoAPICore.post('/', payload)
      .then(res => {
        // 3. ADD_MEMO 변이를 호출하고 API를 통해 받아온 메모 데이터를 넘겨준다.
        commit(ADD_MEMO, res.data);
      });
  }

  export function deleteMemo ({commit}, id){
      memoAPICore.delete(`/${id}`)
        .then(()=>{
            commit(DELETE_MEMO, id);
        })
  }

  export function updateMemo ({ commit }, payload) {
    const { id, content } = payload;
    memoAPICore.put(`/${id}`, { content })
      .then(() => {
        commit(EDIT_MEMO, payload);
      });
  }

  
export default {
    fetchMemos,
    addMemo,
    deleteMemo,
    updateMemo
}