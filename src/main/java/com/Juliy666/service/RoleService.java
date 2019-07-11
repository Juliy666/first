package com.Juliy666.service;

import com.Juliy666.domain.PageListRes;
import com.Juliy666.domain.QueryVo;
import com.Juliy666.domain.Role;

import java.util.List;

import org.springframework.stereotype.Service;


public interface RoleService {
    /*查询角色列表*/
    public PageListRes getRoles(QueryVo vo);

    /*保存角色和权限*/
    public void saveRole(Role role);

	/*更新角色和权限*/
	public void updateRole(Role role);

	/* 删除用户 */
	public void deleteRole(Long rid);

	public List<Role> roleList();
	
	/*根据当前用户的id,查出对应的角色*/
	public List<Long> getRoleByEid(Long id);


}
