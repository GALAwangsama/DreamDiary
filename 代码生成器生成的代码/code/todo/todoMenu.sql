-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('代办', '3', '1', 'todo', 'module/todo/index', 1, 0, 'C', '0', '0', 'module:todo:list', '#', 'admin', sysdate(), '', null, '代办菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('代办查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'module:todo:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('代办新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'module:todo:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('代办修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'module:todo:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('代办删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'module:todo:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('代办导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'module:todo:export',       '#', 'admin', sysdate(), '', null, '');