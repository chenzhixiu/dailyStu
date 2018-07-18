package com.abead.mapper;

import com.abead.entity.Employee;

import java.util.List;

/**
 * @Author chenzhixiu
 * @Date 创建时间 : 2018/4/25 16:44
 */
public interface EmployeeMapper {
    public List<Employee> selectManageInfo();
}
