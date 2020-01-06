package com.hzqing.annoation;

import java.lang.annotation.*;

/**
 * @author hzqing
 * @date 2020-01-04 14:24
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HZQRequestMapping {
    String value() default "";
}
