import request from '@/utils/request'

// 查询睡眠参数列表
export function listSleep(query) {
  return request({
    url: '/module/sleep/list',
    method: 'get',
    params: query
  })
}

// 查询睡眠参数详细
export function getSleep(id) {
  return request({
    url: '/module/sleep/' + id,
    method: 'get'
  })
}

// 新增睡眠参数
export function addSleep(data) {
  return request({
    url: '/module/sleep',
    method: 'post',
    data: data
  })
}

// 修改睡眠参数
export function updateSleep(data) {
  return request({
    url: '/module/sleep',
    method: 'put',
    data: data
  })
}

// 删除睡眠参数
export function delSleep(id) {
  return request({
    url: '/module/sleep/' + id,
    method: 'delete'
  })
}
