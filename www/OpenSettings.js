module.exports = OpenSettings = {};

OpenSettings.settings = function(app, callback) {
	cordova.exec(
		// Success callback
		callback,
		// Failure callback
		function(err) { console.log('OpenSettins.settings error'); },
		// Native Class Name
		"OpenSettings",
		// Name of method in native class.
		"settings",
		// array of args to pass to method.
		[]
	);
};

return OpenSettings;
