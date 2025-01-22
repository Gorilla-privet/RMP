import 'dart:math' as Math;

// 1. Функция для нахождения максимума
int findMax(int a, int b) {
  if (a == b) {
    throw Exception("Числа равны.");
  }
  return (a > b) ? a : b;
}
// 2. Калькулятор деления
double divide(double numerator, double denominator) {
  if (denominator == 0) {
    throw Exception("Недопустимо деление на ноль.");
  }
  return numerator / denominator;
}

// 3. Конвертер строк в числа
int stringToInt(String str) {
  try {
    return int.parse(str);
  } catch (e) {
    throw FormatException("Невозможно конвертировать строку в целое число.");
  }
}

// 4. Проверка возраста
void checkAge(int age) {
  if (age < 0 || age > 150) {
    throw ArgumentError("Возраст должен быть в диапазоне от 0 до 150.");
  }
}

// 5. Нахождение корня
double squareRoot(double number) {
  if (number < 0) {
    throw ArgumentError("Невозможно найти корень из отрицательного числа.");
  }
  return Math.sqrt(number);
}

// 6. Факториал
int factorial(int n) {
  if (n < 0) {
    throw Exception("Факториал не определен для отрицательных чисел.");
  }
  return n == 0 ? 1 : n * factorial(n - 1);
}

// 7. Проверка массива на нули
void checkArrayForZeros(List<int> array) {
  if (array.contains(0)) {
    throw Exception("Массив содержит нули.");
  }
}

// 8. Калькулятор возведения в степень
double power(double base, int exponent) {
  if (exponent < 0) {
    throw Exception("Степень не может быть отрицательной.");
  }
  return Math.pow(base, exponent).toDouble();
}

// 9. Обрезка строки
String trimString(String str, int length) {
  if (length > str.length) {
    throw Exception("Число символов больше длины строки.");
  }
  return str.substring(0, length);
}

//10. Поиск элемента в массиве
int findElementInArray(List<int> array, int element) {
  int index = array.indexOf(element);
  if (index == -1) {
    throw Exception("Элемент не найден в массиве.");
  }
  return index;
}

//11. Конвертация в двоичную систему
String convertToBinary(int number) {
  if (number < 0) {
    throw Exception("Отрицательные числа не могут быть конвертированы в двоичную систему.");
  }
  return number.toRadixString(2);
}

//12. Проверка делимости
bool isDivisible(int a, int b) {
  if (b == 0) {
    throw Exception("Недопустимо деление на ноль.");
  }
  return a % b == 0;
}

//13. Чтение элемента списка
T getElementFromList<T>(List<T> list, int index) {
  if (index < 0 || index >= list.length) {
    throw IndexError(index, list);
  }
  return list[index];
}

//14. Парольная проверка
void checkPasswordComplexity(String password) {
  if (password.length < 8) {
    throw Exception("Пароль должен содержать не менее 8 символов.");
  }
}

//15. Проверка даты
void checkDate(String dateStr) {
  RegExp dateRegex = RegExp(r'^\d{2}\.\d{2}\.\d{4}$');
  if (!dateRegex.hasMatch(dateStr)) {
    throw FormatException(
        "Неверный формат даты. Ожидается формат 'dd.MM.yyyy'.");
  }
}

//16. Конкатенация строк
String concatenateStrings(String? str1, String? str2) {
  if (str1 == null || str2 == null) {
    throw Exception("Одна из строк равна null.");
  }
  return str1 + str2;
}

//17. Остаток от деления
int remainder(int a, int b) {
  if (b == 0) {
    throw Exception("Недопустимо деление на ноль.");
  }
  return a % b;
}

//18. Квадратный корень
double squareRootFunction(double number) {
  if (number < 0) {
    throw ArgumentError("Невозможно найти квадратный корень из отрицательного числа.");
  }
  return Math.sqrt(number);
}

//19. Конвертер температуры
double celsiusToFahrenheit(double celsius) {
  const double absoluteZeroCelsius = -273.15;
  if (celsius < absoluteZeroCelsius) {
    throw Exception("Температура ниже абсолютного нуля.");
  }
  return celsius * (9 / 5) + 32;
}

//20. Проверка строки на пустоту
void checkStringIsEmpty(String? str) {
  if (str == null || str.isEmpty) {
    throw Exception("Строка пустая или равна null.");
  }
}

void main() {
  try {
    print('Максимум из чисел (10 и 11): ${findMax(10,11)}');
  } catch(e) { print(e); }

  try {
    print('Результат деления (49 / 7): ${divide(49,7)}');
  } catch(e) { print(e); }

  try {
    print('Строка "567" конвертирована в число: ${stringToInt("567")}');
  } catch(e) { print(e); }

  try {
    checkAge(25);
    print('Возраст корректен: 52');
  } catch(e) { print(e); }

  try {
    print('Квадратный корень из числа (81): ${squareRoot(81)}');
  } catch(e) { print(e); }

  try {
    print('Факториал числа (6): ${factorial(5)}');
  } catch(e) { print(e); }

  try {
    List<int> array = [1,2,3];
    checkArrayForZeros(array);
    print('Массив [1,2,3] не содержит нулей.');
  } catch(e) { print(e); }

  try {
    print('Возведение в степень (4^2): ${power(4,2)}');
  } catch(e) { print(e); }

  try {
    print('Обрезанная строка "Hello. How are you?" до первых 7 символов: "${trimString("Hello. How are you?",7)}"');
  } catch(e) { print(e); }

  try {
    List<int> array = [1,2,3];
    print('Индекс элемента "1" в массиве [1,2,3]: ${findElementInArray(array,1)}');
  } catch(e) { print(e); }

  try {
    print('Двоичное представление числа "20": ${convertToBinary(20)}');
  } catch(e) { print(e); }

  try {
    print('Проверка делимости (49 на 7): ${isDivisible(49,7)}');
  } catch(e) { print(e); }

  try {
    List<String> list = ['a', 'b', 'c'];
    print('Элемент списка по индексу "1": ${getElementFromList(list,1)}');
  } catch(e) { print(e); }

  try {
    checkPasswordComplexity("password123");
    print("Пароль 'password123' - корректный");
  } catch(e) { print(e);
  }

  try {
    checkDate("23.01.2023");
    print("Дата '23.01.2023' - корректная");
  } catch(e) { print(e);;
  }

  try {
    String result = concatenateStrings('Hello', 'How are you');
    print('Конкатенация строк "Hello" и "How are you": $result');
  } catch(e) { print(e); }

  try {
    print('Остаток от деления (10 % 3): ${remainder(10,3)}');
  } catch(e) { print(e); }

  try {
    print('Квадратный корень из числа (81): ${squareRootFunction(81)}');
  } catch(e) { print(e); }

  try {
    print('Температура в Фаренгейтах при Цельсии "67": ${celsiusToFahrenheit(25)}');
  } catch(e) { print(e); }

  try {
    checkStringIsEmpty('');
    print('Строка не пустая.');
  } catch(e) { print(e); }
}
