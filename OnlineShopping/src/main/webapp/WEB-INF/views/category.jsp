<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<title>Category Page</title>

</head>
<body>
${msg}
	<h1 align="center">Add a Category</h1>
	
	<form:form action="category.do" commandName="category"  method="POST">
	
		<table align="center">
			<tr>
				<td><form:label path="id"> <spring:message text="ID" />	</form:label></td>
				<c:choose>
					<c:when test="${not empty category.id}">
						<td><form:input path="id" disabled="false"  readonly="false" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="id" pattern=".{5,20}" required="true"
								title="id should contains 5 to 20 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
				<td><form:label path="name">	<spring:message text="Name" /> </form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="description"> <spring:message text="Description"/></form:label></td>
				<td><form:input path="description" required="true" /></td>
			</tr>
			
				
			<tr>
				<td colspan="2"><c:if test="${ empty category.name}">
						<input type="submit" value="<spring:message text="Add Category"/>" />
					</c:if> <c:if test="${not empty category.name}">
						<input type="submit" value="<spring:message text="Update Category"/>" />
					</c:if></td>
			</tr>
			
		</table>
	</form:form>
	<br>
	<h3>Category List</h3>
	<c:if test="${!empty categoryList}">
		<table class="tg" border="">
			<tr>
				<th width="80">Category ID</th>
				<th width="120">Category Name</th>
				<th width="120">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="<c:url value='/manage_category_edit/${category.id}' />">Edit</a></td>
					<td><a href="<c:url value='/manage_category_remove/${category.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>






