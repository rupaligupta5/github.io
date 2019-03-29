<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cts.smart_shop.bean.ProductBean"%>
<%@page import="java.util.List"%>
<html>

<head>
    <title>
        Delete Product
    </title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="AddProduct.js"></script>
    <link rel="stylesheet" href="AddProduct.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>
</head>

<body>
    <table>
        <tr>
            <td>

<form action="DeleteProduct" method="post">
<h3>Delete Product</h3>
   
    				<div>
    				<label>Product Name</label>
						<input type="text" name="Product_Name" id="productDLT">
					</div>
					<div  class="form-action-buttons">
						<input type="submit" value="Delete Product">
					</div>
                </form>
</td>
</tr>
    </table>
    <table id="example" class="display" style="width:100%">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Product Image</th>
                <th>Item</th>
                <th>Manufacturing Date</th>
                <th>Location</th>
              
            </tr>
        </thead>
        <tbody>
        
        <%
        List<ProductBean> productBeanList=(ArrayList<ProductBean>)session.getAttribute("productBeanList");
        if(productBeanList!= null && productBeanList.size()>0){
        	for(int i=0;i<productBeanList.size();i++){
        		ProductBean productBean=productBeanList.get(i);
        				
        %>
        
        
            <tr>
                <td><%=productBean.getProduct_Name() %></td>
                <td><%=productBean.getProduct_Image() %></td>
                <td><%=productBean.getItem() %></td>
                <td><%=productBean.getDom() %></td>
                <td><%=productBean.getDoe() %></td>
               
            </tr>
            
            <%} }%>
            
        </tbody>
    </table>
    
    
	
</body>
<script>
$(document).ready(function() {
    $('#example').DataTable();
} );

</script>
</html>
