<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Secure Login</title>

    <!-- Bootstrap -->
    <link href="resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="resources/js/html5shiv.min.js"></script>
      <script src="resources/js/respond.min.js"></script>
    <![endif]-->
    <link href="resources/css/app.css" rel="stylesheet">
  </head>
  <body>
    <div class="container">
      <div class="row" id="pwd-container">
      	<div class="col-md-4"></div>
      	<div class="col-md-4">
      	  <section class="login-form">
      	  	<form method="post" action="#" role="login">
      	  	  <img src="http://i.imgur.com/RcmcLv4.png" class="img-responsive" alt="" />
      	  	  <input type="email" name="email" placeholder="Email" required class="form-control input-lg" />
          	  <input type="password" class="form-control input-lg" id="password" placeholder="Password" />
          	  <div class="pwstrength_viewport_progress"></div>
          	  <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Sign in</button>
          	  <div>
                <a href="#">Create account</a> or <a href="#">reset password</a>
              </div>
      	  	</form>
      	  	<div class="form-links">
          	  <a href="#">c12.io</a>
        	</div>
      	  </section>
      	</div>
      </div>
    </div>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script type="text/javascript" src="resources/js/jquery-3.2.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/pwstrength-bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/app.js"></script>
  </body>
</html>