package practice_thymeleaf.kopring_prac1.service

import practice_thymeleaf.kopring_prac1.domain.Member
import practice_thymeleaf.kopring_prac1.repository.MemoryMemberRepo

class MemberService {

    fun join(member : Member): Long {
        MemoryMemberRepo.findByName(member.name)?.let {
            throw IllegalStateException("이미 존재하는 회원입니다.")
        } ?: MemoryMemberRepo.save(member)

        return member.id
    }

    fun findMembers(): List<Member> {
        return MemoryMemberRepo.findAll()
    }

    fun findOne(id: Long): Member? {
        return MemoryMemberRepo.findById(id)
    }
}