package hello.core.lifecycle

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class BeanLifeCycleTest {

    @Test
    fun lifeCycleTest() {
        val ac: ConfigurableApplicationContext = AnnotationConfigApplicationContext(LifeCycleConfig::class.java)
        ac.getBean<NetworkClient>()
        ac.close()
    }

    @Configuration
    class LifeCycleConfig {

        // @Bean(initMethod = "init", destroyMethod = "close")
        @Bean
        fun networkClient(): NetworkClient {
            val networkClient = NetworkClient()
            networkClient.url = "http://hello-spring.dev"
            return networkClient
        }
    }
}