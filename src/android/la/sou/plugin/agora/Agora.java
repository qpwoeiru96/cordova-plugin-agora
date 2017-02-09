package la.sou.plugin.agora;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.SurfaceView;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import io.agora.rtc.*;
import io.agora.rtc.video.VideoCanvas;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

public class Agora extends CordovaPlugin {

    public static final String TAG = "CDVAgora";

    protected Activity appActivity;

    protected Context appContext;

    private static CallbackContext eventCallbackContext;

    @Override
    protected void pluginInitialize() {

        appContext = this.cordova.getActivity().getApplicationContext();
        appActivity = cordova.getActivity();
        super.pluginInitialize();
    }

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {

        Log.d(TAG, action + " Called");

        if (action.equals("prepare")) {
            return true;
        }

        if (action.equals("create")) {
            try {
                JSONObject config = args.getJSONObject(0);
                if(!config.has("appId")) {
                    callbackContext.error(ClientError.Build(ClientError.ERR_PARAMETER_ERROR, "配置项中需要 appId。"));
                } else {

                    final String appId = config.getString("appId");
                    final Context context = this.cordova.getActivity().getApplicationContext();
                    appActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            AgoraClient.Create(appId, context);
                            //禁止视频
                            AgoraClient.getInstance().getRtcEngine().disableVideo();
                            callbackContext.success();
                        }
                    });
                }
            } catch (Exception e) {
                callbackContext.error(ClientError.Build(ClientError.ERR_PARAMETER_ERROR, "第一个参数必须是对象。"));

            }
            return true;
        }

        if (action.equals("joinChannel")) {
            final String channelKey = args.getString(0);
            final String channelName = args.getString(1);
            final int uid = args.getInt(2);
            appActivity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    AgoraClient.getInstance().getRtcEngine()
                            .joinChannel(channelKey, channelName, null, uid);

                    callbackContext.success();
                }
            });
            return true;
        }

        if (action.equals("leaveChannel")) {
            int result =  AgoraClient.getInstance().getRtcEngine().leaveChannel();

            if(AgoraError.ERR_OK != result) {
                callbackContext.error(ClientError.Build(result, "exec leaveChannel failed!"));
            } else {
                callbackContext.success();
            }

            return true;
        }

        if (action.equals("disableVideo")) {
            int result =  AgoraClient.getInstance().getRtcEngine().disableVideo();

            if(AgoraError.ERR_OK != result) {
                callbackContext.error(ClientError.Build(result, "exec disableVideo failed!"));
            } else {
                callbackContext.success();
            }

            return true;
        }

        if (action.equals("enableVideo")) {
            int result =  AgoraClient.getInstance().getRtcEngine().enableVideo();

            if(AgoraError.ERR_OK != result) {
                callbackContext.error(ClientError.Build(result, "exec enableVideo failed!"));
            } else {
                callbackContext.success();
            }
            return true;
        }



        if (action.equals("enableSpeakerphone")) {
            int result =  AgoraClient.getInstance().getRtcEngine().setEnableSpeakerphone(true);

            if(AgoraError.ERR_OK != result) {
                callbackContext.error(ClientError.Build(result, "exec setEnableSpeakerphone failed!"));
            } else {
                callbackContext.success();
            }
            return true;
        }

        if(action.equals("disableSpeakerphone")) {

            int result =  AgoraClient.getInstance().getRtcEngine().setEnableSpeakerphone(false);

            if(AgoraError.ERR_OK != result) {
                callbackContext.error(ClientError.Build(result, "exec setEnableSpeakerphone failed!"));
            } else {
                callbackContext.success();
            }
            return true;
        }

        if(action.equals("getCallId")) {
            String result =  AgoraClient.getInstance().getRtcEngine().getCallId();
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, result);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        }

        //public abstract int startRecordingService(String key)
        if(action.equals("startRecordingService")) {
            final String recordingKey = args.getString(0);
            String result =  AgoraClient.getInstance().getRtcEngine().startRecordingService(recordingKey);
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, result);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        }

        //public int stopRecordingService(String key)
        if(action.equals("stopRecordingService")) {
            final String recordingKey = args.getString(0);
            String result =  AgoraClient.getInstance().getRtcEngine().stopRecordingService(recordingKey);
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, result);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        }

        if (action.equals("listenEvents")) {
            eventCallbackContext = callbackContext;
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK, 0);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        }

        return super.execute(action, args, callbackContext);
    }

    public static void notifyEvent(String event, JSONObject data) {

        JSONObject json = new JSONObject();

        try {
            json.put("event", event);
            json.put("data", data);
        } catch (JSONException ignored) {

        }

        if (eventCallbackContext != null) {
            PluginResult result = new PluginResult(PluginResult.Status.OK, json);
            result.setKeepCallback(true);
            eventCallbackContext.sendPluginResult(result);
        }
    }
}
