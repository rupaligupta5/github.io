package com.cts.smart_shop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.smart_shop.bean.ProductBean;
import com.cts.smart_shop.dao.AddProductDAO;
import com.cts.smart_shop.dao.AddProductDAOImpl;
import com.cts.smart_shop.dao.ProductDAO;
import com.cts.smart_shop.dao.ProductDAOImpl;
import com.cts.smart_shop.util.DBConnection;

public class ProductServiceImpl implements ProductService {
	
	
	ProductDAO productDAO = new ProductDAOImpl();
	ProductDAO deleteProductDAO = new ProductDAOImpl();
	ProductDAO updateProductDAO = new ProductDAOImpl();
    
public boolean deleteProduct(ProductBean bean) {
    	ProductBean deleteProductBean = new ProductBean();
    	deleteProductBean.setProduct_Name(bean.getProduct_Name());
    	
    	if(deleteProductDAO.deleteProduct(bean)){
           return true;
            }
    	else return false;
          }  
    
public boolean updateProduct(String name,String item) {
    	
    	return updateProductDAO.updateProduct(name,item);
          }  
  
    	AddProductDAO addProductDAO = new AddProductDAOImpl();
		
public boolean addProduct(ProductBean bean) {
	System.out.println("In DAO");
			 return addProductDAO.addProduct(bean);
			
		}



		@Override
public List<ProductBean> getAllProductBean() {
			
			return deleteProductDAO.getAllProductBean();
		}



		@Override
public List<ProductBean> getProductName() {
			
			return productDAO.getProductName();
			}



		@Override
public List<ProductBean> getAllProducts() {
			
			return productDAO.getAllProducts();
		}

		@Override
		public List<ProductBean> sortProducts(String query) {
			
			return productDAO.sortProducts(query);
		}

		@Override
		
		public List<ProductBean> searchProducts(String name)
		{
		
			return productDAO.searchProducts(name);
	}

}


