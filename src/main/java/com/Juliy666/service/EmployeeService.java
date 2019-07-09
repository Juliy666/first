package com.Juliy666.service;


import com.Juliy666.domain.Employee;
import com.Juliy666.domain.PageListRes;
import com.Juliy666.domain.QueryVo;

public interface EmployeeService {
    /*查询员工*/
    public PageListRes getEmployee(QueryVo vo);

    /*保存员工*/
    public void saveEmployee(Employee employee);

    /*更新员工*/
    public void updateEmployee(Employee employee);

    /*更新离职状态*/
    public void updateState(long id);
}
