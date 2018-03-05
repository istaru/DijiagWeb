package com.zll.dijiag.controller;


import com.zll.dijiag.service.IUserService;
import com.zll.dijiag.util.response.CipherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Moon
 * @since 2018-03-01
 */
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
    IUserService userService;

    @PostMapping("/login")
    public CipherResponse login(@RequestBody String data){
        return userService.login(data);
    }
}
