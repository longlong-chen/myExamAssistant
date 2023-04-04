import VUE from 'vue'
import VUEX from 'vuex'

VUE.use(VUEX)

const state = {
  isPractice: false, //练习模式标志
  flag: false, //菜单栏左右滑动标志
  userInfo: null,
  menu: [
    {
      index: '1',
      title: '题库管理',
      icon: 'icon-tiku',
      content:[
      {
        item1:'题库维护',
        path:'/problemManage'
      },
      {
        item2: '添加题库',
        path: '/addProblem'
      }
      ]
    },
    {
      index: '2',
      title: '试卷信息管理',
      icon: 'el-icon-s-management',
      content:[
        {
          item1: '试卷信息维护',
          path: '/paperInfoManage'
        },
        {
          item2: '试卷信息添加',
          path: '/addPaperInfo'
        }
      ]
    }/*,
    {
      index: '3',
      title: '成绩查询',
      icon: 'icon-performance',
      content:[
        {
          item1:'学生成绩查询',
          path:'/allStudentsGrade'
        },
        {path: '/grade'},
        {
          item2: '成绩分段查询',
          path: '/selectExamToPart'
        },
        {path: '/scorePart'}
      ]
    }*/
]
}
const mutations = {
  practice(state,status) {
    state.isPractice = status
  },
  toggle(state) {
    state.flag = !state.flag
  },
  changeUserInfo(state,info) {
    state.userInfo = info
  }
}
const getters = {
 
}
const actions = {
  getUserInfo(context,info) {
    context.commit('changeUserInfo',info)
  },
  getPractice(context,status) {
    context.commit('practice',status)
  }
}
export default new VUEX.Store({
  state,
  mutations,
  getters,
  actions,
  // store
})