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
	'use strict';

	if (navigator.userAgent.match(/IEMobile\/10\.0/)) {
		var msViewportStyle = document.createElement('style')
		msViewportStyle.appendChild(document.createTextNode('@-ms-viewport{width:auto!important}'))
		document.querySelector('head').appendChild(msViewportStyle)
	}

})();

/**
 * Login page
 */
// login form Validation
$('#formLogin').validate({
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
		username: 'Email address is required',
		password: {
			required: 'Password is required',
			minlength: 'Password need to be more than 8 char'
		}
	},
	errorClass : 'help-block',
	highlight: function(element, errorClass) {
		$('#' + element.id ).closest('div').addClass('has-error');
	},
	unhighlight : function(element, errorClass) {
		$('#' + element.id ).closest('div').removeClass('has-error');
	}
});

/**
 * Welcome page logout
 */
$(function() {
	$('#linkLogout').on('click', function(e){
		e.preventDefault();
		$('#formLogout').submit();
	});
});

/**
 * Registration Page
 */
$('#formRegister').validation({
	rules: {
		
	},
	messages: {
		
	},
	errorClass : 'help-block',
	highlight: function(element, errorClass) {
		$('#' + element.id ).closest('div').addClass('has-error');
	},
	unhighlight : function(element, errorClass) {
		$('#' + element.id ).closest('div').removeClass('has-error');
	}
});