<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.xjtu.crm.vo.*"%>
<%@ page import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <body>
  <form action="/myday12/CrmServlet?method=addCustomer" method="post">
  	<table border="1" align="center" width="60%">
  		<caption><h1>新增客户信息</h1></caption>
  		<tr>
  			<th>姓名</th>
  			<td><input type="text" name="name" /></td>
  		</tr>
  		<tr>
  			<th>性别</th>
  			<td>
  				<input  type="radio" name="gender" value="男"/>男
  				<input type="radio" name="gender" value="女"/>女
  			</td>
  		</tr>
  		<tr>
  			<th>地址</th>
  			<td><input type="text" name="address" /></td>
  		</tr>
  		<tr>
  			<th>电话</th>
  			<td><input type="text" name="tel" /></td>
  		</tr>
  		<tr>
  			<th>邮箱</th>
  			<td><input type="text" name="email" /></td>
  		</tr>
  		<tr>
  			<th>生日</th>
  			<td>
  				<select name="year">
  					<c:forEach var="year" begin="1990" end="2001">
  						<option >${year }</option>
   					</c:forEach>
  				</select>年
  				<select name="month">
  					<c:forEach var="month" begin="1" end="12">
  						<option >${month }</option>
  					</c:forEach>
   				</select>月
  				<select name="date">
  					<c:forEach var="date" begin="1" end="31">
  						<option>${date }</option>
  					</c:forEach>
  				</select>日
  			</td>
  		
  			
  		</tr>
  		<tr>
  		   <td colspan="2" align="center">
  		      <input type="submit" value="提交"/>
  		   </td>
  		</tr>
  	</table>
  	</form>
     	<p align="right">
  		<jsp:include page="back.jsp"></jsp:include>
  		</p>
  </body>
</html>
