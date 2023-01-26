<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@include file="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Page</title>
</head>
<h2>Create New Lead here...</h2>
<body>
	<form action ="saveLead" method="post">
		<pre>
	
			First Name<input type="text" name="firstName"/>
			Last Name<input type="text" name="lastName"/>
			Email<input type="text" name="email"/>
			Mobile<input type="number" name="mobile"/>
					<input type="submit" value="save"/>
			
		</pre>
	</form>
	${msg}
</body>
</html>