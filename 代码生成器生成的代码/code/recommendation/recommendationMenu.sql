-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐计划', '3', '1', 'recommendation', 'module/recommendation/index', 1, 0, 'C', '0', '0', 'module:recommendation:list', '#', 'admin', sysdate(), '', null, '推荐计划菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐计划查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'module:recommendation:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐计划新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'module:recommendation:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐计划修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'module:recommendation:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐计划删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'module:recommendation:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('推荐计划导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'module:recommendation:export',       '#', 'admin', sysdate(), '', null, '');