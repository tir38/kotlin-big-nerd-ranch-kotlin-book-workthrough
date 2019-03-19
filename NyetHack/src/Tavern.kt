fun main(args: Array<String>) {
    var beverage = readLine()

    beverage = null

    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that, beverage is null")
    }

    // let example
//    beverage = beverage?.let {
//                if (it.isNotBlank()) {
//        it.capitalize()
//                } else {
//                    "Buttered Ale"
//                }
//    }

    val beverageServed: String = beverage ?: "Buttered Ale"

    println(beverageServed)
}