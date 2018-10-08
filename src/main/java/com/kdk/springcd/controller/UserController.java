package com.kdk.springcd.controller;

import com.kdk.springcd.entity.UserInfo;
import com.kdk.springcd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "getUserId",method = RequestMethod.GET)
    public UserInfo GetUserID(@RequestParam String user_id){
        return userService.GetUser(user_id);
    }

    @RequestMapping(value ="addUser", method = RequestMethod.POST)
    public void AddUser(@RequestParam String user_id ,@RequestParam String user_pwd) throws Exception{
        try {
            UserInfo userInfo = userService.GetUser(user_id);
        } catch (Exception e){
            userService.addUser(user_id,user_pwd);
        }

    }

    @RequestMapping(value = "updatePwd", method = RequestMethod.POST)
    public void UpdatePwd(@RequestParam String user_id,@RequestParam String user_pwd) throws Exception{
        try{
            UserInfo userInfo = userService.GetUser(user_id);
            userService.updatePwd(user_id,user_pwd);
        }catch (Exception e){

        }
    }
}
