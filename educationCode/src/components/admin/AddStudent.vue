<template>
    <section class="update">
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
            <el-form-item label="姓名" prop="studentName">
                <el-input v-model="form.studentName" placeholder="请输入学生姓名"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="studentPassword">
                <el-input v-model="form.studentPassword" placeholder="请输入密码"></el-input>
            </el-form-item>
            <el-form-item label="电话" prop="studentPhone">
                <el-input v-model="form.studentPhone" placeholder="请输入学生电话"></el-input>
            </el-form-item>
            <el-form-item label="邮箱" prop="studentEmail">
                <el-input v-model="form.studentEmail" placeholder="请输入学生邮箱"></el-input>
            </el-form-item>
            <el-form-item label="有效位" prop="disabledFlag">
                <el-switch v-model="form.disabledFlag"></el-switch>
            </el-form-item>
            <el-form-item label="学校" prop="studentSchool">
                <el-input v-model="form.studentSchool" placeholder="请输入学生学校"></el-input>
            </el-form-item>
            <el-form-item label="专业" prop="studentMajor">
                <el-input v-model="form.studentMajor" placeholder="请输入学生专业"></el-input>
            </el-form-item>
            <el-form-item label="性别" prop="sex">
                <el-select v-model="form.sex" placeholder="请选择性别">
                    <el-option label="男" value="1"></el-option>
                    <el-option label="女" value="0"></el-option>
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
                form: {
                   studentName: '',
                   studentPassword: '',
                   studentPhone: '',
                   studentEmail: '',
                   disabledFlag: false,
                   studentSchool: '',
                   studentMajor: '',
                   sex: ''
                },
                rules: {
                    studentName: [
                        { required: true, message: '请输入学生姓名', trigger: 'blur' }
                    ],
                    studentPassword: [
                        { required: true, message: '请输入密码', trigger: 'blur' }
                    ],
                    studentPhone: [
                        { required: true, message: '请输入学生电话', trigger: 'blur' }
                    ],
                    studentEmail: [
                        { required: true, message: '请输入学生邮箱', trigger: 'blur' }
                    ],
                    studentSchool: [
                        { required: true, message: '请输入学生学校', trigger: 'blur' }
                    ],
                    studentMajor: [
                        { required: true, message: '请输入学生专业', trigger: 'blur' }
                    ],
                    sex: [
                        { required: true, message: '请选择性别', trigger: 'change' }
                    ],
                }
            };
        },
        methods: {
            onSubmit(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        //alert('submit!');
                        this.$axios({
                            url: '/api/student',
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
                                this.$router.push({path: '/studentManage'})
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
                this.$router.push({path: '/studentManage'})
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