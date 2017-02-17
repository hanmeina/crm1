package com.xjtu.myday12.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xjtu.myday12.vo.Student;
import com.xjtu.myday12.vo.Teacher;

public class Many2Many {
  public static void main(String[] args) throws SQLException {
	
	  Teacher t1 = new Teacher();
	  Teacher t2 = new Teacher();
	  t1.setName("≤À");
	  t2.setName("∫¨");
	  
	  Student s1= new Student();
	  s1.setName("–°∫Œ");
	  Student s2 = new Student();
	  s2.setName("–°¡ı");
	  List<Teacher> teacherList = new ArrayList<>();
	  teacherList.add(t1);
	  teacherList.add(t2);
	  List<Student> studentList = new ArrayList<>();
	  studentList.add(s1);
	  studentList.add(s2);
	  
	  t1.setStudentList(studentList);
	  t2.setStudentList(studentList);
	  
	  s1.setTeacherList(teacherList);
	  s2.setTeacherList(teacherList);
	  
	  Dao dao = new Dao();
	  dao.save(t1);
	  
}
}
