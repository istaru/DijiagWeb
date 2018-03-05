package com.zll.dijiag.dao;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zll.dijiag.model.Users;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author Moon
 * @since 2018-01-31
 */
public interface UsersMapper extends BaseMapper<Users> {

	List<Map<String, Object>> findByAll2();

	boolean insertUsers2(Map<String, Object> params);

	boolean updateUsers2(Users users);

	boolean deleteUsers2(JSONObject json);
}