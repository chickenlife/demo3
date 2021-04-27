package com.example.demo3.service;

import com.example.demo3.dto.UserInfoDto;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

@Service
public class UserInfoService {

     public UserInfoDto selectUserInfo() {
        return new UserInfoDto();
    }
}
