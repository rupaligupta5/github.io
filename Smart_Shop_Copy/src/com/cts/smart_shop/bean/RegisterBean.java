package com.cts.smart_shop.bean;


public class RegisterBean 
{
	private String First_Name;
	private String Last_Name;
	private String Age;
	private String MobileNumber;
	private String email;
	private String password;
	private String CnfPs;
	private String userType;
	
	public RegisterBean(String first_Name, String last_Name, String age, String mobileNumber, String email,
			String password, String cnfPs, String userType) {
		super();
		First_Name = first_Name;
		Last_Name = last_Name;
		Age = age;
		MobileNumber = mobileNumber;
		this.email = email;
		this.password = password;
		CnfPs = cnfPs;
		this.userType = userType;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getFirst_Name() 
	{
		return First_Name;
	}
	public void setFirst_Name(String First_Name) 
	{
		this.First_Name = First_Name;
	}
	
	
	public String getLast_Name() 
	{
		return Last_Name;
	}
	public void setLast_Name(String Last_Name) 
	{
		this.Last_Name = Last_Name;
	}
	
	
	
	public String getMobileNumber() 
	{
		return MobileNumber;
	}
	public void setMobileNumber(String MobileNumber) 
	{
		this.MobileNumber =MobileNumber;
	}
	
	
	public String getAge() 
	{
		return Age;
	}
	public void setAge(String Age) 
	{
		this.Age =Age;
	}
	
	
	public void setEmail(String email)
	{
		this.email =email;
	}
	public String getEmail() {
		return email;
	}
	
	public String getpassword() 
	{
		return password;
	}
	public void setpassword(String password) 
	{
		this.password =password;
	}
	
	public void setCnfPs(String CnfPs)
	{
		this.CnfPs = CnfPs;
	}
	public String getCnfPs() {
		return CnfPs;
	}
	
	
}