
// ARRAYS

  // se representan usando la clase 'Array'

  // CREACION

    // se crean de dos formas:

      // A - Usando el método 'arrayOf'

        // puedes pasar un grupo de valores a la función arrayOf para crear un array como este:
        
            var numbers = arrayOf(1, 2, 3, 4, 5)
            var animals = arrayOf("Cat", "Dog", "Lion", "Tiger")

        // puedes pasar también un grupo de valores de distintos tipos, aunque no es una práctica recomendada:
        
            var mixedArray = arrayOf(1, true, 3, "Hello", 'A')	// funciona y crea un array de objetos

        // también puedes forzar a que el array sea únicamente de un determinado tipo de dato tipando el array:
        
            var numArray = arrayOf<Int>(1, 2, 3, 4, "Hello")            // error de compilación
            var alternativeNumArray = intArrayOf(1, 2, 3, 4, "Hello")   // error de compilación

            // Array primitivos:

              // En Kotlin todo es un objeto, pero para mejorar el rendimiento representa algunos de los tipos básicos como
              // números, caracteres y booleanos como tipos primitivos en tiempo de ejecución.

              // La función arrayOf() crea arrays de tipo wrapped/envueltos. Es decir, arrayOf(1, 2, 3) corresponde al
              // array Integer[] de Java.

              // Pero Kotlin provee una forma de crear arrays de tipo primitivo también. Contiene clases especiales para
              // ello : IntArray, DoubleArray, CharArray, etc -> con las que se pueden crear arrays de tipos primitivos
              // usando sus correspondientes funciones: intArrayOf(), doubleArrayOf(), charArrayOf(), etc.
              
                  val myCharArray = charArrayOf('K', 'O', 'T')    // CharArray (corresponde a Java 'char[]')
                  val myIntArray = intArrayOf(1, 3, 5, 7)		      // IntArray (corresponde a Java 'int[]')

        // se pueden crear arrays anidados, es decir, arrays de arrays:
        
            val swarm = listOf(12, 5)
            var bigSwarm = arrayOf(swarm, listOf("dolphin", "whale", "orka"))  //  [[12, 5], ["dolphin", "whale", "orka"]]             


      // B - Usando el constructor 'Array()'

        // El constructor Array() toma dos argumentos:

          // Primero -> el tamaño del array.
          // Segundo -> una función que toma el índice del array como argumento y devuelve el elemento a insertar en
          // ese índice (mediante expresión lambda)

              var mySquareArray = Array(5, {i -> i * i})	// [0, 1, 4, 9, 16]
              
              var myDoubledArray = Array(5, {it * 2)	      // [0, 2, 4, 6, 8]


  // ACCESO Y MODIFICACION:

    // se puede acceder a un determinado elemento del array mediente 'array[index]', comenzando el índice desde
    // cero:
         
        val myDoubleArray = arrayOf(4.0, 6.9, 1.7, 12.3, 5.4)
        val firstElement = myDoubleArray[0]
        val lastElement = myDoubleArray[myDoubleArray.size - 1]

    // se puede modificar el valor del elemento de un array de un determinado índice así:
          
        val a = arrayOf(4, 5, 7)    // [4, 5, 7]
        a[1] = 10		                // [4, 10, 7]
