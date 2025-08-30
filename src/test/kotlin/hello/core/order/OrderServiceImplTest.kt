package hello.core.order

import hello.core.discount.FixDiscountPolicy
import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemoryMemberRepo
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class OrderServiceImplTest {

    @Test
    fun createOrder() {

        val memberRepo = MemoryMemberRepo()
        memberRepo.save(Member(1L, "name", Grade.VIP))

        val orderService = OrderServiceImpl(memberRepo, FixDiscountPolicy())
        orderService.createOrder(1L, "itemA", 10_000)

        val order = orderService.createOrder(1L, "itemA", 10_000)
        assertThat(order.discountPrice).isEqualTo(1_000)

    }
}