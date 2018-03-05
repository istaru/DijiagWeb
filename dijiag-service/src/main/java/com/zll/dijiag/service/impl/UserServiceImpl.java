package com.zll.dijiag.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zll.dijiag.model.User;
import com.zll.dijiag.dao.UserMapper;
import com.zll.dijiag.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.zll.dijiag.util.cipher.AES;
import com.zll.dijiag.util.cipher.Crypto;
import com.zll.dijiag.util.response.CipherResponse;
import com.zll.dijiag.util.response.Response;
import com.zll.dijiag.util.response.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Moon
 * @since 2018-03-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Autowired
    UserMapper userMapper;

    Response response;

    @Override
    public CipherResponse login(String data) {
        response = new Response();
        data = Crypto.decryptJson(data);
        JSONObject json = JSONObject.parseObject(data);
        if(null != json){
            String pwd = json.getString("password");
            String md5Pwd = AES.md5(pwd);
            json.put("password",md5Pwd);
            User user = userMapper.pFindUser(json);
            if(null != user){
                if(user.getUserPwd().equals(md5Pwd)){
                    response.setCode(ResponseCode.CODE_SUCCESS);
                    response.setMsg("登录成功");
                    response.setData(user);
                } else {
//                    response.setCode(ResponseCode.CODE_ERROR);
                    response.setMsg("密码错误");
                }
            } else {
                String code = json.getString("code");
                if(!StringUtils.isEmpty(code)){
                    boolean flag = userMapper.insertUser(json);
                    if(flag){
                        response.setCode(ResponseCode.CODE_SUCCESS);
                        response.setMsg("注册成功");
                    } else {
//                    response.setCode(ResponseCode.CODE_ERROR);
                        response.setMsg("注册失败");
                    }
                } else {
                    response.setMsg("请输入验证码");
                }
            }
        } else {
//            response.setCode(ResponseCode.CODE_ERROR);
            response.setMsg("参数有误");
        }
        return Crypto.encodeJson(response);
    }
}
