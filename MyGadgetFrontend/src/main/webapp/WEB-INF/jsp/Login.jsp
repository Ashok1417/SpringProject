<%@ page language="java" contentType="text/html" %>
<%@include file="MainPage.jsp"%>
<div class="container">
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <form action="<c:url value='/logincheck'/>" method="post" class="box">
                    
                    <h1>Login</h1>
                    <p class="text-muted"> Please enter your login and password!</p> 
                    <br/><br/>
                    <input type="text" name="Username" placeholder="Username"> <br/>
                    <input type="password" name="passwrd" placeholder="Password"> <br/>
                    <a class="forgot text-muted" href="#">Forgot password?</a> <br/>
                    <input type="submit" name="" value="login" href="LoginSuccess">
                    
                </form>
            </div>
        </div>
    </div>
</div>

</body>
</html>