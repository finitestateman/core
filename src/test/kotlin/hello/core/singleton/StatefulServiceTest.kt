package hello.core.singleton

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean

class StatefulServiceTest {

    @Test
    fun statefulServiceSingleton() {

        val ac: ApplicationContext = AnnotationConfigApplicationContext(TestConfig::class.java)
        val statefulService1 = ac.getBean<StatefulService>()

        // ThreadA: A사용자가 10,000원 주문
        statefulService1.order("userA", 10_000)
        // ThreadB: B사용자가 20,000원 주문
        statefulService1.order("userA", 20_000)

        // ThreadA: 사용자A 주문 금액 조회
        val price = statefulService1.price
        println("price = $price")

        assertThat(statefulService1.price).isEqualTo(20_000)
    }

    class TestConfig {

        @Bean
        fun statefulService() = StatefulService()

    }
}