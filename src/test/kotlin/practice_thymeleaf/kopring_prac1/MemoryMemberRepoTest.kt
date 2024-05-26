package practice_thymeleaf.kopring_prac1


import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import practice_thymeleaf.kopring_prac1.domain.Member
import practice_thymeleaf.kopring_prac1.repository.MemoryMemberRepo

internal class MemoryMemberRepoTest {

    @Test
    fun save() {

        val member1 = Member("member1")
        val member2 = Member("member2")

        MemoryMemberRepo.save(member1)
        MemoryMemberRepo.save(member2)

        val member1Result = MemoryMemberRepo.findById(member1.id)?.name
        val member2Result = MemoryMemberRepo.findById(member2.id)?.name

        member1Result shouldBe "member1"
        member2Result shouldBe "member2"
    }

    @Test
    fun findByName () {

        val member3 = Member("member3")
        val member4 = Member("member4")

        MemoryMemberRepo.save(member3)
        MemoryMemberRepo.save(member4)

        val member3Result = MemoryMemberRepo.findByName("member3")?.id
        val member4Result = MemoryMemberRepo.findByName("member4")?.id
        val member5Result = MemoryMemberRepo.findByName("member5")?.id

        member3Result shouldBe 1
        member4Result shouldBe 2
        member5Result shouldBe null
    }

    @Test
    fun findAll() {

        val member3 = Member("member3")
        val member4 = Member("member4")

        MemoryMemberRepo.save(member3)
        MemoryMemberRepo.save(member4)

        val memberList = MemoryMemberRepo.findAll()

        memberList.size shouldBe 2
    }
}
