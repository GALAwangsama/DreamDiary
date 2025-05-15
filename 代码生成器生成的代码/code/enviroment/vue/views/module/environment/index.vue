<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="用户ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户ID"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="温度" prop="temperature">
        <el-input
          v-model="queryParams.temperature"
          placeholder="请输入温度"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="湿度" prop="humidity">
        <el-input
          v-model="queryParams.humidity"
          placeholder="请输入湿度"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="分贝" prop="decibel">
        <el-input
          v-model="queryParams.decibel"
          placeholder="请输入分贝"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="光线" prop="light">
        <el-input
          v-model="queryParams.light"
          placeholder="请输入光线"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="空气质量" prop="airQuality">
        <el-input
          v-model="queryParams.airQuality"
          placeholder="请输入空气质量"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="二氧化碳浓度" prop="carbonDioxideConcentration">
        <el-input
          v-model="queryParams.carbonDioxideConcentration"
          placeholder="请输入二氧化碳浓度"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['module:environment:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['module:environment:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['module:environment:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['module:environment:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="environmentList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="用户ID" align="center" prop="userId" />
      <el-table-column label="温度" align="center" prop="temperature" />
      <el-table-column label="湿度" align="center" prop="humidity" />
      <el-table-column label="分贝" align="center" prop="decibel" />
      <el-table-column label="光线" align="center" prop="light" />
      <el-table-column label="空气质量" align="center" prop="airQuality" />
      <el-table-column label="二氧化碳浓度" align="center" prop="carbonDioxideConcentration" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['module:environment:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['module:environment:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改环境参数对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="environmentRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="温度" prop="temperature">
          <el-input v-model="form.temperature" placeholder="请输入温度" />
        </el-form-item>
        <el-form-item label="湿度" prop="humidity">
          <el-input v-model="form.humidity" placeholder="请输入湿度" />
        </el-form-item>
        <el-form-item label="分贝" prop="decibel">
          <el-input v-model="form.decibel" placeholder="请输入分贝" />
        </el-form-item>
        <el-form-item label="光线" prop="light">
          <el-input v-model="form.light" placeholder="请输入光线" />
        </el-form-item>
        <el-form-item label="空气质量" prop="airQuality">
          <el-input v-model="form.airQuality" placeholder="请输入空气质量" />
        </el-form-item>
        <el-form-item label="二氧化碳浓度" prop="carbonDioxideConcentration">
          <el-input v-model="form.carbonDioxideConcentration" placeholder="请输入二氧化碳浓度" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Environment">
import { listEnvironment, getEnvironment, delEnvironment, addEnvironment, updateEnvironment } from "@/api/module/environment"

const { proxy } = getCurrentInstance()

const environmentList = ref([])
const open = ref(false)
const loading = ref(true)
const showSearch = ref(true)
const ids = ref([])
const single = ref(true)
const multiple = ref(true)
const total = ref(0)
const title = ref("")

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    userId: null,
    temperature: null,
    humidity: null,
    decibel: null,
    light: null,
    airQuality: null,
    carbonDioxideConcentration: null
  },
  rules: {
    userId: [
      { required: true, message: "用户ID不能为空", trigger: "blur" }
    ],
  }
})

const { queryParams, form, rules } = toRefs(data)

/** 查询环境参数列表 */
function getList() {
  loading.value = true
  listEnvironment(queryParams.value).then(response => {
    environmentList.value = response.rows
    total.value = response.total
    loading.value = false
  })
}

// 取消按钮
function cancel() {
  open.value = false
  reset()
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    userId: null,
    temperature: null,
    humidity: null,
    decibel: null,
    light: null,
    airQuality: null,
    carbonDioxideConcentration: null
  }
  proxy.resetForm("environmentRef")
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1
  getList()
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef")
  handleQuery()
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id)
  single.value = selection.length != 1
  multiple.value = !selection.length
}

/** 新增按钮操作 */
function handleAdd() {
  reset()
  open.value = true
  title.value = "添加环境参数"
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset()
  const _id = row.id || ids.value
  getEnvironment(_id).then(response => {
    form.value = response.data
    open.value = true
    title.value = "修改环境参数"
  })
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["environmentRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateEnvironment(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功")
          open.value = false
          getList()
        })
      } else {
        addEnvironment(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功")
          open.value = false
          getList()
        })
      }
    }
  })
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value
  proxy.$modal.confirm('是否确认删除环境参数编号为"' + _ids + '"的数据项？').then(function() {
    return delEnvironment(_ids)
  }).then(() => {
    getList()
    proxy.$modal.msgSuccess("删除成功")
  }).catch(() => {})
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('module/environment/export', {
    ...queryParams.value
  }, `environment_${new Date().getTime()}.xlsx`)
}

getList()
</script>
