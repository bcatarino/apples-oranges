package com.hmrc.shoppingcart.model

case class Order[T <: Product](product: Product, quantity: Int)