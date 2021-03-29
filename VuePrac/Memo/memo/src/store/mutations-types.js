// 이 파일 하나에서 스토어 내의 변이 이름을 관리하면 스토어를 파악하기 위해 스토어 전체를 보지 않더라도
// mutations-types.js 파일만 열어보면 대략적인 스토어의 역할을 파악하기가 쉬워진다.
export const FETCH_MEMOS = 'FETCH_MEMOS';
export const ADD_MEMO = 'ADD_MEMO';
export const DELETE_MEMO = 'DELETE_MEMO';
export const EDIT_MEMO = 'EDIT_MEMO';

export const SET_EDITING_ID = 'SET_EDITING_ID';
export const RESET_EDITING_ID = 'RESET_EDITING_ID';