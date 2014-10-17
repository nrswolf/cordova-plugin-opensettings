module.exports = function opensettings(app, callback) {
	cordova.exec(
		// Success callback
		callback,
		// Failure callback
		function(err) { console.log('Missing app scheme.');},
		// Native Class Name
		"OpenSettings",
		// Name of method in native class.
		"open",
		// array of args to pass to method.
		[app]
	);
};
