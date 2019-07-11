package com.Juliy666.mapper;

import com.Juliy666.domain.Permission;
import java.util.List;

public interface PermissionMapper {
    int deleteByPrimaryKey(Long pid);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long pid);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);
    
	/* 通过角色查询rid查询出权限 */
	List<Permission> selectPermissionByRid(Long rid);
}