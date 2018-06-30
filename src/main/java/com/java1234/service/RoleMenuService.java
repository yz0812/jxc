package com.java1234.service;

import com.java1234.entity.RoleMenu;

/**
 * 角色菜单关联service接口
 * @author Administrator
 *
 */
public interface RoleMenuService {
	
	/**
	 * 根据角色id删除所有关联信息
	 * @param userId
	 */
	public void deleteByRoleId(Integer roleId);
	
	/**
	 * 保存实体
	 * @param roleMenu
	 */
	public void save(RoleMenu roleMenu);
}
