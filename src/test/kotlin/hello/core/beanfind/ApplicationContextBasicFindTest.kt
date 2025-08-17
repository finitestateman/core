package hello.core.beanfind

import hello.core.AppConfig
import hello.core.member.MemberService
import hello.core.member.MemberServiceImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.getBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class ApplicationContextBasicFindTest {

    val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

    @Test
    @DisplayName("빈 이름으로 조회")
    fun findAllBean() {

        val memberService = ac.getBean<MemberService>("memberService")
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("이름없이 타입으로 조회")
    fun findBeanByType() {

        val memberService = ac.getBean<MemberService>()
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    fun findBeanByName() {

        val memberService = ac.getBean<MemberServiceImpl>("memberService")
        assertThat(memberService).isInstanceOf(MemberServiceImpl::class.java)
    }

    @Test
    @DisplayName("빈 이름으로 조회 x")
    fun findBeanByNameX() {

        // val xxxxx = ac.getBean<MemberService>("xxxxx")
        assertThrows<NoSuchBeanDefinitionException> { ac.getBean<MemberService>("xxxxx") }
    }
}