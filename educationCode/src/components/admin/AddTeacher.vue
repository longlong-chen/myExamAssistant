<template>
    <section class="update">
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
            <el-form-item label="姓名" prop="teacherName">
                <el-input v-model="form.teacherName" placeholder="请输入教师姓名"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="teacherPassword">
                <el-input v-model="form.teacherPassword" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item label="联系方式" prop="teacherPhone">
                <el-input v-model="form.teacherPhone" placeholder="请输入教师电话"></el-input>
            </el-form-item>
            <el-form-item label="邮箱" prop="teacherEmail">
                <el-input v-model="form.teacherEmail" placeholder="请输入教师邮箱"></el-input>
            </el-form-item>
            <el-form-item label="职称" prop="teacherType">
                <el-input v-model="form.teacherType" placeholder="请输入教师职称"></el-input>
            </el-form-item>
            <el-form-item label="状态" prop="disabledFlag">
                <el-input v-model="form.disabledFlag"  placeholder="请输入教师状态，1代表可用，0代表不可用，默认为0"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="sex">
                <el-input v-model="form.sex" placeholder="请输入教师性别，1代表男性，0代表女性，默认为1"></el-input>
            </el-form-item>
            <el-form-item label="角色" prop="role">
                <el-input v-model="form.role" :disabled="true" placeholder="当前创建均为老师，默认为1，其中0代表管理员，1代表教师，2代表学生"></el-input>
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
        teacherName: null,
        teacherPassword: null,
        teacherPhone: null,
        teacherEmail: null,
        teacherType: null,
        disabledFlag: 0,
        sex: 1,
        role: 1
      },
      rules: {
        teacherName: [
          { required: true, message: '请输入教师姓名', trigger: 'blur' }
        ],
        teacherPassword: [
          { required: true, message: '请输入密码', trigger: 'blur' }
        ],
        teacherPhone: [
          { required: true, message: '请输入教师电话', trigger: 'blur' }
        ],
        teacherEmail: [
          { required: true, message: '请输入教师邮箱', trigger: 'blur' }
        ],
        teacherType: [
          { required: true, message: '请输入教师职称', trigger: 'blur' }
        ],
        disabledFlag: [
          { required: true, message: '请输入教师状态，1代表可用，0代表不可用，默认为0', trigger: 'blur' }
        ],
        sex: [
          { required: true, message: '请输入教师性别，1代表男性，0代表女性，默认为1', trigger: 'blur' }
        ],
        role: [
          { required: true, message: '当前创建均为老师，默认为1，其中0代表管理员，1代表教师，2代表学生', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    onSubmit() { //数据提交
      this.$axios({
        url: '/api/teacher',
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
          this.$router.push({path: '/teacherManage'})
        }
        //this.$router.push({path: '/teacherManage'})
      })
      this.$router.push({path: '/teacherManage'})
    },
    cancel() { //取消按钮
      //this.form = {}
      this.$router.push({path: '/teacherManage'})
    }
  }
}
</script>

<style lang="scss" scoped>
.add {
  padding: 0px 40px;
  width: 400px;
}
</style>