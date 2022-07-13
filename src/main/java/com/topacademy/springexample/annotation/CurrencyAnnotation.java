package com.topacademy.springexample.annotation;

import org.springframework.beans.factory.annotation.Autowired;

@Autowired
public @interface CurrencyAnnotation {

    String beans() default "";
}