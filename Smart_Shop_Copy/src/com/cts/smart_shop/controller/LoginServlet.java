package com.cts.smart_shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.smart_shop.bean.LoginBean;
import com.cts.smart_shop.bean.ProductBean;
import com.cts.smart_shop.service.LoginService;
import com.cts.smart_shop.service.LoginServiceImpl;
import com.cts.smart_shop.service.ProductService;
import com.cts.smart_shop.service.ProductServiceImpl;


public class LoginServlet extends HttpServlet {
                private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                
                	LoginService loginService = new LoginServiceImpl();
                                LoginBean bean = new LoginBean();
                                bean.setEmail(request.getParameter("uname"));
                                bean.setpassword(request.getParameter("pass"));
                              
                                RequestDispatcher dispatcher = null;
                                ProductService productService = new ProductServiceImpl();
                                HttpSession session = request.getSession();
                                
                                if(loginService.validateUser(bean)) {
                                          
                                            String userType = loginService.getUserType(bean.getEmail());
                                           
                                            if("M".equals(userType)) {
                                                         
                                                            
                                                            dispatcher = request.getRequestDispatcher("EditProduct.jsp");
                                                            dispatcher.forward(request, response);
                                            }
                                            else if ("U".equals(userType)){
                                                            
                                                            dispatcher = request.getRequestDispatcher("ProductList.jsp");
                                                            List<ProductBean> product = productService.getProductName();
                                                           
                                                            request.setAttribute("products", product);
                                                            session.setAttribute("username", "name");
                                                            dispatcher.forward(request, response);
                                            }
                                            else {
                                                            dispatcher = request.getRequestDispatcher("Login.jsp");
                                                            dispatcher.forward(request, response);
                                            }
                                   
                                }
                                			else {        
                                                			dispatcher=request.getRequestDispatcher("Login.jsp");
                                                			dispatcher.forward(request, response);
                                }
                                
                }

}
