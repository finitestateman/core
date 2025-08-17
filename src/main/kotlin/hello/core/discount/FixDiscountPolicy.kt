package hello.core.discount

import hello.core.member.Grade
import hello.core.member.Member

class FixDiscountPolicy(private val discountFixAmount: Int = 1_000) : DiscountPolicy {

    override fun discount(member: Member, price: Int) =
        if (member.grade == Grade.VIP) discountFixAmount else 0

}