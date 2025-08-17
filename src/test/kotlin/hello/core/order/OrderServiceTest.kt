package hello.core.order

import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberServiceImpl
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class OrderServiceTest {

    val memberService = MemberServiceImpl()
    val orderService = OrderServiceImpl()

    @Test
    fun createOrder() {

        val memberId = 1L
        val member = Member(memberId, "memberA", Grade.VIP)
        memberService.join(member)

        val order = orderService.createOrder(memberId, "itemA", 10_000)

        Assertions.assertThat(order.discountPrice).isEqualTo(1_000)

    }

}