

// SENTENCIA 'IF'

  // permite especificar una sección de código que se ejecuta sólo si una condición dada es verdadera.

        var n = 34

        if (n % 2 == 0) {
          println("$n is even") // muestra: "34 is even"
        }

  // las llaves son opcionales si el cuerpo de la sentencia 'if' contiene una única línea:
    
        if (n % 2 == 0) println("$n is even")

  // if con rangos -> la sección de código se ejecuta sólo si se cumple un rango especificado

        val fish = 50
        if (fish in 1..100) println(fish)      


// SENTENCIA 'IF-ELSE'

  // la sentencia if-else ejecuta una sección de código si la condición es verdadera y la otra si la condición es falsa.

        var a = 32
        var b = 55

        if (a > b) {
            println("max($a, $b) = $a")
        } else {
            println("max($a, $b) = $b")
        }
        // muestra: "max(32, 55) = 55"


  // USANDO 'IF' COMO UNA EXPRESIÓN

    // En Kotlin, puedes usar if como una expresión en lugar de una declaración. Por ejemplo, puede asignar el resultado
    // de una expresión if-else a una variable.

    // Cuando se usa 'if' como expresión se requiere tener una rama 'else', de lo contrario, el compilador lanzará un error.

        var a = 32
        var b = 55

        var max = if (a > b) a else b
        println("max($a, $b) = $max")   // muestra: "max(32, 55) = 55"


    // las sentencias if-else también pueden tener cuerpos de bloque
    // en el caso de los cuerpos de los bloques, la última expresión es el valor del bloque:

        var a = 32
        var b = 55

        var max = if (a > b) {
            println("$a is greater than $b")
            a     // a es el valor final del bloque
        } else {
            println("$a is less than or equal to $b")
            b     // b es el valor final del bloque
        }
        println("max($a, $b) = $max")

        // Output:
        // 32 is less than or equal to 55
        // max(32, 55) = 55

    // a diferencia de Java, Kotlin no tiene un operador ternario


      // SENTENCIA 'IF-ELSE-IF'

        // se pueden encadenar múltiples bloques 'if-else-if':

            var age = 17

            if (age < 12) {
                println("Child")
            } else if (age in 12..17) {
                println("Teen")
            } else if (age in 18..21) {
                println("Young Adult")
            } else if (age in 22..30) {
                println("Adult")
            } else if (age in 30..50) {
                println("Middle Aged")
            } else {
                println("Old")
            }
            // muestra: "Teen"
  

//  EXPRESIÓN 'WHEN'

  // Es el equivalente a 'switch' de Java, siendo más conciso y poderoso

  // ejemplo con sentencia única por rama:
      
        var dayOfWeek = 4

        when (dayOfWeek) {
            1 -> println("Monday")
            2 -> println("Tuesday")
            3 -> println("Wednesday")
            4 -> println("Thursday")
            5 -> println("Friday")
            6 -> println("Saturday")
            7 -> println("Sunday")
            else -> println("Invalid Day")
        }
        // output: "Thursday"

  // ejemplo con bloque de sentencias por rama:

      var dayOfWeek = 1

      when (dayOfWeek) {
          1 -> {
              // block
              println("Monday")
              println("First day of the week")
          }
          7 -> println("Sunday")
          else -> println("Other days")
      }

  
  // USANDO 'WHEN' COMO EXPRESIÓN

    // se puede usar como una expresión y asignársela a una variable:
    
        var dayOfWeek = 4

        var dayOfWeekInString = when(dayOfWeek) {
            1 -> "Monday"
            2 -> "Tuesday"
            3 -> "Wednesday"
            4 -> "Thursday"
            5 -> "Friday"
            6 -> "Saturday"
            7 -> "Sunday"
            else -> "Invalid Day"
        }

        println("Today is $dayOfWeekInString")	// Today is Thursday


  // COMBINANDO MÚLTIPLES RAMAS 'WHEN' EN UNA USANDO COMA
  
    // ejemplo

        var dayOfWeek = 6

        when (dayOfWeek) {
            1, 2, 3, 4, 5 -> println("Weekday")
            6, 7 -> println("Weekend")
            else -> println("Invalid Day")
        }
        // output: Weekend

  // COMPROBACION DE SI UN VALOR DADO ESTÁ EN UN RANGO DADO O NO UTILIZANDO EL OPERADOR 'IN'

    // el operador 'in' permite verificar si un valor pertenece a un rango o colección:

        var dayOfMonth = 5

        when (dayOfMonth) {
            in 1..7 -> println("We're in the first Week of the Month")
            !in 15..21 -> println("We're not in the third week of the Month")
            else -> println("none of the above")
        }
        // output: We're in the first Week of the Month

  // COMPROBACION DE SI UNA VARIABLE ES DE UN CIERTO TIPO O NO USANDO EL OPERADOR 'IS'
  
      var x : Any = 6.86
      when (x) {
          is Int -> println("$x is an Int")
          is String -> println("$x is a String")
          !is Double -> println("$x is not Double")
          else -> println("none of the above")
      }
      // output: none of the above


  // USANDO 'WHEN' COMO SUSTITUCIÓN DE UNA CADENA 'IF-ELSE-IF'
    
      // ejemplo
      
        var number = 20

        when {
            number < 0 -> println("$number is less than zero")
            number % 2 == 0 -> println("$number is even")
            number > 100 -> println("$number is greater than 100")
            else -> println("None of the above")
        }
        // output: 20 is even


