package hello.core.annotation

import org.springframework.beans.factory.annotation.Qualifier

@Target(
    AnnotationTarget.FIELD,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.VALUE_PARAMETER,
    AnnotationTarget.CLASS,
    AnnotationTarget.ANNOTATION_CLASS
)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Qualifier("mainDiscountPolicy")
annotation class MainDiscountPolicy()