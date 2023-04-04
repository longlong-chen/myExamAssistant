<template>
    <div class="all">
        <el-table :data="pagination.records" border>
            <el-table-column fixed="left" prop="courseId" label="课程代码" width="150"></el-table-column>
            <el-table-column prop="courseName" label="课程名称"></el-table-column>
            <el-table-column fixed="right" label="操作" width="150">
                <template slot-scope="scope">
                    <el-button @click="checkGrade(scope.row.courseId)" type="primary" size="small">编辑</el-button>
                    <el-button @click="deleteById(scope.row.courseId)" type="danger" size="small">删除</el-button>
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
          title="编辑科目信息"
          :visible.sync="dialogVisible"
          width="30%"
          :before-close="handleClose">
          <section class="update">
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="课程代码">
              <el-input v-model="form.courseId" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="课程名称">
              <el-input v-model="form.courseName"></el-input>
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
    this.getCourseInfo();
  },
  methods: {
    getCourseInfo() {
      //分页查询所有试卷信息
      this.$axios(`/api/courses/${this.pagination.current}/${this.pagination.size}`).then(res => {
      this.pagination = res.data.data;
      }).catch((err) => {
        //输出异常
        console.log(err);
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getCourseInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getCourseInfo();
    },
    checkGrade(courseId) { //修改学生信息
      this.dialogVisible = true
      this.$axios(`/api/course/${courseId}`).then(res => {
        this.form = res.data.data
      }).catch((err) => {
        //输出异常
        console.log(err);
      })
    },
    deleteById(courseId) { //删除当前学生
      this.$confirm("确定删除当前课程吗？删除后无法恢复","Warning",{
        confirmButtonText: '确定删除',
        cancelButtonText: '算了,留着吧',
        type: 'danger'
      }).then(()=> { //确认删除
        this.$axios({
          url: `/api/course/${courseId}`,
          method: 'delete',
        }).then(res => {
          this.getCourseInfo();
        })
      }).catch((err) => {
        //输出异常
        console.log(err);
      })
    },
    submit() {
      //console.log(this.form);
      this.dialogVisible = false;
      this.$axios({
        url: '/api/course',
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
        this.getCourseInfo();
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