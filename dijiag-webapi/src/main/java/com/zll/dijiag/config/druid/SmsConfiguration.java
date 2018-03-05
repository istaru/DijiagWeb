package com.zll.dijiag.config.druid;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/properties/sms.properties")
@ConfigurationProperties
public class SmsConfiguration {

    private String zhuce_url;
    private String zhuce_tpl_id;
    private String zhuce_tpl_value;
    private String sms_appkey;

    public String getSms_appkey() {
        return sms_appkey;
    }

    public void setSms_appkey(String sms_appkey) {
        this.sms_appkey = sms_appkey;
    }

    public String getZhuce_url() {
        return zhuce_url;
    }

    public void setZhuce_url(String zhuce_url) {
        this.zhuce_url = zhuce_url;
    }

    public String getZhuce_tpl_id() {
        return zhuce_tpl_id;
    }

    public void setZhuce_tpl_id(String zhuce_tpl_id) {
        this.zhuce_tpl_id = zhuce_tpl_id;
    }

    public String getZhuce_tpl_value() {
        return zhuce_tpl_value;
    }

    public void setZhuce_tpl_value(String zhuce_tpl_value) {
        this.zhuce_tpl_value = zhuce_tpl_value;
    }


}
