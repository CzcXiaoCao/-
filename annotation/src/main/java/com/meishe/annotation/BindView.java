package com.meishe.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by CaoZhiChao on 2018/11/5 16:10
 */
@Documented
@Target(ElementType.FIELD)
@Retention(value = RetentionPolicy.CLASS)
public @interface BindView {
    int id() default 0;
}

