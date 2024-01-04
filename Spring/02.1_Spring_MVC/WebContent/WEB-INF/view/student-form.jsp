<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>
		Student Form
	</title>
</head>

<body>
	<!--Call Student_Controller::processForm( after submittingg-->
	<form:form action="processForm" modelAttribute="student">
		First name: <form:input path="firstName"/>
		<br><br>
		
		Last name: <form:input path="lastName"/>
		<br><br>
		
		Country:
		<form:select path="country">
			<!--Spring will call student.getCountryOptions()-->
			<form:options items="${student.countryOptions}"/>
			<!--  
			<form:option value="c1" label="country1"/>
			<form:option value="c2" label="country2"/>
			<form:option value="c3" label="country3"/>
`			-->
		</form:select>
		<br><br>
		
		Language:
		<form:radiobutton path="language" value="l1" /> language1 
		<form:radiobutton path="language" value="l2" /> language2 
		<form:radiobutton path="language" value="l3" /> language3 
		<br><br>
		
		Language2:
		<form:radiobuttons path="language" items="${student.languageOptions}"/>
		<br><br>
		
		Checkboxes:
		<form:checkboxes items="${student.checkboxesOptions}" path="checkboxes"/>
		<br><br>
		
		<input type="submit" value="Submit"/>
	</form:form>
</body>

</html>