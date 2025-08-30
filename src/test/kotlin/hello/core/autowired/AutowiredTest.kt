package hello.core.autowired

import hello.core.member.Member
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.lang.Nullable
import java.util.*

class AutowiredTest {

    @Test
    fun autowiredOption() {
        AnnotationConfigApplicationContext(TestBean::class.java)
    }

    class TestBean {

        @Autowired(required = false)
        fun setNoBean1(noBean1: Member) {
            println("noBean1 = $noBean1")
        }

        @Autowired
        fun setNoBean2(@Nullable noBean2: Member?) {
            println("noBean2 = $noBean2")
        }

        @Autowired
        fun setNoBean3(noBean3: Optional<Member>) {
            println("noBean3 = $noBean3")
        }
    }
}