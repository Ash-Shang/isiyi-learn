package com.isiyi.mybatis.mapper;

import com.isiyi.mybatis.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT id, username, age, gender FROM test_user")
    List<UserEntity> findList();

}
