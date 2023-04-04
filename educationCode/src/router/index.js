import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/login'

    },
    {
      path: '/login',
      //name: 'login', //登录界面
      component: () => import('@/components/common/Login')
    },
    {
      path: '/student',
      component: () => import('@/components/student/index'),
      children: [
        {path:"/",component: ()=> import('@/components/student/myExam')},
        {path: '/manager', component: () => import('@/components/common/Setting')},
        {path: '/examMsg', component: () => import('@/components/student/examMsg')},
        {path: '/studentScore', component: () => import("@/components/student/answerScore")},
        {path: '/scoreTable', component: () => import("@/components/student/scoreTable")},
        {path:'/startExam', component: () => import('@/components/student/startExam')},
        {path:'/grade', component: () => import('@/components/charts/grade')},
        {path: '/message', component: () => import('@/components/student/message')},
        {path:'/scorePart', component: () => import('@/components/charts/scorePart')}
      ]
    },
    {
      path: '/teacherHome',
      component: () => import('@/components/teacher/TeacherHome'),
      children: [
        {
          path: '/',
          component: () => import('@/components/common/Welcom')
        },
        {
          path: '/problemManage',
          component: () => import('@/components/teacher/ProblemManage')
        },
        {
          path: '/addProblem',
          component: () => import('@/components/teacher/AddProblem')
        },
        {
          path: '/paperInfoManage',
          component: () => import('@/components/teacher/PaperInfoManage')
        },
        {
          path: '/addPaperInfo',
          component: () => import('@/components/teacher/AddPaperInfo')
        }
      ]
    },
    {
      path: '/adminHome',
      component: () => import('@/components/admin/AdminHome'),
      children: [
        {
          path: '/',
          component: () => import('@/components/common/Welcom')
        },
       {
          path: '/teacherManage',
          component: () => import('@/components/admin/TeacherManage')
        },
        {
          path: '/addTeacher',
          component: () => import('@/components/admin/AddTeacher')
        },
        {
          path: '/studentManage',
          component: () => import('@/components/admin/StudentManage')
        },
        {
          path: '/addStudent',
          component: () => import('@/components/admin/AddStudent')
        },
        {
          path: '/courseManage',
          component: () => import('@/components/admin/CourseManage')
        },
        {
          path: '/addCourse',
          component: () => import('@/components/admin/AddCourse')
        },
        {
          path: '/chapterManage',
          component: () => import('@/components/admin/ChapterManage')
        },
        {
          path: '/addChapter',
          component: () => import('@/components/admin/AddChapter')
        }
      ]
    },
    {
      path: '/setting',
      component: () => import('@/components/common/Setting')
    },
    {
      path: '/header',
      component: () => import('@/components/common/Header')
    },
    {
      path: '/home',
      component: () => import('@/components/common/Home')
    },
    {
      path: '/test',
      component: () => import('@/components/common/Test')
    },
    {
      path: '/addProblem',
      component: () => import('@/components/teacher/AddProblem')
    },
    {path: '/answer',component: () => import('@/components/student/answer')}
  ]
})
