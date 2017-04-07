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
	<!-- Fixed navbar -->
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

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <h1>Spring Secure</h1>
        <p>Welcome to Spring Security with HDIV example login page</p>
      </div>

      <div class="page-header">
        <h1>Login</h1>
      </div>
      <div class="row">
        <div class="col-sm-3">
        </div><!-- /.col-sm-4 -->
        <div class="col-sm-6">
          <div class="panel panel-primary">
            <div class="panel-heading">
              <h3 class="panel-title">Login Here</h3>
            </div>
            <div class="panel-body">
              <form:form method="post" action="/spring_security_check" role="login">
      	  	  <input type="email" name="username" placeholder="Email" required class="form-control input-lg" />
          	  <input type="password" name="password" class="form-control input-lg" id="password" placeholder="Password" required />
          	  <div class="pwstrength_viewport_progress"></div>
          	  <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
          	  <div>
                <a href="/register">Create account</a> or <a href="/forgotPassword">reset password</a>
              </div>
      	  	</form:form>
            </div>
          </div>
        </div><!-- /.col-sm-4 -->
        <div class="col-sm-3">
        </div><!-- /.col-sm-4 -->
      </div>
    </div> <!-- /container -->
	<jsp:include page="jspf/footer-include.jsp" />
</body>
</html>
