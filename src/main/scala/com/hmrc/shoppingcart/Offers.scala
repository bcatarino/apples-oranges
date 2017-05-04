package com.hmrc.shoppingcart

import com.hmrc.shoppingcart.model.Order

import scala.collection.immutable.HashMap

object Offers {

  private val offers = HashMap[Product, Order[_] => Int](Apple -> twoForOne, Orange -> threeForTwo)

  def regular = (order: Order[_]) => order.quantity

  def twoForOne = (order: Order[_]) => order.quantity / 2 + order.quantity % 2

  def threeForTwo = (order: Order[_]) => order.quantity / 3 * 2 + order.quantity % 3

  def getOfferPrice = (order: Order[_]) => order.product.cost.*(offers.getOrElse(order.product, regular)(order))
}
