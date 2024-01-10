fun main() {
    val name = "Pavel"

    val massage = howLongOnline(172801)
    println("$name $massage")
}

fun howLongOnline(second: Int): String {
    val minute = 60
    val hour   = minute * minute
    val day    = 24 * hour
    val arrayMinutesString = arrayOf("минуту", "минуты", "минут")
    val arrayHourString    = arrayOf("час", "часа", "часов")

    return when {
        second <= 60 -> "был(а) только что"
        second <= hour -> "был(а) в сети ${second / minute} ${timeString(second / minute, arrayMinutesString)} назад"
        second <= day -> "был(а) в сети ${second / hour} ${timeString(second / hour, arrayHourString)} назад"
        second <= day * 2 -> "был(а) в сети вчера"
        second <= day * 3 -> "был(а) в сети позавчера"
        else -> "был(а) в сети давно"
    }
}

fun timeString(time: Int, array: kotlin.Array<String>): String {
    val n1 = time % 100;
    val n2 = n1 % 10;

    return when {
        n2 == 1 && n1 != 11 -> array[0]
        n2 in 2..4 -> array[1]
        else -> array[2]
    }
}

