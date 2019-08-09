package com.hzqing.mybatis.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author hzqing
 * @date 2019-08-09 08:41
 */

@Data
public class Comment {

    public Comment() {
    }

    public Comment(String msg, LocalDateTime createTime) {
        this.msg = msg;
        this.createTime = createTime;
    }

    private String msg;

    private LocalDateTime createTime;
}
