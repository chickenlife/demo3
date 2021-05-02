package com.example.demo3.service;

import com.example.demo3.domain.UserInfoDomainService;
import com.example.demo3.domain.model.UserInfo;
import com.example.demo3.dto.UserInfoDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {
    final UserInfoDomainService userInfoDomainService;

    public UserInfoService(UserInfoDomainService userInfoDomainService) {
        this.userInfoDomainService = userInfoDomainService;
    }

    public UserInfoDto selectUserInfo(String name) {
        UserInfoDto userInfoDto = new UserInfoDto();
        UserInfo userinfo = userInfoDomainService.getUserInfo(name)
                .orElseThrow(()->new RuntimeException("Not Found User["+name+"]'s UserInfo"));
        userInfoDto.setName(userinfo.getName());
        userInfoDto.setAge(userinfo.getAge());

        return userInfoDto;
    }
}
