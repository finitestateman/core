package hello.core.member

class MemoryMemberRepo : MemberRepo {

    companion object {
        private val store = HashMap<Long, Member>()
    }

    override fun save(member: Member) {
        store[member.id] = member
    }

    override fun findById(memberId: Long) =
        store.get(memberId)
}