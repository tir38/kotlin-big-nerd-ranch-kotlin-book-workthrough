import kotlin.math.min

fun main(args: Array<String>) {
    val name = "Madrigal"
    val healthPoints = 100
    val healthStatus = formatHealthStatus(healthPoints, true)
    println("$name $healthStatus")

    val inebriationValue = castFireball()
    println(inebriationStatus(inebriationValue))
}

private fun inebriationStatus(inebriationValue: Int): String =
        when (inebriationValue) {
            in 1..10 -> "tipsy"
            in 11..20 -> "sloshed"
            in 21..30 -> "soused"
            in 31..40 -> "stewed"
            in 41..50 -> "..t0aSt3d"
            else -> {
                throw NotImplementedError()
            }
        }

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String =
        when (healthPoints) {
            100 -> "is in excellent condition"
            in 90..99 -> "has a few scratches"
            in 80..89 -> if (isBlessed) {
                "has some minor wounds, but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }
            else -> "is probably dying"
        }

private fun castFireball(numFireballs: Int = 2): Int {
    println("A glass of fireball springs into existence. (x$numFireballs)")
    // return inebriation value based on number of fireballs, with a max of 50
    return min(numFireballs * 10, 50)
}