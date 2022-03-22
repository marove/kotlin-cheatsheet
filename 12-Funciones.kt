
// FUNCIONES

  // DEFINIENDO Y LLAMANDO FUNCIONES

    // Se declaran con la palabra reservada 'fun'

    // Sintaxis general:
    
        fun functionName(param1: Type1, param2: Type2,..., paramN: TypeN): Type {
          // cuerplo del método
        }

    // Ejemplo:
    
        fun avg(a: Double, b: Double): Double {
          return  (a + b)/2
        }

    // Llamada anterior función:
    
        avg(4.6, 9.0)  // 6.8

    
  // FUNCIONES DE EXPRESION SIMPLE

    // Se puede omitir el tipo de retorno y las llaves si la función devuelve una sola expresión -> el tipo de retorno es
    // inferido por el compilador a partir de la expresión.

    // ejemplo:
    
          fun avg(a: Double, b: Double) = (a + b)/2

    // A diferencia de otros lenguajes estáticos como Scala, Kotlin no infiere tipos de retorno para funciones con
    // cuerpos de bloque -> por lo tanto, las funciones con cuerpo de bloque siempre deben especificar explícitamente
    // las clases de retorno.

  // FUNCIONES 'UNIT' (SIN TIPO DE RETORNO)

    // Las funciones que no devuelven nada tienen un tipo de retorno 'unit' -> es el equivalente a 'void' en Java
    
    // ejemplo:
        
        fun printAverage(a: Double, b: Double): Unit {
          println("Avg of ($a, $b) = ${(a + b)/2}")
        }

        printAverage(10.0, 30.0)  // Avg of (10.0, 30.0) = 20.0

    // la declaracion de 'Unit' es totalmente opcional, pudiéndose obviar:
      
        fun printAverage(a: Double, b: Double) {
          println("Avg of ($a, $b) = ${(a + b)/2}")
        }

  // FUNCIONES CON PARÁMETROS POR DEFECTO

    // Se puede especificar un valor propuesto para un parámetro de función. El valor por defecto se utiliza cuando se
    // omite el argumento correspondiente de la llamada de función.

    // ejemplo:
        
        fun displayGreeting(message: String, name: String = "Guest") {
            println("Hello $name, $message")
        }

        displayGreeting("Welcome to the CalliCoder Blog") // Hello Guest, Welcome to the CalliCoder Blog

        // si se llama a la función anterior con dos argumentos, funciona como cualquier otra función y utiliza los valores
        // pasados en los argumentos:
        
        displayGreeting("Welcome to the CalliCoder Blog", "John") // Hello John, Welcome to the CalliCoder Blog


  // FUNCIONES DE ARGUMENTOS CON NOMBRE (Function Named Arguments)

    // Kotlin permite especificar los nombres de los argumentos que está pasando a la función -> ésto hace que las
    // llamadas de función sean más legibles.
    
    // También permite pasar el valor de un parámetro de forma selectiva si otros parámetros tienen valores por defecto.
        
    // ejemplo:

        fun arithmeticSeriesSum(a: Int = 1, n: Int, d: Int = 1): Int {
            return n/2 * (2*a + (n-1)*d)
        }

        // se puede especificar los nombres de los argumentos mientras llama a la función de la siguiente manera:
        
            arithmeticSeriesSum(n=10)  // Resultado = 55, usando los valores por defecto 'a' y 'd'

        // de igual manera se puede llamar la función con todos los parámetros de la siguiente manera:
        
            arithmeticSeriesSum(a=3, n=10, d=2)  // Result = 120

        // también se puede reordenar los argumentos si está especificando los nombres
        
            arithmeticSeriesSum(n=10, d=2, a=3)  // Result = 120

        // se puede usar una mezcla de argumentos con nombre y argumentos basados en posición, siempre y cuando todos los
        // argumentos basados en posición se coloquen antes de los argumentos con nombre.
        
            arithmeticSeriesSum(3, n=10)  // Resultado = 75


  // FUNCIONES CON NÚMERO VARIABLE DE ARGUMENTOS (Varargs)

    // Se puede pasar un número variable de argumentos a una función declarando la función con un parámetro 'vararg'

    // ejemplo:
  
        fun sumOfNumbers(vararg numbers: Double): Double {
            var sum: Double = 0.0
            for(number in numbers) {
                sum += number
            }
            return sum
        }

        sumOfNumbers(1.5, 2.0)  // Result = 3.5
        sumOfNumbers(1.5, 2.0, 3.5, 4.0, 5.8, 6.2)  // Result = 23.0
        sumOfNumbers(1.5, 2.0, 3.5, 4.0, 5.8, 6.2, 8.1, 12.4, 16.5)  // Result = 60.0
   
    // En Kotlin, un parámetro vararg del tipo T se representa internamente como un array del tipo T (Array<T>) dentro
    // del cuerpo de la función -> si hay otros parámetros después del parámetro vararg, entonces los valores de esos 
    // parámetros se pueden pasar usando la sintaxis del argumento llamado 
    
    // ejemplo:
      
        fun sumOfNumbers(vararg numbers: Double, initialSum: Double): Double {
            var sum = initialSum
            for(number in numbers) {
                sum += number
            }
            return sum
        }

        sumOfNumbers(1.5, 2.5, initialSum=100.0) // Result = 104.0


  // OPERADOR SPREAD

    // Normalmente, pasamos los argumentos a una función vararg uno por uno. Pero si ya tiene un array y quiere pasar los
    // elementos del array a la función vararg, entonces puede usar el operador spread de la siguiente manera:
    
        val a = doubleArrayOf(1.5, 2.6, 5.4)
        sumOfNumbers(*a)  // Result = 9.5


  // ÁMBITO DE LAS FUNCIONES

    // Kotlin soporta programación funcional.

    // Las funciones son ciudadanos de primera clase en el lenguaje.

    // A diferencia de Java, donde cada función necesita ser encapsulada dentro de una clase, las funciones Kotlin pueden
    // ser definidas en el nivel superior de un archivo fuente

    // Además de las funciones de nivel superior, también tiene la posibilidad de definir funciones de miembro, y
    // funciones locales/anidadas

    // FUNCIONES DE NIVEL SUPERIOR

      // Se definen en un archivo fuente fuera de cualquier clase

      // También se llaman funciones de nivel de paquete, puesto que son miembros del paquete en el que se definen

      // El método main() en sí mismo es una función de nivel superior en Kotlin ya que se define fuera de cualquier clase

      // ejemplo:
        
          package maths

          fun findNthFibonacciNo(n: Int): Int {
              var a = 0
              var b = 1
              var c: Int

              if (n == 0) {
                  return a
              }

              for (i in 2..n) {
                  c = a+b
                  a = b
                  b = c
              }
              return b
          }

          fun main(args: Array<String>) {
            println("10th fibonacci number is - ${findNthFibonacciNo(10)}")
          }
          // salida: 10th fibonacci number is - 55

      // si se quiere llamar a la función findNthFibonacciNo() desde otros paquetes, entonces necesitas importarlo:

          package test
          import maths.findNthFibonacciNo

          fun main(args: Array<String>) {
              println("10th fibonacci number is - ${findNthFibonacciNo(10)}")
          }

    
  // FUNCIONES DE MIEMBRO

    // las funciones de miembro son funciones que son definidas dentro de una clase u objeto:
      
        class User(val firstName: String, val lastName: String) {

        // member function
          fun getFullName(): String {
              return firstName + " " + lastName
          }
        }

    // son llamadas en los objetos instanciados de la clase usando la notación punto (.):
      
        val user = User("Bill", "Gates") // Create an object of the class
        println("Display Name : ${user.getFullName()}") // Call the member function


  // FUNCIONES LOCALES / ANIDADAS

    // Kotlin permite anidar definiciones de funciones -> éstas funciones anidadas son llamadas funciones locales

    // las funciones locales traen más encapsulación y legibilidad al programa:

        fun findBodyMassIndex(weightInKg: Double, heightInCm: Double): Double {

          // Validate the arguments
          if (weightInKg <= 0) {
              throw IllegalArgumentException("Weight must be greater than zero")
          }
          if (heightInCm <= 0) {
              throw IllegalArgumentException("Height must be greater than zero")
          }

          fun calculateBMI(weightInKg: Double, heightInCm: Double): Double {
              val heightInMeter = heightInCm / 100
              return weightInKg / (heightInMeter * heightInMeter)
          }

          // Calculate BMI using the nested function
          return calculateBMI(weightInKg, heightInCm)
        }

    // las funciones locales pueden acceder a las variables locales de la función externa. Así que la función
    // anterior es equivalente a la siguiente:

        fun findBodyMassIndex(weightInKg: Double, heightInCm: Double): Double {
            if(weightInKg <= 0) {
                throw IllegalArgumentException("Weight must be greater than zero")
            }
            if(heightInCm <= 0) {
                throw IllegalArgumentException("Height must be greater than zero")
            }

            // Nested function has access to the local variables of the outer function
            fun calculateBMI(): Double {
                val heightInMeter = heightInCm / 100
                return weightInKg / (heightInMeter * heightInMeter)
            }

            return calculateBMI()
        }

