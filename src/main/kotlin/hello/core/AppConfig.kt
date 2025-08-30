package hello.core

import hello.core.discount.DiscountPolicy
import hello.core.discount.RateDiscountPolicy
import hello.core.member.MemberRepo
import hello.core.member.MemberService
import hello.core.member.MemberServiceImpl
import hello.core.member.MemoryMemberRepo
import hello.core.order.OrderService
import hello.core.order.OrderServiceImpl
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig {

    @Bean
    fun memberService(): MemberService {
        println("call AppConfig.memberService")
        return MemberServiceImpl(memberRepo())
    }

    @Bean
    fun memberRepo(): MemberRepo {
        println("call AppConfig.memberRepo")
        return MemoryMemberRepo()
    }


    @Bean
    fun orderService(): OrderService {
        println("call AppConfig.orderService")
        return OrderServiceImpl(memberRepo(), discountPolicy())
    }

    @Bean
    fun discountPolicy(): DiscountPolicy {
        println("call AppConfig.discountPolicy")
        return RateDiscountPolicy()
    }
}