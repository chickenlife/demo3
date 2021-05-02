package com.example.demo3.controller;

import com.example.demo3.dto.UserInfoDto;
import com.example.demo3.service.UserInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserInfoController {

    final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping("/userinfo/{name}")
    public UserInfoDto selectUserInfo(@PathVariable String name){

        return userInfoService.selectUserInfo(name);
    }
}
