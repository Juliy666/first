package com.Juliy666.web;

import com.Juliy666.domain.AjaxRes;
import com.Juliy666.domain.PageListRes;
import com.Juliy666.domain.QueryVo;
import com.Juliy666.domain.Role;
import com.Juliy666.service.RoleService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoleController {
    /*注入业务层*/
    @Autowired
    private RoleService roleService;

    @RequestMapping("/role")
    public String employee(){
        return "role";
    }
    
	/*获取用户列表*/
    @RequestMapping("/getRoles")
    @ResponseBody
    public PageListRes getRoles(QueryVo vo){
        PageListRes roles = roleService.getRoles(vo);
        System.out.println("来到了getRoles");
        return roles;
    }
    
	/*保存用户*/
    @RequestMapping("/saveRole")
    @ResponseBody
    public AjaxRes saveRole(Role role){
    	System.out.println("来到了saveRole");
    	AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,保存用户*/
            roleService.saveRole(role);
            ajaxRes.setMsg("保存角色成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("保存角色失败");
            ajaxRes.setSuccess(false);
        }
		/* System.out.println("ajax是"+ajaxRes); */
        return ajaxRes;

    }
    
	/*编辑角色*/
    @RequestMapping("/updateRole")
    @ResponseBody
    public AjaxRes updateRole(Role role) {
    	AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,保存用户*/
            roleService.updateRole(role);
            ajaxRes.setMsg("更新角色成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("更新角色失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    	
    }
    
	/* 删除角色 */
    @RequestMapping("/deleteRole")
    @ResponseBody
    public AjaxRes deleteRole(Long rid) {
    	AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,删除用户*/
            roleService.deleteRole(rid);
            ajaxRes.setMsg("删除角色成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("删除角色失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }
    
	/* 获取用户列表（不用分页） */
    @RequestMapping("/roleList")
    @ResponseBody
    public List<Role> roleList() {
    	
    	return roleService.roleList();
    }
    
    /*根据当前用户的id,查出对应的角色*/
    @RequestMapping("/getRoleByEid")
    @ResponseBody
    public List<Long> getRoleByEid(Long id){
    	
    	return roleService.getRoleByEid(id);
    }
    
	



}
