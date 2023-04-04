<template>
<section class="update">
  <el-card class="box-card">
    <div slot="header" class="clearfix">
        <span>个人中心</span>
    </div>
    <div v-for="o in 4" :key="o" class="text item">
        {{'列表内容 ' + o }}
    </div>
 </el-card>
</section>
</template>

<script>
export default {
  data() {
    return {
      
    }
  },
  methods: {
    
  }
}
</script>

<style>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 480px;
  }
  span{
      text-align: center;
      display: block;
  }
</style>