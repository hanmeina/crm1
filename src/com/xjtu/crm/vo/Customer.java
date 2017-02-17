package com.xjtu.crm.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Customer {
	 private int id;
	 private String name;
	 private String gender;
	 private String address;
	 private String tel;
	 private String email;
	 private java.util.Date birthday;
	 
	 //---------------------------------
	 private String  year ;
	 private String  month ;
	 
	 private String date  ;
	 
	 public String getYear() {
		return year;
	}
	public String getMonth() {
		return month;
	}
	public String getDate() {
		return date;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public void setDate(String date) {
		this.date = date;
	}
	 //---------------------------------
	public Customer(){}
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public java.util.Date getBirthday() {
		if(year!=null | month!=null | date!=null){
		try {
			//String->java.util.Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			this.birthday = sdf.parse(this.year+"-"+this.month+"-"+this.date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return this.birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
}
