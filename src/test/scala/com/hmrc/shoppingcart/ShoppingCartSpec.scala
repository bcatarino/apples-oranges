package com.hmrc.shoppingcart

import com.hmrc.shoppingcart.model.{Order, Product}
import org.scalatest.{Matchers, WordSpec}

class ShoppingCartSpec extends WordSpec with Matchers {

  val shoppingCart = new ShoppingCart

  "ShoppingCart#getTotalCost" should {
    "return 0 if no input" in {
      shoppingCart.getTotalCost() should be(0)
    }

    "return 0 if empty list" in {
      shoppingCart.getTotalCost(List()) should be(0)
    }

    "throw IllegalArgumentException if quantity = 0" in {
      assertThrows[IllegalArgumentException] {
        shoppingCart.getTotalCost(List(Order(Apple, 0))) should be(0)
      }
    }

    "return total if order has apples" in {
      shoppingCart.getTotalCost(List(Order(Apple, 2))) should be(1.2)
    }

    "merge orders of same item" in {
      shoppingCart.getTotalCost(List(Order(Apple, 2), Order(Apple, 1))) should be(1.8)
    }

    "return total if order has oranges" in {
      shoppingCart.getTotalCost(List(Order(Orange, 4))) should be(1)
    }

    "return total if order has non-standard product" in {
      shoppingCart.getTotalCost(List(Order(Product("peach", 0.3), 2))) should be(0.6)
    }

    "return total if order has both oranges and apples" in {
      shoppingCart.getTotalCost(List(Order(Orange, 4), Order(Apple, 2), Order(Orange, 1))) should be(2.45)
    }

    "throw IllegalArgumentException if quantity < 0" in {
      assertThrows[IllegalArgumentException] {
        shoppingCart.getTotalCost(List(Order(Apple, -1)))
      }
    }
  }
}
