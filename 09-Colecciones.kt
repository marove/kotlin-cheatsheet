

// COLLECTION

  // Collection<T> es una interfaz que representa un supertipo en la jerarquía de colecciones.
  // Collection<T> es una interfaz de coleccion read-only.
  // List y Set son subtipos de Collection<T>.

  // TIPOS DE COLECCIONES

    // LISTA

      // Los elementos están ordenados por índices.
      // Los elementos pueden repetirse.

        // Ejemplo listas

            val list = listOf(1,2,3)
            val mutableList = mutableListOf(1,2,3)
            mutableList.add(4)
            val arrayList = ArrayList<Int>()  // empty ArrayList
            val emptyList = emptyList<Int>()

    // SET

      // El orden no importa
      // Los elementos no pueden repetirse.

        // Ejemplo Sets

            val s = setOf(1,2,3)
            val hashSet = HashSet<Int>()
            hashSet.add(4)
            print(hashSet) // [4]
            mutableSetOf(1,2,3)  // [1, 2, 3]

    // MAP

      // Es un set de pares clave-valor.
      // La clave (key) es única.
      // Las valores pueden estar repetidos.
      // Map NO es un subtipo de Collection<T>.

        // Ejemplo Maps

            val m = mapOf(1 to "one", 2 to "two")
            val hashMap = HashMap<Int,String>(m)
            hashMap.put(3, "three")
            print(hashMap) // {1=one, 2=two, 3=three}


  // COLECCION READ-ONLY VS COLLECION MUTABLE

    // Cada subtipo de Collection<T> tiene una versión read-only y otra mutable.
    // Read Only -> sólo acceso de lectura
    // Mutable -> puedes tanto leer como modificar elementos de la colección.

  // CREACION DE LA COLECCION

    // A) Instanciando una implementacion como ArrayList, HashSet, HashMap
    // B) Usando las funciones Kotlin STD listOf<T>, SetOf<T>, mapOf<K,V>, mutableListOf<T>, mutableSetOf<T> and mutableMap<K,V>.

    // COLECCIONES VACIAS: métodos emptyList(), emptySet() and emptyMap().


  // recorrer coleccion con forEach

      val list = listOf(1,2,3)

      list.forEach{
        println(it)
      }


// COPIA DE COLECCIONES

  // COPIA DIRECTA

    // toList(), toMutableList(), toSet().

      val fromList = listOf(1,2,3)
      val toList = fromList.toList()  // copiado de lista

  // COPIA A OTRA COLECCION

    // Una lista puede ser copiada a un Set y viceversa:

      val fromList = listOf(1,2,3,3)
      val toSet = fromList.toSet() // 1,2,3

  // COPIADO POR REFERENCIA

    // Podemos simplemente crear una nueva variable de colección asignando una existente a esa variable. Sin embargo, las
    // variables creadas de este modo apuntan a la misma referencia de colección, es decir, una actualización de una de
    // ellas se reflejará en las demás.

      val fromList = mutableListOf(1,2,3)
      val toList = fromList   // toList está copiando por referencia
      toList.add(4)

      println(fromList) // 1,2,3,4


// OPERACIONES CON COLECCIONES

  // ACCESO A VALORES INDIVIDUALES

    // elementAt()            -> recupera un elemento en una posición específica de List y Set.
    // operadores get() y []  -> también pueden utilizarse para acceder a elementos de la Lista en una posición específica.
    // Los elementos de Map   -> se recuperan por clave utilizando get(key), [key] o getValue(key) que, a diferencia de los
    //                         dos primeros, lanzará una excepción si no se encuentra la clave.
    // getOrElse()            -> se puede utilizar con List y Map donde el valor de un elemento inexistente se devuelve desde lambda.


    fun main() {

      // Lista
      val list = listOf(1,5,3,4)

      println(list.elementAt(0))      // 1
      println(list.get(0))            // 1
      println(list.getOrElse(5){it})  // it = 5, passed index
      println(list[0])                // 1

      // Set
      val unsortedSet = setOf(2,3,1)
      val sortedSet = sortedSetOf(3,2,1)

      println(unsortedSet.elementAt(0)) // 2
      println(sortedSet.elementAt(0))   // 1

      // Map
      val map = sortedMapOf(1 to "one", 2 to "two", 3  to "three")

      println(map.get(0))                         // null
      println(map.getOrElse(5){"does not exist"}) // "does not exists"
      println(map[0])                             // null
      println(map.getvalue(0))                    // NoSuchElementException
    }


  // Las versiones seguras de elementAt() son:

    // - elementAtOrNull(): devuelve null si el índice está fuera de los límites.
    // - elementAtOrElse(): toma un lambda con el índice como único argumento que devuelve el resultado si el índice
    //                      está fuera de los límites.

      val list = listOf(1,5,3,4)

      println(list.elementAtOrNull(4))      // null
      println(list.elementAtOrElse(7){it})  // 7

    // first() & last() para obtener el primer y último elemento:

        val list = listOf(1,5,3,4)
        val unsortedSet = setOf(2,3,1)
        val sortedSet = sortedSetOf(3,2,1)

        list.first()        // 1
        unsortedSet.first() // 2
        sortedSet.last()    // 3

    // first() y last() pueden tomar un predicado. Así, first() devolverá la primera coincidencia y last() devolverá el último
    // elemento que coincida con el predicado.
    // firstOrNull() y lastOrNull() son versiones seguras que devuelven null si no se encuentra ninguna coincidencia:

        val list = listOf(1,5,3,4)

        list.first{ it > 2 }  // 5
        list.last{ it < 4 }   // 3

        list.firstOrNull{ it > 5 }  // null
        list.lastOrNull{ it > 5 }   // null

    // find() -> es una función de alias que funciona exactamente igual que firstOrNull()
    // findLast() -> es un alias de lastOrNull()


  //  ACCESO A PARTES DE UNA COLECCION

    // Las partes de una colección pueden recuperarse utilizando los índices de los elementos o el tamaño de las partes deseadas.
    // La función slice() devuelve una lista de elementos con los índices dados.
    // slice() lanza una excepción si un índice está fuera de los límites.

        val list = listOf(1,5,3,4,2)
        list.slice(0..2)       // [1, 5, 3]
        list.slice(setOf(0,2)) // [1,3]

    // List proporciona la función subList(s,e) para recuperar partes por índices:

        val list = listOf(1,5,3,4,2)
        numbers.subList(0, 2)         // [1, 5]

    // take(n) devuelve n elementos empezando por el primero.
    // takeLast(n) devuelve los últimos n elementos.
    // drop(n) devuelve todos los elementos excepto los primeros n.
    // dropLast(n) devuelve todos los elementos excepto los n últimos.

        val list = listOf(1,5,3,4,2)
        list.take(2)       // [1, 5]
        list.dropLast(2)   // [1, 5, 3]


  // COMPROBACION DE EXISTENCIA

    // La función contains() comprueba si una colección incluye un elemento.
    // El operador in funciona como contains()
    // Para comprobar la existencia de más de un elemento se utiliza containsAll()
    // isEmpty() y isNotEmpty() se utilizan para comprobar si la colección tiene algún elemento.

        val list = listOf(1,5,3,4)
        val unsortedSet = setOf(2,3,1)
        val map = sortedMapOf(1 to "one", 2 to "two" ,3  to "three")

        list.contains(2))                     // false
        3 in list)                            // true
        unsortedSet.containsAll(setOf(2,3))   // true
        map.isEmpty()                         // false


