package com.cts.smart_shop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.cts.smart_shop.bean.ProductBean;
import com.cts.smart_shop.service.ProductService;
import com.cts.smart_shop.service.ProductServiceImpl;

@WebServlet("/ProductController")
@MultipartConfig

public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			ProductService addProductService = new ProductServiceImpl();
			List<ProductBean> productBeanList = addProductService.getAllProductBean();
			HttpSession session = request.getSession();
			session.setAttribute("productBeanList", productBeanList);
			response.sendRedirect("AddProduct.jsp");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		String Product_Name = req.getParameter("Product_Name");
		String Product_Image = req.getParameter("Product_Image");
		String Item = req.getParameter("Item");
		String dom = req.getParameter("Dom");
		String doe = req.getParameter("Doe");
		String location = req.getParameter("Location");
		Part part = req.getPart("Product_Image");
		
		InputStream inputStream = null;


		if (part != null) {
		
			inputStream = part.getInputStream();

		}
		int product_price = Integer.parseInt(req.getParameter("product_price"));
		float rating = Float.parseFloat(req.getParameter("Rating"));
		ProductBean productBean = new ProductBean();
		productBean.setProduct_Name(Product_Name);
		productBean.setProduct_Image(inputStream);
		productBean.setItem(Item);
		productBean.setDom(dom);
		productBean.setDoe(doe);
		productBean.setLocation(location);
		productBean.setProduct_price(product_price);
		productBean.setRating(rating);
		ProductService addProductService = new ProductServiceImpl();

		boolean addProduct = addProductService.addProduct(productBean);
		if (addProduct) {
			req.getRequestDispatcher("EditProduct.jsp").forward(req, response);
		} else {
			req.setAttribute("errMessage", addProduct);
			req.getRequestDispatcher("AddProduct.jsp").include(req, response);
		}
	}

}
