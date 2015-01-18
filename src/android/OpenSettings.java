package nl.tapme.cordova;

import android.util.Log;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

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
	private CallbackContext bluetoothChangeCallbackContext = null;
	private BroadcastReceiver BroadcastReceiver;

	@Override
	public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
		Log.v(TAG, "OpenSettings: initialization");
		super.initialize(cordova, webView);
		_adapter = BluetoothAdapter.getDefaultAdapter();
	}

	/**
	 * The final call you receive before your activity is destroyed.
	 */
	@Override
	public void onDestroy() {
		if (BroadcastReceiver != null) {
			cordova.getActivity().unregisterReceiver(BroadcastReceiver);
			BroadcastReceiver = null;
		}
		super.onDestroy();
	}

	public boolean execute(String action, CordovaArgs args, final CallbackContext callbackContext) throws JSONException {

		Log.v(TAG, "OpenSettings: Action:" + action );

		if( action.equals( "bluetoothStatus" ) ) {
			Log.v(TAG, "OpenSettings: bluetoothStatus");
			JSONObject data = new JSONObject();
			data.put("status", getStateDescription(_adapter.getState()) );
			callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, data));
			return true;
		}

		if( action.equals( "bluetooth" ) ) {
			Log.v(TAG, "OpenSettings: bluetooth");

			boolean isEnabled = _adapter.isEnabled();
			if (!isEnabled) {
				_adapter.enable();
			} else {
				_adapter.disable();
			}
			//BluetoothAdapter.enable();
			callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK));
			return true;
		}

		if( action.equals( "bluetoothChange" ) ) {
			IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
			if(bluetoothChangeCallbackContext == null){
				bluetoothChangeCallbackContext = callbackContext;
			}
			if(BroadcastReceiver == null) {
				BroadcastReceiver = new BroadcastReceiver() {
					@Override
					public void onReceive(Context context, Intent intent) {
						final int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE,BluetoothAdapter.ERROR);

						Log.v(TAG, "OpenSettings: bluetoothChange " + getStateDescription(state));
						//data = new JSONObject();
						//data.put("status", getStateDescription(state) );

						PluginResult result = new PluginResult(PluginResult.Status.OK,getStateDescription(state));
						result.setKeepCallback(true);
						bluetoothChangeCallbackContext.sendPluginResult(result);
					}
				};
				webView.getContext().registerReceiver(BroadcastReceiver, filter);
			}

			// Don't return any result now, since status results will be sent when events come in from broadcast receiver
			// http://stackoverflow.com/questions/7751522/android-phonegap-notify-javascript-when-an-asynctask-is-finished
			PluginResult pluginResult = new PluginResult(PluginResult.Status.NO_RESULT);
			pluginResult.setKeepCallback(true);
			callbackContext.sendPluginResult(pluginResult);
			return true;
		}

		return false;
	}

	private String getStateDescription(int state) {
		switch (state) {
			case BluetoothAdapter.ERROR:
				return "ERROR";
			case BluetoothAdapter.STATE_OFF:
				return "STATE_OFF";
			case BluetoothAdapter.STATE_TURNING_OFF:
				return "STATE_TURNING_OFF";
			case BluetoothAdapter.STATE_ON:
				return "STATE_ON";
			case BluetoothAdapter.STATE_TURNING_ON:
				return "STATE_TURNING_ON";
		}
		return "ERROR"+state;
	}

}
