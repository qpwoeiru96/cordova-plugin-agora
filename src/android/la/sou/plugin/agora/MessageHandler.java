package la.sou.plugin.agora;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

import io.agora.rtc.IRtcEngineEventHandler;

public class MessageHandler extends IRtcEngineEventHandler {

    private Class _class = this.getClass();

    public void onJoinChannelSuccess(String channel, int uid, int elapsed) {
        try {
            JSONObject data = new JSONObject();
            data.put("channel", channel);
            data.put("uid", uid);
            data.put("elapsed", elapsed);
            Agora.notifyEvent("onJoinChannelSuccess", data);
        } catch (JSONException ignored) {}
    }

    public void onRejoinChannelSuccess(String channel, int uid, int elapsed) {
        try {
            JSONObject data = new JSONObject();
            data.put("channel", channel);
            data.put("uid", uid);
            data.put("elapsed", elapsed);
            Agora.notifyEvent("onRejoinChannelSuccess", data);
        } catch (JSONException ignored) {}
    }

    public void onWarning(int warn) {
        try {
            JSONObject data = new JSONObject();
            data.put("warn", warn);
            Agora.notifyEvent("onWarning", data);
        } catch (JSONException ignored) {}
    }

    public void onError(int err) {
        try {
            JSONObject data = new JSONObject();
            data.put("err", err);
            Agora.notifyEvent("onError", data);
        } catch (JSONException ignored) {}
    }

    public void onApiCallExecuted(String api, int error) {
        try {
            JSONObject data = new JSONObject();
            data.put("api", api);
            data.put("int", error);
            Agora.notifyEvent("onApiCallExecuted", data);
        } catch (JSONException ignored) {}
    }

    public void onCameraReady() {
        //try {
            JSONObject data = new JSONObject();
            Agora.notifyEvent("onCameraReady", data);
        //} catch (JSONException ignored) {}
    }

    public void onVideoStopped() {
        JSONObject data = new JSONObject();
        Agora.notifyEvent("onVideoStopped", data);
    }

    public void onAudioQuality(int uid, int quality, short delay, short lost) {
        try {
            JSONObject data = new JSONObject();
            data.put("uid", uid);
            data.put("quality", quality);
            data.put("delay", (int)delay);
            data.put("lost", (int)lost);
            Agora.notifyEvent("onAudioQuality", data);
        } catch (JSONException ignored) {}
    }

    public void onLeaveChannel(IRtcEngineEventHandler.RtcStats stats) {
        try {
            JSONObject data = new JSONObject();
            JSONObject temp = new JSONObject();
            temp.put("totalDuration", stats.totalDuration);
            temp.put("txBytes", stats.txBytes);
            temp.put("rxBytes", stats.rxBytes);
            temp.put("txKBitRate", stats.txKBitRate);
            temp.put("rxKBitRate", stats.rxKBitRate);
            temp.put("users", stats.users);
            temp.put("cpuTotalUsage", stats.cpuTotalUsage);
            temp.put("cpuAppUsage", stats.cpuAppUsage);
            data.put("stats", temp);
            Agora.notifyEvent("onLeaveChannel", data);
        } catch (JSONException ignored) {}
    }

    public void onRtcStats(IRtcEngineEventHandler.RtcStats stats) {
        try {
            JSONObject data = new JSONObject();
            JSONObject temp = new JSONObject();
            temp.put("totalDuration", stats.totalDuration);
            temp.put("txBytes", stats.txBytes);
            temp.put("rxBytes", stats.rxBytes);
            temp.put("txKBitRate", stats.txKBitRate);
            temp.put("rxKBitRate", stats.rxKBitRate);
            temp.put("users", stats.users);
            temp.put("cpuTotalUsage", stats.cpuTotalUsage);
            temp.put("cpuAppUsage", stats.cpuAppUsage);
            data.put("stats", temp);
            Agora.notifyEvent("onRtcStats", data);
        } catch (JSONException ignored) {}
    }

    public void onAudioVolumeIndication(IRtcEngineEventHandler.AudioVolumeInfo[] speakers, int totalVolume) {
        try {
            JSONObject data = new JSONObject();
            JSONArray temp = new JSONArray();
            for(AudioVolumeInfo speaker:speakers) {
                JSONObject tmp = new JSONObject();
                tmp.put("uid", speaker.uid);
                tmp.put("volume", speaker.volume);
                temp.put(tmp);
            }
            data.put("speakers", temp);
            data.put("totalVolume", totalVolume);
            Agora.notifyEvent("onAudioVolumeIndication", data);
        } catch (JSONException ignored) {}
    }

    public void onNetworkQuality(int uid, int txQuality, int rxQuality) {
        try {
            JSONObject data = new JSONObject();
            data.put("uid", uid);
            data.put("txQuality", txQuality);
            data.put("rxQuality", rxQuality);
            Agora.notifyEvent("onAudioQuality", data);
        } catch (JSONException ignored) {}
    }

    public void onLastmileQuality(int quality) {
        try {
            JSONObject data = new JSONObject();
            data.put("quality", quality);
            Agora.notifyEvent("onLastmileQuality", data);
        } catch (JSONException ignored) {}
    }

    public void onUserJoined(int uid, int elapsed) {
        try {
            JSONObject data = new JSONObject();
            data.put("uid", uid);
            data.put("elapsed", elapsed);
            Agora.notifyEvent("onUserJoined", data);
        } catch (JSONException ignored) {}
    }

