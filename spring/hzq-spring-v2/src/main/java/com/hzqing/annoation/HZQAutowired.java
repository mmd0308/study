package com.hzqing.annoation;

import java.lang.annotation.*;

/**
 * @author hzqing
 * @date 2020-01-04 14:21
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HZQAutowired {
    String value() default "";
}
