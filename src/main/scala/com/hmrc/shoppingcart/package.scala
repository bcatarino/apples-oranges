package com.hmrc

package object shoppingcart {

  object Apple extends model.Product("apple", BigDecimal(0.6))

  object Orange extends model.Product("orange", BigDecimal(0.25))
}