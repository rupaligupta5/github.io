package com.cts.smart_shop.dao;

import com.cts.smart_shop.bean.LoginBean;

public interface LoginDAO {
       
       public boolean validateUser(LoginBean bean);
       public String insertLogin(LoginBean bean);
       public String getUserType(String email);
       

}
