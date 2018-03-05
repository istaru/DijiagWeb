package com.zll.dijiag.controller;


import com.zll.dijiag.config.druid.SmsConfiguration;
import com.zll.dijiag.service.ISmsService;
import com.zll.dijiag.util.response.CipherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Moon
 * @since 2018-03-01
 */
@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    ISmsService smsService;

    @Autowired
    SmsConfiguration smsConfiguration;

    @PostMapping("/sendSms")
    public CipherResponse sendSms(@RequestParam Map<String,Object> map){
        map.put("sms_appkey", smsConfiguration.getSms_appkey());
        map.put("zhuce_url", smsConfiguration.getZhuce_url());
        map.put("zhuce_tpl_id", smsConfiguration.getZhuce_tpl_id());
        map.put("zhuce_tpl_value", smsConfiguration.getZhuce_tpl_value());
        return smsService.send(map);
    }
}
