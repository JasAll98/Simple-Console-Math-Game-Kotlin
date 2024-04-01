import java.util.*
import kotlin.concurrent.timerTask
import kotlin.system.exitProcess

val timer = Timer()
val scanner = Scanner(System.`in`)

fun main() {

    var time = 60
    var score = 0

    println("O'yin turini tanlashingiz bilan\nSizga 1 daqiqa vaqt beriladi")
    print("O'yin turini tanlang: ( + | - | x ) ")
    val gameMode: String = scanner.next()
    println("Vaqt ketti...")
    timer.run {
        scheduleAtFixedRate(timerTask {
            time--
            if (time < 0) {
                timer.cancel()
                println(" * * * * * * * * * * * * * ")
                println("1 daqiqa davomida to'plagan balingiz: $score")
                exitProcess(0)
            }
        }, 0, 1000)
    }
    while (true) {
        val x = (10..99).random()
        val y = (10..99).random()
        print("$x $gameMode $y = ")
        val natija = scanner.nextInt()
        when (gameMode) {
            "+" -> {
                if (x + y == natija) {
                    score++
                } else {
                    print("Game over! Siz to'plagan ball $score")
                    break
                }
            }

            "-" -> {
                if (x - y == natija) {
                    score++
                } else {
                    print("Game over! Siz to'plagan ball $score")
                    break
                }
            }

            "x" -> {
                if (x * y == natija) {
                    score++
                } else {
                    print("Game over! Siz to'plagan ball $score")
                    break
                }
            }
        }
    }
    timer.cancel()
}