package hello.core.discount

import hello.core.annotation.MainDiscountPolicy
import hello.core.member.Grade
import hello.core.member.Member
import org.springframework.stereotype.Component

@Component
@MainDiscountPolicy
class RateDiscountPolicy(private val discountPercent: Int = 10) : DiscountPolicy {

    override fun discount(member: Member, price: Int) =
        if (member.grade == Grade.VIP) price * discountPercent / 100 else 0
}