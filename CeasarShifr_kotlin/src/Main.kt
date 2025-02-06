import java.io.File
import java.io.PrintWriter
import java.util.Scanner


fun encrypt(scanner: Scanner) {
    println("Введите путь к файлу для шифрования:")
    val inputFilePath = scanner.nextLine()

    println("Введите ключ для шифрования:")
    val shift = scanner.nextInt()
    scanner.nextLine()

    println("Введите путь к файлу для зашифрованного текста:")
    val outputFilePath = scanner.nextLine()

    val input = File(inputFilePath).readText()
    val encrypted = caesarEncrypt(input, shift)

    PrintWriter(File(outputFilePath)).use { writer ->
        writer.println(encrypted)
    }

    println("Текст зашифрован и записан в файл.")
}

fun decrypt(scanner: Scanner) {
    println("Введите путь к файлу с зашифрованным текстом:")
    val inputFilePath = scanner.nextLine()

    println("Введите ключ для расшифровки:")
    val shift = scanner.nextInt()
    scanner.nextLine()

    println("Введите путь к файлу для расшифрованного текста:")
    val outputFilePath = scanner.nextLine()

    val input = File(inputFilePath).readText()
    val decrypted = caesarDecrypt(input, shift)

    PrintWriter(File(outputFilePath)).use { writer ->
        writer.println(decrypted)
    }

    println("Текст расшифрован и записан в файл.")
}

fun bruteForceDecrypt(scanner: Scanner) {
    println("Введите путь к файлу с зашифрованным текстом:")
    val inputFilePath = scanner.nextLine()

    val input = File(inputFilePath).readText()

    println("Введите путь к файлу для записи результатов brute force расшифровки:")
    val outputFilePath = scanner.nextLine()

    PrintWriter(File(outputFilePath)).use { writer ->
        for (shift in 0 until 33) {
            val decrypted = caesarDecrypt(input, shift)
            writer.println("Ключ $shift: $decrypted")
        }
    }
    println("Расшифрование записано в файл.")
}

fun statisticalDecrypt(scanner: Scanner) {
    println("Введите путь к файлу с зашифрованным текстом:")
    val inputFilePath = scanner.nextLine()

    println("Введите путь к файлу для расшифрованного текста:")
    val outputFilePath = scanner.nextLine()

    val input = File(inputFilePath).readText()

    val frequency = input.lowercase().filter { it in 'а'..'я' }.groupingBy { it }.eachCount()
    val mostFrequentChar = frequency.entries.maxByOrNull { it.value }?.key

    if (mostFrequentChar != null) {
        val assumedChar = 'о' // Предполагаем, что самый частый символ - это "о"
        val alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
        val shift = alphabet.indexOf(mostFrequentChar) - alphabet.indexOf(assumedChar)
        val normalizedShift = (shift % alphabet.length + alphabet.length) % alphabet.length //Ensure shift is positive and within alphabet length

        val decrypted = caesarDecrypt(input, normalizedShift)
        PrintWriter(File(outputFilePath)).use { writer ->
            writer.println(decrypted)
        }
        println("Текст расшифрован с помощью статистического анализа и записан в файл.")
        println("Предполагаемый ключ: $normalizedShift")


    } else {
        println("Не удалось определить наиболее частый символ.")
    }
}

fun caesarEncrypt(text: String, shift: Int): String {
    val alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
    val result = StringBuilder()

    for (char in text) {
        if (char.isLetter()) {
            val alphabetIndex = alphabet.indexOf(char.lowercaseChar())
            if (alphabetIndex != -1) {
                val newIndex = (alphabetIndex + shift) % alphabet.length
                result.append(if (char.isUpperCase()) alphabet[newIndex].uppercaseChar() else alphabet[newIndex])
            } else {
                result.append(char)
            }
        } else {
            result.append(char)
        }
    }

    return result.toString()
}
fun caesarDecrypt(text: String, shift: Int): String {
    val normalizedShift = shift % 32
    val decryptionShift = if (normalizedShift >= 0) {
        32 - normalizedShift
    } else {
        normalizedShift + 32
    }
    return caesarEncrypt(text, decryptionShift % 32)
}
fun main() {
    val scanner = Scanner(System.`in`)
    println("Выберите режим:")
    println("1. Шифрование текста")
    println("2. Расшифрование текста с ключом")
    println("3. Расшифрование текста с помощью brute force")
    println("4. Расшифрование текста с помощью статистического анализа")

    val choice = scanner.nextInt()
    scanner.nextLine()

    when (choice) {
        1 -> encrypt(scanner)
        2 -> decrypt(scanner)
        3 -> bruteForceDecrypt(scanner)
        4 -> statisticalDecrypt(scanner)
        else -> println("Неправильный выбор. Пожалуйста, попробуйте снова.")
    }
}