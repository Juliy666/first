package com.Juliy666.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Juliy666.domain.AjaxRes;
import com.Juliy666.domain.Employee;
import com.Juliy666.domain.PageListRes;
import com.Juliy666.domain.QueryVo;
import com.Juliy666.service.EmployeeService;

@Controller
public class EmployeeController {
    /*注入业务层*/
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employee")
    public String employee(){
        return "employee";
    }

    /*调用业务层查询员工*/
    @RequestMapping("/employeeList")
    @ResponseBody
    public PageListRes employeeList(QueryVo vo){
        System.out.println(vo);
        PageListRes pageListRes = employeeService.getEmployee(vo);
        System.out.println(pageListRes);
        return pageListRes;

    }

    /*接受员工提交表单*/
    @RequestMapping("/saveEmployee")
    @ResponseBody
    public AjaxRes saveEmployee(Employee employee){
    	System.out.println(employee);
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层,保存用户*/
            employee.setState(true);
            employeeService.saveEmployee(employee);
            ajaxRes.setMsg("保存成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("保存失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*接收员工更新表单*/
    @RequestMapping("/updateEmployee")
    @ResponseBody
    public AjaxRes updateEmployee(Employee employee){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层。更新用户*/
            employeeService.updateEmployee(employee);
            /*System.out.println(employee);*/
            ajaxRes.setMsg("更新成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("更新失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;


    }

    /*接受员工更新离职状态*/
    @RequestMapping("/updateState")
    @ResponseBody
    public AjaxRes updateState(long id){
        AjaxRes ajaxRes = new AjaxRes();
        try {
            /*调用业务层。更新离职状态*/
            employeeService.updateState(id);
            /*System.out.println(employee);*/
            ajaxRes.setMsg("离职成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            System.out.println(e);
            ajaxRes.setMsg("离职失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }


}
