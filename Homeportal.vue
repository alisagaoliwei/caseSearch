<template>
  <div>
    <!-- 方法一(不兼容低版本浏览器) -->
    <div class="lanren"></div>

    <!-- 方法二(兼容主流浏览器) -->
    <div class="lanren2">
      <div class="left"></div>
      <div class="right"></div>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'HelloWorld',
    data() {
      return {


      }
    },
    methods: {
      handleChange(val) {
        console.log(val);
      }
    }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  sexangle1 {
    position: relative;
    top: -0.01rem;
  }
  .sexangleLeftLine, .sexangleRightLine {
    border-left: solid #3676ce;
    border-width: 0.02rem;
    z-index: 22;
    margin: 0;
    padding: 0;
  }
  .sexangleLeftLine {
    position: absolute;
    width: 0;
    top: 25%;
    bottom: 25%;
    z-index: 1;
  }
  .sexangleLeftLine, .sexangleRightLine {
    border-left: solid #3676ce;
    border-width: 0.02rem;
    z-index: 22;
    margin: 0;
    padding: 0;
  }
  sexangleRightLine {
    position: absolute;
    width: 0;
    top: 25%;
    right: 0;
    bottom: 25%;
    z-index: 1;
  }
  .sexangleTitle {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    width: 90%;
    text-align: center;
    font-size: 0.28rem;
    margin: 0 auto;
    color: #ffffff;
    z-index: 1;
  }
  a {
    text-decoration: none;
    color: white;
  }
  handle {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%,-50%);
    width: 90%;
    text-align: center;
    font-size: 0.28rem;
    margin: 0 auto;
    color: #ffffff;
    z-index: 1;
    height: 50%;
    display: none;
    justify-content: center;
    align-items: center;
  }
  .handle .btn {
    width: 0.39rem;
    height: 0.39rem;
    margin: 0 0.32rem;
    cursor: pointer;
  }
  a {
    text-decoration: none;
    color: white;
  }
  .handle .btn img {
    width: 100%;
    height: 100%;
    float: left;
  }
  .sexangle2, .sexangle3 {
    border-left: 0.02rem solid #3676ce;
    border-right: 0.02rem solid #3676ce;
  }
  .sexangle2, .sexangle3 {
    border-left: 0.02rem solid #3676ce;
    border-right: 0.02rem solid #3676ce;
  }
  .circle {
    position: absolute;
    top: 26%;
    left: 100%;
    transform: translate(-50%,-50%);
    text-align: center;
    font-size: 0.28rem;
    margin: 0 auto;
    color: #ffffff;
    background-color: #0c49a6;
    border-radius: 50%;
    width: 1rem;
    height: 1rem;
    z-index: 1;
    display: none;
  }
  .circle div {
    width: 0.2rem;
    height: 0.2rem;
    border-top: 4px solid #2b84ff;
    border-left: 4px solid #2b84ff;
    margin-left: 0.20rem;
    margin-top: 0.45rem;
    transform: rotate(-75deg);
  }

</style>
