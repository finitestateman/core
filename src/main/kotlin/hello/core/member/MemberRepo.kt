package hello.core.member

interface MemberRepo {

    fun save(member: Member)

    fun findById(memberId: Long): Member?
}