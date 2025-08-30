package hello.core.scan.filter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.getBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.ComponentScan.Filter
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

class ComponentFilterAppConfigTest {

    @Test
    fun filterScan() {

        val ac: AnnotationConfigApplicationContext =
            AnnotationConfigApplicationContext(ComponentFilterAppConfig::class.java)
        val beanA = ac.getBean<BeanA>("beanA")

        assertThat(beanA).isNotNull()
        assertThrows<NoSuchBeanDefinitionException> {
            ac.getBean<BeanB>("beanB")
        }
    }

    @Configuration
    @ComponentScan(
        includeFilters = [
            Filter(type = FilterType.ANNOTATION, classes = [MyIncludeComponent::class])
        ],
        excludeFilters = [
            Filter(type = FilterType.ANNOTATION, classes = [MyExcludeComponent::class])
        ]
    )
    class ComponentFilterAppConfig
}