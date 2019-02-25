package personal.gzy.util;

import io.netty.channel.Channel;
import io.netty.util.Attribute;
import personal.gzy.attribute.Attributes;

/**
 * @ClassName LoginUtil
 * @Description TODO   客户端登陆验证工具类
 * @Author GZY
 * @Date 2019/2/25 14:16
 * @Version
 **/
public class LoginUtil {
    public static void makeAsLogin(Channel channel){
        channel.attr(Attributes.LOGIN).set(true);
    }
    public static boolean hasLogin(Channel channel){
        Attribute<Boolean> login = channel.attr(Attributes.LOGIN);
        return login.get() != null;
    }
}
