<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
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
		<div>
			<ol class="breadcrumb">
	  			<li>
	  				<div>
		  				<a href="<c:url value="login" />">Login
						</a>
					</div>
	  			</li>
	  			<li class="active">Register</li>
			</ol>
		</div>
		<div class="page-header">
			<h1>Register</h1>
		</div>
		<form:form method="post" action="/registerUser" id="formRegister" modelAttribute="registrationForm" >
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label class="control-label" for="inputFirstName"><span class="req" title="Required">*</span>First Name</label> 
						<form:input path="firstName" cssClass="form-control" id="inputFirstName" placeholder="First Name"/>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label" for="inputMI">MI</label> 
						<form:input path="middleInitial" cssClass="form-control" id="inputMI" placeholder="Middle Initial" maxlength="1"/>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label class="control-label" for="inputLastName"><span class="req" title="Required">*</span>Last Name</label> 
						<form:input path="lastName" cssClass="form-control" id="inputLastName" placeholder="Last Name" />
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label" for="inputSuffix">Suffix</label> 
						<form:input path="suffix" cssClass="form-control" id="inputSuffix" placeholder="Suffix" maxlength="3"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label" for="inputEmail"><span class="req" title="Required">*</span>Email</label> 
						<form:input path="email" cssClass="form-control" id="inputEmail" placeholder="Email Address" aria-describedby="inputSuccess2Status"/>
						<span class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>
  						<span id="inputSuccess2Status" class="sr-only">(success)</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label" for="inputPassword"><span class="req" title="Required">*</span>Password</label> 
						<form:password path="password" cssClass="form-control" id="inputPassword" placeholder="Password"/>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label" for="inputConfirmPassword"><span class="req" title="Required">*</span>Confirm Password</label> 
						<form:password path="confirmPassword" cssClass="form-control" id="inputConfirmPassword" placeholder="Confirm Password"/>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<label class="control-label" for="inputAddress1"><span class="req" title="Required">*</span>Address Line1</label> 
						<form:input path="address1" cssClass="form-control" id="inputAddress1" placeholder="Address Line 1"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<label class="control-label" for="inputAddress2">Address Line2</label> 
						<form:input path="address2" cssClass="form-control" id="inputAddress2" placeholder="Address Line 2"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label" for="inputCity"><span class="req" title="Required">*</span>City</label> 
						<form:input path="city" cssClass="form-control" id="inputCity" placeholder="City"/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label class="control-label" for="inputState"><span class="req" title="Required">*</span>State</label> 
						<form:input path="state" cssClass="form-control" id="inputState" placeholder="State"/>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label class="control-label" for="inputZip"><span class="req" title="Required">*</span>Zip Code</label> 
						<form:input path="zip" cssClass="form-control" id="inputZip" placeholder="Zip Code"/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label" for="inputCountry"><span class="req" title="Required">*</span>Country</label> 
						<form:input path="country" cssClass="form-control" id="inputCountry" placeholder="Country"/>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label class="control-label" for="inputPhone1"><span class="req" title="Required">*</span>Primary Phone</label> 
						<form:input path="phone1" cssClass="form-control" id="inputPhone1" placeholder="Phone"/>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label" for="inputPhone1Extn">Extn</label> 
						<form:input path="phone1Extn" cssClass="form-control" id="inputPhone1Extn" placeholder="Extn"/>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label class="control-label" for="inputPhone2">Secondary Phone</label> 
						<form:input path="phone2" cssClass="form-control" id="inputPhone2" placeholder="Phone"/>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label" for="inputPhone2Extn">Extn</label> 
						<form:input path="phone2Extn" cssClass="form-control" id="inputPhone2Extn" placeholder="Extn"/>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-sm-12">
					<div class="text-right">
						<form:button id="btnCancel" class="btn btn-default" name="Cancel">Cancel</form:button>
						<form:button id="btnRegister" class="btn btn-primary" name="register">Register</form:button>
					</div>
				</div>
			</div>
		</form:form>
		<spring:url var="registrationCheckEmailExists" value="/checkEmailExists" />
	</div> <%-- /container --%>
	<script type="text/javascript">
		var registrationCheckEmailExistsUrl = "${registrationCheckEmailExists}";
	</script>
	<jsp:include page="jspf/footer-include.jsp" />
</body>
</html>