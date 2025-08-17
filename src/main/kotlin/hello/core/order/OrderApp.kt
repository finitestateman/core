package hello.core.order

import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberServiceImpl

fun main() {

    val memberService = MemberServiceImpl()
    val orderService = OrderServiceImpl()

    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10_000)

    println("order = $order")

}