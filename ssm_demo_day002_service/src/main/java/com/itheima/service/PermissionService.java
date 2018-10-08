package com.itheima.service;

import com.itheima.pojo.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll();

    void save(Permission permission);

    List<Permission> findRoleByIdAndAllPermission(String roleId);
}
