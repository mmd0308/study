package com.hzqing.netty.nio.demo2;

import java.nio.ByteBuffer;

/**
 * @author hzqing
 * @date 2019-12-25 09:07
 */

/**
 * 手动分配缓冲区
 */
public class BufferWrap {
    public static void main(String[] args) {
        // 分配指定大小的缓冲区
        ByteBuffer buffer1 = ByteBuffer.allocate(10);

        // 包装一个现有的数组
        byte array [] = new byte[10];
        ByteBuffer buffer2 = ByteBuffer.wrap(array);
    }
}
