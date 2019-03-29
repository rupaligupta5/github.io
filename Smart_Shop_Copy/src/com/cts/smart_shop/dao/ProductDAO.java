package com.cts.smart_shop.dao;

import java.util.List;

import com.cts.smart_shop.bean.ProductBean;

public interface ProductDAO {
	
	public boolean addProduct(ProductBean bean);
	  public boolean deleteProduct(ProductBean bean);
	  public boolean updateProduct(String name, String item);
	  public List<ProductBean> getAllProductBean();
	  public List<ProductBean> getProductName();
	  public List<ProductBean> getAllProducts();
	  public List<ProductBean> sortProducts(String query);
	  public List<ProductBean> searchProducts(String name);
	
}
