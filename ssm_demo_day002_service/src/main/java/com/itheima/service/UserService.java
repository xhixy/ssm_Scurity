package com.itheima.service;

import com.itheima.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void save(UserInfo userInfo);

    List<UserInfo> findAll();

    UserInfo findById(String id);

    void addRoleToUser(String userId, String[] str);

    void deleteRole(String userId,String[] roleIds);

    UserInfo findUserByIdDeleteRole(String userId);
}
