package hello.core

import hello.core.member.MemberRepo
import hello.core.member.MemoryMemberRepo
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["hello.core.member"],
    basePackageClasses = [AutoAppConfig::class], // 디폴트는 이 클래스가 속한 패키지와 하위 패키지
    excludeFilters = [
        ComponentScan.Filter(type = FilterType.ANNOTATION, classes = [Configuration::class])
    ]
)
class AutoAppConfig {

    @Bean(name = ["memoryMemberRepo"])
    fun memoryMemberRepo(): MemberRepo = MemoryMemberRepo()
}