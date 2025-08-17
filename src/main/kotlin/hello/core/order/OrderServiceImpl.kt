package hello.core.order

import hello.core.discount.DiscountPolicy
import hello.core.member.MemoryMemberRepo

class OrderServiceImpl(private val discountPolicy: DiscountPolicy) : OrderService {

    private val memberRepo = MemoryMemberRepo()

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {

        val member = memberRepo.findById(memberId)
        val discountPrice = discountPolicy.discount(member!!, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}