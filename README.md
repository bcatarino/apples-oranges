# apples-oranges
Shopping cart for apples and Oranges.

## Dependencies

* jre 8
* scala 2.12
* sbt

## Assumptions

* Given the nature of the exercise, I understand a simple solution that executes the business logic is enough. It's not required to build rest endpoints, in my understanding.
* Instead of using an array of strings as input, I prefer to model an Order class that allows to set the quantity for each product. I still double check if there are duplicate products on the input and sum their quantities, to make sure input is correctly processed.
* Assuming the requirement is only the function to calculate total cost and not really the checkout, so there's no need to identify the user to which the cart belongs to.
* I'm also assuming I'm supposed to create only a function that can be reused later and that I don't need to provide a main to execute the function and that a suite of unit tests is enough to prove it works.

## Run Tests

> sbt test
