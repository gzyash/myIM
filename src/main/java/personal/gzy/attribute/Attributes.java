package personal.gzy.attribute;

import io.netty.util.AttributeKey;
import personal.gzy.session.Session;

public interface Attributes {
    AttributeKey<Session> SESSION = AttributeKey.newInstance("session");
}
