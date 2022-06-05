<template>
  <div id="index">
    <!--走马灯组件-->
    <el-carousel indicator-position="" arrow="never">
      <el-carousel-item :key="item">
        <!--图片组件-->
        <!-- <el-image style="height: 600px;background-position:center;" :src="img" :fit="scale-down"></el-image> -->
        <h1 id="h1">欢迎您,超级管理员!</h1>
        <h3 id="h2">登入：{{new Date().toLocaleString()}}</h3>
      </el-carousel-item>
    </el-carousel>
    <!--日历组件-->
    <el-calendar v-model="value"></el-calendar>
  </div>

</template>

<script>
import img1 from "../assets/index_img/1.jpeg"
import img2 from "../assets/index_img/2.jpeg"
import img3 from "../assets/index_img/3.jpeg"
import img4 from "../assets/index_img/4.png"
import img5 from "../assets/index_img/5.png"
import img6 from "../assets/index_img/Spring.png"

export default {
  name: "index",
  data() {
    return {
      H:zero(new Date().getHours),
      M:zero(new Date().getMinutes),
      value: new Date()
    }
  },
  created() {
    function zero(num){
      if(num < 10)
      return '0' + num
    }

    

  },
  methods: {
    
  },

}
</script>

<style scoped>
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}

#h1 {
  text-align:center;margin-top: 100px;
  display: block;  
  color: #01699F;
  /* font-family: "Arial", "Microsoft YaHei", "黑体", "宋体", sans-serif; */
   font-family: "Lucida Calligraphy", cursive, serif, sans-serif;
}
#h2{
  text-align: center;
  font: Tahoma,Helvetica,Arial,'宋体',sans-serif;
}
</style>
