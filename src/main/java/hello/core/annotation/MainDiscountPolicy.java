package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;


//markAnnotation 은 Runtime , 예외가 터지면 복잡해짐
//Runtime 을 줄이고 컴파일에서 예외를 잡을 수 없을까? => markAnnotation 대신에 MarkInterface
//MarkInterface Body가 없고 MarkInterface를 상속받은 클래스만 사용할 수 있다. (~~~able) => MarkInterface를
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {

}
