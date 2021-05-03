package com.example.demo3.domain;

import com.example.demo3.domain.model.UserInfo;
import com.example.demo3.domain.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
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
}
