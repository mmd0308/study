package com.hzqing.mybatis;

import com.hzqing.mybatis.entity.Blog;
import com.hzqing.mybatis.mapper.BlogMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author hzqing
 * @date 2019-08-09 08:35
 */
public class Test {


    public static void main(String[] args) throws IOException {

        InputStream inputStream = Resources.getResourceAsStream("mybaits-conf.xml");

        // 创建sqlsessionfactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);


        // 插入
//        Blog blog = new Blog();
//        String title = "test2";
//        blog.setTitle("标题： " + title);
//        Comment comment = new Comment(title + "文章，评论", LocalDateTime.now());
//        blog.setComment(comment);
//        mapper.insert(blog);
//        sqlSession.commit();
//        sqlSession.close();

        // 查询
        List<Blog> blogs = mapper.selectLists();
        blogs.forEach(item -> System.out.println(item));

    }

    public void insert(BlogMapper blogMapper,Blog blog){
        blogMapper.insert(blog);
    }
}
