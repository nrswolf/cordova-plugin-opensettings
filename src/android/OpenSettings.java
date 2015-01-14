package nl.tapme.cordova.opensettings;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import org.apache.cordova.*;
import org.apache.cordova.api.*;  // for Cordova 2.9
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OpenSettings extends CordovaPlugin {

	private Context context;

	@Override
	public void initialize( CordovaInterface cordova, CordovaWebView webView ) {
		super.initialize( cordova, webView );

		this.context = cordova.getActivity().getApplicationContext();
	}

	public boolean execute( String action, JSONArray data, CallbackContext callbackContext ) throws JSONException {

		if( action.equals( "bluetoothStatus" ) ) {
			callbackContext.success('hi from android');
			return true;
		}

		return false;

	}

}