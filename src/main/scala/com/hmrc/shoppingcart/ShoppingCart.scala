package com.hmrc.shoppingcart

import com.hmrc.shoppingcart.model.Order

class ShoppingCart {

  def getTotalCost(orders: List[Order[_]] = List[Order[_]]()): BigDecimal = {

    require(orders.forall(_.quantity > 0), "Each order must have at least one item")

    val totalOrders = orders.groupBy(_.product)
                            .map(ordersByProduct => Order(ordersByProduct._1, ordersByProduct._2.map(_.quantity).sum))
    totalOrders.map(Offers.getOfferPrice).sum
  }
}