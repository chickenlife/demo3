package com.example.demo3.domain;

import com.example.demo3.domain.model.UserInfo;
import com.example.demo3.domain.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserInfoDomainService {

    private final UserInfoRepository userInfoRepository;

    @Transactional
    public UserInfo getUserInfo(String name) {
        Optional<UserInfo> userInfo = userInfoRepository.findByName(name);
        if(!userInfo.isPresent())
            throw new RuntimeException("findByName, not found :"+name);
        return userInfo.get();
    }

    @Transactional
    public void createUserInfo(UserInfo userInfo) {

        userInfoRepository.save(userInfo);
    }

    @Transactional
    public void updateUserInfo(UserInfo userInfo) {
        log.debug("userInfo.getId() : "+ userInfo.getId());
        UserInfo userinfo1 = userInfoRepository.findById(userInfo.getId())
                .orElseThrow(()-> new RuntimeException("not found"));

        log.debug("userinfo1.getId() : "+ userinfo1.getId());
        log.debug("userinfo1.getName() : "+ userinfo1.getName());
        log.debug("userinfo1.getAge() : "+ userinfo1.getAge());
        userinfo1.setId(userInfo.getId());
        userinfo1.setName(userInfo.getName());
        userinfo1.setAge(userInfo.getAge());
        userInfoRepository.save(userinfo1);
    }
}
