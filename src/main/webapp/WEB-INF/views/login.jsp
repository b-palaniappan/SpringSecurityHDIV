<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Secure Login</title>

    <jsp:include page="jspf/header-include.jsp" />
  </head>
  <body class="login-page">
    <div class="container">
      <div class="row" id="pwd-container">
      	<div class="col-md-4"></div>
      	<div class="col-md-4">
      	  <section class="login-form">
      	  	<form:form method="post" action="/spring_security_check" role="login">
      	  	  <img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="" />
      	  	  <input type="email" name="username" placeholder="Email" required class="form-control input-lg" />
          	  <input type="password" name="password" class="form-control input-lg" id="password" placeholder="Password" required />
          	  <div class="pwstrength_viewport_progress"></div>
          	  <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
          	  <div>
                <a href="/register">Create account</a> or <a href="/forgotPassword">reset password</a>
              </div>
      	  	</form:form>
      	  	<div class="form-links">
          	  <a href="#">c12.io</a>
        	</div>
      	  </section>
      	</div>
      </div>
    </div>

    <jsp:include page="jspf/footer-include.jsp" />
  </body>
</html>