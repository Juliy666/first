package com.Juliy666.mapper;

import com.Juliy666.domain.Employee;
import com.Juliy666.domain.QueryVo;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll(QueryVo vo);

    int updateByPrimaryKey(Employee record);

    void updateState(long id);
}