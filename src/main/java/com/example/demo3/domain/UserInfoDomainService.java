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
    public Optional<UserInfo> getUserInfo(String name) {

        return userInfoRepository.findByName(name);
    }

    @Transactional
    public void createUserInfo(UserInfo userInfo) {

        userInfoRepository.save(userInfo);
    }

    @Transactional
    public void updateUserInfo(UserInfo userInfo) {
        Optional<UserInfo> userinfo1 = userInfoRepository.findById(userInfo.getId());
        log.debug("userinfo1.getId() : "+ userinfo1.get().getId());
        log.debug("userinfo1.getName() : "+ userinfo1.get().getName());
        log.debug("userinfo1.getAge() : "+ userinfo1.get().getAge());
        userinfo1.get().setId(userInfo.getId());
        userinfo1.get().setName(userInfo.getName());
        userinfo1.get().setAge(userInfo.getAge());
        userInfoRepository.save(userinfo1.get());
    }
}
