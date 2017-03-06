<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<div class ="Light-group">

<c:forEach items="${products}"  var="product">

<a href="${contextRoot}/show/product/${product.id}/products" class="Light-group-item">${product.name}</a>

</c:forEach>
</div>