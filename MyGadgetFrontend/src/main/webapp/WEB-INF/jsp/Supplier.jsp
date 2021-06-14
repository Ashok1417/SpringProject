<%@ page language="java" contentType="text/html" %>

<%@include file="MainPage.jsp"%>

<div class="table-responsive">
<form action="<c:url value='/insertSupplier'/>" method="post">
  <label>
    <p class="label-txt">Supplier ID</p>
    <input type="text" class="input" name="SupplierID">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">Supplier Name</p>
    <input type="text" class="input" name="SupplierName">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">Supplier Description</p>
    <textarea cols="30" rows="5" class="input" name="SupplierDesc"></textarea>
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <button type="submit">Insert Data</button>
</form>

<table align="Center" cellSpacing="2" cellPadding="2" class="table table-hover" width="50%">
	<tr bgcolor="pink">
		<td>Supplier ID</td>
		<td>Supplier Name</td>
		<td>Supplier Desc</td>
		<td>Operation</td>
	</tr>
	
	<c:forEach items="${supplierlist}" var="supplier">
	<tr bgcolor="white">
		<td>${supplier.supplierID}</td>
		<td>${supplier.supplierName}</td>
		<td>${supplier.supplierDesc}</td>
		<td>
		<a href="<c:url value='/deletesupplier/${supplier.supplierID}'/>">Delete</a>
		&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/editsupplier/${supplier.supplierID}'/>">Edit</a>
		</td>
	</tr>
	</c:forEach>
	

</table>
</div>
</body>
</html>