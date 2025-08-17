package hello.core.discount

import hello.core.member.Grade
import hello.core.member.Member

class RateDiscountPolicy(private val discountPercent: Int = 10) : DiscountPolicy {

    override fun discount(member: Member, price: Int) =
        if (member.grade == Grade.VIP) price * discountPercent / 100 else 0
}