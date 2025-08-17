package hello.core.order

import hello.core.discount.FixDiscountPolicy
import hello.core.member.MemoryMemberRepo

class OrderServiceImpl : OrderService {

    private val memberRepo = MemoryMemberRepo()
    private val discountPolicy = FixDiscountPolicy()

    override fun createOrder(memberId: Long, itemName: String, itemPrice: Int): Order {

        val member = memberRepo.findById(memberId)
        val discountPrice = discountPolicy.discount(member!!, itemPrice)

        return Order(memberId, itemName, itemPrice, discountPrice)
    }
}