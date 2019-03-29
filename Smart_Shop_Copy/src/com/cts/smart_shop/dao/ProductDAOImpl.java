package com.cts.smart_shop.dao;

import java.io.InputStream; 
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cts.smart_shop.bean.ProductBean;
import com.cts.smart_shop.util.DBConnection;

public class ProductDAOImpl implements ProductDAO {

private static final String Item = null;


	@Override
public boolean addProduct(ProductBean productBean) {
		String Product_Name = productBean.getProduct_Name();
		InputStream Product_Image = productBean.getProduct_Image();
		String Item = productBean.getItem();
		String dom = productBean.getDom();
		String doe = productBean.getDoe();
		String location = productBean.getLocation();
		int product_price = productBean.getProduct_price();
		Float rating = productBean.getRating();
		
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConnection.getConnection();
			
			String query = "insert into product_list(Product_Name,Product_Image,Item,dom,doe,location,product_price,rating) values (?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query); 
            ps.setString(1, Product_Name);
            ps.setBlob(2, Product_Image);
            ps.setInt(3, Integer.parseInt(Item));
            ps.setString(4, (dom));
            ps.setString(5, (doe));
            ps.setString(6, (location));
            ps.setInt(7, product_price);
            ps.setFloat(7, rating);
            int i= ps.executeUpdate();
			if (i!=0) 
			return true; 
         
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			
			 try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
		return false;  
	}

	@Override
public boolean deleteProduct(ProductBean deleteProductBean) {
        String Product_Name = deleteProductBean.getProduct_Name();
        
        Connection con = null;
        PreparedStatement ps = null;
        try
        {
                        con = DBConnection.getConnection();                                   
                        String query = "delete from product_list where Product_Name=?";
                        
                        ps = con.prepareStatement(query); 

                        ps.setString(1, Product_Name);
                        int i= ps.executeUpdate();
                       if (i!=0) 
                    	return true; 


         }
        catch(SQLException e)
        {
                        e.printStackTrace();
        }
        finally{
           try {
                        ps.close();
               } 
            catch (SQLException e) {
                        e.printStackTrace();
               }
        }                          
        return false;  
}

	
public boolean updateProduct(String name, String item) {
        String Product_Name = name;
        String Item = item;
        
        Connection con = null;
        PreparedStatement ps = null;
        try
        {
                        con = DBConnection.getConnection();   
                        
                        String query = "Update product_list set Item =? where Product_Name=?";
                
                        ps = con.prepareStatement(query); 

                        ps.setString(1, Item);
                        ps.setString(2, Product_Name);
                      
                        int i= ps.executeUpdate();
                       if (i!=0) 
                       {
                    	return true; 
                       }


         }
        catch(SQLException e)
        {
                        e.printStackTrace();
        }
        finally{
           try {
                        ps.close();
               } 
            catch (SQLException e) {
                        e.printStackTrace();
               }
        }                          
        return false;  
}
	
public List<ProductBean> getProductName() {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		List<ProductBean> productName=new ArrayList<ProductBean>();
		try
		{
			con = DBConnection.getConnection();
			
			String query = "select * from product_list";
			ps = con.prepareStatement(query); 
			ResultSet rs= ps.executeQuery();
			int i=0;
            while(rs.next())
            {
            	String id = rs.getString("Product_Name");
            	Blob image = rs.getBlob("Product_Image");
            	String item = rs.getString("Item");
				String dom = rs.getString("dom");
				String doe = rs.getString("doe");
				String location = rs.getString("location");
				Float rating = rs.getFloat("Rating");
				int product_price = rs.getInt("product_price");
				
				ProductBean productBean = new ProductBean();
				productBean.setProduct_Image(image.getBinaryStream());
				productBean.setProduct_Name(id);
				productBean.setDoe(doe);
				productBean.setDom(dom);
				productBean.setItem(item);
				productBean.setLocation(location);
				productBean.setRating(rating);
                productBean.setProduct_price(product_price);				
				
				
				productName.add(productBean);
				
		   	
            }
            return productName;
         
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			
			 try {
				ps.close();
			 	 }
			 catch (SQLException e) {
				
				e.printStackTrace();
			 	 }		
			
			   }	return null;
		 }

	
	
