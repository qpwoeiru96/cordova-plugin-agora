package la.sou.plugin.agora;
import android.content.Context;
import io.agora.rtc.RtcEngine;

public class AgoraClient {

    private String _appId;

    private MessageHandler _messageHandler;

    private Context _applicationContext;

    private RtcEngine _rtcEngine;

    private AgoraClient(String appId, Context applicationContext) {
        _appId = appId;
        _messageHandler = new MessageHandler();
        _applicationContext = applicationContext;

        _rtcEngine = RtcEngine.create(_applicationContext, _appId, _messageHandler);
    }

    public MessageHandler getMessageHandler() {
        return _messageHandler;
    }

    public Context getApplicationContext() {
        return _applicationContext;
    }

    public String getAppId() {
        return _appId;
    }

    public RtcEngine getRtcEngine()
    {
        return _rtcEngine;
    }

    protected static AgoraClient instance = null;

    public static AgoraClient Create(String appId, Context applicationContext) {
        instance = new AgoraClient(appId, applicationContext);
        return instance;
    }

    public static AgoraClient getInstance() {
        //if(instance == null)
        //    throw new Exception("please call Create() first。");

        return instance;
    }
}