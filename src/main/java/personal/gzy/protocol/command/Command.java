package personal.gzy.protocol.command;

/**
 * 命令标示
 *
 */
public interface Command {
    //客户端登陆命令
    Byte LOGIN_REQUEST = 1;
    //服务端响应命令
    Byte LOGIN_RESPONSE = 2;
    //客户端信息
    Byte MESSAGE_REQUEST = 3;
    //服务端信息
    Byte MESSAGE_RESPONSE = 4;
    //登出标识
    Byte LOGINOUT_REQEUST = 5;
    Byte LOGINOUT_RESPONSE = 6;
    //创建请求群聊组标识
    Byte CREATEGROUP_REQUEST = 7;
    //创建响应群聊组标识
    Byte CREATEGROUP_RESPONSE = 8;
    //加群
    Byte ADD_GROUP_REQUEST = 9;
    Byte ADD_GROUP_RESPONSE = 10;
    //退群
    Byte QUIT_GROUP_REQUEST = 11;
    Byte QUIT_GROUP_RESPONSE = 12;
}
