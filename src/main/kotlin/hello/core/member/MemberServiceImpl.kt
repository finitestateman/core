package hello.core.member

class MemberServiceImpl : MemberService {

    private val memberRepo = MemoryMemberRepo()

    override fun join(member: Member) =
        memberRepo.save(member)

    override fun findMember(memberId: Long) =
        memberRepo.findById(memberId)
}