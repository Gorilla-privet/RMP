import kotlin.math.pow

fun main() {
    // Задача 1: Четное или нечетное число
    println("Введите целое число:")
    val number1 = readLine()!!.toInt()
    println("Число ${if (number1 % 2 == 0) "четное" else "нечетное"}.")

    // Задача 2: Минимальное из трех чисел
    println("Введите три целых числа:")
    val numbers = List(3) { readLine()!!.toInt() }
    println("Минимальное число: ${numbers.minOrNull()}")

    // Задача 3: Таблица умножения
    println("Таблица умножения на 5:")
    for (i in 1..10) {
        println("5 x $i = ${5 * i}")
    }

    // Задача 4: Сумма чисел от 1 до N
    println("Введите целое число N:")
    val n = readLine()!!.toInt()
    val sum = (1..n).sum()
    println("Сумма чисел от 1 до $n: $sum")

    // Задача 5: Число Фибоначчи
    println("Введите целое число N для чисел Фибоначчи:")
    val fibN = readLine()!!.toInt()
    var a = 0
    var b = 1
    println("Первые $fibN чисел Фибоначчи:")
    repeat(fibN) {
        print("$a ")
        val next = a + b
        a = b
        b = next
    }
    println()

    // Задача 6: Проверка простого числа
    println("Введите целое число для проверки на простоту:")
    val primeCandidate = readLine()!!.toInt()
    val isPrime = primeCandidate > 1 && (2 until primeCandidate).none { primeCandidate % it == 0 }
    println("$primeCandidate ${if (isPrime) "является" else "не является"} простым числом.")

    // Задача 7: Обратный порядок чисел
    println("Введите целое число N:")
    val reverseN = readLine()!!.toInt()
    println("Числа от $reverseN до 1 в обратном порядке:")
    for (i in reverseN downTo 1) {
        print("$i ")
    }
    println()

    // Задача 8: Сумма четных чисел
    println("Введите два целых числа A и B:")
    val (aRange, bRange) = readLine()!!.split(" ").map { it.toInt() }

    val evenSum = (aRange..bRange).filter { it % 2 == 0 }.sum()
    println("Сумма четных чисел от $aRange до $bRange: $evenSum")

    // Задача 9: Реверс строки
    println("Введите строку для реверса:")
    val inputString = readLine()!!
    val reversedString = inputString.reversed()
    println("Обратная строка: $reversedString")

    // Задача 10: Количество цифр в числе
    println("Введите целое число для подсчета цифр:")
    val digitCountNumber = readLine()!!
    val countDigits = digitCountNumber.replace("-", "").length
    println("Количество цифр в числе: $countDigits")

    // Задача 11: Факториал числа
    fun factorial(n: Int): Long {
        return if (n <= 1) 1 else n * factorial(n - 1)
    }

    println("Введите целое число N для вычисления факториала:")
    val factorialN = readLine()!!.toInt()
    println("$factorialN! = ${factorial(factorialN)}")

    // Задача 12: Сумма цифр числа
    println("Введите целое число для нахождения суммы цифр:")
    val sumDigitsNumber = readLine()!!
    val sumOfDigits = sumDigitsNumber.sumOf { it.toString().toInt() }
    println("Сумма цифр числа: $sumOfDigits")

    // Задача 13: Палиндром
    println("Введите строку для проверки на палиндром:")
    val palindromeString = readLine()!!
    val isPalindrome = palindromeString == palindromeString.reversed()
    println("\"$palindromeString\" ${if (isPalindrome) "является" else "не является"} палиндромом.")

    // Задача 14: Найти максимальное число в массиве
    println("Введите размер массива:")
    val arraySize14 = readLine()!!.toInt()
    val array14 = IntArray(arraySize14)
    println("Введите элементы массива:")
    for (i in array14.indices) {
        array14[i] = readLine()!!.toInt()
    }
    println("Максимальное число в массиве: ${array14.maxOrNull()}")

    // Задача 15: Сумма всех элементов массива
    val sumArray15 = array14.sum()
    println("Сумма всех элементов массива: $sumArray15")

    // Задача 16: Количество положительных и отрицательных чисел
    var positiveCount = array14.count { it > 0 }
    var negativeCount = array14.count { it < 0 }
    println("Количество положительных чисел: $positiveCount")
    println("Количество отрицательных чисел: $negativeCount")

    // Задача 17: Простые числа в диапазоне
    println("Введите два целых числа A и B для поиска простых чисел:")
    val (aRangePrimes, bRangePrimes) = readLine()!!.split(" ").map { it.toInt() }

    fun isPrime(num: Int): Boolean {
        if (num < 2) return false
        for (i in 2..Math.sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) return false
        }
        return true
    }

    println("Простые числа в диапазоне от $aRangePrimes до $bRangePrimes:")
    for (num in aRangePrimes..bRangePrimes) {
        if (isPrime(num)) print("$num ")
    }

    // Задача 18: Подсчет гласных и согласных в строке
    println("\nВведите строку для подсчета гласных и согласных букв:")
    val vowelConsonantString = readLine()!!

    val vowels = "aeiouAEIOU"
    var vowelCount18 = vowelConsonantString.count { it in vowels }
    var consonantCount18 = vowelConsonantString.count { it.isLetter() && it !in vowels }

    println("Количество гласных букв: $vowelCount18")
    println("Количество согласных букв: $consonantCount18")

    // Задача 19: Перестановка слов в строке
    println("\nВведите строку, состоящую из нескольких слов:")
    val wordsString19 = readLine()!!

    val reversedWords19 = wordsString19.split(' ').reversed().joinToString(" ")

    println("Слова в обратном порядке: $reversedWords19")

    // Задача 20: Число Армстронга
    fun isArmstrong(number: Int): Boolean {
        val digitsCount = number.toString().length
        return number == number.toString().map { it.toString().toInt().toDouble().pow(digitsCount).toInt() }.sum()
    }

    println("\nВведите целое число для проверки на число Армстронга:")
    val armstrongCandidate = readLine()!!.toInt()

    if (isArmstrong(armstrongCandidate)) {
        println("$armstrongCandidate является числом Армстронга.")
    } else {
        println("$armstrongCandidate не является числом Армстронга.")
    }
}