package hello.core.beanfind

import hello.core.member.MemberRepo
import hello.core.member.MemoryMemberRepo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoUniqueBeanDefinitionException
import org.springframework.beans.factory.getBean
import org.springframework.beans.factory.getBeansOfType
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

class ApplicationContextSameBeanFindTest {

    val ac = AnnotationConfigApplicationContext(SameBeanConfig::class.java)

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류가 발생한다")
    fun findBeanByTypeDuplicate() {
        assertThrows<NoUniqueBeanDefinitionException> { ac.getBean<MemberRepo>() }
    }

    @Test
    @DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다")
    fun findBeanByName() {
        val memberRepo = ac.getBean<MemberRepo>("memberRepo1")
        assertThat(memberRepo).isInstanceOf(MemberRepo::class.java)
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    fun findAllBeanByType() {

        val beansOfType = ac.getBeansOfType<MemberRepo>()
        assertThat(beansOfType.size).isEqualTo(2)

        beansOfType.forEach { (key, value) ->
            println("key = $key, value = $value")

        }
    }


    @Configuration
    class SameBeanConfig {

        @Bean
        fun memberRepo1(): MemberRepo = MemoryMemberRepo()

        @Bean
        fun memberRepo2(): MemberRepo = MemoryMemberRepo()

    }
}