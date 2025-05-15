-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员标记', '3', '1', 'vip', 'module/vip/index', 1, 0, 'C', '0', '0', 'module:vip:list', '#', 'admin', sysdate(), '', null, '会员标记菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员标记查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'module:vip:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员标记新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'module:vip:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员标记修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'module:vip:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员标记删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'module:vip:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('会员标记导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'module:vip:export',       '#', 'admin', sysdate(), '', null, '');