package com.example.demo3.service;

import com.example.demo3.domain.UserInfoDomainService;
import com.example.demo3.domain.model.UserInfo;
import com.example.demo3.dto.UserInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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

    public UserInfoDto createUserInfo(UserInfoDto userInfoDto) {
        UserInfo userInfo = new UserInfo();
        userInfo.setName(userInfoDto.getName());
        userInfo.setAge(userInfoDto.getAge());

        userInfoDomainService.createUserInfo(userInfo);
        return userInfoDto;
    }

    public UserInfoDto updateUserInfo(String name, UserInfoDto userInfoDto) {

        UserInfo userInfo = new UserInfo();
        userInfo.setId(userInfoDto.getId());
        userInfo.setName(userInfoDto.getName());
        userInfo.setAge(userInfoDto.getAge());
        log.debug("userInfo created, id:"+userInfoDto.getId());
        userInfoDomainService.updateUserInfo(userInfo);
        return userInfoDto;
    }
}
