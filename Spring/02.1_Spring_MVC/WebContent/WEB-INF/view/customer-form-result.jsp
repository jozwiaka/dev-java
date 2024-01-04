<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<title>Customer form result</title>
</head>
<body>
Customer = ${customer.firstName} ${customer.lastName}
<br><br>
Number = ${customer.number}
<br><br>
Postal code = ${customer.postalCode}
<br><br>
Course code = ${customer.courseCode}
</body>
</html>