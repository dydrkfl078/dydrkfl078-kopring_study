package practice_thymeleaf.kopring_prac1.repository

import practice_thymeleaf.kopring_prac1.domain.Member

object MemoryMemberRepo : MemberRepo {

    private var store : HashMap<Long, Member> = HashMap()
    private var sequence = 0L

    override fun save(member: Member): Member {
        member.id = (++sequence)
        store[member.id] = member
        return member
    }

    override fun findById(id: Long): Member? {
        return store[id]
    }

    override fun findByName(name: String): Member? {
        return store.values.firstOrNull {
            it.name == name
        }
    }

    override fun findAll(): List<Member> {
        return store.values.toList()
    }
}