package hello.core.order

import hello.core.AppConfig
import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberService
import org.springframework.context.annotation.AnnotationConfigApplicationContext

fun main() {

    // val appConfig = AppConfig()
    // val memberService = appConfig.memberService()
    // val orderService = appConfig.orderService()

    val applicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    val memberService = applicationContext.getBean("memberService", MemberService::class.java)
    val orderService = applicationContext.getBean("orderService", OrderService::class.java)

    val memberId = 1L
    val member = Member(memberId, "memberA", Grade.VIP)
    memberService.join(member)

    val order = orderService.createOrder(memberId, "itemA", 10_000)

    println("order = $order")

}