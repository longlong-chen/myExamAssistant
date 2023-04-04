<template>
    <div class="all">
        <el-row>
          <el-col :span="12">
            <el-input  placeholder="请输入学生姓名来检索目标学生" v-model="query" clearable @clear="getStudentByName(query)">
              <el-button slot="append" icon="el-icon-search" @click="getStudentByName(query)"></el-button>
            </el-input>
          </el-col>
        </el-row>
        <el-table :data="pagination.records" border>
            <el-table-column fixed="left" prop="studentId" label="账号" width="150"></el-table-column>
            <el-table-column prop="studentName" label="姓名"></el-table-column>
            <el-table-column prop="studentPassword" label="密码"></el-table-column>
            <el-table-column prop="studentPhone" label="电话" width="180"></el-table-column>
            <el-table-column prop="studentEmail" label="邮箱" width="180"></el-table-column>
            <el-table-column prop="studentSchool" label="学校" width="180"></el-table-column>
            <el-table-column prop="studentMajor" label="专业" width="180"></el-table-column>
            <el-table-column prop="sex" label="性别"></el-table-column>
            <el-table-column prop="role" label="角色"></el-table-column>
            <el-table-column label="状态" prop="disabledFlag">
              <!-- scope.row 就是当前行的信息 -->
              <template slot-scope="scope">
                <el-switch v-model="scope.row.disabledFlag" @change="userStateChanged(scope.row)"></el-switch>
              </template>
             </el-table-column>
            <el-table-column fixed="right" label="操作" width="150">
                <template slot-scope="scope">
                    <el-button @click="checkGrade(scope.row.studentId)" type="primary" size="small">编辑</el-button>
                    <el-button @click="deleteById(scope.row.studentId)" type="danger" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="pagination.current"
            :page-sizes="[1, 2, 5, 100]"
            :page-size="pagination.size"
            layout="total, sizes, prev, pager, next, jumper"
            :total="pagination.total"
            class="page">
        </el-pagination>
        <!-- 编辑对话框-->
        <el-dialog
          title="编辑学生信息"
          :visible.sync="dialogVisible"
          width="30%"
          :before-close="handleClose">
          <section class="update">
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="账号">
              <el-input v-model="form.studentId" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="姓名">
              <el-input v-model="form.studentName"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input v-model="form.studentPassword"></el-input>
            </el-form-item>
            <el-form-item label="电话">
              <el-input v-model="form.studentPhone"></el-input>
            </el-form-item>
            <el-form-item label="邮箱">
              <el-input v-model="form.studentEmail"></el-input>
            </el-form-item>
            <el-form-item label="状态">
              <el-switch v-model="form.disabledFlag"></el-switch>
            </el-form-item>
            <el-form-item label="角色">
              <el-input v-model="form.role" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="性别">
              <el-select v-model="form.sex" placeholder="请选择性别">
                <el-option label="男" value="1"></el-option>
                <el-option label="女" value="0"></el-option>
              </el-select>
            </el-form-item>
             <el-form-item label="学校">
              <el-input v-model="form.studentSchool"></el-input>
            </el-form-item>
            <el-form-item label="专业">
              <el-input v-model="form.studentMajor"></el-input>
            </el-form-item>
          </el-form>
          </section>
          <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="submit()">确 定</el-button>
          </span>
        </el-dialog>
    </div>
</template>

<script>
export default {
  data() {
    return {
      pagination: {
        //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 2, //每页条数
      },
      dialogVisible: false, //对话框
      form: {}, //保存点击以后当前老师的信息
      query: ''
    }
  },
  created() {
    this.getStudentInfo();
  },
  methods: {
    getStudentInfo() {
      //分页查询所有试卷信息
      this.$axios(`/api/students/${this.pagination.current}/${this.pagination.size}`).then(res => {
      this.pagination = res.data.data;
      }).catch((err) => {
        //输出异常
        console.log(err);
      })
    },
    getStudentByName(studentName) {
      //分页查询所有试卷信息
      this.$axios(`/api/students/${this.pagination.current}/${this.pagination.size}/${studentName}`).then(res => {
      this.pagination = res.data.data;
      console.log("按学生姓名查找学生");
      }).catch((err) => {
        //输出异常
        console.log(err);
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getStudentInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getStudentInfo();
    },
    checkGrade(studentId) { //修改学生信息
      this.dialogVisible = true
      this.$axios(`/api/student/${studentId}`).then(res => {
        this.form = res.data.data
      }).catch((err) => {
        //输出异常
        console.log(err);
      })
    },
    deleteById(studentId) { //删除当前学生
      this.$confirm("确定删除当前学生吗？删除后无法恢复","Warning",{
        confirmButtonText: '确定删除',
        cancelButtonText: '算了,留着吧',
        type: 'danger'
      }).then(()=> { //确认删除
        this.$axios({
          url: `/api/student/${studentId}`,
          method: 'delete',
        }).then(res => {
          this.getStudentInfo()
        })
      }).catch((err) => {
        //输出异常
        console.log(err);
      })
    },
    // 修改用户状态
    async userStateChanged(userinfo) {
      this.$axios({
          url: `/api/studentState/${userinfo.studentId}/${userinfo.disabledFlag}`,
          method: 'put',
      }).then(res => {
        //console.log(res)
        if(res.data.code ==200) {
          this.$message({
            message: '更新成功',
            type: 'success'
          })
        }
        this.$message.success("操作成功！！！");
      }).catch((err) => {
        //输出异常
        console.log(err);
      })
    },
    submit() {
      //console.log(this.form);
      this.dialogVisible = false;
      this.$axios({
        url: '/api/student',
        method: 'put',
        data: {
          ...this.form
        }
      }).then(res => {
        console.log(res)
        if(res.data.code ==200) {
          this.$message({
            message: '更新成功',
            type: 'success'
          })
        }
        else if(res.data.code ==400) {
          this.$message({
            message: '更新失败',
            type: 'error'
          })
        }
        this.getStudentInfo()
      }).catch((err) => {
        //输出异常
        //console.log("4444444444");
        console.log(err);
        this.$message({
          message: '更新失败',
          type: 'error'
        })
      })
    },
    handleClose(done) { //关闭提醒
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        }).catch(_ => {});
    }
  }
}
</script>

<style lang="scss" scoped>
.all {
  padding: 0px 40px;
  .page {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .edit {
    margin-left: 20px;
  }
  .el-table tr {
    background-color: #dd5862 !important;
  }
}
.el-table .warning-row {
  background: #000 !important;
}

.el-table .success-row {
  background: #dd5862;
}
.input {
  text-align:center;vertical-align:middle;
}
</style>