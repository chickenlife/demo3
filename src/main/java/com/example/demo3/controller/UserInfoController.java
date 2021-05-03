package com.example.demo3.controller;

import com.example.demo3.dto.UserInfoDto;
import com.example.demo3.service.UserInfoService;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserInfoController {

    final UserInfoService userInfoService;

    public UserInfoController(UserInfoService userInfoService) {

        this.userInfoService = userInfoService;
    }

    @PostMapping("/userinfo")
    public UserInfoDto createUserInfo(@RequestBody UserInfoDto userInfoDto){
        userInfoService.createUserInfo(userInfoDto);
        return userInfoDto;
    }

    @GetMapping("/userinfo/{name}")
    public UserInfoDto selectUserInfo(@PathVariable String name){

        return userInfoService.selectUserInfo(name);
    }

    @PutMapping("/userinfo/{name}")
    public UserInfoDto updateUserInfo(@PathVariable String name, @RequestBody UserInfoDto userInfoDto){

        return userInfoService.updateUserInfo(name,userInfoDto);
    }
}
