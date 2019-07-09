package com.Juliy666.service;

import com.Juliy666.domain.PageListRes;
import com.Juliy666.domain.QueryVo;
import com.Juliy666.domain.Role;
import org.springframework.stereotype.Service;


public interface RoleService {
    /*查询角色列表*/
    public PageListRes getRoles(QueryVo vo);

    /*保存角色和权限*/
    public void saveRole(Role role);

	/*更新角色和权限*/
	public void updateRole(Role role);


}
