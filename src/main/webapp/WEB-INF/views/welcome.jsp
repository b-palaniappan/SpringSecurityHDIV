<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    <link href="resources/css/style.min.css" rel="stylesheet">
  </head>
  <body>
    <p>Welcome page</p>
    <form:form action="/logout">

    </form:form>

    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script type="text/javascript" src="resources/js/jquery-3.2.0.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/pwstrength-bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/js/app.js"></script>
    <script type="text/javascript" src="resources/js/script.min.js"></script>
  </body>
</html>