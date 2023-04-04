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
        title: '教师管理',
        icon: 'icon-Userselect',
        content:[
            {
                item1:'教师维护',
                path:'/teacherManage'
            },
            {
                item2: '添加教师',
                path: '/addTeacher'
            }
        ]
    },
    {
        index: '2',
        title: '学生管理',
        icon: 'icon-role',
        content:[
            {
                item1:'学生维护',
                path:'/studentManage'
            },
            {
                item2: '添加学生',
                path: '/addStudent'
            }
        ]
    }/*,
    {
        index: '3',
        title: '资料管理',
        icon: 'icon-module4mokuai',
        content:[
            {
                item1:'商品维护',
                path:'/commodityManage'
            },
            {
                item2: '添加商品',
                path: '/addCommodity'
            }
        ]
    }*/,
    {
      index: '3',
      title: '学科管理',
      icon: 'el-icon-reading',
      content:[
          {
              item1:'科目维护',
              path:'/courseManage'
          },
          {
              item2: '添加科目',
              path: '/addCourse'
          }
      ]
    },
    {
      index: '4',
      title: '章节管理',
      icon: 'el-icon-edit-outline',
      content:[
          {
              item1:'章节维护',
              path:'/chapterManage'
          },
          {
              item2: '添加章节',
              path: '/addChapter'
          }
      ]
    }
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