package com.cts.smart_shop.controller;
import java.io.IOException;
import java.util.List;

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


public class DeleteProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteProductServlet() {
    	super();
}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                    String Product_Name = request.getParameter("Product_Name");
                   
                    ProductBean deleteProductBean = new ProductBean();
    
                    deleteProductBean.setProduct_Name(Product_Name);
           
                    ProductService deleteProductService = new ProductServiceImpl();
                    
                    boolean deleteProduct = deleteProductService.deleteProduct(deleteProductBean);
                    if(deleteProduct)  
                    {
                    				ProductService addProductService = new ProductServiceImpl();
                    				List<ProductBean> productBeanList=addProductService.getAllProductBean();
                    				request.setAttribute("productBeanList", productBeanList);
                                    request.getRequestDispatcher("AddProduct.jsp").forward(request, response);
                    }
                    else   
                    {
                                  
                                    request.getRequestDispatcher("EditProduct.jsp").include(request, response);
                    }
    }


}
