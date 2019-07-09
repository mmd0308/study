package com.hzqing.study.properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.ParameterMap;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.util.Collection;
import java.util.Properties;

/**
 * @author hzqing
 * @date 2019-07-07 18:04
 */
public class PropertiesDemo {

    @Test
    public void test() throws Exception {
        Reader resourceAsReader = Resources.getResourceAsReader("com/hzqing/study/properties/mybatis-config.xml");
        Properties properties = new Properties();
        properties.setProperty("username","zhangsan");
        properties.setProperty("password","zhangsan");
        SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(resourceAsReader,properties);
        Properties variables = sqlSessionFactory.getConfiguration().getVariables();
        System.out.println(variables);
    }
}
