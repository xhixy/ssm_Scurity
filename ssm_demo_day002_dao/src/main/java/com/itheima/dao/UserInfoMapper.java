package com.itheima.dao;

import com.itheima.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author 用户
 */
public interface UserInfoMapper {

    /**
     * 通过用户名查询用户
     * @param username
     * @return
     */
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.dao.RoleMapper.findAllByUserId"))
    })
    public UserInfo findUserByUsername(String username);

    /**
     * 插入用户
     * @param userInfo
     */
    @Insert("insert into users (username,email,password,phoneNum,status) values(#{username},#{email},#{password},#{phoneNum},#{status})")
    public void save(UserInfo userInfo);

    /**
     * 查询所有
     * @return
     */
    @Select("select * from users")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.itheima.dao.RoleMapper.findAllByUserId"))
    })
    List<UserInfo> findAll();

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.itheima.dao.RoleMapper.findAllByUserId"))
    })
    UserInfo findById(String id);


    /**
     * 通过uesrId和roleId插入USERS_ROLE中间表
     * @param userId
     * @param roleId
     */
    @Insert("insert into USERS_ROLE (userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId")String roleId);

    /**
     * 通过userId查询user
     * @param userId
     * @return
     */
    @Select("select * from users where id = #{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "com.itheima.dao.RoleMapper.findAllByUserId"))
    })
    UserInfo findUserByIdDeleteRole(String userId);

    /**
     * 通过uesrId和roleId删除
     * @param userId
     * @param roleId
     */
    @Delete("delete from USERS_ROLE where userId = #{userId} and roleId = #{roleId}")
    void deleteRole(@Param("userId") String userId,@Param("roleId") String roleId);
}
