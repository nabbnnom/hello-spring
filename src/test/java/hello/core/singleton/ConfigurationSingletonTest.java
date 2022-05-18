package hello.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
	
	@Test
	void configurationTest() {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
		
		//��� ���� �ν��Ͻ��� �����ϰ� �ִ�.
		System.out.println("memberService -> memberRepository = " + memberService.getMemberRepository());
		System.out.println("orderService -> memberRepository = " + orderService.getMemberRepository());
		System.out.println("memberRepository = " + memberRepository);
		
		assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
		assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
	}
	
	@Test
	void configurationDeep() {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//AppConfig�� ���Ǹ� ������ ��ϵȴ�.
		AppConfig bean = ac.getBean(AppConfig.class);
		
		System.out.println("been = " + bean.getClass());
		//���: been = class hello.core.AppConfig$$EnhancerBySpringCGLIB$$a86a580b
		
	}

}
