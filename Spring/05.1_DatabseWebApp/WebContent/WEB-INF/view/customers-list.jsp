<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Customers List</title>

	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
		<!-- ${appName}/myStyleSheet -->
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<input
				type="button"
				value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button"
			/>
			<table>
			<tr> <!-- tr = row -->
				<th>First Name</th> <!-- th = header cell = bold -->
				<th>Last Name</th>
				<th>Email</th>
				<th>Action</th>
			</tr>
				<c:forEach var="customer" items="${customers}">
				
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="id_Customer" value="${customer.id}"></c:param>
					</c:url>
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="id_Customer" value="${customer.id}"></c:param>
					</c:url>
					
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
</body>
</html>