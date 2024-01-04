<!--<!DOCTYPE html>--> <!-- Dont need -->
<html>
<body>
<h3>Spring REST</h3>
<hr>
<!-- <a href="test/hello">Hello</a> -->
<a href="${pageContext.request.contextPath}/test/hello">${pageContext.request.contextPath}/test/hello</a>
<br><br>
<a href="${pageContext.request.contextPath}/api/students">${pageContext.request.contextPath}/api/students</a> <!-- "/api/students?" solves eclipse caching bug (JSONS are not updating) -->
</body>
</html>