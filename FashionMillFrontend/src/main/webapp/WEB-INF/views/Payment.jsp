<%@ page language="java" contentType="text/html;"%>
<%@include file="Header.jsp" %>

<div class="container">
<table class="table table-bordered" align="center">

<tr>
  <td colspan="2"><center>Payment Detail</center></td>
</tr>
<tr>
  <td colspan="2">
    <center>
     <input type="radio" name="paymentmode" value="CC">Credit Card
     <input type="radio" name="paymentmode" value="COD">Cash On Delivery
    </center>
  </td>
</tr>
<tr>
   <td>Card Number</td>
   <td><input type="text" name="cardno"/></td>
</tr>
<tr>
   <td>Valid<input type="text" name="Valid"/></td>
   <td>CVV<input type="text" name="CVV"/></td>
</tr>
<tr>
   <td>Name</td>
   <td><input type="text" name="name"/></td>
</tr>
<tr class="success">
   <td colspan="2"><center><input type="submit" value="Pay" class="btn btn-success"/></center></td>
</tr>
</table>
</form>
</div>