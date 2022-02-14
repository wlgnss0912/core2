package hello.core2.autowired;

import hello.core2.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean {

        @Autowired(required = false)
        public void setNoBean1(Member member1){
            System.out.println("member1 = " + member1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member member2){
            System.out.println("member2 = " + member2);
        }

        @Autowired
        public void setNoBean2(Optional<Member> member3){
            System.out.println("member3 = " + member3);
        }

    }
}
