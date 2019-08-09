package com.hzqing.mybatis.typehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hzqing.mybatis.entity.Comment;
import com.mysql.cj.xdevapi.JsonParser;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author hzqing
 * @date 2019-08-09 09:42
 */
public class CommentTypeHandler extends BaseTypeHandler<Comment> {

    /**
     * 将java类型转换称jdbc类型
     * @param preparedStatement
     * @param i
     * @param comment
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Comment comment, JdbcType jdbcType) throws SQLException {
        // 设置Comment类型时候调用，将coment对象类型专程jdbc varchar类型存储
        System.out.println("preparedStatement = [" + preparedStatement + "], i = [" + i + "], comment = [" + comment + "], jdbcType = [" + jdbcType + "]");
        String jsonComment = JSONObject.toJSONString(comment);
        preparedStatement.setString(i,jsonComment);
    }

    /**
     *
     * @param resultSet
     * @param s 列名
     * @return
     * @throws SQLException
     */
    @Override
    public Comment getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println("resultSet = [" + resultSet + "], s = [" + s + "]");
        String string = resultSet.getString(s);
        return JSONObject.parseObject(string, Comment.class);
    }

    /**
     * @param resultSet
     * @param i 下表
     * @return
     * @throws SQLException
     */
    @Override
    public Comment getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println("resultSet = [" + resultSet + "], i = [" + i + "]");
        String string = resultSet.getString(i);
        return JSONObject.parseObject(string, Comment.class);
    }

    /**
     * 存储过程中使用
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public Comment getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println("callableStatement = [" + callableStatement + "], i = [" + i + "]");
        String string = callableStatement.getString(i);
        return JSONObject.parseObject(string, Comment.class);
    }
}
