package com.itheima.service;

import com.itheima.pojo.Role;

import java.util.List;


public interface RoleService {

    List<Role> findAll();

    void save(Role role);

    List<Role> findUserByIdAndAllRole(String userId);

    Role findById(String id);

    void addPermissionToRole(String roleId, String[] permissions);
}
