package personal.gzy.session;

import lombok.Data;

/**
 * @ClassName Session
 * @Description TODO
 * @Author GZY
 * @Date 2019/2/26 16:07
 * @Version
 **/
@Data
public class Session {
    private String userId;
    private String userName;

    public Session(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Session{" +
                "userId='" + userId +
                '}';
    }
}
