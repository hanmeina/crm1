package com.xjtu.myday12.vo;

import java.util.ArrayList;
import java.util.List;

import sun.net.www.content.text.plain;

//¶à·½
public class Department {
 private int id;
 private String name;
 private List<Employee> employeeList = new ArrayList<>();
  public Department(){}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public List<Employee> getEmployeeList() {
	return employeeList;
}
public void setEmployeeList(List<Employee> employeeList) {
	this.employeeList = employeeList;
}
  
}
