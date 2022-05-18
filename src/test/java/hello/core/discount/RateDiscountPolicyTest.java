package hello.core.discount;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {
	
	RateDiscountPolicy discountPolicy = new RateDiscountPolicy();
	
	@Test
	@DisplayName("VIP�� 10% ������ ����Ǿ�� �Ѵ�.")
	void vip_o() {
		//given
		Member member = new Member(1L, "memberA", Grade.VIP);
		
		//when
		int discount = discountPolicy.discount(member, 20000);
		
		//then
		assertThat(discount).isEqualTo(2000);
	
	}
	
	@Test
	@DisplayName("VIP�� �ƴϸ� ������ ������� �ʾƾ� �Ѵ�.")
	void vip_x() {
		//given
		Member member = new Member(2L, "memberB", Grade.BASIC);
		
		//when
		int discount = discountPolicy.discount(member, 30000);
		
		//then
		assertThat(discount).isEqualTo(0);
	}

}
