package com.cts.smart_shop.controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.smart_shop.bean.ProductBean;
import com.cts.smart_shop.dao.ProductDAO;
import com.cts.smart_shop.service.ProductService;
import com.cts.smart_shop.service.ProductServiceImpl;
import com.cts.smart_shop.service.RegisterService;
import com.cts.smart_shop.service.RegisterServiceImpl;


public class UpdateProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UpdateProductServlet() {
    	super();
}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher requestDispatcher =   request.getRequestDispatcher("UpdateProduct.jsp");
    	
    	
    	requestDispatcher.forward(request, response);
    	
    	
    }
  

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
                    String Product_Name = request.getParameter("Product_Name");
                    String item = request.getParameter("Item");
                    ProductBean updateProductBean = new ProductBean();    
                    updateProductBean.setProduct_Name(Product_Name);           
                    ProductService updateProductService = new ProductServiceImpl();
                   
                    if(updateProductService.updateProduct(Product_Name,item))  
                    {
                    	
                                    request.getRequestDispatcher("UpdateProduct.jsp").forward(request, response);
                    }
                    else   
                    {
                            
                                    request.getRequestDispatcher("UpdateProduct.jsp").include(request, response);
                    }
    }


}
