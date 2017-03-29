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

    <jsp:include page="jspf/header-include.jsp" />
  </head>
  <body>
    <p>Welcome page</p>
    <form:form action="/logout">

    </form:form>

    <jsp:include page="jspf/footer-include.jsp" />
  </body>
</html>