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
      <el-form-item label="日期" prop="date">
        <el-date-picker clearable
          v-model="queryParams.date"
          type="date"
          value-format="YYYY-MM-DD"
          placeholder="请选择日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="心率" prop="heartRate">
        <el-input
          v-model="queryParams.heartRate"
          placeholder="请输入心率"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="血氧" prop="oxygenLevel">
        <el-input
          v-model="queryParams.oxygenLevel"
          placeholder="请输入血氧"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="体温" prop="bodyTemperature">
        <el-input
          v-model="queryParams.bodyTemperature"
          placeholder="请输入体温"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="乳酸" prop="lactate">
        <el-input
          v-model="queryParams.lactate"
          placeholder="请输入乳酸"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="浅睡时长" prop="lightSleepDuration">
        <el-input
          v-model="queryParams.lightSleepDuration"
          placeholder="请输入浅睡时长"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="深度睡眠时长" prop="deepSleepDuration">
        <el-input
          v-model="queryParams.deepSleepDuration"
          placeholder="请输入深度睡眠时长"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="快速眼动期" prop="rapidEyeMovementDuration">
        <el-input
          v-model="queryParams.rapidEyeMovementDuration"
          placeholder="请输入快速眼动期"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="清醒次数" prop="wakeUpCount">
        <el-input
          v-model="queryParams.wakeUpCount"
          placeholder="请输入清醒次数"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="睡眠呼吸质量" prop="sleepBreathingQuality">
        <el-input
          v-model="queryParams.sleepBreathingQuality"
          placeholder="请输入睡眠呼吸质量"
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
          v-hasPermi="['module:sleep:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['module:sleep:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['module:sleep:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['module:sleep:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="sleepList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键ID" align="center" prop="id" />
      <el-table-column label="用户ID" align="center" prop="userId" />
      <el-table-column label="日期" align="center" prop="date" width="180">
        <template #default="scope">
          <span>{{ parseTime(scope.row.date, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="心率" align="center" prop="heartRate" />
      <el-table-column label="血氧" align="center" prop="oxygenLevel" />
      <el-table-column label="体温" align="center" prop="bodyTemperature" />
      <el-table-column label="乳酸" align="center" prop="lactate" />
      <el-table-column label="浅睡时长" align="center" prop="lightSleepDuration" />
      <el-table-column label="深度睡眠时长" align="center" prop="deepSleepDuration" />
      <el-table-column label="快速眼动期" align="center" prop="rapidEyeMovementDuration" />
      <el-table-column label="清醒次数" align="center" prop="wakeUpCount" />
      <el-table-column label="睡眠呼吸质量" align="center" prop="sleepBreathingQuality" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['module:sleep:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['module:sleep:remove']">删除</el-button>
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

    <!-- 添加或修改睡眠参数对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="sleepRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item>
        <el-form-item label="日期" prop="date">
          <el-date-picker clearable
            v-model="form.date"
            type="date"
            value-format="YYYY-MM-DD"
            placeholder="请选择日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="心率" prop="heartRate">
          <el-input v-model="form.heartRate" placeholder="请输入心率" />
        </el-form-item>
        <el-form-item label="血氧" prop="oxygenLevel">
          <el-input v-model="form.oxygenLevel" placeholder="请输入血氧" />
        </el-form-item>
        <el-form-item label="体温" prop="bodyTemperature">
          <el-input v-model="form.bodyTemperature" placeholder="请输入体温" />
        </el-form-item>
        <el-form-item label="乳酸" prop="lactate">
          <el-input v-model="form.lactate" placeholder="请输入乳酸" />
        </el-form-item>
        <el-form-item label="浅睡时长" prop="lightSleepDuration">
          <el-input v-model="form.lightSleepDuration" placeholder="请输入浅睡时长" />
        </el-form-item>
        <el-form-item label="深度睡眠时长" prop="deepSleepDuration">
          <el-input v-model="form.deepSleepDuration" placeholder="请输入深度睡眠时长" />
        </el-form-item>
        <el-form-item label="快速眼动期" prop="rapidEyeMovementDuration">
          <el-input v-model="form.rapidEyeMovementDuration" placeholder="请输入快速眼动期" />
        </el-form-item>
        <el-form-item label="清醒次数" prop="wakeUpCount">
          <el-input v-model="form.wakeUpCount" placeholder="请输入清醒次数" />
        </el-form-item>
        <el-form-item label="睡眠呼吸质量" prop="sleepBreathingQuality">
          <el-input v-model="form.sleepBreathingQuality" placeholder="请输入睡眠呼吸质量" />
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

<script setup name="Sleep">
import { listSleep, getSleep, delSleep, addSleep, updateSleep } from "@/api/module/sleep"

const { proxy } = getCurrentInstance()

const sleepList = ref([])
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
    date: null,
    heartRate: null,
    oxygenLevel: null,
    bodyTemperature: null,
    lactate: null,
    lightSleepDuration: null,
    deepSleepDuration: null,
    rapidEyeMovementDuration: null,
    wakeUpCount: null,
    sleepBreathingQuality: null
  },
  rules: {
    userId: [
      { required: true, message: "用户ID不能为空", trigger: "blur" }
    ],
  }
})

const { queryParams, form, rules } = toRefs(data)

/** 查询睡眠参数列表 */
function getList() {
  loading.value = true
  listSleep(queryParams.value).then(response => {
    sleepList.value = response.rows
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
    date: null,
    heartRate: null,
    oxygenLevel: null,
    bodyTemperature: null,
    lactate: null,
    lightSleepDuration: null,
    deepSleepDuration: null,
    rapidEyeMovementDuration: null,
    wakeUpCount: null,
    sleepBreathingQuality: null
  }
  proxy.resetForm("sleepRef")
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
  title.value = "添加睡眠参数"
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset()
  const _id = row.id || ids.value
  getSleep(_id).then(response => {
    form.value = response.data
    open.value = true
    title.value = "修改睡眠参数"
  })
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["sleepRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateSleep(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功")
          open.value = false
          getList()
        })
      } else {
        addSleep(form.value).then(response => {
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
  proxy.$modal.confirm('是否确认删除睡眠参数编号为"' + _ids + '"的数据项？').then(function() {
    return delSleep(_ids)
  }).then(() => {
    getList()
    proxy.$modal.msgSuccess("删除成功")
  }).catch(() => {})
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('module/sleep/export', {
    ...queryParams.value
  }, `sleep_${new Date().getTime()}.xlsx`)
}

getList()
</script>
