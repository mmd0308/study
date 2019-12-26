package com.hzqing.demo1;

/**
 * @author hzqing
 * @date 2019-07-31 16:14
 */
public class Demo1 {
    public static void main(String[] args) {
        String token ="b3bfbfe7c31d244c6d454aced56710d9609e3cd5a538888658211680e36bddb4";
        String res = token.trim().startsWith("Bearer") ? token : "Bearer " + token;
        System.out.println(res);
    }
}
