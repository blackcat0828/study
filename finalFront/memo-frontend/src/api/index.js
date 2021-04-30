import axios from 'axios';

const api = axios.create({
  baseURL: '//localhost:8000/'
  
})

// api.interceptors.response.use(function (response) {
//   return response;
// }, function (error){
//   //에러 트레킹을 위한 함수 호출
//   sendErrorReport(error);
//   return Promise.reject(error);
// })

export default api;
