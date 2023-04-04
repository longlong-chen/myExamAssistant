// 成绩统计页面
<template>
  <div id="mygrade">
    <div class="title">我的成长足迹</div>
  <div id="grade">
    <div ref="box" class="box"></div>
    <div class="notFound" v-if="isNull">
      <i class="iconfont icon-LC_icon_tips_fill"></i><span>您还未参加过练习喔</span>
    </div>
  </div>
  </div>
</template>

<script>
export default {
  name: "grade",
  data() {
    return {
      isNull: false, //原始数据
      tableDataX: [], //x轴数据 保存次数
      tableDataY: [], //y轴数据 保存分数
    }
  },
  mounted() {
    this.score();
  },
  methods: {
    score() {
      let studentId = this.$cookies.get("cid")
      this.$axios(`/api/score/${studentId}`).then(res => { //根据学生Id查询成绩
        console.log(res)
        if(res.data.code == 200) {
          let rootData = res.data.data
          rootData.forEach((element,index) => {
            this.tableDataX.push(`第${index + 1}次`)
            this.tableDataY.push(element.score)
          });
          let boxDom = this.$refs["box"];
          let scoreCharts = this.$echarts.init(boxDom);
          let option = {
            xAxis: {
              type: "category",
              data: this.tableDataX
            },
            yAxis: {
              type: "value"
            },
            series: [
              {
                data: this.tableDataY,
                type: "line",
                itemStyle: { normal: { label: { show: true } } }
              }
            ]
          };
          scoreCharts.setOption(option);
          scoreCharts.on("mouseover", params => {
            console.log(params.value);
          });
        }else {
          this.isNull = true
        }
      })
    }
  }
};
</script>

<style lang="scss" scoped>
#mygrade {
  width: 980px;
  margin: 0 auto;
}
#grade {
  position: relative;
  //width: 980px;
  //margin: 0 auto;
  background-color: #fff;
  .box{
    width: 600px;
    height: 400px;
  }
  .notFound {
    position: absolute;
    top: 0px;
    left: 0px;
  }
}
.title {
  margin: 20px;
}
</style>