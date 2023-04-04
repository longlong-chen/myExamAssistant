//查询所有题库
<template>
  <div class="exam">
    <el-table :data="pagination.records" border :row-class-name="tableRowClassName">
      <el-table-column fixed="left" prop="questionId" label="试题编号" width="150"></el-table-column>
      <el-table-column prop="question" label="题目信息" width="490"></el-table-column>
      <el-table-column prop="courseId" label="所属课程" width="150"></el-table-column>
      <el-table-column prop="chapterId" label="所属章节" width="150"></el-table-column>
      <el-table-column prop="type" label="题目类型" width="200"></el-table-column>
      <el-table-column prop="score" label="试题分数" width="150"></el-table-column>
      <el-table-column prop="level" label="难度等级" width="133"></el-table-column>
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row.questionId,scope.row.type)" type="primary" size="small">编辑</el-button>
          <el-button @click="deleteRecord(scope.row.questionId,scope.row.type)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[6, 10, 20, 100]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total"
      class="page"
    ></el-pagination>
    <!-- 编辑对话框-->
    <el-dialog
      title="编辑题目信息"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <section class="update">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="试题编号">
            <el-input v-model="form.questionId" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="题目信息">
            <el-input type="textarea" v-model="form.question"></el-input>
          </el-form-item>
          <el-form-item label="所属课程">
              <el-select v-model="form.courseId" placeholder="请选择所属课程" @change="getChapterInfo($event)">
                <el-option
                    v-for="item in courses"
                    :key="item.courseId"
                    :label="item.courseName"
                    :value="item.courseId">
                    <span style="float: left">{{ item.courseName }}</span>
                    <span style="float: right; color: #8492a6; font-size: 13px">{{ item.courseId }}</span>
                </el-option>
              </el-select>
          </el-form-item>
          <el-form-item label="所属章节">
              <el-select v-model="form.chapterId" placeholder="请选择所属章节">
                <el-option
                    v-for="item in chapters"
                    :key="item.chapterId"
                    :label="item.chapterName"
                    :value="item.chapterId">
                    <span style="float: left">{{ item.chapterName }}</span>
                    <span style="float: right; color: #8492a6; font-size: 13px">{{ item.chapterId }}</span>
                </el-option>
              </el-select>
          </el-form-item>
          <!--
          <el-form-item label="题目类型">
            <el-input v-model="form.type"></el-input>
          </el-form-item>
          -->
          <el-form-item label="题目分数">
            <el-input v-model="form.score"></el-input>
          </el-form-item>
          <el-form-item label="难度等级">
            <el-rate v-model="form.level"></el-rate>
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
        size: 6 //每页条数
      },
      form: {},
      dialogVisible: false,
      courses: [],
      chapters: [],
      type: ''
    };
  },
  created() {
    this.getAnswerInfo();
  },
  methods: {
    submit() {
      this.dialogVisible = false;
      console.log("要更改的题目类型： "+this.type);
      if(this.type == "选择题"){
        console.log("进行"+this.type+"更新");
        this.$axios({
        url: '/api/select',
        method: 'put',
        data: {
          ...this.form
        }
      }).then(res => {
        if(res.data.code == 200) {
          this.$message({ //成功修改提示
            message: '更新成功',
            type: 'success'
          })
        }
        this.getAnswerInfo()
      })
      }
      else if(this.type == "填空题"){
        console.log("进行"+this.type+"更新");
        this.$axios({
        url: '/api/fill',
        method: 'put',
        data: {
          ...this.form
        }
      }).then(res => {
        if(res.data.code == 200) {
          this.$message({ //成功修改提示
            message: '更新成功',
            type: 'success'
          })
        }
        this.getAnswerInfo()
      })
      }
      else if(this.type == "判断题"){
        console.log("进行"+this.type+"更新");
        this.$axios({
        url: '/api/judge',
        method: 'put',
        data: {
          ...this.form
        }
      }).then(res => {
        if(res.data.code == 200) {
          this.$message({ //成功修改提示
            message: '更新成功',
            type: 'success'
          })
        }
        this.getAnswerInfo()
      })
      }
      else if(this.type == "简答题"){
        console.log("进行"+this.type+"更新");
        this.$axios({
        url: '/api/short',
        method: 'put',
        data: {
          ...this.form
        }
      }).then(res => {
        if(res.data.code == 200) {
          this.$message({ //成功修改提示
            message: '更新成功',
            type: 'success'
          })
        }
        this.getAnswerInfo()
      })
      }
    },
    handleClose(done) { //关闭提醒
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        }).catch(_ => {});
    },
    edit(questionId,type) { //编辑试题
      this.dialogVisible = true;
      this.getCourseInfo();
      this.getChapterInfo1();
      this.type = type;
      console.log("题型为： "+type);
      console.log("问题编号 ： "+questionId);
      this.$axios(`/api/problem/${questionId}/${type}`).then(res => { //根据id请求后台
        console.log(res);
        if(res.data.code == 200) {
          this.form = res.data.data
        }
      })
    },
    getCourseInfo() {
      //获取所有课程供选择
      this.$axios(`/api/courses`).then(res => {
      this.courses = res.data.data;
      console.log(res.data.data);
      }).catch((err) => {
      //输出异常
      console.log(err);
      })
    },
    getChapterInfo1() {
      //获取所有课程供选择
      this.$axios(`/api/allchapters`).then(res => {
      this.chapters = res.data.data;
      console.log("看这里")
      console.log(res.data.data);
      }).catch((err) => {
      //输出异常
      console.log(err);
      })
    },
    getChapterInfo(value) {
      //获取所有章节供选择
      //this.courseId = parseInt(this.form.courseId);
      //console.log(this.courseId);
      //this.form.chapterId = '';
      if(this.form.chapterId){
        this.form.chapterId = '';
      }
      console.log("value = "+value)
      this.$axios(`/api/coursesById/${value}`).then(res => {
      this.chapters = res.data.data;
      }).catch((err) => {
      //输出异常
      console.log(err);
      })
    },
    getAnswerInfo() {
      //分页查询所有试卷信息
      this.$axios(
        `/api/problems/${this.pagination.current}/${this.pagination.size}`
      )
        .then(res => {
          this.pagination = res.data.data;
          console.log(res);
        })
        .catch(error => {});
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getAnswerInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getAnswerInfo();
    },
    tableRowClassName({ row, rowIndex }) {
      if (rowIndex % 2 == 0) {
        return "warning-row";
      } else {
        return "success-row";
      }
    }
  }
};
</script>
<style lang="scss" scoped>
.exam {
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
    background-color: #DD5862 !important;
  }
}
  .el-table .warning-row {
    background: #000 !important;
    
  }

  .el-table .success-row {
    background: #DD5862;
  }

</style>