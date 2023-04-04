<template>
    <section class="update">
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
            <el-form-item label="章节名称" prop="chapterName">
                <el-input v-model="form.chapterName" placeholder="请输入章节名称"></el-input>
            </el-form-item>
            <el-form-item label="所属课程" prop="courseId">
                <el-select v-model="form.courseId" placeholder="请选择所属课程">
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
            <el-form-item>
                <el-button type="primary" @click="onSubmit('form')">立即创建</el-button>
                <el-button type="text" @click="cancel()">取消</el-button>
                <el-button @click="resetForm('form')">重置</el-button>
            </el-form-item>
        </el-form>
    </section>
</template>

<script>
    export default {
        data() {
            return {
                form: {},
                chapters: [],
                rules: {
                    chapterName: [
                        { required: true, message: '请输入章节名称', trigger: 'blur' }
                    ],
                    courseId: [
                        { required: true, message: '请选择所属课程', trigger: 'change' }
                    ]
                }
            };
        },
        created() {
            this.getCourseInfo();
        },
        methods: {
            getCourseInfo() {
                //获取所有课程供选择
                this.$axios(`/api/courses`).then(res => {
                this.chapters = res.data.data;
                //console.log("输出章节信息");
                //console.log(this.chapters);
                }).catch((err) => {
                //输出异常
                console.log(err);
                 })
            },
            onSubmit(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        //alert('submit!');
                        this.$axios({
                            url: '/api/chapter',
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
                                this.$router.push({path: '/chapterManage'})
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
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            cancel() { //取消按钮
                //this.form = {}
                this.$router.push({path: '/courseManage'})
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