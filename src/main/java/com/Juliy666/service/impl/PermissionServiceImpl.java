package com.Juliy666.service.impl;

import com.Juliy666.domain.Permission;
import com.Juliy666.mapper.PermissionMapper;
import com.Juliy666.service.PermissionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> getPermission() {
        List<Permission> permissions = permissionMapper.selectAll();
        return permissions;
    }

	@Override
	public List<Permission> getPermission(Long rid) {
		
		return permissionMapper.selectPermissionByRid(rid);
	}
}
