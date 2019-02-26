package personal.gzy.util;

import io.netty.channel.Channel;
import personal.gzy.attribute.Attributes;
import personal.gzy.session.Session;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName SessionUtil
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/26 16:18
 * @Version
 **/
public class SessionUtil {
    private static Map<String, Channel> userIdChannelMap = new ConcurrentHashMap<>();


    public static boolean hasLogin(Channel channel) {
        return channel.hasAttr(Attributes.SESSION);
    }

    public static void bindSession(Session session, Channel channel) {
        userIdChannelMap.put(session.getUserId(), channel);
        channel.attr(Attributes.SESSION).set(session);
    }

    public static Session getSession(Channel channel) {
        return channel.attr(Attributes.SESSION).get();
    }

    public static Channel getChannel(String toUserId) {
        return userIdChannelMap.get(toUserId);
    }

    public static void unBindSession(Channel channel) {
        if(hasLogin(channel)){
           userIdChannelMap.remove(getSession(channel).getUserId());
           channel.attr(Attributes.SESSION).set(null);
        }
    }
}
