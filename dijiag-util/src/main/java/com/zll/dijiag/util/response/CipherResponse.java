package com.zll.dijiag.util.response;

public class CipherResponse {
    //加密的key
    private long secret;

    //加密的内容
    private String content;

    public CipherResponse() {
    }

    public CipherResponse(long secret, String content) {
        this.secret = secret;
        this.content = content;
    }

    public long getSecret() {
        return secret;
    }

    public void setSecret(long secret) {
        this.secret = secret;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
