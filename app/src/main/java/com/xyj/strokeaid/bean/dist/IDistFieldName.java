package com.xyj.strokeaid.bean.dist;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface IDistFieldName {

    /**
     * default extension name
     */
    String value() default "";
}
