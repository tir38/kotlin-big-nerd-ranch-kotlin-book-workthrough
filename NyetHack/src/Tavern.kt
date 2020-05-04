import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME: String = "Taernyl's Folly"

var playerGold: Int = 10
var playerSilver: Int = 10

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
//    placeOrder("shandy,Dragon's Breath,5.91")

    applyExperiment()
}

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance = totalPurse - price
//    println("Remaining balance: $remainingBalance")
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    val remainingGold = remainingBalance.toInt() // will this always round down??
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt() // round to int will lose/add a fraction of a silver
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
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

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims: ${toDragonSpeak("Ah delicious $name")}"
    } else {
        "Madrigal says: Thanks for the $name"
    }
    println(phrase)
}

fun applyExperiment() {
    val file = File("somefile.txt").apply {
        setReadable(true)
    }

    file.setReadable(false)

    // can apply be used outside of object creation?
    file.apply {
        // yest I can!!
        setReadable(true)
    }

    // because of relative scoping i can do stuff like this
    file.apply {
        val someBool = true
        setReadable(someBool)
    }

    file.apply {
        val someBool = false
        // Because someBool was relatively scoped above,  I can "reuse" the name again here w/out interference,
        // and w/out having to make someBool mutable !!!
        setReadable(someBool)
    }
}

fun letExperiment() {
    val i = listOf(1, 3, 5).first().let {
        it * it
    }
}
