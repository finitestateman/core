package hello.core.beanfind

import hello.core.AppConfig
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextInfoTest {

    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("모든 빈 출력하기")
    fun findAllBean() =
        ac.beanDefinitionNames
            .associateWith { ac.getBean(it) }
            .forEach(::println)


    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    fun findApplicationBean() =
        ac.beanDefinitionNames
            // ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            // ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            .filter { ac.getBeanDefinition(it).role == BeanDefinition.ROLE_APPLICATION }
            .associateWith { ac.getBean(it) }
            .forEach(::println)
}