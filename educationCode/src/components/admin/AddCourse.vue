<template>
    <section class="update">
        <el-form ref="form" :model="form" :rules="rules" label-width="80px">
            <el-form-item label="课程名称" prop="courseName">
                <el-input v-model="form.courseName" placeholder="请输入课程名称"></el-input>
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
                   courseName: ''
                },
                rules: {
                    courseName: [
                        { required: true, message: '请输入课程名称', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            onSubmit(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        //alert('submit!');
                        this.$axios({
                            url: '/api/course',
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
                                this.$router.push({path: '/courseManage'})
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