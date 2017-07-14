package ii_collections

fun example1(list: List<Int>) {

    // If a lambda has exactly one parameter, that parameter can be accessed as 'it'
    val positiveNumbers = list.filter { it > 0 }

    val squares = list.map { it * it }
}

fun Shop.getCitiesCustomersAreFrom(): Set<City> {
    // Return the set of cities the customers are from
//    val f:(Customer)->City = fun (c:Customer):City = c.city//函数对象的形式customers.map(f)

//    val list=customers.map(::func)//1、最初的形式

//    val list=customers.map(fun(c:Customer)=c.city)//2、改成匿名函数的形式

//    val list=customers.map({c->c.city})//3、转成Lambda，Lambda表达式就是一个匿名函数,

    val list = customers.map { it.city }//4、如果Lambda只有一个参数，且这个参数可以推断出类型，可以省略
    return list.toSet()
}

fun func(c: Customer): City {
    return c.city
}

fun Shop.getCustomersFrom(city: City): List<Customer> {
    // Return a list of the customers who live in the given city
//    customers.filter (fun(c:Customer):Boolean=c.city==city )
//    customers.filter { c:Customer->c.city==city }
//    customers.filter { c->c.city==city }
//    customers.filter { it.city==city }
    return customers.filter { it.city == city }

}


