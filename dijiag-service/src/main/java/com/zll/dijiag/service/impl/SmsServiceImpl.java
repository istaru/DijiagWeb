package com.zll.dijiag.service.impl;

import com.baomidou.mybatisplus.mapper.Condition;
import com.zll.dijiag.model.Sms;
import com.zll.dijiag.dao.SmsMapper;
import com.zll.dijiag.service.ISmsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zll.dijiag.util.BaseTools;
import com.zll.dijiag.util.cipher.Crypto;
import com.zll.dijiag.util.response.CipherResponse;
import com.zll.dijiag.util.response.Response;
import com.zll.dijiag.util.response.ResponseCode;
import com.zll.dijiag.util.sms.SmsUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Moon
 * @since 2018-03-01
 */
@Service
public class SmsServiceImpl extends ServiceImpl<SmsMapper, Sms> implements ISmsService {

    @Autowired
    SmsMapper smsMapper;

    @Value("${zhuce_url}")
    private String zhuceUrl;

    @Value("${zhuce_tpl_id}")
    private String zhuceTplId;

    @Value("${zhuce_tpl_value}")
    private String zhuceTplValue;

    @Override
    public CipherResponse send(Map<String, Object> map) {
        Response response = new Response();
        try {
            //用户手机号码
            String phone = map.get("phone") == null ? "" : map.get("phone").toString();
            //短信类型(1:注册验证码)
            String type = map.get("type") == null ? "" : map.get("type").toString();
            if(!StringUtils.isEmpty(phone)){
                if(!StringUtils.isEmpty(type) && "1".equals(type)){
                   int count = smsMapper.selectCount(
                            Condition.create()
                                    .eq("phone",phone)
                                    .eq("type",type)
                                    .le("TIMESTAMPDIFF(SECOND,create_time,NOW())", 300)
                    );
                    if(count == 0){
                        Sms sms = new Sms();
                        sms.setId(BaseTools.getUUID());
                        sms.setPhone(phone);
                        sms.setType(type);
                        sms.setCode(RandomStringUtils.randomNumeric(4));
                        if(smsMapper.insert(sms) > 0){
                            //发送短信
                            if (SmsUtil.send(map.get("sms_appkey").toString(), map.get("zhuce_url").toString(), map.get("zhuce_tpl_id").toString(), map.get("zhuce_tpl_value").toString(), type, phone, sms.getCode(), 5) ) {
                                response.setCode(ResponseCode.CODE_SUCCESS);
                            } else {
                                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                            }
                        }
                    } else {
                        response.setMsg("发送过于频繁，请稍后再试");
                    }
                } else {
                    response.setMsg("恶意请求");
                }
            } else {
                response.setMsg("请输入手机号码");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Crypto.encodeJson(response);
    }
}
