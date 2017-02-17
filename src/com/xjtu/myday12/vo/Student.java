package com.xjtu.myday12.vo;

import java.util.ArrayList;
import java.util.List;

public class Student {
  private int id;
  private String name;
  private List<Teacher> teacherList = new ArrayList<>();
  public Student(){}
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
public List<Teacher> getTeacherList() {
	return teacherList;
}
public void setTeacherList(List<Teacher> teacherList) {
	this.teacherList = teacherList;
}
  
}
