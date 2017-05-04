package com.hmrc.shoppingcart

import com.hmrc.shoppingcart.model.{Order, Product}
import org.scalatest.{Matchers, WordSpec}

class OffersSpec extends WordSpec with Matchers {

  "Offers#regular" should {
    "always return quantity" in {
      Offers.regular(Order(Product("peach", 2), 5)) should be(5)
      Offers.regular(Order(Apple, 3)) should be(3)
    }
  }

  "Offers#twoForOne" should {
    "return half" in {
      Offers.twoForOne(Order(Apple, 2)) should be(1)
      Offers.twoForOne(Order(Apple, 10)) should be(5)
    }

    "round up result" in {
      Offers.twoForOne(Order(Apple, 3)) should be(2)
      Offers.twoForOne(Order(Apple, 11)) should be(6)
    }
  }

  "Offers#threeForTwo" should {
    "return two thirds" in {
      Offers.threeForTwo(Order(Apple, 6)) should be(4)
      Offers.threeForTwo(Order(Apple, 9)) should be(6)
    }

    "round up result" in {
      Offers.threeForTwo(Order(Apple, 8)) should be(6)
      Offers.threeForTwo(Order(Apple, 10)) should be(7)
    }
  }
}
