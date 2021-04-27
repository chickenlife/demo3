package com.example.demo3.controller;

import com.example.demo3.dto.UserInfoDto;
import com.example.demo3.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInfoController {

    final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/userinfo")
    public UserInfoDto selectUserInfo(){
        return userInfoService.selectUserInfo();
    }
}