// BUCLE 'WHILE'

  // ejecuta un bloque de código repetidamente siempre y cuando una condición dada sea verdadera:

        while(condition) {
            // code to be executed
        }

        // ejemplo:
        var x = 1

        while (x <= 5) {
            println("$x ")
            x++
        }
        // output: 1 2 3 4 5


// BUCLE 'DO-WHILE'

  // es similar al bucle 'while' excepto que comprueba la condición al final del bucle:

        var x = 1

        do {
            print("$x ")
            x++
        } while (x <= 5)
        // muestra: 1 2 3 4 5

        // como comprueba la condición al final del bucle, al menos se ejecuta una vez la iteración:
        var x = 6

        do {
            print("$x ")
            x++
        } while (x <= 5)
        // output: 6


// BUCLE 'FOR'

  // se utiliza para iterar a través de rangos, matrices, colecciones o cualquier cosa que proporcione un iterador

  // iteración sobre un rango:
  
        for (value in 1..10) {
              print("$value ")
          }
        // output: 1 2 3 4 5 6 7 8 9 10

  // iteración sobre un array:
  
        var primeNumbers = intArrayOf(2, 3, 5, 7, 11)

        for (number in primeNumbers) {
            print("$number ")
        }
        // output: 2, 3, 5, 7, 11

  // iteración sobre un array usando sus índices

    // cada matriz en Kotlin tiene una propiedad llamada indices que devuelve un rango de índices válidos de esa matriz.
    // puede iterar sobre los índices del array y recuperar cada elemento del array usando su índice como sigue:

          var primeNumbers = intArrayOf(2, 3, 5, 7, 11)

          for (index in primeNumbers.indices) {
              println("PrimeNumber(${index+1}): ${primeNumbers[index]}")
          }

          // Output
          // PrimeNumber(1): 2
          // PrimeNumber(2): 3
          // PrimeNumber(3): 5
          // PrimeNumber(4): 7
          // PrimeNumber(5): 11


    // iteración sobre un array usando la función 'withIndex()'
    
      // con ella se obtiene un iterable de tipo 'IndexedValue'. Esto permite acceder tanto al índice como al elemento
      // del array en cada iteración:

          var primeNumbers = intArrayOf(2, 3, 5, 7, 11)

          for((index, number) in primeNumbers.withIndex()) {
              println("PrimeNumber(${index+1}): $number")
          }
          // Output:
          // PrimeNumber(1): 2
          // PrimeNumber(2): 3
          // PrimeNumber(3): 5
          // PrimeNumber(4): 7
          // PrimeNumber(5): 11

// PALABRA RESERVADA 'BREAK'

  // sirve para salir de un bucle:

      for (num in 1..100) {
          if (num%3 == 0 && num%5 == 0) {
              println("First positive no divisible by both 3 and 5: ${num}")
              break
          }
      }
      // Output:
      // First positive no divisible by both 3 and 5: 15

// PALABRA RESERVADA 'CONTINUE'

  // sirve para saltar a la siguiente iteración de un bucle:

      for (num in 1..10) {
          if (num%2 == 0) {
              continue;
          }
          print("${num} ")
      }
      // Output:
      // 1 3 5 7 9

