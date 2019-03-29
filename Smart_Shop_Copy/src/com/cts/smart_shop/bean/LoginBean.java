package com.cts.smart_shop.bean;
public class LoginBean 
{
	private String Email;
	private String password;
	private String userType;
	
	public String getEmail() 
	{
		return Email;
	}
	public void setEmail(String Email) 
	{
		this.Email = Email;
	}	

	public String getpassword() 
	{
		return password;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Email == null) ? 0 : Email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginBean other = (LoginBean) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (Email == null) {
			if (other.Email != null)
				return false;
		} else if (!Email.equals(other.Email))
			return false;
		return true;
	}
	
	public String toString() {
		return "LoginBean [Email=" + Email + ", password=" + password + "]";
	}
	
	public void setpassword(String password)
	{
		this.password=password;
	
	
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
}