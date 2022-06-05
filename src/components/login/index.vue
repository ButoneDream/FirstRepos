<template>

  <div class="login-container">
    <div class="login-box">

      <!-- 头像区域 -->
      <div class="text-center avatar-box">
        <img src="./logo.png" class="img-thumbnail avatar" alt="图片丢失">
      </div>

      <!-- 表单区域 -->
      <div class="form-login p-4">
        <!-- 登录名称 -->
        <div class="form-group form-inline">
          <label for="username">登录名称</label>
          <input 
            type="text" 
            class="form-control ml-2" 
            id="username" 
            placeholder="请输入登录名称" 
            autocomplete="off" 
            v-model.trim="username">
        </div>
        <!-- 登录密码 -->
        <div class="form-group form-inline">
          <label for="password">登录密码</label>
          <input 
            type="password" 
            class="form-control ml-2" 
            id="password" 
            placeholder="请输入登录密码"
            v-model.trim="password"
            >
        </div>
        <!-- 注册按钮 -->
        <div class="form-group form-inline d-flex justify-content-end">
          <button type="button" class="btn btn-link" @click="gotoReg">前往注册</button>
        </div>
        <!-- 登录和重置按钮 -->
        <div class="form-group form-inline d-flex justify-content-center">
          <button type="button" class="btn btn-secondary mr-2" @click="reset">重置</button>
          <button type="button" class="btn btn-primary" @click="login">登录</button>
        </div>
      </div>

    </div>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  name: 'MyLogin',
  data(){
     return{
       username: 'admin',
       password: '123456'
     }
  },
  methods:{
    //跳转至注册页面
    gotoReg(){
      this.$router.push('/register')
    },
    //重置输入框 清空
    reset(){
      this.username = '',
      this.password = ''
    },
    //登录方法 异步
    async login(){
      let par = { 
          username:this.username,
          password:this.password
                }
      const { data:res } = await axios.post('http://localhost:8082/login',par)
      console.log('响应数据==',res);
      let check = res
      console.log(check)
      
      if(check == '登录成功'){
        alert('登录成功！')
        // 登录成功
        // 1. 存储 token
        localStorage.setItem('token','Bearer xxxx')
        // 2. 跳转到后台主页
        this.$router.push('/index')
      }
      else {
        // 登录失败
        alert('登录失败！')
        localStorage.removeItem('token')
      }
    }
  }
}
</script>

<style lang="less" scoped>
// body{
//     background-color: #2d3a4b !important
// }
label{
  color: white;
}
.login-container {
  background-color: #2d3a4b;
  height: 100%;
  .login-box {
    width: 30%;
    height: 80%;
    background-color: #2d3a4b;
    border-radius: 3px;
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
    box-shadow: 0 0 6px rgba(255, 255, 255, 0.5);
    .form-login {
      // position: absolute;
      margin-top: 300px;
      bottom: 0;
      left: 0;
      width: 100%;
      box-sizing: border-box;
    }
  }
}

.form-control {
  flex: 1;
}

.avatar-box {
  position: absolute;
  width: 100%;
  top: -65px;
  left: 0;
  .avatar {
    width: 120px;
    height: 120px;
    border-radius: 50% !important;
    box-shadow: 0 0 6px #efefef;
  }
}
</style>
