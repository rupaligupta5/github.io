package com.cts.smart_shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cts.smart_shop.bean.ProductBean;
import com.cts.smart_shop.service.ProductService;
import com.cts.smart_shop.service.ProductServiceImpl;

@WebServlet("/DeleteProduct")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DeleteProduct() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductService addProductService = new ProductServiceImpl();
 		List<ProductBean> productBeanList=addProductService.getAllProductBean();
 		HttpSession session=request.getSession();
 		session.setAttribute("productBeanList", productBeanList);
 		response.sendRedirect("DeleteProduct.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String Product_Name = request.getParameter("Product_Name");
         
         ProductBean deleteProductBean = new ProductBean();

         deleteProductBean.setProduct_Name(Product_Name);

         ProductService deleteProductService = new ProductServiceImpl();
         
         boolean deleteProduct = deleteProductService.deleteProduct(deleteProductBean);
         if(deleteProduct)  
         {
        	 			HttpSession session=request.getSession();
        	 			ProductService addProductService = new ProductServiceImpl();
        	 			List<ProductBean> productBeanList=addProductService.getAllProductBean();
        	 			session.setAttribute("productBeanList", productBeanList);
        	 			request.getRequestDispatcher("DeleteProduct.jsp").forward(request, response);
         }
         else   
         {
                       
                         request.getRequestDispatcher("EditProduct.jsp").include(request, response);
         }
	}

}
