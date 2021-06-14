<%@ page language="java" contentType="text/html"%>

<%@include file="MainPage.jsp"%>


<form action="<c:url value='/insertproduct'/>" method="post">
  <label>
    <p class="label-txt">Product ID</p>
    <input type="text" class="input" name="ProductID">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">Product Name</p>
    <input type="text" class="input" name="ProductName">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">Product Description</p>
    <textarea cols="30" rows="5" class="input" name="ProductDesc"></textarea>
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  
   <label>
    <p class="label-txt">Product Review</p>
    <textarea cols="30" rows="5" class="input" name="ProductReview"></textarea>
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  
  <button type="submit">Insert Data</button>
</form>

<div class="table-responsive">
<table align="Center" cellSpacing="2" cellPadding="2" class="table table-hover" width="50%">
	<tr bgcolor="pink">
		<td>Product ID</td>
		<td>Product Name</td>
		<td>Product Description</td>
		<td>Product Review</td>
		<td>Operation</td>
	</tr>
	
	<c:forEach items="${ProductList}" var="product">
		<tr bgcolor="White">
			<td>${product.getProductId()}</td>
			<td>${product.getProductName()}</td>
			<td>${product.getProductDesc()}</td>
			<td>${product.getProductReview()}</td>
			<td>
		<a href="<c:url value='/deleteproduct/${product.getProductId()}'/>">Delete</a>
		&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/editproduct/${product.getProductId()}'/>">Edit</a>
		</td>
		</tr>
		
	
	</c:forEach>

</table>

</div>



</body>
</html>