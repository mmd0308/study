package com.hzqing.netty.rpc.protocol;

import java.io.Serializable;

/**
 * @author hzqing
 * @date 2019-12-16 09:11
 */

public class InvokerProtocol implements Serializable {


    private String className;

    private String methodName;

    private Class<?> [] params;

    private Object[] values;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParams() {
        return params;
    }

    public Object[] getValues() {
        return values;
    }

    public void setValues(Object[] values) {
        this.values = values;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setParams(Class<?>[] params) {
        this.params = params;
    }
}
