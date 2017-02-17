package com.xjtu.crm.web.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.DbUtils;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.xjtu.crm.service.CrmService;
import com.xjtu.crm.vo.Customer;
import com.xjtu.crm.vo.Page;

/**
 * Servlet implementation class CrmServlet
 */
public class CrmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   CrmService crmService = new CrmService();
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
	    System.out.println(method);
		if(method!=null){
			if(method.equals("findAllCustomer")){
				
				this.findAllCustomer(request, response); 
			}else if(method.equals("findCustomerById")){
				//System.out.println("findCustomerById");
				this.findCustomerById(request, response);
			}else if(method.equals("deleteCustomerById")){
				this.deleteCustomerById(request, response);
				
			}else if(method.equals("toAddJsp")){
				this.toAddJsp(request, response);
				
			}
		}
	} 

	


	private void toAddJsp(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			request.getRequestDispatcher("/WEB-INF/jsp/add.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		if(method!=null){
		
		 if(method.equals("addCustomer")){
		
			this.addCustomer(request, response);
		}else if(method.equals("updateCustomer")){
			this.updateCustomer(request, response);
			
		}
		}
	}

	private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   int id = Integer.parseInt(request.getParameter("id"));
		   Customer customer = new Customer();
		   customer.setId(id);
			try {				
				Enumeration<String> enums = request.getParameterNames();
				while(enums.hasMoreElements()){
					String key = enums.nextElement();
					String[] values = request.getParameterValues(key);
					BeanUtils.setProperty(customer, key, values);
					  
				}
			
	            crmService.updateCustomer(customer);
	            request.setAttribute("message", "修改成功"); 
				request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				 e.printStackTrace();
				 request.setAttribute("message", "修改失败"); 
				 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
			}
	}




	private void addCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("add()");
	   Customer customer = new Customer();
		try {
			
			Enumeration<String> enums = request.getParameterNames();
			while(enums.hasMoreElements()){
				String key = enums.nextElement();
				String[] values = request.getParameterValues(key);
				BeanUtils.setProperty(customer, key, values);
				  
			}
		
            crmService.addCustomer(customer);
            request.setAttribute("message", "注册成功"); 
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
			 request.setAttribute("message", "注册失败"); 
			 request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
		
	}
	public void deleteCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("deleteCustomerById");
		String ids = request.getParameter("ids");  
		String[] idStrings = ids.split("_");
		try {
			crmService.deleteCustomerById(idStrings);
			request.setAttribute("message", "批量删除成功"); 
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "批量删除出错"); 
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
		
	}
	public void findCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println("进来了");
		Customer customer =null;
		try {
			customer = crmService.findCustomerById(id);
			//System.out.println(customer.getName());
			if(customer!=null){
				request.setAttribute("customer", customer); 
				request.getRequestDispatcher("/WEB-INF/jsp/detail.jsp").forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "编辑用户信息失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);;
		}
		
	}
    private void findAllCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("jianle ");
    	int currPageNO = Integer.parseInt(request.getParameter("currPageNO"));
		try {
			Page  page = crmService.findAllCustomer(currPageNO);
			System.out.println("pageNO:"+page.getAllPageNO());
			request.setAttribute("page", page);
			request.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "查询用户所有信息失败");
			request.getRequestDispatcher("/WEB-INF/jsp/message.jsp").forward(request, response);
		}
		
	}
}
