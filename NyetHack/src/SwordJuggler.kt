fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

    println("You juggle $swordsJuggling swords!")
    juggleSwords(swordsJuggling ?: 1)
}

fun proficiencyCheck(swordsJuggling: Int?) {
//    swordsJuggling ?: throw UnskilledSwordJugglerException()
    checkNotNull(swordsJuggling) { "Player cannot juggle swords" }
}


fun juggleSwords(swordsJuggling: Int) {
    require(swordsJuggling < 3) { "Juggle at least 3 swords to be interesting" }
    println("Commence juggling !!!")
}

class UnskilledSwordJugglerException :
        IllegalStateException("Player cannot juggle swords")