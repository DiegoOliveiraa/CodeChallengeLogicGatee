import java.util.*

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
fun main() {
    val input = Scanner(System.`in`)
    val n = input.nextInt()
    val m = input.nextInt()

    val signalData = mutableMapOf<String, String>()

    for (i in 0 until n) {
        val inputName = input.next()
        val inputSignal = input.next()
        signalData[inputName] = inputSignal
    }

    val resultData = mutableMapOf<String, String>()

    for (i in 0 until m) {
        val outputName = input.next()
        val type = input.next()
        val inputName1 = input.next()
        val inputName2 = input.next()

        val inputSignal1 = signalData[inputName1]!!
        val inputSignal2 = signalData[inputName2]!!

        val outputSignal = when (type) {
            "AND" -> andGate(inputSignal1, inputSignal2)
            "OR" -> orGate(inputSignal1, inputSignal2)
            "XOR" -> xorGate(inputSignal1, inputSignal2)
            "NAND" -> nandGate(inputSignal1, inputSignal2)
            "NOR" -> norGate(inputSignal1, inputSignal2)
            "NXOR" -> nxorGate(inputSignal1, inputSignal2)
            else -> throw IllegalArgumentException("Invalid gate type: $type")
        }

        resultData[outputName] = outputSignal
    }

    for ((outputName, outputSignal) in resultData) {
        println("$outputName $outputSignal")
    }
}

fun andGate(input1: String, input2: String): String {
    return input1.zip(input2) { a, b -> if (a == '-' && b == '-') '-' else '_' }.joinToString("")
}

fun orGate(input1: String, input2: String): String {
    return input1.zip(input2) { a, b -> if (a == '_' && b == '_') '_' else '-' }.joinToString("")
}

fun xorGate(input1: String, input2: String): String {
    return input1.zip(input2) { a, b -> if (a == b) '_' else '-' }.joinToString("")
}

fun nandGate(input1: String, input2: String): String {
    return input1.zip(input2) { a, b -> if (a == '_' || b == '_') '-' else '_' }.joinToString("")
}

fun norGate(input1: String, input2: String): String {
    return input1.zip(input2) { a, b -> if (a == '-' || b == '-') '_' else '-' }.joinToString("")
}

fun nxorGate(input1: String, input2: String): String {
    return input1.zip(input2) { a, b -> if (a != b) '_' else '-' }.joinToString("")
}
