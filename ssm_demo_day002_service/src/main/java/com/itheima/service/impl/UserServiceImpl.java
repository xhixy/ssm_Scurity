package com.itheima.service.impl;

import com.itheima.dao.UserInfoMapper;
import com.itheima.pojo.Role;
import com.itheima.pojo.UserInfo;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = userInfoMapper.findUserByUsername(username);
        List<SimpleGrantedAuthority> authority = getAuthority(userInfo.getRoles());
        User user = new User(userInfo.getUsername(),userInfo.getPassword(), userInfo.getStatus() != 0,true,true,true,authority);
        return user;
    }

    @Override
    public void save(UserInfo userInfo) {
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoMapper.save(userInfo);
    }

    @Override
    public List<UserInfo> findAll() {
        return userInfoMapper.findAll();
    }

    @Override
    public UserInfo findById(String id) {
        return userInfoMapper.findById(id);
    }

    @Override
    public void addRoleToUser(String userId, String[] str) {
        for (String roleId : str) {
            userInfoMapper.addRoleToUser(userId,roleId);
        }
    }

    @Override
    public void deleteRole(String userId,String[] roleIds) {
        for (String roleId : roleIds) {
            userInfoMapper.deleteRole(userId,roleId);
        }
    }

    @Override
    public UserInfo findUserByIdDeleteRole(String userId) {
        return userInfoMapper.findUserByIdDeleteRole(userId);
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return authorities;
    }
}
