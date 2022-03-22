
// OPERADORES

  // OPERADORES NUMÉRICOS

    // Aritmeticos:

        a + b              // suma
        a - b              // resta
        a / b              // división
        a % b              // resto

    // Comparación:

        a == b             // igual
        a != b             // distinto
        a < b              // mayor
        a > b              // menor
        a <= b             // menor o igual
        a >= b             // mayor o igual

    // Asignación: 

        a += b             // equivalencia a = a + b
        a -= b             // equivalencia a = a - b
        a *= b             // equivalencia a = a * b 
        a /= b             // equivalencia a = a / b
        a %= b             // equivalencia a = a % b


    // Incremento/Decremento:
      
        ++  // incremento
        --  // decremento


    // ejemplos:

        var a = 10
        var b = 20

        var c = ((a + b) * ( a + b))/2   // 450
        var isALessThanB = a < b         // true
        a++                              // a ahora pasa a ser 11
        b += 5                           // b ahora pasa a ser 25


  // Todo en Kotlin es un objeto, incluso los tipos de datos básicos como Int, Char, Double, Boolean, etc. Kotlin no
  // tiene tipos primitivos separados y sus correspondientes tipos envueltos como Java.

  // Hay que tener en cuenta que Kotlin puede representar tipos básicos como Int, Char, Boolean, etc. como valores
  // primitivos en tiempo de ejecución para mejorar el rendimiento, pero para los usuarios finales, todos ellos son objetos.

  // Puesto que todos los tipos de datos son objetos, las operaciones de estos tipos se representan internamente como
  // llamadas de función.
  // Por ejemplo, la operación de suma a + b entre dos números a y b se representa como una llamada de función a.plus(b):
    
        var a = 4
        var b = 5

        println(a + b)
        // es equivalente a
        println(a.plus(b))

  // Todos los operadores anteriores tienen un nombre simbólico que se utiliza para traducir cualquier expresión que contenga
  // a esos operadores en las llamadas de función correspondientes:

    // EXPRESION --> TRADUCCION
    
        a + b             a.plus(b)
        a - b             a.minus(b)
        a * b             a.times(b)
        a / b             a.div(b)
        a % b             a.rem(b)
        a++               a.inc(b)
        a--               a.dec(b)
        a > b             a.compareTo(b) > 0
        a < b             a.comparteToc(b) < 0
        a += b            a.plusAssign(b)
        ...               ...


  // Sobrecarga de operador:
  // 


  // OPERADRES DE BITS (BITWISE)

    // A diferencia de C, C++ y Java, Kotlin no tiene operadores de bits como | (bitwise-o), & (bitwise-y), ^ (bitwise-xor),
    // <<< (signo de desplazamiento a la izquierda), >> (signo de desplazamiento a la derecha) etc.

    // Para realizar operaciones de bits, Kotlin proporciona los siguientes métodos que funcionan para los tipos Int y Long:    

        shl   // signed shift left (equivalente al operador <<)
        shr   // signed shift right (equivalente al operador>>)
        ushr  // unsigned shift right (equivalente al operador >>>)
        and   // bitwise and (equivalente al operador &)
        or    // bitwise or (equivalente al operador |)
        xor   // bitwise xor (equivalente al operador ^)
        inv   // bitwise complement (equivalente al operador ~)

      // ejemplos:
      
          1 shl 2   // Equivalente a 1.shl(2), Resultado = 4
          16 shr 2  // Resultado = 4
          2 and 4   // Resultado = 0
          2 or 3    // Resultado = 3
          4 xor 5   // Resultado = 1
          4.inv()   // Resultado = -5

    // Todas las funciones de bits, excepto inv(), pueden ser llamadas usando la notación infija (infix). La notación infija
    // de 2.and(4) es 2 and 4. La notación Infix permite escribir llamadas de función de una manera más intuitiva.


  // OPERADORES BOOLEANOS

    // se utilizan generalmente en expresiones de flujo de control como if, if-else, while etc., para probar la validez de
    // una condición.

    // tipos:
    
        ||  // OR lógico
        &&  // AND lógico
        !   // NOT lógico

    // ejemplos:
    
        2 == 2 && 4 != 5      // true
        4 > 5 && 2 < 7        // false
        !(7 > 12 || 14 < 18)  // false

  
  // OPERADORES SOBRE CADENA DE CARACTERES

    // concatenacion de Strings

      // se realiza con el operador '+':
      
          var firstName = "Rajeev"
          var lastName = "Singh"
          var fullName = firstName + " " + lastName	// "Rajeev Singh"

    // interpolacion de Strings

      // permite insertar directamente una expresión de plantilla dentro de una cadena
      // las expresiones de plantillas son pequeñas piezas de código que se evalúan y sus resultados se concatenan con la
      // cadena original, y van prececidas del símbolo $:
      
          var a = 12
          var b = 18
          println("Avg of $a and $b is equal to ${ (a + b)/2 }") // imprime: Avg of 12 and 18 is equal to 15

      // si la expresión de la plantilla es una variable simple, se puede escribir como $variableName, en cambio si se trata
      // de una expresión, hay que insertarla dentro de un bloque ${}.
