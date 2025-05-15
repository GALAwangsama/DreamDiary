import request from '@/utils/request'

// 查询环境参数列表
export function listEnvironment(query) {
  return request({
    url: '/module/environment/list',
    method: 'get',
    params: query
  })
}

// 查询环境参数详细
export function getEnvironment(id) {
  return request({
    url: '/module/environment/' + id,
    method: 'get'
  })
}

// 新增环境参数
export function addEnvironment(data) {
  return request({
    url: '/module/environment',
    method: 'post',
    data: data
  })
}

// 修改环境参数
export function updateEnvironment(data) {
  return request({
    url: '/module/environment',
    method: 'put',
    data: data
  })
}

// 删除环境参数
export function delEnvironment(id) {
  return request({
    url: '/module/environment/' + id,
    method: 'delete'
  })
}
