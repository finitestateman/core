package hello.core.scope

import jakarta.annotation.PostConstruct
import jakarta.annotation.PreDestroy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Scope

class PrototypeTest {

    @Test
    fun prototypeBeanFind() {

        val ac = AnnotationConfigApplicationContext(PrototypeBean::class.java)

        val prototypeBean1 = ac.getBean<PrototypeBean>()
        println("find prototypeBean1")
        val prototypeBean2 = ac.getBean<PrototypeBean>()
        println("find prototypeBean2")

        println("singletonBean1 = $prototypeBean1")
        println("singletonBean2 = $prototypeBean2")

        assertThat(prototypeBean1).isNotSameAs(prototypeBean2)

        prototypeBean1.destroy()
        prototypeBean2.destroy()

        ac.close()
    }

    @Scope("prototype")
    class PrototypeBean {

        @PostConstruct
        fun init() {
            println("PrototypeBean.init")
        }

        // Prototype에서는 호출 안 된다
        @PreDestroy
        fun destroy() {
            println("PrototypeBean.destroy")
        }

    }
}