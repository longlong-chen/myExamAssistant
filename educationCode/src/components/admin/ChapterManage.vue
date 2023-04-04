<template>
    <div class="all">
        <el-table :data="pagination.records" border>
            <el-table-column fixed="left" prop="chapterId" label="章节代码" width="150"></el-table-column>
            <el-table-column prop="chapterName" label="章节名称"></el-table-column>
            <el-table-column prop="courseId" label="所属课程"></el-table-column>
            <el-table-column fixed="right" label="操作" width="150">
                <template slot-scope="scope">
                    <el-button @click="checkGrade(scope.row.chapterId)" type="primary" size="small">编辑</el-button>
                    <el-button @click="deleteById(scope.row.chapterId)" type="danger" size="small">删除</el-button>
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
          title="编辑章节信息"
          :visible.sync="dialogVisible"
          width="30%"
          :before-close="handleClose">
          <section class="update">
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="章节代码">
              <el-input v-model="form.chapterId" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="章节名称">
              <el-input v-model="form.chapterName"></el-input>
            </el-form-item>
            <el-form-item label="所属课程">
              <el-select v-model="form.courseId" placeholder="请选择">
                <el-option
                    v-for="item in chapters"
                    :key="item.courseId"
                    :label="item.courseName"
                    :value="item.courseId">
                    <span style="float: left">{{ item.courseName }}</span>
                    <span style="float: right; color: #8492a6; font-size: 13px">{{ item.courseId }}</span>
                </el-option>
              </el-select>
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
        size: 5, //每页条数
      },
      dialogVisible: false, //对话框
      form: {}, //保存点击以后当前章节的信息
      query: '',
      chapters: [/*{
        value: '100',
        label: '数据结构'
      },{
        value: '101',
        label: '计算机网络'  
      },{
        value: '102',
        label: '操作系统' 
      },{
        value: '103',
        label: '计算机组成原理'  
      }*/
      ]
    }
  },
  created() {
    this.getChapterInfo();
  },
  methods: {
    getChapterInfo() {
      //分页查询所有章节信息
      this.$axios(`/api/chapters/${this.pagination.current}/${this.pagination.size}`).then(res => {
      this.pagination = res.data.data;
      }).catch((err) => {
        //输出异常
        console.log(err);
      })
    },
    getCourseInfo() {
      //获取所有课程供选择
      this.$axios(`/api/courses`).then(res => {
      this.chapters = res.data.data;
      console.log("输出章节信息");
      console.log(this.chapters);
      }).catch((err) => {
        //输出异常
        console.log(err);
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getChapterInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getChapterInfo();
    },
    checkGrade(chapterId) { //修改章节信息
      this.dialogVisible = true;
      //获取所有课程
      this.getCourseInfo();
      this.$axios(`/api/chapter/${chapterId}`).then(res => {
        this.form = res.data.data
      }).catch((err) => {
        //输出异常
        console.log(err);
      })
    },
    deleteById(chapterId) { //删除章节
      this.$confirm("确定删除当前章节吗？删除后无法恢复","Warning",{
        confirmButtonText: '确定删除',
        cancelButtonText: '算了,留着吧',
        type: 'danger'
      }).then(()=> { //确认删除
        this.$axios({
          url: `/api/chapter/${chapterId}`,
          method: 'delete',
        }).then(res => {
          this.getChapterInfo();
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
        url: '/api/chapter',
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
        this.getChapterInfo();
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