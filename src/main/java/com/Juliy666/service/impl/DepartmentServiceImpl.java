package com.Juliy666.service.impl;

import com.Juliy666.domain.Department;
import com.Juliy666.mapper.DepartmentMapper;
import com.Juliy666.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    /*注入mapper*/
    @Autowired
    private DepartmentMapper departmentMapper;
    
    @Override
    public List<Department> getDepartmentList() {
        return departmentMapper.selectAll();
    }
}

