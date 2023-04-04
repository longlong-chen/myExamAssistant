<!--
<template>
    <div>
        <img :src="image" />
    </div>
</template>

<script>
export default {
    data() {
		return {
			img: require('@/assets/myimage/001.jpg'),
            image: ''
		};
	},
    created() {
        this.image = this.img;
        console.log("img: "+this.img);
        console.log("image: "+this.image);
    }
}
</script>
-->
<template>
   
<div class="upload-image">
    <el-form :model="ruleForm" ref="ruleForm" label-width="100px">
        <el-form-item label="活动名称" prop="name">
            <el-input v-model="ruleForm.name" style="width: 300px"></el-input>
        </el-form-item>
        <el-form-item label="上传图片" ref="uploadElement" prop="imageUrl">
            <el-input v-model="ruleForm.imageUrl" v-if="false"></el-input>
           <el-upload
			class="avatar-uploader"
			action="http://localhost:8080/test/upload"
			:show-file-list="false"
			:on-success="handleAvatarSuccess"
			:before-upload="beforeAvatarUpload"
		>
			<img v-if="imgUrl" :src="imgUrl" class="avatar" />
			<i v-else class="el-icon-plus avatar-uploader-icon"></i>
		</el-upload>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="submitForm()">立即创建</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
    </el-form>
    <div>
        展示图片：
        <img :src=baseUrl />
    </div>
</div>
</template>

<script>
    export default {
        data() {
            return {
                baseUrl: '',
                img: '001.jpg',
                imgUrl: '',
                ruleForm: {
                name: '',
                imageUrl: '',
                }
            }
        },
        methods: {
            submitForm() {
                console.log("活动名称： "+this.ruleForm.name+"图片地址： "+this.ruleForm.imageUrl);
            },
            handleAvatarSuccess(res, file) {
                this.baseUrl = require("@/assets/myimage/"+file.name);
                console.log(res);
                console.log(file);
                console.log(file.name);
                this.ruleForm.imageUrl = file.name;
                //this.img = ;
                this.imgUrl = URL.createObjectURL(file.raw);
      },
      beforeAvatarUpload(file) {
        const isJPG = file.type === 'image/jpeg';
        const isLt2M = file.size / 1024 / 1024 < 2; 
        if (!isJPG) {
          this.$message.error('上传头像图片只能是 JPG 格式!');
        }
        if (!isLt2M) {
          this.$message.error('上传头像图片大小不能超过 2MB!');
        }
        return isJPG && isLt2M;
      }
        }
    }
</script>
<style scoped>

</style>