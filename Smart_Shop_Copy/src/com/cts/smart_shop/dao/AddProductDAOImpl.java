package com.cts.smart_shop.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cts.smart_shop.bean.ProductBean;
import com.cts.smart_shop.util.DBConnection;
public class AddProductDAOImpl implements AddProductDAO
{
	@Override
	public boolean addProduct(ProductBean productBean)
	{
		String Product_Name = productBean.getProduct_Name();
		InputStream Product_Image = productBean.getProduct_Image();
		String Item = productBean.getItem();
		String dom = productBean.getDom();
		String doe = productBean.getDoe();
		String Location = productBean.getLocation();
		int price = productBean.getProduct_price();
		System.out.println(productBean.getProduct_Name());
		float rating = productBean.getRating();
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConnection.getConnection();
			System.out.println(price);
			String query = "insert into product_list(Product_Name,Product_Image,Item,dom,doe,Location,Product_Price,Rating) values (?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query); 
            ps.setString(1, Product_Name);
            ps.setBlob(2, Product_Image);
            ps.setInt(3, Integer.parseInt(Item));
            ps.setString(4, (dom));
            ps.setString(5, (doe));
            ps.setString(6, (Location));
            ps.setInt(7, (price));
            ps.setFloat(8, (rating));
            
          
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

	
}

