<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

<head>
	<title>Student form result</title>
</head>
<body>
<%--calls student.getFirstName()--%>
Student = ${student.firstName} ${student.lastName}
<br><br>

Country = ${student.country}
<br><br>

Language = ${student.language}
<br><br>

Checkboxes =
<ul> <!-- unordered list -->
	<c:forEach var="temp" items="${student.checkboxes}">
	<li>${temp}</li> <!-- list item -->
	</c:forEach>
</ul>
</body>

</html>