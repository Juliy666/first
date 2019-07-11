package com.Juliy666.mapper;

import com.Juliy666.domain.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long rid);

    int insert(Role record);

    Role selectByPrimaryKey(Long rid);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    /*保存角色和权限的关系*/
    void insertRoleAndPermissionRel(@Param("rid") Long rid, @Param("pid") Long pid);
    
	/* 打破角色和权限之间的关系 */
	void deletePermissionRel(Long rid);

	List<Long> getRoleWithEid(Long id);
}