package personal.gzy.util;

import java.util.UUID;

public class IdUtil {
    public static String createId(){return UUID.randomUUID().toString().split("-")[0];}
}
