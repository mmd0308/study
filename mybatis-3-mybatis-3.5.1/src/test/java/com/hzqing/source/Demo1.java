package com.hzqing.source;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.Reader;

/**
 * @author hzqing
 * @date 2019-07-07 18:04
 */
public class Demo1 {

    @Test
    public void test1() throws Exception {
        Reader resourceAsReader = Resources.getResourceAsReader("com/hzqing/source/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(resourceAsReader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
    }
}
