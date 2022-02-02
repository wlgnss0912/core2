package hello.core2;

import hello.core2.member.Grade;
import hello.core2.member.Member;
import hello.core2.member.MemberService;
import hello.core2.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//순수 자바로 검증하는 방법(좋지 않음)
public class MemberApp {
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberSerivce = applicationContext.getBean("memberService", MemberService.class);//이름(기본적으로 이름이 AppConfig의 메서드 이름으로 등록된다), 타입

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberSerivce.join(member);

        Member findMember = memberSerivce.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find member = " + findMember.getName());
    }
}
