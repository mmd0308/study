package com.hzqing.formework.annotation;

import java.lang.annotation.*;

/**
 * @author hzqing
 * @date 2020-01-08 14:06
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HZQController {

    String value() default "";
}
