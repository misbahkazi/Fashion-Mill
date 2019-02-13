<%@ page language="java" contentType="text/html"%>

<%@include file="Header.jsp" %>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<form action="<c:url value="/updateProduct"/>" method="post">  
<table align="center" class="table">
  
  <tr>
    <td colspan="2"> 
    <h3><center>PRODUCT </center></h3> 
    </td>
  </tr>
  
   <tr>
    <td> Product ID </td>
    <td> <input type="text" name="productId" value="${product.productId}" readonly /></td>
  </tr>
 
  
  <tr>
    <td> Product Name </td>
    <td> <input type="text" name="productName" value="${product.productName}"/></td>
  </tr>
  
   <tr>
    <td> Price </td>
    <td> <input type="text" name="price" value="${product.price}"/></td>
  </tr>
  
  <tr>
    <td> Stock </td>
    <td> <input type="text" name="stock" value="${product.stock}"/></td>
  </tr>
  
  <tr>
    <td> Category </td>
    <td> <input type="text" name="categoryName" value="${category.categoryName}"/></td>
  </tr>
  
   <tr>
     <td> Supplier </td>
     <td>  <input type="text" name="supplierId" value="${supplierDetail.supplierId}"/> </td>
  </tr>
  
  
  <tr>
    <td> Product Description </td>
    <td> <input type="text" name="productDesc" value="${product.productDesc}"/></td>
  </tr>
  
  <tr>
    <td colspan="2"> 
    <center><input type="submit" value="UPDATE PRODUCT"/></center> 
    </td>
  </tr>
     
</table>
</form>