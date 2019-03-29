package com.cts.smart_shop.service;

import com.cts.smart_shop.bean.LoginBean;
import com.cts.smart_shop.bean.RegisterBean;
import com.cts.smart_shop.dao.LoginDAO;
import com.cts.smart_shop.dao.LoginDAOImpl;
import com.cts.smart_shop.dao.RegisterDAO;
import com.cts.smart_shop.dao.RegisterDAOImpl;

public class RegisterServiceImpl implements RegisterService{
	 			RegisterDAO registerDAO = new RegisterDAOImpl();
	 			LoginDAO loginDAO = new LoginDAOImpl();
	 			
	 			public boolean registerUser(RegisterBean bean) {
                LoginBean loginBean = new LoginBean();
                loginBean.setEmail(bean.getEmail());
                loginBean.setpassword(bean.getpassword());
                loginBean.setUserType(bean.getUserType());
                
	 			if(registerDAO.registerUser(bean)&& "success".equals(loginDAO.insertLogin(loginBean))){
	 					return true;
	 				}
	 				else return false;
	 			}	
	}