package com.cts.smart_shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.cts.smart_shop.bean.RegisterBean;
import com.cts.smart_shop.util.DBConnection;
public class RegisterDAOImpl implements RegisterDAO
{
	@Override
	public boolean registerUser(RegisterBean registerBean)
	{
		String First_Name = registerBean.getFirst_Name();
		String Last_Name = registerBean.getLast_Name();
		String Age = registerBean.getAge();
		String MobileNumber = registerBean.getMobileNumber();
		
		String Email = registerBean.getEmail();
		String password = registerBean.getpassword();
		String CnfPs = registerBean.getCnfPs();
		Connection con = null;
		PreparedStatement ps = null;
		try
		{
			con = DBConnection.getConnection();
			String query = "insert into reg(First_Name,Last_Name,Age,MobileNumber,Email,password,CnfPs,usertype) values (?,?,?,?,?,?,?,?)";
		
			ps = con.prepareStatement(query); 

            ps.setString(1, First_Name);
            ps.setString(2, Last_Name);
            ps.setString(3, Age);
            ps.setString(4, MobileNumber);
            ps.setString(5, Email);
            ps.setString(6, password);
            ps.setString(7, CnfPs);
            ps.setString(8, registerBean.getUserType());
            
        
            int i= ps.executeUpdate();
			if (i!=0)  
			return true; 
       
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally{
			
			 DBConnection.closeConnection(con);
				
			
		}
		return false;  
	}

	
}