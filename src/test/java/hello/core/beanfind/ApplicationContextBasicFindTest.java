package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberService;

public class ApplicationContextBasicFindTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	
	@Test
	@DisplayName("�� �̸����� ��ȸ")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("�̸� ���� Ÿ�Ը����� ��ȸ")
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
		assertThat(memberService).isInstanceOf(MemberService.class);
	}
	
	@Test
	@DisplayName("�� �̸����� ��ȸX")
	void findBeanByNameX() {
//		MemberService memberServie = ac.getBean("abcd", MemberService.class);
		Assertions.assertThrows(NoSuchBeanDefinitionException.class, ()->ac.getBean("abcd", MemberService.class));
	}
}
