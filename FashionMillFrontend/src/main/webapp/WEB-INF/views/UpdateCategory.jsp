<%@ page language="java" contentType="text/html"%>

<%@include file="Header.jsp" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<form action="<c:url value="/updateCategory"/>" method="post">  
<table align="center" class="table">
  
  <tr>
    <td colspan="2"> 
    <h3><center>CATEGORY</center></h3> 
    </td>
  </tr>
  
   <tr>
    <td> Category ID </td>
    <td> <input type="text" name="categoryId" value="${category.categoryId}" readonly /></td>
  </tr>
  
  <tr>
    <td> Category Name </td>
    <td> <input type="text" name="categoryName" value="${category.categoryName}"/></td>
  </tr>
   
  <tr>
    <td> Category Description </td>
    <td> <input type="text" name="categoryDesc" value="${category.categoryDesc}"/></td>
  </tr>
  
  <tr>
    <td colspan="2"> 
    <center><input type="submit" value="UPDATE CATEGORY"/></center> 
    </td>
  </tr>
     
</table>
</form>