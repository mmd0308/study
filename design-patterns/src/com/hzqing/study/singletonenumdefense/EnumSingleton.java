package com.hzqing.study.singletonenumdefense;

/**
 * 枚举类型实现单例
 *  线程安全
 *  调用效率高
 *  不能延迟加载
 *  天然防御反射攻击
 *  甜言防御序列化和反序列化
 */
public enum EnumSingleton {

    INSTANCE;
}
