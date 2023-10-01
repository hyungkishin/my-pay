package common;


import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UseCase {

    // Application 로직에서 사용 (서비스 Layer) 사용을 하는 케이스
    @AliasFor(annotation = Component.class)
    String value() default "";

}
