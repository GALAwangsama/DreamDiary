import request from '@/utils/request'

// 查询推荐计划列表
export function listRecommendation(query) {
  return request({
    url: '/module/recommendation/list',
    method: 'get',
    params: query
  })
}

// 查询推荐计划详细
export function getRecommendation(id) {
  return request({
    url: '/module/recommendation/' + id,
    method: 'get'
  })
}

// 新增推荐计划
export function addRecommendation(data) {
  return request({
    url: '/module/recommendation',
    method: 'post',
    data: data
  })
}

// 修改推荐计划
export function updateRecommendation(data) {
  return request({
    url: '/module/recommendation',
    method: 'put',
    data: data
  })
}

// 删除推荐计划
export function delRecommendation(id) {
  return request({
    url: '/module/recommendation/' + id,
    method: 'delete'
  })
}
