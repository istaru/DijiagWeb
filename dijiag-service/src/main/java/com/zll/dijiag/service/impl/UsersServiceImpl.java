package com.zll.dijiag.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zll.dijiag.dao.UsersMapper;
import com.zll.dijiag.model.Users;
import com.zll.dijiag.service.IUsersService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

import com.zll.dijiag.util.cipher.Crypto;
import com.zll.dijiag.util.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Moon
 * @since 2018-01-31
 */
@Service
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements IUsersService {

	boolean flag;

	@Autowired
	UsersMapper usersMapper;

	/**
	 * 查询所有用户（封装）
	 * @return
	 */
	@Override
	public Response findByAll() {
		List<Users> lists = new Users().selectAll();
		if(!lists.isEmpty()){
			return Crypto.response(true,lists);
		} else {
			return Crypto.response(false,"");
		}
	}

	/**
	 * 查询所有用户（sql）
	 * @return
	 */
	@Override
	public Response findByAll2() {
		List<Map<String, Object>> lists = usersMapper.findByAll2();
		if(!lists.isEmpty()){
			return Crypto.response(true,lists);
		} else {
			return Crypto.response(false,"");
		}
	}

	/**
	 * 插入用户数据（封装）
	 * @return
	 */
	@Override
	public Response insertUsers(Users users) {
		flag = users.insert();
		if(flag){
			return findByAll2();
		} else {
			return Crypto.response(false,"");
		}
	}

	/**
	 * 插入用户数据（sql）
	 * @return
	 */
	@Override
	public Response insertUsers2(Map<String, Object> params) {
		flag = usersMapper.insertUsers2(params);
		if(flag){
			return findByAll2();
		} else {
			return Crypto.response(false,"");
		}
	}

	/**
	 * 修改数据（封装）
	 * @param users
	 * @return
	 */
	@Override
	public Response updateUsers(Users users) {
		flag = users.insertOrUpdate();
		if(flag){
			return findByAll2();
		} else {
			return Crypto.response(false,"");
		}
	}

	/**
	 * 修改数据（sql）
	 * @param users
	 * @return
	 */
	@Override
	public Response updateUsers2(Users users) {
		flag = usersMapper.updateUsers2(users);
		if(flag){
			return findByAll2();
		} else {
			return Crypto.response(false,"");
		}
	}

	/**
	 * 删除数据（封装）
	 * @param users
	 * @return
	 */
	@Override
	public Response deleteUsers(Users users) {
		flag = users.deleteById();
		if(flag){
			return findByAll2();
		} else {
			return Crypto.response(false,"");
		}
	}

	/**
	 * 删除数据（json）
	 * @param json
	 * @return
	 */
	@Override
	public Response deleteUsers2(String json) {
		json = Crypto.decryptJson(json);
		flag = usersMapper.deleteUsers2(JSONObject.parseObject(json));
		if(flag){
			return findByAll2();
		} else {
			return Crypto.response(false,"");
		}
	}

}