	@Override
public List<ProductBean> getAllProductBean() {
		Connection con = null;
		PreparedStatement ps = null;
		List<ProductBean> productBeanList=new ArrayList<ProductBean>();
		try
		{
			con = DBConnection.getConnection();
			
			String query = "select * from product_list";
			ps = con.prepareStatement(query); 
			ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            	ProductBean productBean= new ProductBean();
            	productBean.setProduct_Name(rs.getString("Product_Name"));
            	productBean.setProduct_Image(rs.getBlob("Product_Image").getBinaryStream());
            	productBean.setItem(rs.getString("Item"));
            	productBean.setDom(rs.getString("dom"));
            	productBean.setDoe(rs.getString("doe"));
            	productBean.setDoe(rs.getString("location"));
            	productBean.setRating(rs.getFloat("Rating"));
            	productBean.setProduct_price(rs.getInt("product_price"));
            	productBeanList.add(productBean);
            	
            }
         return productBeanList;
        
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			
			 try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
			
		}		return null;
	}

	@Override
public List<ProductBean> getAllProducts() {
	return null;
	}

	@Override
	public List<ProductBean> sortProducts(String query) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		List<ProductBean> productBeanList=new ArrayList<ProductBean>();
		String query2 = new String();
		if("name".equals(query))
			query2="select * from product_list order by Product_Name";
		if("price".equals(query))
			query2="select * from product_list order by Product_Price";
		if("availability".equals(query))
			query2="select * from product_list order by Item";
		if("popularity".equals(query))
			query2="select * from product_list order by Rating";
		try
		{
			con = DBConnection.getConnection();
			
			
			ps = con.prepareStatement(query2); 
			ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
            	ProductBean productBean= new ProductBean();
            	productBean.setProduct_Name(rs.getString("Product_Name"));
            	productBean.setProduct_Image(rs.getBlob("Product_Image").getBinaryStream());
            	productBean.setItem(rs.getString("Item"));
            	productBean.setDom(rs.getString("dom"));
            	productBean.setDoe(rs.getString("doe"));
            	productBean.setLocation(rs.getString("Location"));
            	productBean.setRating(rs.getFloat("Rating"));
            	productBean.setProduct_price(rs.getInt("Product_Price"));
            	productBeanList.add(productBean);
            	
            }
         return productBeanList;
			
        
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			
			 try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
			
		}		return null;
	}

	@Override
	public List<ProductBean> searchProducts(String name) {
		Connection con = null;
		PreparedStatement ps = null;
		List<ProductBean> productBeanList=new ArrayList<ProductBean>();
		try
		{
			con = DBConnection.getConnection();
			
			String query = "select * from product_list where Product_Name=?";
			con.setAutoCommit(true);
			ps = con.prepareStatement(query);
			ps.setString(1, name);
			ResultSet rs=ps.executeQuery();
			 while(rs.next())
	            {
	            	ProductBean productBean= new ProductBean();
	            	productBean.setProduct_Name(rs.getString("Product_Name"));
	            	productBean.setProduct_Image(rs.getBlob("Product_Image").getBinaryStream());
	            	productBean.setItem(rs.getString("Item"));
	            	productBean.setDom(rs.getString("dom"));
	            	productBean.setDoe(rs.getString("doe"));
	            	productBean.setLocation(rs.getString("Location"));
	            	productBean.setRating(rs.getFloat("Rating"));
	            	productBean.setProduct_price(rs.getInt("Product_Price"));
	            	productBeanList.add(productBean);
	            	
	            }
            	
         return productBeanList;
            	
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			
			 try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
				
			
		}		return null;
	}

}
