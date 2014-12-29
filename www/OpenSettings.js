module.exports = OpenSettings = {};

OpenSettings.settings = function(app, callback) {
	cordova.exec(
		// Success callback
		callback,
		// Failure callback
		function(err) { console.log('Missing app scheme.');},
		// Native Class Name
		"OpenSettings",
		// Name of method in native class.
		"settings",
		// array of args to pass to method.
		[app]
	);
};

OpenSettings.bluetooth = function (app, callback) {
	cordova.exec(
		// Success callback
		callback,
		// Failure callback
		function(err) { console.log('Missing app scheme.');},
		// Native Class Name
		"OpenSettings",
		// Name of method in native class.
		"bluetooth",
		// array of args to pass to method.
		[app]
	);
};

return OpenSettings;
