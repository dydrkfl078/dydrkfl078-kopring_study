package practice_thymeleaf.kopring_prac1

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import practice_thymeleaf.kopring_prac1.repository.JdbcMemberRepo
import practice_thymeleaf.kopring_prac1.repository.MemberRepo
import practice_thymeleaf.kopring_prac1.repository.MemoryMemberRepo
import practice_thymeleaf.kopring_prac1.service.MemberService
import javax.sql.DataSource

@Configuration
class SpringConfig(private val dataSource: DataSource) {

    @Bean
    fun memberService(): MemberService {
        return MemberService(MemberRepo())
    }

    @Bean
    fun MemberRepo(): MemberRepo {
//        return MemoryMemberRepo()
        return JdbcMemberRepo(dataSource)
    }
}