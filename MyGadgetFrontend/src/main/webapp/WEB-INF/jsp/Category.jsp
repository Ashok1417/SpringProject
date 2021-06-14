<%@ page language="java" contentType="text/html"%>

<%@include file="MainPage.jsp"%>

<form action="<c:url value='/insertcategory'/>" method="post">
 
  <label>
    <p class="label-txt">Category ID</p>
    <input type="text" class="input" name="CategoryId">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  
  <label>
    <p class="label-txt">Category Name</p>
    <input type="text" class="input" name="categoryName">
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  
  <label>
    <p class="label-txt">Category Description</p>
    <textarea cols="30" rows="5" class="input" name="categoryDesc"></textarea>
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
 
  <button type="submit">Insert Data</button>
</form>

<div class="table-responsive">
<table align="Center" cellSpacing="2" cellPadding="2" class="table table-hover" width="50%">
	<tr bgcolor="pink">
		<td>Category ID</td>
		<td>Category Name</td>
		<td>Category Description</td>
		<td>Operation</td>
	</tr>
	
	<c:forEach items="${categoryList}" var="category">
	<tr bgcolor="White">
		<td>${category.getCategoryId()}</td>
		<td>${category.getCategoryName()}</td>
		<td>${category.getCategoryDesc()}</td>
		<td>
		<a href="<c:url value='/deletecategory/${category.getCategoryId()}'/>">Delete</a>
		&nbsp;&nbsp;|&nbsp;&nbsp;
		<a href="<c:url value='/editcategory/${category.getCategoryId()}'/>">Edit</a>
		</td>
	</tr>
	</c:forEach>
	

</body>
</html>