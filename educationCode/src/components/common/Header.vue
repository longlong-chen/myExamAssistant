<template>
    <header id="topbar">
        <el-row>
            <el-col :span="4" class="topbar-left">
                <i class="iconfont icon-kaoshi"></i>
                <span class="title" @click="index()">EXAM-SYSTEM</span>
            </el-col>
            <el-col :span="20" class="topbar-right">
                <i class="el-icon-menu" @click="toggle()"></i>
                <div class="user">
                    <span>{{user.userName}}</span>
                    <img src="@/assets/img/userimg.png" class="user-img" ref="img" @click="showSetting()" />
                    <transition name="fade">
                        <div class="out" ref="out" v-show="login_flag">
                            <ul>
                                <li @click="checkGrade(user.userId,role)"><a href="javascript:;">我的主页</a></li>
                                <li @click="setting()"><a href="javascript:;">设置</a></li>
                                <li class="exit" @click="exit()"><a href="javascript:;">退出</a></li>
                            </ul>
                        </div>
                    </transition>
                </div>
            </el-col>
        </el-row>
        <!-- 编辑对话框-->
        <!--学生-->
        <el-dialog
          title="个人中心"
          :visible.sync="dialogVisible1"
          :modal-append-to-body="false"
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
            <el-button @click="cancle()">关 闭</el-button>
            <el-button type="primary" @click="submit( )">保 存</el-button>
          </span>
        </el-dialog>
        <!--老师-->
        <el-dialog
          title="个人中心"
          :visible.sync="dialogVisible2"
          :modal-append-to-body="false"
          width="30%"
          :before-close="handleClose">
          <section class="update">
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="账号">
              <el-input v-model="form.teacherId" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="姓名">
              <el-input v-model="form.teacherName"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input v-model="form.teacherPassword"></el-input>
            </el-form-item>
            <el-form-item label="电话">
              <el-input v-model="form.teacherPhone"></el-input>
            </el-form-item>
            <el-form-item label="邮箱">
              <el-input v-model="form.teacherEmail"></el-input>
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
             <el-form-item label="职称">
              <el-input v-model="form.teacherType"></el-input>
            </el-form-item>
          </el-form>
          </section>
          <span slot="footer" class="dialog-footer">
            <el-button @click="cancle()">关 闭</el-button>
            <el-button type="primary" @click="submit( )">保 存</el-button>
          </span>
        </el-dialog>
        <!--管理员-->
        <el-dialog
          title="个人中心"
          :visible.sync="dialogVisible3"
          :modal-append-to-body="false"
          width="30%"
          :before-close="handleClose">
          <section class="update">
          <el-form ref="form" :model="form" label-width="80px">
            <el-form-item label="账号">
              <el-input v-model="form.administratorId" :disabled="true"></el-input>
            </el-form-item>
            <el-form-item label="姓名">
              <el-input v-model="form.administratorName"></el-input>
            </el-form-item>
            <el-form-item label="密码">
              <el-input v-model="form.administratorPassword"></el-input>
            </el-form-item>
            <el-form-item label="电话">
              <el-input v-model="form.administratorPhone"></el-input>
            </el-form-item>
            <el-form-item label="邮箱">
              <el-input v-model="form.administratorEmail"></el-input>
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
          </el-form>
          </section>
          <span slot="footer" class="dialog-footer">
            <el-button @click="cancle()">关 闭</el-button>
            <el-button type="primary" @click="submit( )">保 存</el-button>
          </span>
        </el-dialog>
    </header>
</template>

