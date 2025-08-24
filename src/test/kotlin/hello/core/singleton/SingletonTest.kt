package hello.core.singleton

import hello.core.AppConfig
import hello.core.member.MemberService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    fun pureContainer() {

        val appConfig = AppConfig()

        // 1. 조회: 호출할 때 마다 객체를 생성
        val memberService1 = appConfig.memberService()

        // 2. 조회: 호출할 때 마다 객체를 생성
        val memberService2 = appConfig.memberService()

        // 3. 참조값이 다른 것을 확인
        println("memberService1 = $memberService1")
        println("memberService2 = $memberService2")

        assertThat(memberService1).isNotSameAs(memberService2)

    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    fun singletonServiceTest() {

        val singletonService1 = SingletonService.instance
        val singletonService2 = SingletonService.instance

        val singletonObject1 = SingletonObjectService
        val singletonObject2 = SingletonObjectService

        println("singletonService1 = $singletonService1")
        println("singletonService2 = $singletonService2")

        println("singletonObject1 = $singletonObject1")
        println("singletonObject2 = $singletonObject2")

        singletonService1.logic()
        singletonObject1.logic()

        assertThat(singletonService1).isSameAs(singletonService2)
        assertThat(singletonObject1).isSameAs(singletonObject2)

    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    fun springContainer() {

        val ac = AnnotationConfigApplicationContext(AppConfig::class.java)

        val memberService1 = ac.getBean<MemberService>("memberService")
        val memberService2 = ac.getBean<MemberService>("memberService")

        println("memberService1 = $memberService1")
        println("memberService2 = $memberService2")

        assertThat(memberService1).isSameAs(memberService2)

    }
}