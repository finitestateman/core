package hello.core.beanfind

import hello.core.discount.DiscountPolicy
import hello.core.discount.FixDiscountPolicy
import hello.core.discount.RateDiscountPolicy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.beans.factory.getBean
import org.springframework.beans.factory.getBeansOfType
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextExtendsFindTest {

    private val ac = AnnotationConfigApplicationContext(TestConfig::class.java)

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복 오류가 발생한다")
    fun findBeanByParentTypeDuplicate() {

        assertThrows<NoUniqueBeanDefinitionException> {
            ac.getBean<DiscountPolicy>()
        }
    }

    @Test
    @DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    fun findBeanByParentTypeBeanName() {

        val rateDiscountPolicy = ac.getBean<DiscountPolicy>("rateDiscountPolicy")
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy::class.java)

    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    fun findAllBeanByParentType() {

        val beansOfType = ac.getBeansOfType<DiscountPolicy>()
        assertThat(beansOfType.size).isEqualTo(2)

        beansOfType.forEach { (key, value) ->
            println("key = $key, value = $value")

        }
    }

    @Test
    @DisplayName("Object 타입으로 모두 조회")
    fun findAllBeanByObjectType() {

        val beansOfType = ac.getBeansOfType<Object>()

        beansOfType.forEach { (key, value) ->
            println("key = $key, value = $value")

        }
    }

    @Configuration
    class TestConfig {

        @Bean
        fun rateDiscountPolicy(): DiscountPolicy = RateDiscountPolicy()

        @Bean
        fun fixDiscountPolicy(): DiscountPolicy = FixDiscountPolicy()

    }
}
