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
}
