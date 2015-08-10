OpenSettings
======
Fork of original repo to remove Bluetooth dependencies.

## Installation

```
cordova plugin add https://github.com/nrswolf/cordova-plugin-opensettings
```

## Usage

```javascript
if(device.platform === 'iOS' && device.version > 8) {
	OpenSettings.settings();
}
```

