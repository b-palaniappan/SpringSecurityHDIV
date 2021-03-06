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
<%--
	Used for including CSRF token in JSON requests
	Also see bottom of this file for adding CSRF token to JQuery AJAX requests
--%>
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
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
					<li><a href="/logout" id="linkLogout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	
	<div class="alert alert-danger" role="alert">
		<strong>Oh snap!</strong> Something went wrong. Go back or click <a href="/welcome">here</a>.
	</div>
	
	<%-- Logout Form --%>
	<form:form method="post" action="/logout" id="formLogout">
	</form:form>
	<jsp:include page="jspf/footer-include.jsp" />
</body>
</html>