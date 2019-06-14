<template>
  <div>
    <el-form :inline="true" :model="formInline" class="demo-form-inline" style="margin-left: 10px;">
      <el-form-item label="区划">
        <el-input v-model="formInline.countryId" placeholder="区划"></el-input>
      </el-form-item>
      <el-form-item label="机构">
        <el-input v-model="formInline.orgId" placeholder="机构"></el-input>
      </el-form-item>
      <el-form-item label="时间">
        <el-date-picker
          v-model="formInline.value1"
          type="date"
          placeholder="选择日期">
        </el-date-picker>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">查询</el-button>
      </el-form-item>
    </el-form>
    <div  class="text item">
      <template>
        <el-table
          :header-cell-style="{background:'#eef1f6',color:'#606266'}"
          :data="tableData"
          style="width: 100%">
          <el-table-column
            prop="name"
            label="姓名"
          >
          </el-table-column>
          <el-table-column
            prop="gender"
            label="性别"
          >
          </el-table-column>
          <el-table-column
            prop="birthday"
            label="出生日期">
          </el-table-column>
            <el-table-column
              prop="address"
              label="家庭地址"
              :show-overflow-tooltip="true"
            >

            </el-table-column>

          <el-table-column
            prop="title"
            label="文档名称"
          >
          </el-table-column>
          <el-table-column
            prop="classCode"
            label="文档类型">
          </el-table-column>
          <el-table-column
            prop="serviceTime"
            label="服务时间"
          >
          </el-table-column>
          <el-table-column
            prop="serviceOrgName"
            label="服务机构"
          >
          </el-table-column>
          <el-table-column
            prop="creationTime"
            label="创建时间">
          </el-table-column>

        </el-table>
      </template>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage4"
        :page-sizes="[100, 200, 300, 400]"
        :page-size="100"
        layout="total, sizes, prev, pager, next, jumper"
        :total="400">
      </el-pagination>
    </div>

  </div>
</template>

<script>
  export default {
    data() {
      return {
        formInline: {
          countryId: '',
          orgId: '',
          value1: '',
        },
        currentPage4: 4,
        tableData: [
          {
            name: '王小虎',
            gender: '男',
            birthday: '2016-05-02',
            address: '上海市普陀区金沙江路 1518 弄',
            title: '上海市',
            classCode: '高档类',
            serviceTime: '2016-05-02',
            serviceOrgName: '普陀区金沙',
            creationTime: '2016-05-02',
        },
          {
            name: '王小虎',
            gender: '男',
            birthday: '2016-05-02',
            address: '上海市普陀区金沙江路 1518 弄',
            title: '上海市',
            classCode: '高档类',
            serviceTime: '2016-05-02',
            serviceOrgName: '普陀区金沙',
            creationTime: '2016-05-02',
          },
          {
            name: '王小虎',
            gender: '男',
            birthday: '2016-05-02',
            address: '上海市普陀区金沙江路 1518 弄',
            title: '上海市',
            classCode: '高档类',
            serviceTime: '2016-05-02',
            serviceOrgName: '普陀区金沙',
            creationTime: '2016-05-02',
          },
          {
            name: '王小虎',
            gender: '男',
            birthday: '2016-05-02',
            address: '上海市普陀区金沙江路 1518 弄',
            title: '上海市',
            classCode: '高档类',
            serviceTime: '2016-05-02',
            serviceOrgName: '普陀区金沙',
            creationTime: '2016-05-02',
          },
        ]

      }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`);
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`);
      }
    },
    created: function () {


    },
    destroyed: function () {

    },
    watch: {},

    computed: {}

  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  .el-pagination {
    margin-top: 12px;
    text-align: right;
  }
</style>