<script>
import store from '@/vuex/store'
import storeTeacher from '@/vuex/storeTeacher'
import {mapState,mapMutations} from 'vuex'
export default {
    data() {
        return {
            role: null,
            dialogVisible1: false, //对话框
            dialogVisible2: false,
            dialogVisible3: false,
            form: {}, //保存点击以后当前老师的信息
            login_flag: false,
            user: { //用户信息
                userName: null,
                userId: null
            }
        }
    },
    created() {
        this.getUserInfo()
    },
    methods: {
        //显示、隐藏退出按钮
        showSetting() {
            this.login_flag = !this.login_flag
        },
        //左侧栏放大缩小
        ...mapMutations(["toggle"]),
        getUserInfo() { //获取用户信息
            this.role = this.$cookies.get("role");
            let userName = this.$cookies.get("cname");
            let userId = this.$cookies.get("cid");
            this.user.userName = userName;
            this.user.userId = userId;
        },
        index() {
            //this.$router.push({path: '/adminHome'})
        },
        exit() {
            let role = this.$cookies.get("role")
            this.$router.push({path:"/"}) //跳转到登录页面
            this.$cookies.remove("cname") //清除cookie
            this.$cookies.remove("cid")
            this.$cookies.remove("role")
            /*if(role == 0) {
                this.menu.pop()
            }*/
        },
        setting() {
          //跳转到修改页码页面
          this.$router.push({path: '/setting'})
        },
        checkGrade(userId,role) { //修改信息
          console.log("role="+role);
          if(role == 0){
            this.dialogVisible3 = true;
            this.$axios(`/api/admin/${userId}`).then(res => {
            this.form = res.data.data
            }).catch((err) => {
              //输出异常
              console.log("获取当前ID下的管理员信息");
              console.log(err);
            })
          }
          if(role == 2){
            this.dialogVisible1 = true
            this.$axios(`/api/student/${userId}`).then(res => {
            this.form = res.data.data
            }).catch((err) => {
              //输出异常
              console.log("获取当前ID下的学生信息");
              console.log(err);
            })
          }
          if(role == 1){
            this.dialogVisible2 = true
            this.$axios(`/api/teacher/${userId}`).then(res => {
            this.form = res.data.data
            }).catch((err) => {
              //输出异常
              console.log("获取当前ID下的老师信息");
              console.log(err);
            })
          }
        },
        handleClose(done) { //关闭提醒
          this.$confirm('确认关闭？')
          .then(_ => {
            done();
          }).catch(_ => {});
        },
        submit() {
          if(this.role == 0){
            console.log("修改管理员信息");
            this.dialogVisible3 = false;
            this.$axios({
              url: '/api/admin',
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
              this.getUserInfo()
            }).catch((err) => {
              //输出异常
              //console.log("4444444444");
              console.log(err);
              this.$message({
                message: '更新失败',
                type: 'error'
              })
            })
          }
          if(this.role == 1){
            console.log("修改老师信息");
            this.dialogVisible2 = false;
            this.$axios({
              url: '/api/teacher',
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
              this.getUserInfo()
            }).catch((err) => {
              //输出异常
              //console.log("4444444444");
              console.log(err);
              this.$message({
                message: '更新失败',
                type: 'error'
              })
            })
          }
          if(this.role == 2){
            console.log("修改学生信息");
            this.dialogVisible1 = false;
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
              this.getUserInfo()
            }).catch((err) => {
              //输出异常
              console.log("4444444444");
              console.log(err);
              this.$message({
                message: '更新失败',
                type: 'error'
              })
            })
          }
        },
        cancle() {
          this.dialogVisible1 = false;
          this.dialogVisible2 = false;
          this.dialogVisible3 = false;
        }
    },
    store
}
</script>

<style scoped>
.fade-enter-active, .fade-leave-active {
  transition: opacity .5s;
}
.fade-enter, .fade-leave-to /* .fade-leave-active below version 2.1.8 */ {
  opacity: 0;
}
#topbar {
  position: relative;
  z-index: 10;
  background-color: #124280;
  height: 80px;
  line-height: 80px;
  color: #fff;
  box-shadow: 5px 0px 10px rgba(0, 0, 0, 0.5);
}
#topbar .topbar-left {
  height: 80px;
  display: flex;
  justify-content: center;
  background: rgba(0, 0, 0, 0.05);
  overflow: hidden;
}
.topbar-left .icon-kaoshi {
  font-size: 60px;
}
.topbar-left .title {
  font-size: 20px;
  cursor: pointer;
}
.topbar-right {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.topbar-right .el-icon-menu {
  font-size: 30px;
  margin-left: 20px;
}
.topbar-right .user {
  position: relative;
  margin-right: 40px;
  display: flex;
}
.topbar-right .user-img {
  width: 50px;
  height: 50px;
  /*border-radius: 50%;*/
  position:relative; 
  top:15px;
}
.user .out {
  font-size: 14px;
  position: absolute;
  top: 80px;
  right: 0px;
  background-color: #fff;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  padding: 12px;
}
.user .out ul {
  list-style: none;
}
.user .out ul > li {
  height: 26px;
  line-height: 26px;
  margin-top: 4px;
  padding-top: 4px;
}
.out a {
  text-decoration: none;
  color: #000;
}
.out .exit {
  margin-top: 4px;
  padding-top: 4px;
  /*border-top: 1px solid #ccc;*/
}
</style>