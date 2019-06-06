const val TAVERN_NAME: String = "Taernyl's Folly"


fun main(args: Array<String>) {
//    var beverage = readLine()
//    beverage = null
//
//    if (beverage != null) {
//        beverage = beverage.capitalize()
//    } else {
//        println("I can't do that, beverage is null")
//    }
//
//    // let example
////    beverage = beverage?.let {
////                if (it.isNotBlank()) {
////        it.capitalize()
////                } else {
////                    "Buttered Ale"
////                }
////    }
//
//    val beverageServed: String = beverage ?: "Buttered Ale"
//    println(beverageServed)
    placeOrder("shandy,Dragon's Breath,5.91")
}

private fun toDragonSpeak(phrase: String) =
        phrase.replace(Regex("[Aaeiou]")) {
            when (it.value) {
                "a" -> "4"
                "A" -> "4"
                "e" -> "3"
                "i" -> "1"
                "o" -> "0"
                "u" -> "|_|"
                else -> it.value
            }
        }

fun placeOrder(metaMenuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

//    val data = metaMenuData.split(",")
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]
    val (type, name, price) = metaMenuData.split(",")
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)

//    val phrase = "Ah, delicious $name"
//    println("Madrigal exclaims: ${toDragonSpeak(phrase)}")

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims: ${toDragonSpeak("Ah delicious $name")}"
    } else {
        "Madrigal says: Thanks for the $name"
    }
    println(phrase)
}