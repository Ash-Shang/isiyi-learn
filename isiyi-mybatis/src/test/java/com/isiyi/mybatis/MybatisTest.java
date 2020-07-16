package com.isiyi.mybatis;

import com.isiyi.mybatis.entity.UserEntity;
import com.isiyi.mybatis.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MybatisApplication.class)
public class MybatisTest {

    @Autowired
    UserMapper userMapper;


    @Test
    public void test01(){
        List<UserEntity> list = userMapper.findList();
        System.out.println(list.toString());
    }


}
