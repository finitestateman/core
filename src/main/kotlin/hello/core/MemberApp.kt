package hello.core

import hello.core.member.Grade
import hello.core.member.Member

fun main() {

    val appConfig = AppConfig()
    val memberService = appConfig.memberService()

    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val findMember = memberService.findMember(1L)
    println("new member = ${member.name}")
    println("find member = ${findMember?.name}")
}