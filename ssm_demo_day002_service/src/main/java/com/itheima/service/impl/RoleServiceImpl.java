package com.itheima.service.impl;

import com.itheima.dao.RoleMapper;
import com.itheima.pojo.Role;
import com.itheima.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAll() {
        return roleMapper.findAll();
    }

    @Override
    public void save(Role role) {
        roleMapper.save(role);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(String userId) {
        return roleMapper.findUserByIdAndAllRole(userId);
    }

    @Override
    public Role findById(String id) {
        return roleMapper.findById(id);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissions) {
        for (String permissionId : permissions) {
            roleMapper.addPermissionToRole(roleId,permissionId);
        }
    }
}
