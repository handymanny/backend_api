package Security;

import java.util.Date;

public class JwtToken {

    private String token;
    private Date expire;

    public JwtToken(String token, Date expire) {
        this.token = token;
        this.expire = expire;
    }

    public JwtToken(){}

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }
}
