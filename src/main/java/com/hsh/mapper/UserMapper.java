package com.hsh.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hsh.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author xrkhy
 * @date 2025/9/8 21:56
 * @description
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from smbms_user where userName=#{userName} and userPassword=#{userPassword}")
    User login(@Param("userName") String userName, @Param("userPassword") String userPassword);
}
