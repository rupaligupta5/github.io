<!DOCTYPE html>
<html>
<head>
    <title>
        Update Product
    </title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <script src="AddProduct.js"></script>
    <link rel="stylesheet" href="AddProduct.css">
</head>
<body>
    <table>
        <tr>
            <td>

		<form action="UpdateProductServlet" method="post">
		<h3>Update Product</h3>
            <div>
                    <label>Product Name</label>
                    <input type="text" name="Product_Name" id="productName">
             </div>
             <div>
                    <label>Number of Items</label>
                    <input type="number" name="Item" id="productItems">
              </div>
               <div  class="form-action-buttons">
                    <input type="submit" value="Update Product">
                </div>
                </form>
			</td>
		</tr>
    </table>
    </body>
</html>
                