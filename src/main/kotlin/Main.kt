fun main() {
println(agoToText(20000))
}
fun agoToText(seconds: Int): String {
    var result = when (seconds) {
        in 0..60 -> "был(а) в сети только что"
        in 60..60 * 60 -> "был(а) в сети ${seconds/60} ${correctFormMinute(seconds)} назад"
        in 60 * 60..24 * 60 * 60 -> "был(а) в сети ${seconds/60/60} ${correctFormHour(seconds)} назад"
        in 24 * 60 * 60..24 * 60 * 60 * 2 -> "был(а) в сети вчера"
        in 24 * 60 * 60 * 2..24 * 60 * 60 * 3 -> "был(а) в сети позавчера"
        in 24 * 60 * 60 * 3..24 * 60 * 60 * 4 -> "был(а) в сети давно"
        else -> "был(а) в сети очень давно"
    }
    return result
}

fun correctFormMinute(seconds: Int): String {
    var correct = when {
        (seconds / 60)%10 == 1 && (seconds / 60) % 100 != 11 ->  "минуту"
        (seconds / 60) % 10 == 2 || (seconds / 60) % 10 == 3 || (seconds / 60) % 10 == 4 -> "минуты"
        else -> "минут"
    }
    return correct
}
fun correctFormHour(seconds: Int): String {
    var correctHour = when {
        (seconds / 60 / 60)%10 == 1 && (seconds / 60 / 60) % 100 != 11 ->  "час"
        (seconds / 60 / 60) % 10 == 2 || (seconds / 60 / 60) % 10 == 3 || (seconds / 60 / 60) % 10 == 4 -> "часа"
        else -> "часов"
    }
    return correctHour
}