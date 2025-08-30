package hello.core.autowired

import hello.core.AutoAppConfig
import hello.core.discount.DiscountPolicy
import hello.core.member.Grade
import hello.core.member.Member
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.getBean
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class AllBeanTest {

    @Test
    fun findAllBean() {

        val ac = AnnotationConfigApplicationContext(AutoAppConfig::class.java, DiscountService::class.java)
        val discountService = ac.getBean<DiscountService>()

        val member = Member(1L, "userA", Grade.VIP)
        val discountPrice = discountService.discount(member, 10_000, "fixDiscountPolicy")

        assertThat(discountService).isInstanceOf(DiscountService::class.java)
        assertThat(discountPrice).isEqualTo(1_000)

        val rateDiscountPrice = discountService.discount(member, 20_000, "rateDiscountPolicy")
        assertThat(rateDiscountPrice).isEqualTo(2_000)

    }

    class DiscountService(
        private val policyMap: Map<String, DiscountPolicy>,
        private val policies: List<DiscountPolicy>
    ) {

        init {
            println("policyMap = $policyMap")
            println("policies = $policies")
        }

        fun discount(member: Member, price: Int, discountCode: String): Int {
            val discountPolicy = policyMap[discountCode]!!
            return discountPolicy.discount(member, price)
        }
    }
}

