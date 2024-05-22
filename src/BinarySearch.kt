fun main() {
    var elements: IntArray = generateOrderedArray(64)

    println("From these Elements: ${elements.joinToString()}")

    binarySearch(elements, readNumber())
}

fun binarySearch(elements: IntArray, item: Int) {
    var steps: Int = 0
    var low: Int = 0
    var high: Int = elements.size - 1

    while (low <= high) {
        var middle: Int = (high + low) / 2
        var guess = elements[middle]

        steps++
        println("Step $steps: Low: $low, High: $high, Middle: $middle, Guess: $guess")

        if (guess == item) {
            println("Item found at index $middle in $steps steps")
            return
        }

        if (guess > item) {
            high = middle - 1
        } else {
            low = middle + 1
        }
    }

    println("Item not found after $steps steps")
}

fun generateOrderedArray(size: Int): IntArray {
    return IntArray(size) { it }
}

fun readNumber(): Int {
    println("Choose a number:")
    val number = readLine()?.toIntOrNull()
    return number ?: readNumber()
}