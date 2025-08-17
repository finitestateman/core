package hello.core.order

import hello.core.AppConfig
import hello.core.member.Grade
import hello.core.member.Member

fun main() {

    val appConfig = AppConfig()
    val memberService = appConfig.memberService()
    val orderService = appConfig.orderService()

    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10_000)

    println("order = $order")

}