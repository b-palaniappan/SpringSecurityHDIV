/**
 * Application related javascript code
 */

/**
 * Login Page JS code
 */

jQuery(document).ready(function() {
	'use strict';
	var options = {};
	options.ui = {
		container : '#pwd-container',
		showVerdictsInsideProgressBar : true,
		viewports : {
			progress : ".pwstrength_viewport_progress"
		}
	};
	$(':password').pwstrength(options);
});