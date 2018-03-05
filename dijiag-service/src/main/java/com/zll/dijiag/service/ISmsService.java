package com.zll.dijiag.service;

import com.zll.dijiag.model.Sms;
import com.baomidou.mybatisplus.service.IService;
import com.zll.dijiag.util.response.CipherResponse;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Moon
 * @since 2018-03-01
 */
public interface ISmsService extends IService<Sms> {

    CipherResponse send(Map<String, Object> map);
}
