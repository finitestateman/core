package hello.core

import hello.core.discount.FixDiscountPolicy
import hello.core.member.MemberService
import hello.core.member.MemberServiceImpl
import hello.core.member.MemoryMemberRepo
import hello.core.order.OrderService
import hello.core.order.OrderServiceImpl

class AppConfig {

    fun memberService(): MemberService =
        MemberServiceImpl(memberRepo())

    fun memberRepo() = MemoryMemberRepo()

    fun orderService(): OrderService =
        OrderServiceImpl(memberRepo(), discountPolicy())

    fun discountPolicy() = FixDiscountPolicy()
}