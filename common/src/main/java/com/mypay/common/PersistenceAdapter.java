package com.mypay.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PersistenceAdapter {

    // 영속성 계층의 Adapter 를 의미
    @AliasFor(annotation = Component.class)
    String value() default "";

}
