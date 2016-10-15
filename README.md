```
Method:
		addEventListener: function(eventName, callback) {},
        removeEventListener: function(eventName, callback) {},
        create: function (config, successCallback, failCallback) {},
        joinChannel: function (channelKey, channelName, uid, successCallback, failCallback) {},
        leaveChannel: function (successCallback, failCallback) {},
        enableVideo: function(successCallback, failCallback) {},
        disableVideo: function(successCallback, failCallback) {},
        enableSpeakerphone: function(successCallback, failCallback) {},
        disableSpeakerphone: function(successCallback, failCallback) {},
        getCallId: function(successCallback, failCallback) {}
```

```
Event: @see: android document
	加入频道回调 (onJoinChannelSuccess)
	重新加入频道回调 (onRejoinChannelSuccess) 
	发生警告回调(onWarning)
	发生错误回调 (onError)
	离开频道回调 (onLeaveChannel) 
	声音质量回调 (onAudioQuality) 
	说话声音音量提示回调  (onAudioVolumeIndication) 
	其他用户加入当前频道回调 (onUserJoined) 
	其他用户离开当前频道回调 (onUserOffline)
	用户静音回调 (onUserMuteAudio) 
	Rtc Engine 统计数据回调 (onRtcStats)
	网络质量报告回调 (onLastmileQuality)
	连接中断回调 (onConnectionInterrupted)
	连接丢失回调  (onConnectionLost)
	本地视频显示回调 (onFirstLocalVideoFrame) 
	远端视频显示回调 (onFirstRemoteVideoFrame)
	远端视频接收解码回调 (onFirstRemoteVideoDecoded)
	其他用户停止/重启视频回调 (onUserMuteVideo)
	其他用户启用/关闭视频 (onUserEnableVideo)
	本地视频统计回调 (onLocalVideoStat)
	远端视频统计回调 (onRemoteVideoStat)
	摄像头启用回调 (onCameraReady)
	视频功能停止回调(onVideoStopped)
	更新录制服务状态回调 (onRefreshRecordingServiceStatus)
	录制开始/停止/状态查询回调(onApiCallExecuted)
	接收到对方数据流消息的回调(onStreamMessage) 
	接收对方数据流消息错误的回调(onStreamMessageError)
```

```
	sample:
		agora.create({appId: "appId"}, function() {
            agora.joinChannel('channelKey', 'test', null, function() {
                agora.enableSpeakerphone(function() {}, function(error) {
                    console.error(error.code +":" + error.message);
                });
        
                agora.getCallId(function(id) {
                    console.log("Call Id:" + id);
                });
        
        
                setTimeout(function() {
                    agora.leaveChannel();
                }, 10000);
        
            }, function(error) {
                console.log(error);
                console.error(error.code +":" + error.message);
            });
        }, function(error) {
            console.error(error.code +":" + error.message);
        });
		
		agora.addEventListener("onJoinChannelSuccess", function(data) {
			//...
		});
```