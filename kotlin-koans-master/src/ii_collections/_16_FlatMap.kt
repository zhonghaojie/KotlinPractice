package ii_collections

fun example() {
    val result = listOf("abc", "12").flatMap { it.toList() }
    result == listOf('a', 'b', 'c', '1', '2')
}
val Customer.orderedProducts: Set<Product> get() {
    // Return all products this customer has ordered
//    val list=ArrayList<Product>()
//    orders.forEach { list.addAll(it.products) }
//    return orders.flatMap (fun(order:Order):List<Product> = order.products ).toSet()
//    return orders.flatMap { order:Order->order.products }.toSet()
//    return orders.flatMap { order->order.products }.toSet()
    return orders.flatMap { it.products }.toSet()
}

val Shop.allOrderedProducts: Set<Product> get() {
    // Return all products that were ordered by at least one customer
    return customers.flatMap { it.orders }.flatMap { it.products }.toSet()
//    return customers.flatMap { it.orderedProducts }.toSet()//官网答案
}
