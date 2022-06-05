<template>
    <div id="blood_sugar">
        <!--添加按钮-->
        <el-button style="margin-top: 10px" size="mini" type="success" @click="show = !show">添加</el-button>
        <!--员工信息列表-->
        <el-table :data="tableData.filter(data => !search || data.cont.toLowerCase().includes(search.toLowerCase()))"
            style="width: 100%" height="300">
            <el-table-column label="用户编号" width="200" prop="uid" />
            <el-table-column label="编号" width="200" prop="id" />
            <el-table-column label="志愿活动" width="200" prop="cont" />
            <el-table-column label="发布时间" width="200" prop="date" />
            <el-table-column label="备注" width="200" prop="note">
            </el-table-column>
            <el-table-column align="right">
                <template slot="header" slot-scope="scope">
                    <el-input v-model="search" size="mini" style="width: auto" placeholder="输入志愿活动关键字搜索" />
                </template>
                <template slot-scope="scope">
                    <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-popconfirm confirm-button-text='好的' cancel-button-text='不用了' icon="el-icon-info"
                        icon-color="red" title="确定删除吗？" @confirm="handleDelete(scope.$index, scope.row)">
                        <el-button size="mini" type="danger" slot="reference">删除</el-button>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>
        <!--分页组件-->
        <el-row>
            <el-col :span="12" offset="12">
                <el-pagination style="margin: 15px 0px" background layout="prev, pager, next, jumper, total, sizes"
                    :page-size="size" :current-page="now" :page-sizes="[2, 4, 6, 8, 10, 12]" @current-change="findPage"
                    @size-change="findSize" :total="total">
                </el-pagination>
            </el-col>
        </el-row>
        <!--Steps步骤条-->
        <el-steps :active="active" finish-status="success">
            <el-step title="添加"></el-step>
            <el-step title="修改"></el-step>
        </el-steps>
        <!--表单布局-->
        <el-row>
            <el-col :span="12">
                <!--添加表单-->
                <div style="margin-top: 0px; height: 400px;">
                    <el-collapse-transition>
                        <div v-show="show" class="transition-box">
                            <el-form ref="form" :model="form" label-suffix=":" label-width="80px">
                                <el-form-item label="用户编号">
                                    <el-input v-model="form.uid"></el-input>
                                </el-form-item>
                                <el-form-item label="编号">
                                    <el-input v-model="form.id"></el-input>
                                </el-form-item>
                                <el-form-item label="志愿活动">
                                    <el-input v-model="form.cont"></el-input>
                                </el-form-item>
                                <el-form-item label="发布时间">
                                    <el-date-picker value-format="yyyy-MM-dd HH:mm:ss" type="datetime" placeholder="请选择"
                                        v-model="form.date" style="width: 100%;"></el-date-picker>
                                </el-form-item>
                                <el-form-item label="备注">
                                    <el-input type="textarea" v-model="form.note"></el-input>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="primary" @click="onSubmit">添加</el-button>
                                    <el-button @click="clearInfo">重置</el-button>
                                </el-form-item>
                            </el-form>
                        </div>
                    </el-collapse-transition>
                </div>
            </el-col>
            <el-col :span="12">
                <!--修改表单-->
                <div style="margin-top: 0px; height: 400px;">
                    <el-collapse-transition>
                        <div v-show="show2" class="transition-box">
                            <el-form ref="form" :model="form" label-suffix=":" label-width="80px">
                                <el-form-item label="用户编号">
                                    <el-input v-model="form.uid"></el-input>
                                </el-form-item>
                                <el-form-item label="编号">
                                    <el-input v-model="form.id"></el-input>
                                </el-form-item>
                                <el-form-item label="修改内容">
                                    <el-input v-model="form.cont"></el-input>
                                </el-form-item>
                                <el-form-item label="修改时间">
                                    <el-date-picker type="datetime" value-format="yyyy-MM-dd HH:mm:ss" placeholder="请选择" v-model="form.date"
                                        style="width: 100%;"></el-date-picker>
                                </el-form-item>
                                <el-form-item label="备注">
                                    <el-input type="textarea" v-model="form.note"></el-input>
                                </el-form-item>
                                <el-form-item>
                                    <el-button type="primary" @click="onSubmit2">修改</el-button>
                                    <el-button @click="clearInfo">重置</el-button>
                                </el-form-item>
                            </el-form>
                        </div>
                    </el-collapse-transition>
                </div>
            </el-col>
        </el-row>
    </div>
</template>

<script>
export default {
    name: "blood_sugar",
    data() {
        return {
            tableData: [],
            search: '',
            show: false,
            show2: false,
            form: {
                uid: '',
                id: '',
                cont: '',
                date: '',
                note: ''
            },
            total: 0,
            now: 1,
            size: 4
        }
    },
    methods: {
        findPage(now_page) {//用来处理当前页的方法,page为当前页
            this.now = now_page;
            this.showAllUsers(now_page, this.size);
        },
        findSize(now_size) {//用来处理每页条数的方法,size为当前页条数
            this.size = now_size;
            this.showAllUsers(this.now, now_size);
        },
        clearInfo() {
            this.form = {};
        },
        handleEdit(index, row) {
            console.log(index, row);
            this.show2 = !this.show2;//展示编辑表单
            this.form = row;
        },
        handleDelete(index, row) {
            //发送axios异步请求到删除用户的controller
            this.axios.get("http://localhost:8082/vol/deleteByID?id=" + row.id).then(res => {
                //判断执行状态
                if (res.data.status) {
                    this.$message({
                        message: res.data.msg,
                        type: 'success'
                    });
                } else
                    this.$message.error(res.data.msg);
                this.showAllUsers();//重新渲染数据
            });
        },
        onSubmit() {
            //发送axios异步请求到添加用户的controller
            this.axios.post("http://localhost:8082/vol/add", this.form).then(res => {
                //判断执行状态
                if (res.data.status) {
                    this.$message({
                        message: '恭喜你,' + res.data.msg,
                        type: 'success'
                    });
                    // this.form = {sex: '男'};//清空表单信息
                    this.show = false;//隐藏表单
                } else
                    this.$message.error(res.data.msg);
                this.showAllUsers();//重新渲染数据
            });
        },
        onSubmit2() {
            //发送axios异步请求到修改用户的controller
            this.axios.post("http://localhost:8082/vol/update", this.form).then(res => {
                //判断执行状态
                if (res.data.status) {
                    this.$message({
                        message: '恭喜你,' + res.data.msg,
                        type: 'success'
                    });
                    this.show2 = false;//隐藏表单
                } else
                    this.$message.error(res.data.msg);
                this.showAllUsers();//重新渲染数据
            });
        },
        showAllUsers(currentPage, pageSize) {  //异步请求显示所有数据
            currentPage = currentPage ? currentPage : this.now;
            pageSize = pageSize ? pageSize : this.size;
            this.axios.get("http://localhost:8082/vol/findByPage?nowPage=" + currentPage + "&rows=" + pageSize).then(res => {
                this.tableData = res.data.vol;
                this.total = res.data.total;
            });
        }
    },
    created() {
        this.showAllUsers();
    }
}
</script>

<style scoped>
.transition-box {
    margin-bottom: 10px;
    width: 100%;
    height: 400px;
    border-radius: 4px;
    background-color: #ffffff;
    text-align: left;
    color: #fff;
    padding: 0px 10px;
    box-sizing: border-box;
    margin-right: 20px;
}
</style>
