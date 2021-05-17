<template>
  <tr>
    <td>{{ id }}</td>
    <td>{{ name }}</td>
    <td>{{ getFormatDate(start_date) }}</td>
    <td>{{ title }}</td>
    <td>{{ dept_name }}</td>
  </tr>
</template>

<script>
import moment from 'moment';
export default {
  name: 'row',
  props: {
    id: { type: Number },
    name: { type: String },
    start_date: { type: String },
    title: {type: String},
    dept_name: { type: String },
  },
  methods: {
    getFormatDate(start_date) {
      return moment(new Date(start_date)).format('YYYY.MM.DD');
    },
  },
};
</script>
