fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 100

    val healthStatus = if (healthPoints == 100) {
        "is in excellent condition"
    } else if (healthPoints in 90..99) {
        "has a few scratches"
    } else {
        "is probably dying"
    }
    println("$name $healthStatus")

    val healthStatus2 = when (healthPoints) {
        100 -> "is in excellent condition"
        in 90..99 -> "has a few scratches"
        else -> "is probably dying"
    }
    println("$name $healthStatus2")
}