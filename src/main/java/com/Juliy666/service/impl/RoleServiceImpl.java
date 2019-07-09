package com.Juliy666.service.impl;

import com.Juliy666.domain.PageListRes;
import com.Juliy666.domain.Permission;
import com.Juliy666.domain.QueryVo;
import com.Juliy666.domain.Role;
import com.Juliy666.mapper.RoleMapper;
import com.Juliy666.service.RoleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    /*注入mapper*/
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public PageListRes getRoles(QueryVo vo) {
        Page<Object> page = PageHelper.startPage(vo.getPage(), vo.getRows());
        /*查询数据*/
        List<Role> roles = roleMapper.selectAll();
        /*返回的数据是pageList*/
        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(roles);
        return pageListRes;

    }
    /*保存角色和权限*/
    @Override
    public void saveRole(Role role) {
        /*1保存角色*/
        roleMapper.insert(role);
        System.out.println(role);
        /*2保存角色和权限的关系*/
        for (Permission permission : role.getPermissions()) {
            roleMapper.insertRoleAndPermissionRel(role.getRid(),permission.getPid());
        }
    }
    
    /*更新角色和权限*/
	@Override
	public void updateRole(Role role) {
		/*1打破角色与权限之间的之前的关系*/
		roleMapper.deletePermissionRel(role.getRid());
		/*2更新角色*/
		roleMapper.updateByPrimaryKey(role);
		/* 3重新建立角色与权限的关系 */
		 for (Permission permission : role.getPermissions()) {
            roleMapper.insertRoleAndPermissionRel(role.getRid(),permission.getPid());
    	}
	}
}
