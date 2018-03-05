package com.zll.dijiag.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;
import com.zll.dijiag.model.Users;
import com.zll.dijiag.util.response.Response;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Moon
 * @since 2018-01-31
 */
public interface IUsersService extends IService<Users> {

	Response findByAll();

	Response findByAll2();

	Response insertUsers(Users users);

	Response insertUsers2(Map<String, Object> params);

    Response updateUsers(Users users);

	Response updateUsers2(Users users);

	Response deleteUsers(Users users);

	Response deleteUsers2(String json);
}
