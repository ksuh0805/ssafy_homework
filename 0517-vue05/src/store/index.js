import Vue from "vue";
import Vuex from "vuex";
import http from '@/util/http-common';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    emps: [],
    emp: {
      hireDate: '',
      name: '',
      title: '',
      dept: '',
      commision: '',
      salary: ''
    },
  },
  getters: {},
  mutations: {
    ADD_EMP(state, emp) {
      http
        .post('', {
          name: emp.name,
          title: emp.title,
          dept_id: emp.dept,
          start_date: emp.hireDate,
          commision_pct: emp.commision,
          salary: emp.salary,
        })
        .then(() => {
          alert('등록이 완료되었습니다.');
        })
        .catch(() => {
          alert('등록 처리시 에러가 발생했습니다.');
        });
    },
    GET_EMPS(state) {
      http
      .get('/all')
      .then(({ data }) => {
        state.emps = data;
      })
      .catch(() => {
        alert('에러가 발생했습니다.');
      });
    }
  },
  actions: {
    addEmp({ commit }, emp) {
      commit('ADD_EMP', emp);
    },
    getEmps({ commit }) {
      commit('GET_EMPS');
    }
  },
});
