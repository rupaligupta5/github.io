package com.cts.smart_shop.service;

import com.cts.smart_shop.bean.LoginBean;
import com.cts.smart_shop.dao.LoginDAO;
import com.cts.smart_shop.dao.LoginDAOImpl;

	public class LoginServiceImpl implements LoginService{

	                LoginDAO loginDAO = new LoginDAOImpl();
	                public boolean validateUser(LoginBean bean) {
	                                return loginDAO.validateUser(bean);
	                }
					@Override
					public String getUserType(String email) {
									return loginDAO.getUserType(email);
					}

	}