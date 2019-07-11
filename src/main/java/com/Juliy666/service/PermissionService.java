package com.Juliy666.service;

import com.Juliy666.domain.Permission;

import java.util.List;

public interface PermissionService {
    public List<Permission> getPermission();

	/* 根据角色id查出对应权限 */
	public List<Permission> getPermission(Long rid);
}
