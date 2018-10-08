package com.itheima.service.impl;

import com.itheima.dao.PermissionMapper;
import com.itheima.pojo.Permission;
import com.itheima.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 失败
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public List<Permission> findAll() {
        return permissionMapper.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionMapper.save(permission);
    }

    @Override
    public List<Permission> findRoleByIdAndAllPermission(String roleId) {
        return permissionMapper.findRoleByIdAndAllPermission(roleId);
    }
}
