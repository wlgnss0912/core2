package hello.core2;

import hello.core2.member.MemberRepository;
import hello.core2.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        //basePackages = "hello.core.member",//member만 component스캔의 대상이 된다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //기존의 AppConfig라는 class(수동으로 빈 등록?)에 @Configuration이라는 애노테이션이 있기 때문에 제외 시켜주어야한다.
)//@Component라는 애노테이션을 다 찾아서 스프링 빈으로 자동 등록
public class AutoAppConfig {

}
