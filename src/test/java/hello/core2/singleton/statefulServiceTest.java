package hello.core2.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class statefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        statefulService statefulService1 = ac.getBean(statefulService.class);
        statefulService statefulService2 = ac.getBean(statefulService.class);

        //ThreadA : A 사용자가 10000원 주문
        statefulService1.order("userA", 10000);
        //ThreadB : B 사용자가 20000원 주문
        statefulService2.order("userB", 20000);

        //ThreadA : A 사용자가 주문 금액 조회 하는 도중에 B 사용자가 주문을 해버림(끼어듬)
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {
        @Bean
        public statefulService statefulService(){
            return new statefulService();
        }
    }
}