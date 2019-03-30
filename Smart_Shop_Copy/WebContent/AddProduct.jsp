<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cts.smart_shop.bean.ProductBean"%>
<%@page import="java.util.List"%>
<html>

<head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.css"/>
 
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.18/datatables.min.js"></script>

    <title>
        Add Product
    </title>
    <script src="AddProduct.js"></script>
    <link rel="stylesheet" href="AddProduct.css">
</head>

<body>
    <table>
        <tr>
            <td>
                <form action="ProductController" method="post"  autocomplete="auto" enctype="multipart/form-data">
                <h3>Add Product</h3>
                    <div>
                        <label>Product Name*</label><label class="validation-error hide" id="productNameValidationError">This field is required.</label>
                        <input type="text" name="Product_Name" id="productName" >
                    </div>
                    <div>
                        <label>Product Image</label>
                        <input type="file" name="Product_Image" id="productImage">
                    </div>
                    <div>
                        <label>No. of Items</label>
                        <input type="number" name="Item" id="productItems">
                    </div>
                    <div>
                        <label>Manufacturing Date</label>
                        <input type="text" name="Dom" id="productMFG">
                    </div>
                    <br>
                    <div>
                        <label>Expiration Date</label>
                        <input type="text" name="Doe" id="productEXP">
                    </div>
                    
                     <div>
                        <label>Location</label>
                        <input type="text" name="Location" id="productMFG">
                    </div>
                     <div>
                        <label>Product_Price</label>
                        <input type="number" name="product_price" id="productMFG" >
                    </div>
                     <div>
                        <label>Rating</label>
                        <input type="text" name="Rating" id="productMFG" >
                    </div>
                    <div  class="form-action-buttons">
                        <input type="submit" value="Add Product">
                    </div>
                    
                </form>
            </td>
            <td>
                
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
 <td><a href="ViewImageServlet?id=<%=productBean.getProduct_Name()%>" >Show Image</a></td>   
<%--               <td><%=productBean.getProduct_Image() %></td>   
 --%>            
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