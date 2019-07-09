package com.hzqing.source;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.util.Properties;

/**
 * @author hzqing
 * @date 2019-07-07 18:04
 */
public class Demo {

    @Test
    public void test() throws Exception {
        Reader resourceAsReader = Resources.getResourceAsReader("com/hzqing/source/mybatis-config.xml");
        Properties properties = new Properties();
        properties.setProperty("username","root");
        properties.setProperty("password","root");
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(resourceAsReader,properties);

        // 获取一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();

    }
}
