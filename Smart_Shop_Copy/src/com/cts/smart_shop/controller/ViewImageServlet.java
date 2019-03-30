package com.cts.smart_shop.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cts.smart_shop.bean.Person;
import com.cts.smart_shop.bean.ProductBean;
import com.cts.smart_shop.util.DBConnection;

@WebServlet("/ViewImageServlet")
public class ViewImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ViewImageServlet() {
        super();
    }

    private Person getImageInTable(Connection conn, String id) throws SQLException {
    	 String sql = "Select * from product_list where Product_Name=?";
         PreparedStatement pstm = conn.prepareStatement(sql);
         pstm.setString(1, id);
         Person p = null;
         ResultSet rs = pstm.executeQuery();
         if (rs.next()) {
             String name = rs.getString("Product_Name");
             byte[] imageData = rs.getBytes("Product_Image");
             String imageFileName = rs.getString("Location");
             return new Person(id, name, imageFileName, imageData);}
         else
         {return null;}
         }
        
    	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
	      try {
	        
	          conn = DBConnection.getConnection();
	          String id = null;
        	  System.out.println("In view image controller"+ request.getParameter("id"));

	          try {	         
	        	id =request.getParameter("id");  
	          } catch (Exception e) {
	 
	          }
	          Person person = getImageInTable(conn, id);
	          
	          if (person == null) {
	        
	              response.sendRedirect(request.getContextPath() + "/images/noimage.jpg");
	              return;
	          }
	        
	         
	          String imageFileName = person.getImageFileName();
	          System.out.println("File Name: "+ imageFileName);
	        
	        
	          String contentType = this.getServletContext().getMimeType(imageFileName);
	          System.out.println("Content Type: "+ contentType);
	        
	          response.setHeader("Content-Type", contentType);
	        
	          response.setHeader("Content-Length", String.valueOf(person.getImageData().length));
	        
	          response.setHeader("Content-Disposition", "inline; filename=\"" + person.getImageFileName() + "\"");
	
	          response.getOutputStream().write(person.getImageData());
	 
	      } catch (Exception e) {
	          throw new ServletException(e);
	      }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
	}

}
