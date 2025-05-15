import request from '@/utils/request'

// 查询会员标记列表
export function listVip(query) {
  return request({
    url: '/module/vip/list',
    method: 'get',
    params: query
  })
}

// 查询会员标记详细
export function getVip(id) {
  return request({
    url: '/module/vip/' + id,
    method: 'get'
  })
}

// 新增会员标记
export function addVip(data) {
  return request({
    url: '/module/vip',
    method: 'post',
    data: data
  })
}

// 修改会员标记
export function updateVip(data) {
  return request({
    url: '/module/vip',
    method: 'put',
    data: data
  })
}

// 删除会员标记
export function delVip(id) {
  return request({
    url: '/module/vip/' + id,
    method: 'delete'
  })
}
