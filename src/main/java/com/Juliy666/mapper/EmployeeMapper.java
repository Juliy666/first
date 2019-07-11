package com.Juliy666.mapper;

import com.Juliy666.domain.Employee;
import com.Juliy666.domain.QueryVo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll(QueryVo vo);

    int updateByPrimaryKey(Employee record);

    void updateState(long id);

    /*保存员工和角色 关系*/
    void insertEmployeeAndRoleRel(@Param("id") Long id, @Param("rid") Long rid);
    /* 打破角色和员工的关系 */
	void deleteRoleRel(Long id);
}