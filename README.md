OpenSettings
======
OpenSettings opens your apps settings in settings.app (makes it more easy for users to turn on Location Services).

## Installation

```
cordova plugin add https://github.com/erikhuisman/cordova-plugin-opensettings.git
```

## Usage

```
OpenSettings();

// Use cordova device plugin to check for iOs 8
// cordova plugin add org.cordova.plugin.device
if(device.platform === 'iOS' && device.version > 8) {
	OpenSettings();
}

```

