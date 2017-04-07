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
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Spring Secure</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/profile">Profile</a></li>
					<li><a href="/logout" id="linkLogout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<%-- Empty form created to have CSRF and HDIV tokens generated --%>
	<div class="container theme-showcase" role="main">
		<div class="jumbotron">
			<h1>Welcome Page</h1>
			<p>Spring Security with HDIV Welcome page</p>
		</div>
	</div>
	
	<%-- Logout Form --%>
	<form:form method="post" action="/logout" id="formLogout">
	</form:form>
	<jsp:include page="jspf/footer-include.jsp" />
</body>
</html>