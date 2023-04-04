<template>
<div id="mygrade">
  <div class="title">我的成绩分布</div>
  <div class="part" >
    <div class="box" ref="box"></div>
    <div v-if="isNull">
      <span>您还未参加考试哦,请参加练习后再来查看。</span>
    </div>
  </div>
</div>
</template>

<script>
export default {
  data() {
    return {
      isNull: false, //是否有成绩标志位
      name: null,
      category: { //保存分数段
        '120分及以上': 0,
        '100-119分': 0,
        '90-99分': 0,
        //'80-89分': 0,
        //'70-79分': 0,
        //'60-69分': 0,
        '90分以下': 0
      }
    }
  },
  created() {
    this.getScoreInfo()

  },
  methods: {
    getScoreInfo() {
      //let examCode = this.$route.query.examCode
      //this.name = this.$route.query.source
      let studentId = this.$cookies.get("cid")
      this.name = this.$cookies.get("cname")
      console.log("studentId: "+studentId)
      this.$axios(`/api/score/${studentId}`).then(res => {
        let data = res.data.data
        console.log("长度："+data.length)
        if(data.length > 0) {
          let box = this.$refs['box']
          let charts = this.$echarts.init(box)
          data.forEach(element => {
            console.log("分数： "+Math.floor(element.score / 10))
            switch(Math.floor(element.score / 10)) {
              case 15:
              case 14:
              case 13:
              case 12:
                this.category['120分及以上']++
                break   
              case 11:
              case 10:
                this.category['100-119分']++
                break 
              case 9:
                this.category['90-99分']++
                break
              /*case 8:
                this.category['80-89分']++
                break
              case 7:
                this.category["70-79分"]++
                break
              case 6:
                this.category['60-69分']++
                break*/
              default:
                this.category['90分以下']++
            }
          });
          console.log(this.category['120分及以上'])
            console.log(this.category['100-119分'])
            console.log(this.category['90-99分'])
            console.log(this.category['90分以下'])
          let option = {
              title : {
                  text: `${this.name}的分数段图`,
                  subtext: '分数段饼图',
                  x:'center'
              },
              tooltip : {
                  trigger: 'item',
                  formatter: "{a}：{b} <br/> {c}次 ({d}%)"
              },
              legend: {
                  orient: 'vertical',
                  left: 'left',
                  data: ['120分及以上','100-119分','90-99分','90分以下']
              },
              series : [
                  {
                      name: '分数段',
                      type: 'pie',
                      radius : '35%',
                      center: ['50%', '35%'],
                      data:[
                          {value:this.category['120分及以上'], name:'120分及以上'},
                          {value:this.category['100-119分'], name:'100-119分'},
                          {value:this.category['90-99分'], name:'90-99分'},
                          //{value:this.category['80-89分'], name:'80-89分'},
                          //{value:this.category['70-79分'], name:'70-79分'},
                          //{value:this.category['60-69分'], name:'60-69分'},
                          {value:this.category['90分以下'], name:'90分以下'}
                      ],
                      itemStyle: {
                          emphasis: {
                              shadowBlur: 10,
                              shadowOffsetX: 0,
                              shadowColor: 'rgba(0, 0, 0, 0.5)'
                          }
                      }
                  }
              ]
          };
          charts.setOption(option)
        }else {
          this.isNull = true
        }
      })
    }
  },

}
</script>

<style lang="scss" scoped>
.part {
   background-color: #fff;
  .box {
    width: 800px;
    height: 600px;
    margin-left: 40px;
  }
}
#mygrade {
  width: 980px;
  margin: 0 auto;
}
.title {
  margin: 20px;
}
</style>