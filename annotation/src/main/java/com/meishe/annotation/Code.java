package com.meishe.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

/**
 * Created by CaoZhiChao on 2018/11/5 15:26
 */
@Retention(CLASS)
@Target(METHOD)
public @interface Code {
    public String author();
    public String date() default "";
}
