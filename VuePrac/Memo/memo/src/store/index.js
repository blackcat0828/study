import Vue from 'vue';
import Vuex from 'vuex';

import state from './states.js';
import getters from './getters.js';
import mutations from './mutations';
import actions from './actions';

// Vuex를 사용하기 위해 Vue.use(Vuex)를 먼저 호출한다.
Vue.use(Vuex);

export default new Vuex.Store({
    state,
    getters,
    mutations,
    actions
});