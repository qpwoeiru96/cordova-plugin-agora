package la.sou.plugin.agora;

import org.json.JSONException;
import org.json.JSONObject;

public final class ClientError {
    public static final int
            ERR_OK = 0, //正常情况的返回值，意味着没有错误。
            ERR_PARAMETER_ERROR = 6601;

    public static JSONObject Build(int error, String message) throws JSONException {

        JSONObject obj = new JSONObject();
        obj.put("code", error);
        obj.put("message", message);
        return obj;
    }
}
