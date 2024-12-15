import kotlin.system.measureTimeMillis

fun main() {
    while (true) {
        println("\nSeleccione una opcion:")
        println("1. Ordenar una lista usando Bubble Sort")
        println("2. Ordenar una lista usando Quick Sort")
        println("3. Calcular el factorial de un numero")
        println("4. Resolver las Torres de Hanoi")
        println("5. Salir")
        print("Opcion: ")

        when (readLine()?.toIntOrNull()) {
            1 -> bubbleSortOption()
            2 -> quickSortOption()
            3 -> factorialOption()
            4 -> hanoiOption()
            5 -> {
                println("Saliendo del programa...")
                break
            }
            else -> println("Opción no válida. Intente nuevamente.")
        }
    }
}

fun bubbleSortOption() {
    print("Ingrese una lista de numeros separados por comas: ")
    val input = readLine()
    val numbers = input?.split(",")?.mapNotNull { it.trim().toIntOrNull() }

    if (numbers.isNullOrEmpty()) {
        println("Entrada no válida.")
        return
    }

    val time = measureTimeMillis {
        val sortedList = bubbleSort(numbers)
        println("Lista ordenada usando Bubble Sort: $sortedList")
    }
    println("Tiempo de ejecucion: ${time / 1000.0} segundos")
}

fun bubbleSort(list: List<Int>): List<Int> {
    val mutableList = list.toMutableList()
    for (i in mutableList.indices) {
        for (j in 0 until mutableList.size - i - 1) {
            if (mutableList[j] > mutableList[j + 1]) {
                val temp = mutableList[j]
                mutableList[j] = mutableList[j + 1]
                mutableList[j + 1] = temp
            }
        }
    }
    return mutableList
}

fun quickSortOption() {
    print("Ingrese una lista de numeros separados por comas: ")
    val input = readLine()
    val numbers = input?.split(",")?.mapNotNull { it.trim().toIntOrNull() }

    if (numbers.isNullOrEmpty()) {
        println("Entrada no válida.")
        return
    }

    val time = measureTimeMillis {
        val sortedList = quickSort(numbers)
        println("Lista ordenada usando Quick Sort: $sortedList")
    }
    println("Tiempo de ejecucion: ${time / 1000.0} segundos")
}

fun quickSort(list: List<Int>): List<Int> {
    if (list.size < 2) return list
    val pivot = list[list.size / 2]
    val less = list.filter { it < pivot }
    val equal = list.filter { it == pivot }
    val greater = list.filter { it > pivot }
    return quickSort(less) + equal + quickSort(greater)
}

fun factorialOption() {
    print("Ingrese un numero: ")
    val input = readLine()?.toIntOrNull()

    if (input == null || input < 0) {
        println("Entrada no válida. Ingrese un número entero positivo.")
        return
    }

    println("El factorial de $input es: ${factorial(input)}")
}

fun factorial(n: Int): Long {
    return if (n == 0 || n == 1) 1 else n * factorial(n - 1)
}

fun hanoiOption() {
    print("Ingrese el numero de discos: ")
    val disks = readLine()?.toIntOrNull()

    if (disks == null || disks <= 0) {
        println("Entrada no válida. Ingrese un número entero positivo.")
        return
    }

    println("Resolviendo las Torres de Hanoi para $disks discos:")
    hanoi(disks, "A", "C", "B")
}

fun hanoi(n: Int, from: String, to: String, aux: String) {
    if (n == 1) {
        println("Mover disco 1 de Torre $from a Torre $to")
        return
    }
    hanoi(n - 1, from, aux, to)
    println("Mover disco $n de Torre $from a Torre $to")
    hanoi(n - 1, aux, to, from)
}
