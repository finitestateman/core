package hello.core.order

import hello.core.discount.DiscountPolicy
import hello.core.member.MemberRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class OrderServiceImpl(
    private var memberRepo: MemberRepo,
    private var discountPolicy: DiscountPolicy
) : OrderService {

    @Autowired
    fun init(memberRepo: MemberRepo, discountPolicy: DiscountPolicy) {
        this.memberRepo = memberRepo
        this.discountPolicy = discountPolicy
    }

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {

        val member = memberRepo.findById(memberId)
        val discountPrice = discountPolicy.discount(member!!, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }

    // 테스트 용도
    fun getMemberRepo() = memberRepo
}