package hello.core

import hello.core.member.Grade
import hello.core.member.Member
import hello.core.member.MemberServiceImpl

fun main() {

    val memberService = MemberServiceImpl()
    val member = Member(1L, "memberA", Grade.VIP)
    memberService.join(member)

    val findMember = memberService.findMember(1L)
    println("new member = ${member.name}")
    println("find member = ${findMember?.name}")
}