package hello.core.singleton

import hello.core.AppConfig
import hello.core.member.MemberRepo
import hello.core.member.MemberServiceImpl
import hello.core.order.OrderServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ConfigurationSingletonTest {

    @Test
    fun configurationTest() {

        val ac: ApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)

        val memberRepo = ac.getBean<MemberRepo>("memberRepo")

        val memberService = ac.getBean<MemberServiceImpl>("memberService")
        val orderService = ac.getBean<OrderServiceImpl>("orderService")

        val memberRepo1 = memberService.getMemberRepo()
        val memberRepo2 = orderService.getMemberRepo()

        println("memberRepo = $memberRepo")
        println("memberRepo1 = $memberRepo1")
        println("memberRepo2 = $memberRepo2")

        assertThat(memberRepo)
            .isSameAs(memberRepo1)
            .isSameAs(memberRepo2)
    }
}