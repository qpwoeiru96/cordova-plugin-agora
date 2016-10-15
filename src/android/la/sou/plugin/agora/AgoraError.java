package la.sou.plugin.agora;

public final class AgoraError {

        public static final int
                ERR_OK = 0, //正常情况的返回值，意味着没有错误。
                ERR_FAILED = 1, //一般性的错误(没有明确归类的错误原因)。
                ERR_INVALID_ARGUMENT = 2, //API 调用了无效的参数。例如指定的频道名含有非法字符。
                ERR_NOT_READY = 3, //SDK 的模块没有准备好，例如某个 API 调用依赖于某个模块，但是那个模块还没有准备好服务。
                ERR_NOT_SUPPORTED = 4, //SDK 不支持该功能。
                ERR_REFUSED = 5, //调用被拒绝。仅供 SDK 内部使用，不通过API 或者回调事件返回给应用程序。
                ERR_BUFFER_TOO_SMALL = 6, //传入的缓冲区大小不足以存放返回的数据。
                ERR_NOT_INITIALIZED = 7, //SDK 没有初始化就调用其 API。
                ERR_INVALID_VIEW = 8, //指定的 view 无效，使用视频功能时需要指定 view，如果没有会返回该错误。
                ERR_NO_PERMISSION = 9, //没有操作权限。仅供 SDK 内部使用，不通过API 或者回调事件返回给应用程序。
                ERR_TIMEDOUT = 10, //API 调用超时。有一些 API 调用需要 SDK 返回结果，如果 SDK 处理时间过长，会出现此错误。
                ERR_CANCELED = 11, //请求被取消。仅供 SDK 内部使用，不通过API 或者回调事件返回给应用程序。
                ERR_TOO_OFTEN = 12, //调用频率太高。仅供 SDK 内部使用，不通过API 或者回调事件返回给应用程序。
                ERR_BIND_SOCKET = 13, //SDK 内部绑定到网络 socket 失败。仅供 SDK内部使用，不通过 API 或者回调事件返回给应用程序。
                ERR_NET_DOWN = 14, //网络不可用。仅供 SDK 内部使用，不通过API 或者回调事件返回给应用程序。
                ERR_NET_NOBUFS = 15, //没有网络缓冲区可用。仅供 SDK 内部使用，不通过 API 或者回调事件返回给应用程序。
                ERR_INIT_VIDEO = 16, //初始化视频功能失败。
                ERR_JOIN_CHANNEL_REJECTED = 17, //加入频道被拒绝。这个错误一般是因为已经在频道中了，又调用加入频道的 API，例如 joinChannel。
                ERR_LEAVE_CHANNEL_REJECTED = 18, //离开频道失败。这个错误一般是因为不在频道中，又调用退出频道的 API，例如 leaveChannel。
                ERR_ALREADY_IN_USE = 19, //资源已被占用，不能重复使用
                ERR_ABANDON_REQUEST = 20, //SDK 放弃请求，可能由于请求次数太多。仅供SDK 内部使用，不通过 API 或者回调事件返回给应用程序。
                ERR_INVALID_VENDOR_KEY = 101, //指定的 App ID 无效。
                ERR_INVALID_CHANNEL_NAME = 102, //指定的频道名无效。
                ERR_CHANNEL_KEY_EXPIRED = 109, //当前使用的 Channel Key 过期，不再有效。
                ERR_INVALID_CHANNEL_KEY = 110, //指定的 Channel Key 无效。一般是因为 key 生成的不对。
                ERR_NOT_IN_CHANNEL = 113, //用户不在频道内。
                ERR_SIZE_TOO_LARGE = 114, //数据太大
                ERR_BITRATE_LIMIT = 115, //码率受限
                ERR_TOO_MANY_DATA_STREAMS = 116, //数据流/通道过多
                ERR_STREAM_MESSAGE_TIMEOUT = 117, //数据流发送超时
                ERR_LOAD_MEDIA_ENGINE = 1001, //加载媒体引擎失败。
                ERR_START_CALL = 1002, //启动媒体引擎开始通话失败。
                ERR_START_CAMERA = 1003, //启动摄像头失败。
                ERR_START_VIDEO_RENDER = 1004, //启动视频渲染模块失败。
                ERR_ADM_GENERAL_ERROR = 1005, //音频设备模块出现一般性错误（没有明显归类的错误）。
                ERR_ADM_JAVA_RESOURCE = 1006, //音频设备模块：使用 java 资源出现错误。
                ERR_ADM_SAMPLE_RATE = 1007, //音频设备模块：设置的采样频率出现错误。
                ERR_ADM_INIT_PLAYOUT = 1008, //音频设备模块：初始化播放设备出现错误。
                ERR_ADM_START_PLAYOUT = 1009, //音频设备模块：启动播放设备出现错误。
                ERR_ADM_STOP_PLAYOUT = 1010, //音频设备模块：停止播放设备出现错误。
                ERR_ADM_INIT_RECORDING = 1011, //音频设备模块：初始化录音设备时出现错误。
                ERR_ADM_START_RECORDING = 1012, //音频设备模块：启动录音设备出现错误。
                ERR_ADM_STOP_RECORDING = 1013, //音频设备模块：停止录音设备出现错误。
                ERR_ADM_RUNTIME_PLAYOUT_ERROR = 1015, //音频设备模块:运行时播放出现错误。
                ERR_ADM_RUNTIME_RECORDING_ERROR = 1017, //音频设备模块:运行时录音错误。
                ERR_ADM_RECORD_AUDIO_FAILED = 1018, //音频设备模块:录音失败。
                ERR_ADM_INIT_LOOPBACK = 1022, //音频设备模块:初始化 loopback 设备错误。
                ERR_ADM_START_LOOPBACK = 1023, //音频设备模块:启动 loopback 设备错误。
                ERR_VDM_CAMERA_NOT_AUTHORIZED = 1501; //视频设备模块:摄像头没有使用权限。

}
