package com.xjtu.myday12.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;

import com.sun.jndi.url.dns.dnsURLContext;
import com.xjtu.myday12.vo.Department;
import com.xjtu.myday12.vo.Employee;
import com.xjtu.myday12.vo.Student;
import com.xjtu.myday12.vo.Teacher;
import com.xjtu.util.JdbcUtil;

public class Dao {
	QueryRunner queryRunner  = new QueryRunner(JdbcUtil.getDataSource());
	public void save(Department department) throws SQLException {
		// TODO Auto-generated method stub
		if(department==null){
			throw new SQLException();
		}
		
		//向department表插入一条记录
		String sql="insert into department(name) values(?)";
		queryRunner.update(sql, department.getName());
		//取得department的主键id
		String sql1 = "select id from department where name=?";
	    Object[] object	= queryRunner.query(sql1, new ArrayHandler(),department.getName());
		int did = (Integer)object[0];
		//向employee表中插入多条记录
		String sql2 = "insert into employee(name,did) values(?,?)";
		for(Employee e: department.getEmployeeList()){
		   queryRunner.update(sql2,new Object[]{e.getName(),did});
		}
	}

	public void save(Teacher t) throws SQLException {
		// TODO Auto-generated method stub
		if(t == null){
			throw new SQLException();
		}
		//1.向teacher表插入一条记录
		String sql = "insert into teacher(name) values(?)";
		queryRunner.update(sql, t.getName());
		//2.取teacher表中刚插入的主键
		sql = "select id  from teacher where name = ?";
		Object[] objects = queryRunner.query(sql, new ArrayHandler(), t.getName());
        int tid = (Integer)objects[0];
		//3.向student表插入N条记录
        sql = "insert into student(name) values(?)";
        for(Student s:t.getStudentList()){
        	queryRunner.update(sql,s.getName());
        	//4.取得student表的主键
        	String temp1  = "select id from student where name = ?";
        	objects = queryRunner.query(temp1, new ArrayHandler(), s.getName());
        	int sid = (Integer)objects[0];
        	//5.向middle表中插入N条记录
        	String temp2 = "insert into middle(tid,sid) values(?,?)";
        	queryRunner.update(temp2, new Object[]{tid,sid});
     	
        }
       
        
	}

}
