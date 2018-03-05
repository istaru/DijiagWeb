package com.zll.dijiag.service;

import com.zll.dijiag.model.User;
import com.baomidou.mybatisplus.service.IService;
import com.zll.dijiag.util.response.CipherResponse;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Moon
 * @since 2018-03-01
 */
public interface IUserService extends IService<User> {

    CipherResponse login(String data);
}
