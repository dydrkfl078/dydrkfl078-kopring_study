package practice_thymeleaf.kopring_prac1

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import practice_thymeleaf.kopring_prac1.repository.MemoryMemberRepo
import practice_thymeleaf.kopring_prac1.service.MemberService

@Configuration
class SpringConfig {

    @Bean
    fun memberService(): MemberService {
        return MemberService(memoryMemberRepo())
    }

    @Bean
    fun memoryMemberRepo(): MemoryMemberRepo {
        return MemoryMemberRepo()
    }
}