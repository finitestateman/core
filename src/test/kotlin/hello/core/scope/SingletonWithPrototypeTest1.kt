package hello.core.scope

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class SingletonWithPrototypeTest1 {

    @Test
    fun prototypeFind() {

        val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)

        val prototypeBean1 = ac.getBean<PrototypeBean>()
        prototypeBean1.addCount()
        assertThat(prototypeBean1.count).isEqualTo(1)

        val prototypeBean2 = ac.getBean<PrototypeBean>()
        prototypeBean2.addCount()
        assertThat(prototypeBean2.count).isEqualTo(1)
    }

    @Test
    fun singletonClientPrototype() {

        val ac = AnnotationConfigApplicationContext(ClientBean::class.java, PrototypeBean::class.java)

        val clientBean1 = ac.getBean<ClientBean>()
        val count1 = clientBean1.logic()
        assertThat(count1).isEqualTo(1)

        val clientBean2 = ac.getBean<ClientBean>()
        val count2 = clientBean2.logic()
        assertThat(count2).isEqualTo(2)

    }

    @Scope("singleton")
    class ClientBean(val prototypeBean: PrototypeBean) {

        fun logic(): Int {
            prototypeBean.addCount()
            val count = prototypeBean.count
            return count
        }
    }

    @Scope("prototype")
    class PrototypeBean {

        var count: Int = 0

        fun addCount() {
            count++
        }

        @PostConstruct
        fun init() {
            println("PrototypeBean.init $this")
        }

        @PreDestroy
        fun destroy() {
            println("PrototypeBean.destroy")
        }
    }
}