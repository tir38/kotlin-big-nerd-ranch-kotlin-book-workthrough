fun main(args: Array<String>) {

//    val greetingFunction: (String, Int) -> String = { playerName, numBuildings ->
//        val currentYear = 2018
//        println("Adding $numBuildings houses")
//        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
//    }
//
//    runSimulation("Guyal", :: printConstructionCost) { playerName: String, numBuildings: Int ->
//        val currentYear = 2018
//        println("Adding $numBuildings houses")
//        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
//    }

//    println(greetingFunction("Guyal", 4))
//    println(greetingFunction2("Guyal", 4))

    runSimulation()

}

fun runSimulation() {
    val greetingsFunction = configureGreetingFunction()
    println(greetingsFunction("Guyal"))
}

fun printConstructionCost(numBuildings: Int) {
    val cost = 500
    println("construction cost: ${cost * numBuildings}")
}

fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}
