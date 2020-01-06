package com.hzqing.annoation;

import java.lang.annotation.*;

/**
 * @author hzqing
 * @date 2020-01-04 14:23
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HZQController {
    String value() default "";
}
