package nl.tapme.cordova.opensettings;

import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaArgs;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;

import org.json.JSONException;
import org.json.JSONArray;
import org.json.JSONObject;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.bluetooth.BluetoothAdapter;

public class OpenSettings extends CordovaPlugin {

    private static final String TAG = "OpenSettings";
	private BluetoothAdapter _adapter;

	@Override
    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        Log.v(TAG, "OpenSettings: initialization");
        super.initialize(cordova, webView);
		_adapter = BluetoothAdapter.getDefaultAdapter();
    }

    public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {

		if( action.equals( "bluetoothStatus" ) ) {
			Log.v(TAG, "OpenSettings: bluetoothStatus");
			callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, _adapter.getState()));
			return true;
		}

		return false;
	}

}