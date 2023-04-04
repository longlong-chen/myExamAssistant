<template>
    <div id="index">
        <header1 class="topbar"></header1>
        <section class="container">
            <div class="left_side">
                <teacherLeft></teacherLeft>
            </div>
            <div class="main_wrapper">
                <navigator class="nav"></navigator>
                <router-view></router-view>
            </div>
        </section>
  </div>
</template>

<script>
import header from '@/components/teacher/TeacherHeader'
import teacherLeft from '@/components/teacher/TeacherLeft'
import navigator from '@/components/teacher/TeacherNavigator'
export default {
    components:{
    header1: header,
    teacherLeft: teacherLeft,
    navigator: navigator
  },
  data() {
    return {
      username: '陈龙龙'
    }
  },
  methods: {
    
  }
}
</script>

<style lang="scss" scoped>
#index .nav {
  box-shadow: 1px 0 5px rgba(0, 0, 0, 0.1);
  margin-bottom: 30px;
}
.container {
  display: flex;
  background-color: #fff;
}
.main_wrapper {
  overflow: hidden;
  flex: 1;
  background-color: #fff;
}
</style>