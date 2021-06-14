<%@ page language="java" contentType="text/html" %>
<%@include file="MainPage.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <form action="<c:url value='/insertuser'/>" method="post" class="box">


			<h1>Register Here</h1>
			<br/>
			<input type="text" name="Username" placeholder="UserName" class="input"/>
			<br/>
			<input type="password" name="passwrd" placeholder="Password" class="input"/>
			<br/>
			<input type="text" name="CustomerName" placeholder="CustomerName" class="input"/>
			<br/>
			<input type="text" name="Role" placeholder="Role" class="input">
			<br/>
			<input type="text" name="Address" placeholder="Address" class="input">
			<br/>
			<input type="text" name="MobileNo" placeholder="MobileNo" class="input">
			<br/>
			<input type="text" name="EmailId" placeholder="EmailId" class="input">
			<br/>
			<input type="text" name="enabled" placeholder="enabled" class="input">
			<br/>
			<Button type="submit" >Insert Data</Button>
			<br/><br/><br/>
			<input type="reset" value="Reset"/>
		

              </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>