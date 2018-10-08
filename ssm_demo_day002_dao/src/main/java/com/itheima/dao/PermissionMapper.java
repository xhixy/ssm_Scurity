package com.itheima.dao;

import com.itheima.pojo.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {


    @Select("select * from permission where id in (select permissionId from ROLE_PERMISSION where roleId = #{roleId})")
    public List<Permission> findByRoleId(String roleId);

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);

    @Select("select * from PERMISSION where id not in (select PERMISSIONID from ROLE_PERMISSION where roleId = #{roleId})")
    List<Permission> findRoleByIdAndAllPermission(String roleId);
}
