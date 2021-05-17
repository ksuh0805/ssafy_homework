<template>
  <div>
    <div class="form-group">
      <label for="name">이름</label>
      <input
        type="text"
        class="form-control"
        id="name"
        ref="name"
        placeholder="이름을 입력하세요"
        v-model="name"
      />
    </div>
    <div class="form-group">
      <label for="salary">월급</label>
      <input
        type="number"
        class="form-control"
        id="salary"
        ref="salary"
        placeholder="월급을 입력하세요"
        v-model="salary"
      />
    </div>
    <div class="form-group">
      <label for="commision">커미션</label>
      <input
        type="number"
        class="form-control"
        id="comission"
        ref="comission"
        placeholder="커미션을 입력하세요"
        v-model="commision"
      />
    </div>
    <div class="custom-form-group">
            <label for="dept">부서</label>
            <select id="dept" v-model="dept">
            <option disabled value="">부서번호를 선택하세요</option>
            <option v-for="dept in 10" :key="dept">{{dept + 100}}</option>
            </select>
    </div>
    <div class="custom-form-group">
            <label for="title">직책</label>
            <select id="title" v-model="title">
            <option disabled value="">직책을 선택하세요</option>
            <option v-for="t in titles" :key="t">{{t}}</option>
            </select>
    </div>
    <div class="custom-form-group">
            <label for="hireDate">고용일</label>
            <input type="date" id="hireDate" placeholder="고용일을 입력하세요" v-model="hireDate"/>
    </div>
    <div class="text-right">
      <button class="btn btn-primary" @click="addEmp">등록</button>
    </div>
  </div>
</template>

<script>
//import http from '@/util/http-common';
export default {
  data: function() {
    return {
      titles: [
                '사장',
                '기획부장',
                '영업부장',
                '총무부장',
                '인사부장',
                '과장',
                '영업대표이사',
                '사원',
              ],
      deptNames: ['기획', '영업', '총무', '인사', '기타'],
      hireDate: '',
      name: '',
      title: '',
      dept: '',
      commision: '',
      salary: ''
    };
  },
  methods: {
    addEmp(){
      const emp = {
        hireDate: this.hireDate,
        name: this.name,
        title: this.title,
        dept: this.dept,
        commision: this.commision,
        salary: this.salary
      }
      this.$store.dispatch('addEmp', emp);
      this.hireDate = '';
      this.name = '';
      this.title = '';
      this.dept = '';
      this.commision = '';
      this.salary = '';
    }
  }
};
</script>