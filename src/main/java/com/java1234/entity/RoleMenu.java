package com.java1234.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 角色菜单关联实体
 * @author Administrator
 *
 */
@Entity
@Table(name="t_roleMenu")
public class RoleMenu {

	@Id
	@GeneratedValue
	private Integer id; // 编号
	
	
	@ManyToOne
	@JoinColumn(name="roleId")
	private Role role; // 角色
	
	@ManyToOne
	@JoinColumn(name="menuId")
	private Menu menu; // 菜单

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	
	
}
