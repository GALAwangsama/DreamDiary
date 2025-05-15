import request from '@/utils/request'

// 查询代办列表
export function listTodo(query) {
  return request({
    url: '/module/todo/list',
    method: 'get',
    params: query
  })
}

// 查询代办详细
export function getTodo(id) {
  return request({
    url: '/module/todo/' + id,
    method: 'get'
  })
}

// 新增代办
export function addTodo(data) {
  return request({
    url: '/module/todo',
    method: 'post',
    data: data
  })
}

// 修改代办
export function updateTodo(data) {
  return request({
    url: '/module/todo',
    method: 'put',
    data: data
  })
}

// 删除代办
export function delTodo(id) {
  return request({
    url: '/module/todo/' + id,
    method: 'delete'
  })
}
