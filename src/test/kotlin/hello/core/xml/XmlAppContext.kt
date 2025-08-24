package hello.core.xml

import hello.core.member.MemberService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.support.GenericXmlApplicationContext

class XmlAppContext {

    @Test
    fun xmlAppContext() {

        val ac = GenericXmlApplicationContext("appConfig.xml")
        val memberService = ac.getBean<MemberService>("memberService")

        assertThat(memberService).isInstanceOf(MemberService::class.java)

    }


}