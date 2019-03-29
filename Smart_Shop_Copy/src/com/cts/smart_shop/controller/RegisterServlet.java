package com.cts.smart_shop.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.smart_shop.bean.RegisterBean;
import com.cts.smart_shop.dao.RegisterDAO;

import com.cts.smart_shop.service.RegisterService;
import com.cts.smart_shop.service.RegisterServiceImpl;


public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String first_Name= request.getParameter("First_Name");
		String last_Name = request.getParameter("Last_Name");
		String age = request.getParameter("Age");
		String mobileNumber = request.getParameter("MobileNumber");
		String email = request.getParameter("Email");
		String password = request.getParameter("password");
		String cnfPs = request.getParameter("CnfPs");
		String userType = request.getParameter("userType");

		RegisterBean registerBean = new RegisterBean(first_Name, last_Name, age, mobileNumber, email, password, cnfPs, userType);
	
		
		RegisterService registerService = new RegisterServiceImpl();
		
		if(registerService.registerUser(registerBean))   
		{String info="User Added Successfully";
			request.setAttribute("info", info);
			request.getRequestDispatcher("Home.jsp").forward(request, response);
		}
		else   
		{
			String info="Email Id Already Exists";
			request.setAttribute("info", info);
			request.getRequestDispatcher("Register.jsp").include(request, response);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userType=req.getParameter("userType");
		
		resp.sendRedirect("Register.jsp?userType="+userType);
				
	}

}
