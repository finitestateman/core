package hello.core.scan

import hello.core.AutoAppConfig
import hello.core.member.MemberService
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AutoAppConfigTest {

    @Test
    fun basicScan() {

        val ac = AnnotationConfigApplicationContext(AutoAppConfig::class.java)

        val memberService = ac.getBean<MemberService>()
        Assertions.assertThat(memberService).isInstanceOf(MemberService::class.java)
    }

}