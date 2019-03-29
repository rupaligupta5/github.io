package com.cts.smart_shop.service;

import com.cts.smart_shop.bean.LoginBean;

public interface LoginService {
public boolean validateUser(LoginBean bean);
public String getUserType(String email);
}
