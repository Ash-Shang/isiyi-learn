package com.isiyi.mybatis.test;

import com.isiyi.mybatis.entity.UserEntity;
import com.isiyi.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestExam {

    public static void main(String[] args) throws IOException {
        String resource = "D:\\ws2020\\isiyi-learn\\isiyi-mybatis\\src\\main\\resources\\mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<UserEntity> list = mapper.findList();
        System.out.println(list.toString());
    }

}
