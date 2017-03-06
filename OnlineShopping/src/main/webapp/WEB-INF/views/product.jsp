
	<div class="wrapper">

	<h1 align="center" >Add  Product</h1>

	<form:form action="product.do" commandName="product"  method="POST">
		<table align="center">

	<tr><td>Product Id <td> <form:input path="id"/> <td>	</tr>
	
<tr><td>Product Name <td> <form:input path="name"/> <td>	</tr>
	
	<tr><td> Description <td> <form:input path="description"/> <td>	</tr>
	
	<tr><td>Price  <td> <form:input path="price"/> <td>	</tr>
	
	
<tr>
<td colspan="2">

<input type="submit" name="action" value="Add">
<input type="submit" name="action" value="Edit">
<input type="submit" name="action" value="Delete">
<input type="submit" name="action" value="Search">
</td>
</tr>

	</table>


</form:form>

<br>


	<h3 align="center">Product List</h3>
<table class="table">
    <thead>
        <tr>
            <th>ProductId</th>
            <th>ProdName</th>
            <th>Description</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>

    
    		<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.id}</td>
					<td>${product.name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td><a href="<c:url value='manage_product_edit/${product.id}' />">Edit</a></td>
					<td><a href="<c:url value='manage_product_remove/${product.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
</div>
