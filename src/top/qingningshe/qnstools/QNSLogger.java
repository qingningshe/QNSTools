package top.qingningshe.qnstools;

import android.util.Log;


public class QNSLogger {
	
	public static boolean OPEN=false;
	public static String TAG="QNS";
	
	public static void i(Object msg){
		if (OPEN) {
			Log.i(TAG, msg.toString());
		}
	}
	
	public static void e(Object msg){
		if (OPEN) {
			Log.e(TAG, msg.toString());
		}
	}

}
