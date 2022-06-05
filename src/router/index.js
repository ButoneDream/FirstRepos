import Vue from 'vue'
import Router from 'vue-router'
import Index from "../components/index"
import List from "../components/employee/list"
import Blood_sugar from "../components/healthdata/blood_sugar"
import Notice from "../components/notice.vue"
import Helpinfo from "../components/helpinfo.vue"
import Vol  from "../components/volunteer.vue"
import Login from "../components/login/index"
import Register from "../components/login/register"
Vue.use(Router)

export default new Router({
  routes: [
    {
     path: '/login',
     component:Login ,
     meta:{
        showNav: true
      }
    },
    {
      path:'/register',
      component:Register,
      meta:{
        showNav:true
      }
    },
    {
      path: '/',
      redirect: '/login',
     
    },
    {
      path: '/index',
      component: Index
    },
    {
      path: '/list',
      component: List
    },
    {
      path: '/blood_sugar',
      component: Blood_sugar
    },
    {
      path:'/notice',
      component:Notice
    },
    {
      path:'/helpinfo',
      component:Helpinfo
    },
    {
      path:'/volunteer',
      component:Vol
    }
  ]
})
