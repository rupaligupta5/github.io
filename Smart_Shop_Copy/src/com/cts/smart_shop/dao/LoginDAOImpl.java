package com.cts.smart_shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import com.cts.smart_shop.bean.LoginBean;
import com.cts.smart_shop.util.DBConnection;

public class LoginDAOImpl  implements LoginDAO{

                public boolean validateUser(LoginBean bean) {
                               
                                Connection connection = null;

                                String query = "select email, password from login where email=? and password=?";
                                PreparedStatement preparedStatement = null;
                                ResultSet resultSet = null;
                                
                                
                                try {
                                                connection = DBConnection.getConnection();
                                                preparedStatement = connection.prepareStatement(query);
                                                preparedStatement.setString(1, bean.getEmail());
                                                preparedStatement.setString(2, bean.getpassword());
                                                resultSet = preparedStatement.executeQuery();
              
                                                if(resultSet.next()) {
                                                                return true;
                                                }
                                                else return false;
                                } catch (SQLException e) {
                                               
                                                e.printStackTrace();
                                }
                                finally {
                                                DBConnection.closeConnection(connection);
                                }
                                
                                return false;
                }

				@Override
				public String insertLogin(LoginBean bean) {
				
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					String query = "insert into login (email,password,usertype) values(?,?,?)";
					
					try {
						connection = DBConnection.getConnection();
						preparedStatement = connection.prepareStatement(query);
						preparedStatement.setString(1, bean.getEmail());
						preparedStatement.setString(2, bean.getpassword());
						preparedStatement.setString(3, bean.getUserType());
				
						preparedStatement.executeUpdate();
						return "success";
					} catch (SQLException e) {
						
						e.printStackTrace();
						return "fail";
					}
					finally {
						DBConnection.closeConnection(connection);
					}
					
				}

				@Override
				public String getUserType(String email) {
					
					Connection connection = null;
					PreparedStatement preparedStatement = null;
					String query = "select usertype from login where email=?";
					ResultSet resultSet = null;
					
					
					try {
						connection = DBConnection.getConnection();
						preparedStatement = connection.prepareStatement(query);
						
						preparedStatement.setString(1,email);
						
						resultSet = preparedStatement.executeQuery();
						
						if(resultSet.next()){
							String res =  resultSet.getString(1);
						
							return res;
						}
						else {
							
						
							return "";}
						
					} catch (SQLException e) {
						
						e.printStackTrace();
						return "fail";
					}
					finally {
						DBConnection.closeConnection(connection);
					}
		}

}
