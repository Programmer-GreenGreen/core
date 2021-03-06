package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean(){

        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName); //오브젝트 꺼내기
            System.out.println("name = " +beanDefinitionName + "object"  + bean );
        }
    } @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean(){

        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 스프링에 등록된 모든 빈 이름 조회
        for (String beanDefinitionName : beanDefinitionNames) {
            //beanDefinition => Bean 하나하나에 대한 메타정보
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //ROLE_APPLICATION => 일반적으로 사용자가 정의한 빈
            //ROLE_INFRASTRUCTURE => 스프링이 내부에서 사용하는 빈
          
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName); //오브젝트 꺼내기

                System.out.println("name = " + beanDefinitionName + "object" + bean);
            }
        }
    }
}
