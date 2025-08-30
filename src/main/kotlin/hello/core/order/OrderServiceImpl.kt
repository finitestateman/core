package hello.core.order

import hello.core.discount.DiscountPolicy
import hello.core.member.MemberRepo
import org.springframework.stereotype.Component

@Component
// @RequiredArgsConstructor
class OrderServiceImpl(
    private val memberRepo: MemberRepo,
    private val discountPolicy: DiscountPolicy
) : OrderService {

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {

        val member = memberRepo.findById(memberId)
        val discountPrice = discountPolicy.discount(member!!, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }

    // 테스트 용도
    fun getMemberRepo() = memberRepo
}