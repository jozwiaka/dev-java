<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<head>
	<title>Customer form</title>
	
	<style>
		.error {color:red}
	</style>
</head>

<body>
	<form:form action="processForm" modelAttribute="customer">
		First name = <form:input path="firstName"/>
		<br><br>
		Last name (*) = <form:input path="lastName"/>
		<form:errors path="lastName" cssClass="error"/> 
		<br><br>
		Number (*; [0,10]; d) = <form:input path="number"/>
		<form:errors path="number" cssClass="error"/> 
		<br><br>
		Postal code (5x c/d) = <form:input path="postalCode"/>
		<form:errors path="postalCode" cssClass="error"/>
		<br><br>
		Course code = <form:input path="courseCode"/>
		<form:errors path="courseCode" cssClass="error"/>		
		<br><br>
		<input type="submit" value="Submit"/>
	</form:form>
</body>

</html>