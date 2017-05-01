/**
 * Application related javascript code
 */

/*!
 * IE10 viewport hack for Surface/desktop Windows 8 bug
 * Copyright 2014-2015 Twitter, Inc.
 * Licensed under MIT (https://github.com/twbs/bootstrap/blob/master/LICENSE)
 */

// See the Getting Started docs for more information:
// http://getbootstrap.com/getting-started/#support-ie10-width
(function() {
	"use strict";
	if (navigator.userAgent.match(/IEMobile\/10\.0/)) {
		var msViewportStyle = document.createElement("style");
		msViewportStyle.appendChild(document.createTextNode("@-ms-viewport{width:auto!important}"));
		document.querySelector("head").appendChild(msViewportStyle);
	}
})();

jQuery.validator.setDefaults({
	errorClass : "help-block",
	highlight(element, errorClass) {
		$("#" + element.id ).closest("div").addClass("has-error");
	},
	unhighlight(element, errorClass) {
		$("#" + element.id ).closest("div").removeClass("has-error");
	}
});

/**
 * Login page
 */
$("#formLogin").validate({
	rules: {
		username: {
			required: true,
			email: true
		},
		password: {
			required: true,
			minlength: 8
		}
	},
	messages: {
		username: {
			required: "Email address is required",
			email: "Not a valid Email"
		},
		password: {
			required: "Password is required",
			minlength: "Password need to be more than 8 character"
		}
	}
});

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
});

// Validate if the user id is already exits
$("#inputEmail").focusout(function() {
	$.ajax({
		type: "POST",
		url: registrationCheckEmailExistsUrl,
		data: JSON.stringify({ email: $("#inputEmail").val() }),
		contentType: "application/json",
		dataType: "json",
		success(data) { 
			alert("data: " + data.exists);
			if (data.exists === "Y") {
				$("#inputEmail").closest("div").addClass("has-error");
			}
		}
	});
});

/**
 * Welcome page logout
 */
$(function() {
	$("#linkLogout").on("click", function(e){
		e.preventDefault();
		$("#formLogout").submit();
	});
});

/**
 * Registration Page
 */
$("#formRegister").validate({
	rules: {
		firstName: "required",
		lastName: "required",
		email: {
			required: true,
			email: true
		},
		password: {
			required: true,
			minlength: 8
		},
		confirmPassword: {
			required: true,
			minlength: 8,
			equalTo: "#inputPassword"
		},
		address1: "required",
		city: "required",
		state: "required",
		zip: "required",
		country: "required",
		phone1: "required"
	},
	messages: {
		firstName: "First Name is required",
		lastName: "Last Name is required",
		email: {
			required: "Email is required",
			email: "Email is not valid"
		},
		password: {
			required: "Password is required",
			minlength: "Password need to be more than 8 character"
		},
		confirmPassword: {
			required: "Confirm Password is required",
			minlength: "Confirm Password need to be more than 8 character",
			equalTo: "Confirm Password need to match password"
		},
		address1: "Address line 1 is required",
		city: "City is required",
		state: "State is required",
		zip: "Zip is required",
		country: "Country is required",
		phone1: "Primary Phone is required"
	}
});