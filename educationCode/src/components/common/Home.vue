<!--
<template>
	<div class="hello">
		<el-upload
			class="avatar-uploader"
			action="http://localhost:8080/test/upload"
			:show-file-list="false"
			:on-success="handleAvatarSuccess"
			:before-upload="beforeAvatarUpload"
		>
			<img v-if="imageUrl" :src="imageUrl" class="avatar" />
			<i v-else class="el-icon-plus avatar-uploader-icon"></i>
		</el-upload>
    <div>
      <span>展示</span>
      <img :src="imageUrl" class="avatar" />
    </div>
	</div>
</template>
<script>
export default {
	name: 'HelloWorld',
	data() {
		return {
			imageUrl: '',
      img: ''
		};
	}
	,
	 methods: {
      handleAvatarSuccess(res, file) {
        console.log(res);
        console.log(file);
        console.log(file.name);
        //this.img = require("@/assets/myimage/"+file.name);
        console.log("img: "+this.img);
        this.imageUrl = URL.createObjectURL(file.raw);
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
};
</script>
-->
<!-- Add "scoped" attribute to limit CSS to this component only -->
<!--
<style scoped>
 .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
-->