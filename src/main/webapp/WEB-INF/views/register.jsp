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
	  				<a href="
						<c:url value="login">
							<c:param name="${modifyHDIVStateParameter}" value="${hdivFormStateId}" />
						</c:url>">Login
					</a>
	  			</li>
	  			<li class="active">Register</li>
			</ol>
		</div>
		<div class="page-header">
			<h1>Register</h1>
		</div>
		<form:form method="post" action="/registerUser" id="formRegister" >
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label class="control-label" for="inputFirstName"><span class="req" title="Required">*</span>First Name</label> 
						<input name="firstName" type="text" class="form-control" id="inputFirstName" placeholder="First Name" required>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label" for="inputMI">MI</label> 
						<input name="middleInitial" type="text" class="form-control" id="inputMI" placeholder="Middle Initial" required>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label class="control-label" for="inputLastName"><span class="req" title="Required">*</span>Last Name</label> 
						<input name="lastName" type="text" class="form-control" id="inputLastName" placeholder="Last Name" required>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label" for="inputSuffix">Suffix</label> 
						<input name="suffix" type="text" class="form-control" id="inputSuffix" placeholder="Suffix" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label" for="inputEmail"><span class="req" title="Required">*</span>Email</label> 
						<input name="email" type="text" class="form-control" id="inputEmail" placeholder="Email Address" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label" for="inputPassword"><span class="req" title="Required">*</span>Password</label> 
						<input name="password" type="text" class="form-control" id="inputPassword" placeholder="Password" required>
					</div>
				</div>
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label" for="inputConfirmPassword"><span class="req" title="Required">*</span>Confirm Password</label> 
						<input name="confirmPassword" type="text" class="form-control" id="inputConfirmPassword" placeholder="Confirm Password" required>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<label class="control-label" for="inputAddress1"><span class="req" title="Required">*</span>Address Line1</label> 
						<input name="address1" type="text" class="form-control" id="inputAddress1" placeholder="Address" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-12">
					<div class="form-group">
						<label class="control-label" for="inputAddress2"><span class="req" title="Required">*</span>Address Line2</label> 
						<input name="address2" type="text" class="form-control" id="inputAddress2" placeholder="Address" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label" for="inputAddress2"><span class="req" title="Required">*</span>City</label> 
						<input name="address2" type="text" class="form-control" id="inputAddress2" placeholder="City" required>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label class="control-label" for="inputAddress2"><span class="req" title="Required">*</span>State</label> 
						<input name="address2" type="text" class="form-control" id="inputAddress2" placeholder="State" required>
					</div>
				</div>
				<div class="col-sm-3">
					<div class="form-group">
						<label class="control-label" for="inputAddress2"><span class="req" title="Required">*</span>Zip Code</label> 
						<input name="address2" type="text" class="form-control" id="inputAddress2" placeholder="Zip Code" required>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-sm-6">
					<div class="form-group">
						<label class="control-label" for="inputAddress2"><span class="req" title="Required">*</span>Country</label> 
						<input name="address2" type="text" class="form-control" id="inputAddress2" placeholder="Country" required>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-sm-4">
					<div class="form-group">
						<label class="control-label" for="inputAddress2"><span class="req" title="Required">*</span>Primary Phone</label> 
						<input name="address2" type="text" class="form-control" id="inputAddress2" placeholder="Phone" required>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label" for="inputAddress2"><span class="req" title="Required">*</span>Extn</label> 
						<input name="address2" type="text" class="form-control" id="inputAddress2" placeholder="Extn" required>
					</div>
				</div>
				<div class="col-sm-4">
					<div class="form-group">
						<label class="control-label" for="inputAddress2">Secondary Phone</label> 
						<input name="address2" type="text" class="form-control" id="inputAddress2" placeholder="Phone" required>
					</div>
				</div>
				<div class="col-sm-2">
					<div class="form-group">
						<label class="control-label" for="inputAddress2">Extn</label> 
						<input name="address2" type="text" class="form-control" id="inputAddress2" placeholder="Extn" required>
					</div>
				</div>
			</div>
			<hr>
			<div class="row">
				<div class="col-sm-12">
					<div class="text-right">
						<button type="button" name="go" class="btn btn-default" id="btnCancel">Cancel</button>
						<button type="submit" name="go" class="btn btn-primary" id="btnRegister">Register</button>
					</div>
				</div>
			</div>
		</form:form>
	</div> <%-- /container --%>
	<jsp:include page="jspf/footer-include.jsp" />
</body>
</html>