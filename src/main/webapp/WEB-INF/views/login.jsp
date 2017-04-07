<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Spring Security HDIV">
<meta name="author" content="b-palaniappan">
<title>Secure Login</title>
<jsp:include page="jspf/header-include.jsp" />
</head>

<body>
	<%-- Fixed navbar --%>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> 
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Spring Secure</a>
			</div>
		</div>
	</nav>
	<div class="container theme-showcase" role="main">
		<div class="page-header">
			<h1>Login</h1>
		</div>
		<div class="row">
			<div class="col-sm-3"></div> <%-- /.col-sm-3 --%>
			<div class="col-sm-6">
			<%-- Invalid user id / password --%>
			<div class="alert alert-danger hide" role="alert" id="loginInvalidCredential">
       			<strong>Error!</strong> Wrong Email address and / or Password.
     			</div>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Login Here</h3>
				</div>
				<div class="panel-body">
					<form:form method="post" action="/spring_security_check" role="login" id="formLogin">
						<div class="form-group">
							<label class="control-label" for="inputUserName">Email address</label> 
							<input name="username" type="email" class="form-control" id="inputUserName" placeholder="Email" required>
						</div>
						<div class="form-group">
							<label class="control-label" for="password">Password</label> 
							<input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password" required>
						</div>
						<button type="submit" name="go" class="btn btn-primary">Sign in</button>
					</form:form>
				</div>
			</div>
			<div>
				<a href="/register">Create account</a> or <a href="/forgotPassword">Forgot password</a>
			</div>
		</div> <%-- /.col-sm-6 --%>
		<div class="col-sm-3"></div> <%-- /.col-sm-3 --%>
		</div>
	</div> <%-- /container --%>
	<jsp:include page="jspf/footer-include.jsp" />
</body>
</html>