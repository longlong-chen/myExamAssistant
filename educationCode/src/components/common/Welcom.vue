<template>
<div>
    <!--<div class="bg"></div>
    <div>欢迎来到计算机学科考研助手</div>-->
    <section class="description">
    <p class="title">计算机考研助手功能介绍</p>
    <p class="content">随着网络的不断发展，互联网的普及范围越来越广泛，
        教育行业更是受到了很大的影响和改变，学生们目前更倾向于使用在线方式进行学习与练习。
        计算机专业考研助手系统是基于B/S架构模式，使用SSM框架技术，运用MYSQL数据库管理技术，
        针对计算机专业考研学生开发的辅助学习平台。不仅能满足绝大部分计算机专业学生的考研复习与练习的需求，
        还能极大的提高考生的复习效率。学生可以进行相关科目的考点学习与题目练习，还可以进行模拟考试，
        查看自己的薄弱考点，进行针对性的刷题练习。老师则可以通过该平台进行录入试题、组织考试、
        上传资料等辅助性指导，以提高学生的上岸几率。
    </p>
   </section>
</div>
</template>

<script>
export default {
    
}
</script>

<style lang="scss" scoped>
.description {
  margin-left: 40px;
  .title {
    font-size: 22px;
    font-weight: 400;
    color: rgb(31, 47, 61);
  }
  .content {
    width: 600px;
    background-color: #FAF5F2;
    padding: 16px 32px;
    border-radius: 4px;
    border-left: 5px solid #FDC8C8;
    margin: 20px 0px;
  }
}
</style>