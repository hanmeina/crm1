package com.xjtu.myday12.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xjtu.myday12.vo.Department;
import com.xjtu.myday12.vo.Employee;

public class One2Many {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
         Department department = new Department();
         department.setName("软件部");
         
         Employee employee1 = new Employee();
         employee1.setName("小王");
        
         Employee employee2 = new Employee();	 
         employee2.setName("小何");
      
        
         List<Employee> employeeList = new ArrayList<>();
         employeeList.add(employee1);
         employeeList.add(employee2);
         
         department.setEmployeeList(employeeList);
         employee1.setDepartment(department);
         employee2.setDepartment(department);
         //保存部门时同时保存对应的员工记录
         Dao  dao  = new Dao();
         dao.save(department);
	}

}
