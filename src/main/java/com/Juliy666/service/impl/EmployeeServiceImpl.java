package com.Juliy666.service.impl;

import com.Juliy666.domain.Employee;
import com.Juliy666.domain.PageListRes;
import com.Juliy666.domain.QueryVo;
import com.Juliy666.domain.Role;
import com.Juliy666.mapper.EmployeeMapper;
import com.Juliy666.service.EmployeeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageListRes getEmployee(QueryVo vo) {
        //利用分页插件设置页数
        Page<Object> page = PageHelper.startPage(vo.getPage(),vo.getRows());
        //查询员工
        List<Employee> employees = employeeMapper.selectAll(vo);
        System.out.println(employees);
        //封装为pageList
        PageListRes pageListRes = new PageListRes();
        pageListRes.setTotal(page.getTotal());
        pageListRes.setRows(employees);
        return pageListRes;

    }

    /*保存员工*/
    @Override
    public void saveEmployee(Employee employee) {
		/* 保存员工 */
        employeeMapper.insert(employee);
		/* 保存角色与员工关系的关系表,就可以根据员工查出对应的角色了 */
		/* 取出每个角色 */
        System.out.println(employee.getRoles());
        for (Role role : employee.getRoles()) {
            employeeMapper.insertEmployeeAndRoleRel(employee.getId(),role.getRid());
        }
    }

    /*更新员工*/
    @Override
    public void updateEmployee(Employee employee) {
		/* 打破角色和员工的关系 */
    	employeeMapper.deleteRoleRel(employee.getId());
		/* 更新员工 */
        employeeMapper.updateByPrimaryKey(employee);
		/* 重新建立角色和员工的关系 */
        for (Role role : employee.getRoles()) {
            employeeMapper.insertEmployeeAndRoleRel(employee.getId(),role.getRid());
        }
    }

    /*更新员工状态*/
    @Override
    public void updateState(long id) {
        employeeMapper.updateState(id);
    }
}
