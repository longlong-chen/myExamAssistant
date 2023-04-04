//查询所有试卷信息
<template>
  <div class="exam">
    <el-table :data="pagination.records" border>
      <el-table-column fixed="left" prop="paperId" label="试卷编号" width="150"></el-table-column>
      <el-table-column prop="paperName" label="试卷名称" width="180"></el-table-column>
      <el-table-column prop="createDate" label="创建日期" width="120"></el-table-column>
      <el-table-column prop="totalTime" label="持续时间" width="120"></el-table-column>
      <el-table-column prop="mark" label="总分" width="120"></el-table-column>
      <el-table-column prop="type" label="试卷类型" width="120"></el-table-column>
      <el-table-column prop="tips" label="考生提示" width="400"></el-table-column>
      <el-table-column label="是否发布" prop="publishFlag">
        <!-- scope.row 就是当前行的信息 -->
        <template slot-scope="scope">
            <el-switch v-model="scope.row.publishFlag" @change="userStateChanged(scope.row)"></el-switch>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row.paperId)" type="primary" size="small">编辑</el-button>
          <el-button @click="deleteRecord(scope.row.paperId)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[4, 8, 10, 20]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total" class="page">
    </el-pagination>
    <!-- 编辑对话框-->
    <el-dialog
      title="编辑试卷信息"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <section class="update">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="试卷名称">
            <el-input v-model="form.paperName"></el-input>
          </el-form-item>
          <el-form-item label="创建日期">
            <el-col :span="11">
              <el-date-picker type="date" placeholder="选择日期" v-model="form.createDate"  :disabled="true" style="width: 100%;"></el-date-picker>
            </el-col>
          </el-form-item>
          <el-form-item label="持续时间">
            <el-input v-model="form.totalTime"></el-input>
          </el-form-item>
          <el-form-item label="总分">
            <el-input v-model="form.mark"></el-input>
          </el-form-item>
          <el-form-item label="试卷类型">
            <el-input v-model="form.type"></el-input>
          </el-form-item>
          <el-form-item label="考生提示">
            <el-input type="textarea" v-model="form.tips"></el-input>
          </el-form-item>
          <el-form-item label="是否发布">
              <el-switch v-model="form.publishFlag"></el-switch>
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
      form: {
      }, //保存点击以后当前试卷的信息
      pagination: { //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 4 //每页条数
      },
      dialogVisible: false
    }
  },
  created() {
    this.getPaperInfo()
  },
  methods: {
    /*formatTime(date) { //日期格式化
      //let date = new Date(date);
      let year = date.getFullYear();
      let month= date.getMonth()+ 1 < 10 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
      let day=date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
      let hours=date.getHours() < 10 ? "0" + date.getHours() : date.getHours();
      let minutes=date.getMinutes() < 10 ? "0" + date.getMinutes() : date.getMinutes();
      let seconds=date.getSeconds() < 10 ? "0" + date.getSeconds() : date.getSeconds();
      // 拼接
      return year+"-"+month+"-"+day+" "+hours+":"+minutes+":"+seconds;
    },*/
    edit(paperId) { //编辑试卷
      this.dialogVisible = true
      this.$axios(`/api/paperInfo/${paperId}`).then(res => { //根据试卷id请求后台
        if(res.data.code == 200) {
          this.form = res.data.data
        }
      })
    },
    handleClose(done) { //关闭提醒
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        }).catch(_ => {});
    },
    submit() { //提交修改后的试卷信息
      this.dialogVisible = false;
      //let createDate = this.formatTime(this.form.createDate);
      //this.form.createDate = createDate.substr(0,10);
      this.$axios({
        url: '/api/paperInfo',
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
        this.getPaperInfo()
      })
    },
    deleteRecord(paperId) {
      this.$confirm("确定删除该记录吗,该操作不可逆！！！","删除提示",{
        confirmButtonText: '确定删除',
        cancelButtonText: '算了,留着',
        type: 'danger'
      }).then(()=> { //确认删除
        this.$axios({
          url: `/api/paperInfo/${paperId}`,
          method: 'delete',
        }).then(res => {
          this.getPaperInfo()
        })
      }).catch(() => {

      })
    },
    getPaperInfo() { //分页查询所有试卷信息
      this.$axios(`/api/paperInfos/${this.pagination.current}/${this.pagination.size}`).then(res => {
        this.pagination = res.data.data;
        //console.log("res: "+this.pagination);
      }).catch(error => {
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val
      this.getPaperInfo()
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val
      this.getPaperInfo()
    },
    // 修改用户状态
    async userStateChanged(paperinfo) {
      this.$axios({
          url: `/api/paperState/${paperinfo.paperId}/${paperinfo.publishFlag}`,
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
    }
  },
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
  .edit{
    margin-left: 20px;
  }
}
</style>