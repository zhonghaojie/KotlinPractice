package ii_collections

fun example8() {
    val numbers = listOf(1, 3, -4, 2, -11)

    // The details (how multi-assignment works) will be explained later in the 'Conventions' task
    val (positive, negative) = numbers.partition { it > 0 }

    positive == listOf(1, 3, 2)
    negative == listOf(-4, -11)
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> {
    // Return customers who have more undelivered orders than delivered
//    val c=ArrayList<Customer>()
//    for(cus in customers){
//        val (delivered,undelivered)=cus.orders.partition { it.isDelivered }
//        if(delivered.size<undelivered.size){
//            c.add(cus)
//        }
//    }
//    return c.toSet()
    return customers.filter {
        val (delivered,undelivered)=it.orders.partition { it.isDelivered }
        delivered.size<undelivered.size //返回值为最后一行
    }.toSet()

}
