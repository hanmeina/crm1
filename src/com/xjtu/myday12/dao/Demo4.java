package com.xjtu.myday12.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import com.xjtu.myday12.vo.User;
import com.xjtu.util.JdbcUtil;


//演示ResultSetHandler接口的各种实现类的用法
public class Demo4 {
	@Test
	public void testBeanHandler() throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		User user = (User) runner.query(sql,new BeanHandler(User.class));
		System.out.println("用户名：" + user.getUsername());
	}
	@Test
	public void testBeanListHandler() throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		List<User> userList = (List<User>) runner.query(sql,new BeanListHandler(User.class));
		for(User user : userList){
			System.out.println("用户名：" + user.getUsername());
			System.out.println("密码：" + user.getPassword());
		}
	}
	@Test
	public void testArrayHandler() throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		Object[] array = (Object[]) runner.query(sql,new ArrayHandler());
		System.out.println("编号 : " + array[0]);
		System.out.println("用户名 : " + array[1]);
	}
	@Test
	public void testArrayListHandler() throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		List<Object[]> list = (List<Object[]>) runner.query(sql,new ArrayListHandler());
		for(Object[] array : list){
			System.out.print("编号 : " + array[0] + "\t");
			System.out.println("用户名 : " + array[1]);
		}
	}
	@Test
	public void testMapHandler() throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		Map<String,Object> map = (Map<String, Object>) runner.query(sql,new MapHandler());
		System.out.println("用户名：" + map.get("username"));
	}
	@Test
	public void testMapListHandler() throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select * from user";
		List<Map<String,Object>> list = (List<Map<String, Object>>) runner.query(sql,new MapListHandler());
		for(Map<String,Object> map : list){
			System.out.println("用户名：" + map.get("username"));
			System.out.println("薪水：" + map.get("salary"));
		}
	}
	@Test
	public void testScalarHandler() throws SQLException{
		QueryRunner runner = new QueryRunner(JdbcUtil.getDataSource());
		String sql = "select count(*) from user";
		Long sum = (Long) runner.query(sql,new ScalarHandler());
		System.out.println("共有" + sum + "人");
	}
}



