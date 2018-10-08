package com.itheima.dao;

import com.itheima.pojo.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {

    @Select("select * from member where id = #{id}")
    public Member findById(String id);
}
