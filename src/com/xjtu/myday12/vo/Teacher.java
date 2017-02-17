package com.xjtu.myday12.vo;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.ArrayList;
import java.util.List;

public class Teacher {
  private int id;
  private String name;
  private List<Student> studentList= new ArrayList<>();
  public Teacher(){}
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
public List<Student> getStudentList() {
	return studentList;
}
public void setStudentList(List<Student> studentList) {
	this.studentList = studentList;
}
  
}
