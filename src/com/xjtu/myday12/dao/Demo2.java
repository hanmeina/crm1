package com.xjtu.myday12.dao;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.management.Query;

import org.apache.commons.beanutils.BeanUtils;

import com.xjtu.myday12.vo.User;
import com.xjtu.util.JdbcUtil;

//使用元数据简化curd操作，结合反射
public class Demo2 {
  public static void main(String[] args) throws Exception {
   
//	  String sql  =  "insert into user(username,password,birthday,salary) values(?,?,?,?) ";
//	  Object[] params = {"哈哈","123","1992-03-05",5000};
//	  update(sql,params);
	  //String sql = "update user set username = ? where id = ? ";
	 // update(sql, new Object[]{"哈哈",14});
	  //String sql = "delete from user where id = ?";
	 // update(sql, new Object[]{2});
	  String sql = "select * from user where id=?";
	User user =   (User) query(sql,new Object[]{15},User.class);
	 System.out.println("用户名："+user.getUsername()); 
}
  /**
   * R操作通用的方法
   * @param sql
   * @param params
   * @param clazz
   
   */
private static Object query(String sql, Object[] params, Class clazz) throws Exception {
    Object  object =  clazz.newInstance();
   Connection conn =  JdbcUtil.getMySqlConnection();
   PreparedStatement psmt	= conn.prepareStatement(sql);
   ParameterMetaData ptmd =  psmt.getParameterMetaData();
  int size =  ptmd.getParameterCount();
  for(int i = 0;i<size;i++){
	  psmt.setObject(i+1,params[i]);
	  
  }
  
  ResultSet rs = psmt.executeQuery();
  if(rs.next()){
  ResultSetMetaData rsmd = rs.getMetaData();
  int column = rsmd.getColumnCount();

  for(int i=0;i<column;i++){
	  
	  BeanUtils.setProperty(object,rsmd.getColumnName(i+1) , rs.getObject(i+1));
  }
  }
   JdbcUtil.close(conn);
   JdbcUtil.close(psmt);
   JdbcUtil.close(rs);
	return object;
}
/**
 * CUD操作,通用的方法
 * @param sql
 * @param params
 */
private static void update(String sql, Object[] params) {
	// TODO Auto-generated method stub
	Connection conn  = null;
	PreparedStatement psmt = null;
	try {
	    conn  = JdbcUtil.getMySqlConnection();
	    psmt	 =  conn.prepareStatement(sql);
	    ParameterMetaData ptmd   =  psmt.getParameterMetaData();
	    int size =  ptmd.getParameterCount();
	    for(int i=0;i<size;i++){
	    	psmt.setObject(i+1,params[i]);	    	
	    }
	   psmt.executeUpdate();
	 
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		JdbcUtil.close(conn);
		JdbcUtil.close(psmt);
	}
	
}
  
  
  
}
