<%@ page language="java" contentType="text/html"%>
<%@include file="Header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<form action="<c:url value="/addUser"/>" method="post">

<table border="1" align="center">
	<tr bgcolor="gray">
		<td colspan="2"> <center>REGISTER</center></td>
	</tr>
	<tr bgcolor="pink">
		<td>Full Name</td>
		<td><input type="text" name="customerName" required/></td>
	</tr>
	
	<tr bgcolor="pink">
		<td>Address</td>
		<td><input type="text" name="customerAddr" required/></td>
	</tr>
	
	
	<tr bgcolor="pink">
		<td>User Name</td>
		<td><input type="text" name="username" required/></td>
	</tr>
	<tr bgcolor="pink">
		<td>Password</td>
		<td><input type="text" name="password" required/></td>
	</tr>
	
	<tr bgcolor="gray"> 
		<td colspan="2">
			<center><input type="submit" value="REGISTER"/></center>
		</td>
	</tr>
</table>
</form>
</body>
</html>