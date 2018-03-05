package com.zll.dijiag.dao;

import com.alibaba.fastjson.JSONObject;
import com.zll.dijiag.model.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Moon
 * @since 2018-03-01
 */
public interface UserMapper extends BaseMapper<User> {

    User pFindUser(JSONObject json);

    boolean insertUser(JSONObject json);
}