    public void onUserOffline(int uid, int reason) {
        try {
            JSONObject data = new JSONObject();
            data.put("uid", uid);
            data.put("reason", reason);
            Agora.notifyEvent("onUserOffline", data);
        } catch (JSONException ignored) {}
    }

    public void onUserMuteAudio(int uid, boolean muted) {
        try {
            JSONObject data = new JSONObject();
            data.put("uid", uid);
            data.put("muted", muted);
            Agora.notifyEvent("onUserMuteAudio", data);
        } catch (JSONException ignored) {}
    }

    public void onUserMuteVideo(int uid, boolean muted) {
        try {
            JSONObject data = new JSONObject();
            data.put("uid", uid);
            data.put("muted", muted);
            Agora.notifyEvent("onUserMuteVideo", data);
        } catch (JSONException ignored) {}
    }

    public void onUserEnableVideo(int uid, boolean enabled) {
        try {
            JSONObject data = new JSONObject();
            data.put("uid", uid);
            data.put("enabled", enabled);
            Agora.notifyEvent("onUserEnableVideo", data);
        } catch (JSONException ignored) {}
    }

    /** @deprecated */
    @Deprecated
    public void onLocalVideoStat(int sentBitrate, int sentFrameRate) {
        try {
            JSONObject data = new JSONObject();
            data.put("sentBitrate", sentBitrate);
            data.put("sentFrameRate", sentFrameRate);
            Agora.notifyEvent("onLocalVideoStat", data);
        } catch (JSONException ignored) {}
    }

    /** @deprecated */
    @Deprecated
    public void onRemoteVideoStat(int uid, int delay, int receivedBitrate, int receivedFrameRate) {
        try {
            JSONObject data = new JSONObject();
            data.put("uid", uid);
            data.put("delay", delay);
            data.put("receivedBitrate", receivedBitrate);
            data.put("receivedFrameRate", receivedFrameRate);
            Agora.notifyEvent("onRemoteVideoStat", data);
        } catch (JSONException ignored) {}
    }

    public void onRemoteVideoStats(IRtcEngineEventHandler.RemoteVideoStats stats) {
        try {
            JSONObject data = new JSONObject();
            JSONObject temp = new JSONObject();

            temp.put("uid", stats.uid);
            temp.put("delay", stats.delay);
            temp.put("width", stats.width);
            temp.put("height", stats.height);
            temp.put("receivedBitrate", stats.receivedBitrate);
            temp.put("receivedFrameRate", stats.receivedFrameRate);
            data.put("stats", temp);
            Agora.notifyEvent("onRemoteVideoStats", data);
        } catch (JSONException ignored) {}
    }

    public void onLocalVideoStats(IRtcEngineEventHandler.LocalVideoStats stats) {
        try {
            JSONObject data = new JSONObject();
            JSONObject temp = new JSONObject();

            temp.put("sentBitrate", stats.sentBitrate);
            temp.put("sentFrameRate", stats.sentFrameRate);
            data.put("stats", temp);
            Agora.notifyEvent("onLocalVideoStats", data);
        } catch (JSONException ignored) {}
    }

    public void onFirstRemoteVideoFrame(int uid, int width, int height, int elapsed) {
        try {
            JSONObject data = new JSONObject();
            data.put("uid", uid);
            data.put("width", width);
            data.put("height", height);
            data.put("elapsed", elapsed);
            Agora.notifyEvent("onFirstRemoteVideoFrame", data);
        } catch (JSONException ignored) {}
    }

    public void onFirstLocalVideoFrame(int width, int height, int elapsed) {
        try {
            JSONObject data = new JSONObject();
            data.put("width", width);
            data.put("height", height);
            data.put("elapsed", elapsed);
            Agora.notifyEvent("onFirstLocalVideoFrame", data);
        } catch (JSONException ignored) {}
    }

    public void onFirstRemoteVideoDecoded(int uid, int width, int height, int elapsed) {
        try {
            JSONObject data = new JSONObject();
            data.put("uid", uid);
            data.put("width", width);
            data.put("height", height);
            data.put("elapsed", elapsed);
            Agora.notifyEvent("onFirstRemoteVideoDecoded", data);
        } catch (JSONException ignored) {}
    }

    public void onConnectionLost() {
        //try {
            JSONObject data = new JSONObject();
            Agora.notifyEvent("onConnectionLost", data);
        //} catch (JSONException ignored) {}
    }

    public void onConnectionInterrupted() {
        //try {
        JSONObject data = new JSONObject();
        Agora.notifyEvent("onConnectionInterrupted", data);
        //} catch (JSONException ignored) {}
    }

    public void onRefreshRecordingServiceStatus(int status) {
        try {
            JSONObject data = new JSONObject();
            data.put("status", status);
            Agora.notifyEvent("onRefreshRecordingServiceStatus", data);
        } catch (JSONException ignored) {}
    }

    public void onStreamMessage(int uid, int streamId, byte[] data) {
        try {
            JSONObject json = new JSONObject();
            json.put("uid", uid);
            json.put("streamId", streamId);
            json.put("data", data.toString());
            Agora.notifyEvent("onStreamMessage", json);
        } catch (JSONException ignored) {}
    }

    public void onStreamMessageError(int uid, int streamId, int error, int missed, int cached) {
        try {
            JSONObject data = new JSONObject();
            data.put("uid", uid);
            data.put("streamId", streamId);
            data.put("missed", missed);
            data.put("cached", cached);
            Agora.notifyEvent("onStreamMessageError", data);
        } catch (JSONException ignored) {}
    }
}
