package hello.core.member

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MemberServiceImpl @Autowired constructor(private val memberRepo: MemberRepo) : MemberService {

    override fun join(member: Member) =
        memberRepo.save(member)

    override fun findMember(memberId: Long) =
        memberRepo.findById(memberId)

    // 테스트 용도
    fun getMemberRepo() = memberRepo
}