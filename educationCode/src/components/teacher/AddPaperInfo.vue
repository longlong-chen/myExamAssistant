<!-- 添加考试 -->
<template>
  <section class="add">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="试卷名称">
        <el-input v-model="form.paperName"></el-input>
      </el-form-item>
      <el-form-item label="创建日期">
        <el-col :span="11">
          <el-date-picker placeholder="选择日期" v-model="form.createDate" style="width: 100%;"></el-date-picker>
        </el-col>
      </el-form-item>
      <el-form-item label="持续时间">
        <el-input v-model="form.totalTime"></el-input>
      </el-form-item>
      <el-form-item label="总分">
        <el-input v-model="form.mark"></el-input>
      </el-form-item>
      <el-form-item label="考试类型">
        <el-input v-model="form.type"></el-input>
      </el-form-item>
      <el-form-item label="考生提示">
        <el-input type="textarea" v-model="form.tips"></el-input>
      </el-form-item>
      <el-form-item label="是否发布" prop="publishFlag">
        <el-switch v-model="form.publishFlag"></el-switch>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit()">立即创建</el-button>
        <el-button type="text" @click="cancel()">取消</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>

<script>
export default {
  data() {
    return {
      form: { //表单数据初始化
        publishFlag: false
      }
    };
  },
  methods: {
    formatTime(date) { //日期格式化
      let year = date.getFullYear();
      let month= date.getMonth()+ 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
      let day=date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
      let hours=date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
      let minutes=date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
      let seconds=date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
      // 拼接
      return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
    },
    onSubmit() {
      let createDate = this.formatTime(this.form.createDate)
      this.form.createDate = createDate.substr(0,10)
      this.$axios({
        url: '/api/paperInfo',
        method: 'post',
        data: {
        ...this.form
        }
      }).then(res => {
        if(res.data.code == 200) {
            this.$message({
            message: '数据添加成功',
            type: 'success'
            })
            this.$router.push({path: '/paperInfoManage'})
        } else {
            this.$message({
            message: '数据添加失败',
            type: 'error'
            })
        }
        }).catch((err) => {
        //console.log("4444444444");
        console.log(err);
        this.$message({
        message: '更新失败',
        type: 'error'
        })
        })
    },
    cancel() { //取消按钮
      this.form = {};
      this.$router.push({path: '/paperInfoManage'});
    },
    
  }
};
</script>
<style lang="scss" scoped>
.add {
  padding: 0px 40px;
  width: 400px;
}
</style>