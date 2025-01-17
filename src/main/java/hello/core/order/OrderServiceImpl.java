package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long MemberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(MemberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(MemberId, itemName, itemPrice, discountPrice);
    }

    //Test 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
