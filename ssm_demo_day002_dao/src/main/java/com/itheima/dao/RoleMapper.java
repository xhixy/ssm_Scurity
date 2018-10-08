package com.itheima.dao;

import com.itheima.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleMapper {


    @Select("select * from role where id in(select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "com.itheima.dao.PermissionMapper.findByRoleId")),
    })
    public List<Role> findAllByUserId(String userId);

    @Select("select * from role")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "com.itheima.dao.PermissionMapper.findByRoleId")),
            @Result(property = "users",column = "id",javaType = List.class,many = @Many(select = "com.itheima.dao.UserInfoMapper.findById"))
    })
    List<Role> findAll();

    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from ROLE where id not in (select ROLEID from USERS_ROLE where userId = #{userId})")
    List<Role> findUserByIdAndAllRole(String userId);


    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "com.itheima.dao.PermissionMapper.findByRoleId"))
    })
    Role findById(String id);

    @Insert("insert into ROLE_PERMISSION (roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
