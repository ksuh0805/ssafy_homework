<template>
  <div>
    <div v-if="items.length">
      <table class="table table-bordered table-condensed">
        <tr>
          <th>번호</th>
          <th>이름</th>
          <th>입사일</th>
          <th>직급</th>
          <th>부서</th>
        </tr>
        <list-row
          v-for="(item, index) in items"
          :key="`${index}_items`"
          :id="item.id"
          :name="item.name"
          :start_date="item.start_date"
          :title="item.title"
          :dept_name="item.dept_name"
        />
      </table>
    </div>
    <div v-else>목록이 없습니다.</div>
  </div>
</template>

<script>
// import http from '@/util/http-common';
import ListRow from '@/components/Row.vue';
export default {
  name: 'list',
  components: {
    ListRow,
  },
  computed: {
    items(){
      return this.$store.state.emps;
    }
  },
  created() {
    this.$store.dispatch('getEmps')
  },
};
</script>

<style>
</style>

