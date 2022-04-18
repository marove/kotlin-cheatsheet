
// TIPOS DE DATOS


  // Se utilizan para categorizar un conjunto de valores relacionados y definir las operaciones que se pueden realizar
  // en ellos.

  // Kotlin tiene tipos predefinidos como Int, Double, Boolean, Char, etc.

  // En Kotlin, todos los tipos de datos es un objeto -> más específicamente, todo se comporta como un objeto. 
  // Kotlin puede representar algunos de los tipos básicos como números, caracteres y booleanos como valores primitivos en
  // tiempo de ejecución para mejorar el rendimiento, pero para los usuarios finales, todos ellos son objetos.

  // Todos los tipos de Kotlin heredan del tipo Any.


  // TIPOS DE DATOS NUMÉRICOS

    // ENTEROS

      Byte  // 8 bits
      Short // 16 bits
      Int   // 32 bits
      Long  // 64 bits

    // DECIMALES
    
      Float   // valor de coma flotante de precisión simple de 32 bits
      Double  // valor de coma flotante de doble precisión de 64 bits 

    // Ejemplos:

      val myByte: Byte = 10
      val myShort: Short = 125

      val myInt = 1000
      val myLong = 1000L    // El sufijo 'L' es usado específicmante a un valor 'long'

      val myFloat = 126.78f   // El sufijo 'f' o 'F' representa un 'Float' 
      val myDouble = 325.49   // Es tipo Double por defecto cualquier valor decimal si no se especifica con f de Float

   
      // también se puede utilizar el guión bajo en los valores numéricos grandes para hacerlos más legibles:
      val hundredThousand = 100_000
      val oneMillion = 1_000_000
      
      // se puede declarar valores hexadecimales y binarios de la siguiente manera:
      val myHexa = 0x0A0F  // Hexadecimal values are prefixed with '0x' or '0X'
      val myBinary = 0b1010  // Binary values are prefixed with '0b' or '0B'

      // Kotlin en cambio no tiene ninguna representación de los valores octales.


  // BOOLEANOS

    // se usan para representar valores lógicos:
    val myBoolean = true
    val anotherBoolean = false


  // CARACTERES

    // CHAR

      // representa caracteres

      // no se pueden tratar como números como sucede en Java

      // se declaran usando comillas simples:
      val letterChar = 'A'
      val digitChar = '9'

      // escapar caracteres:

          // \n - nueva línea
          // \t - tabulación
          // \r - retorno de carro
          // \b - retroceso

    // STRING

      // representa una cadena de caracteres

      // se puede declarar así:
      var myStr: String = "Hello, Kotlin"
      var myStr = "Hello, Kotlin" // con las comillas asume que es un String por defecto y no hace falta una declaración explícita

      // string template -> introduce variables dentro de un string

      var myStringTemplate = "I have $numberOfFish fish and $numberOfPlants plants"
      var myAlternativeStringTemplate = "I have ${numberOfFish + $numberOfPlants} fish and plants"

      // escapar strings -> los strings declarados con dobles comillas pueden escapar caracteres como '\n', '\t',
      // '\r' y '\b':
      var myEscapedString = "Hello Reader,\nWelcome to my Blog"

      // se puede acceder al caracter de un índice en particular usando 'str[index]', comenzando el índice desde 0.
      var name = "John"
      var firstCharInName = name[0]  // 'J'
      var lastCharInName = name[name.length - 1]  // 'n'

      // declarar strings en bruto -> no escapan y pueden abarcar múltiples líneas:
      var myMultilineRawString = """
      The Quick Brown Fox
      Jumped Over a Lazy Dog.
      """

  // CONVERSION ENTRE TIPOS DE DATOS

    // A diferencia de Java, Kotlin no admite la conversión implícita de tipos más pequeños a tipos más grandes.
    // Por ejemplo, Int no puede asignarse a Long o Double.

    var myInt = 100
    var myLong: Long = myInt // Error de compilación


    // Sin embargo, cada tipo de número contiene funciones de ayuda que se pueden utilizar para convertir explícitamente
    // un tipo a otro. Las siguientes funciones de ayuda son soportadas para la conversión de tipos entre tipos:

      + toByte()
      + toShort()
      + toInt()
      + toLong()
      + toFLoat()
      + toDouble()
      + toChar()
      + toBoolean()
      + toString()

    // Ejemplos de conversión de tipos explícita:

      // de tipos más pequeños a más grandes
      val myInt = 100
      val myLong = myInt.toLong()   // conversión explícita de 'Int' a 'Long'

      // de tipos más grandes a más pequeños:
      val doubleValue = 176.80
      val intValue = doubleValue.toInt()  // 176

      // cada tipo en Kotlin, no sólo el tipo numérico, soporta una función de ayuda llamada toString() para convertirlo
      // en String.
      val myInt = 1000
      myInt.toString()  // "1000"

      // se puede convertir un String a un tipo numérico también:
      val str = "1000"
      val intValue = str.toInt()

      // si la conversión String a tipo numérico no es posible, entonce se lanza una excepción NumberFormatException:
      val str = "1000ABC"
      str.toInt()   // lanza java.lang.NumberFormatException

