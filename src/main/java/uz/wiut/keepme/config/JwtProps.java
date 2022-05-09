package uz.wiut.keepme.config;

public class JwtProps {

    private Long expireTime = 3600l;
    private Long expireTimeRefresh = 7200l;
    private String secret = "f1e5183f31ab5df628bc58d9d007305e";

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    public Long getExpireTimeRefresh() {
        return expireTimeRefresh;
    }

    public void setExpireTimeRefresh(Long expireTimeRefresh) {
        this.expireTimeRefresh = expireTimeRefresh;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

}
