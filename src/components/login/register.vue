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
          <label for="username">用户名称</label>
          <input 
            type="text" 
            class="form-control ml-2" 
            id="username" 
            placeholder="请输入用户名" 
            autocomplete="off" 
            v-model.trim="username">
        </div>
        <!-- 登录密码 -->
        <div class="form-group form-inline">
          <label for="password">用户密码</label>
          <input 
            type="password" 
            class="form-control ml-2" 
            id="password" 
            placeholder="请输入密码"
            v-model.trim="password"
            >
        </div>
        <!-- 手机号码 -->
        <div class="form-group form-inline">
          <label for="phone">手机号码</label>
          <input 
            type="phone" 
            class="form-control ml-2" 
            id="phone" 
            placeholder="请输入手机号"
            v-model.trim="phone"
            >
        </div>
        <!-- 注册和重置按钮 -->
        <div class="form-group form-inline d-flex justify-content-center">
          <button type="button" class="btn btn-secondary mr-2" @click="reset">重置</button>
          <button type="button" class="btn btn-primary" @click="register">注册</button>
        </div>
      </div>

    </div>
  </div>
</template>
<script>
import axios from 'axios'
export default {
  name: 'MyRegister',
  data(){
     return{
       username: '',
       password: '',
       phone:''
     }
  },
  methods:{
    reset(){
      this.username = '',
      this.password = '',
      this.phone=''
    },
    async register(){
      let par = { 
          username:this.username,
          password:this.password,
          phone:this.phone
                }
      const { data:res } = await axios.post('http://localhost:8082/save',par)
      console.log('响应数据==',res);
      let check = res
      console.log(check)
      
      if(check == '操作成功'){
        alert('注册成功！')
        
        //  跳转到登录页面
        this.$router.push('/')
      }
      else {
        // 注册失败
        alert('操作失败！')
       
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
