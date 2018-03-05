package com.zll.dijiag.controller;


import com.zll.dijiag.util.response.Response;
import org.springframework.web.bind.annotation.*;

import com.zll.dijiag.model.Users;
import com.zll.dijiag.service.IUsersService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Moon
 * @since 2018-01-31
 */
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    IUsersService usersService;

    @GetMapping("/findByAll")
    public Response findByAll() {
        return usersService.findByAll();
    }

    @GetMapping("/findByAll2")
    public Response findByAll2() {
        return usersService.findByAll2();
    }

    @GetMapping("/insertUsers")
    public Response insertUsers(Users users) {
        return usersService.insertUsers(users);
    }

    @GetMapping("/insertUsers2")
    public Response insertUsers2(@RequestParam Map<String,Object> params) {
        return usersService.insertUsers2(params);
    }

    @GetMapping("/updateUsers")
    public Response updateUsers(Users users){
        return usersService.updateUsers(users);
    }

    @GetMapping("/updateUsers2")
    public Response updateUsers2(Users users){
        return usersService.updateUsers2(users);
    }

    @GetMapping("/deleteUsers")
    public Response deleteUsers(Users users){
        return usersService.deleteUsers(users);
    }

    @PostMapping("/deleteUsers2")
    public Response deleteUsers2(@RequestBody String json){
        return usersService.deleteUsers2(json);
    }

}
