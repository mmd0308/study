package com.hzqing.study.delegate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hzqing
 * @date 2019-07-03 13:47
 */
public class Leader implements IEmployee{

    private Map<String,IEmployee> employeeMap = new HashMap<>();

    public Leader() {
        employeeMap.put("A",new EmployeeA());
        employeeMap.put("B",new EmployeeB());
    }

    public void doing(String commd){
        /**
         * leader分发任务
         */
        employeeMap.get(commd).doing(commd);
    }

}
