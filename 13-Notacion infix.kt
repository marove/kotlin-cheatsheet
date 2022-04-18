
// NOTACION INFIX

    // Kotlin soporta llamadas a funciones de un tipo especial llamadas infix -> puedes marcar cualquier función miembro
    // o función de extensión con el modificador infix para permitir que sea llamada usando la notación infix. El único
    // requisito es que la función debe tener sólo un parámetro requerido.

    // EJEMPLOS DEL API DE KOTLIN

        // 1. CREACION DE UN MAPA

            val map = mapOf(1 to "one", 2 to "two", 3 to "three")

        // las expresiones 1 to "one", 2 to "two", etc, son notaciones infix de las llamadas a
        // funciones 1.to("one") y 2.to("two"), etc. -> to() es una función infix que crea un Pair<A, B> a partir
        // de dos valores.


        // 2. OPERADORES DE RANGO (until, downTo, step)

            // Kotlin proporciona varios operadores de rango que normalmente se llaman utilizando la notación infix:

                for (i in 1 until 10) {	        // equivale a -> for(i in 1.until(10))
                    print("$i ")
                }

                for (i in 10 downTo 1) {	    // equivale a -> for(i in 10.downTo(1))
                    print("$i ")
                }

                for (i in 1 until 10 step 2) {  // equivale a -> for(i in 1.until(10).step(2))
                    print("$i ")
                }


        // 3. String.matches()

            // la función String.matches() en Kotlin que hace coincidir una cadena con un Regex es una función infix:

                val regex = Regex("[tT]rue|[yY]es")
                val str = "yes"

                str.matches(regex)

            // notación infix de la llamada a la función anterior:

                str matches regex

    // CREACION DE UNA FUNCION INFIX

        // puedes convertir una función miembro de un solo parámetro o una función de extensión, en una función infix
        // marcándola con la palabra clave infix.

        // ejemplo:

            // se ha crea una función miembro infix llamada add() para sumar dos números complejos:

                data class ComplexNumber(val realPart: Double, val imaginaryPart: Double) {
                    // función infix para sumar dos números complejos
                    infix fun add(c: ComplexNumber): ComplexNumber {
                        return ComplexNumber(realPart + c.realPart, imaginaryPart + c.imaginaryPart)
                    }
                }

            // ahora se puede llamar al método add() utilizando la notación infija:

                val c1 = ComplexNumber(3.0, 5.0)
                val c2 = ComplexNumber(4.0, 7.0)

                // llamada habitual
                c1.add(c2)  // produce -> ComplexNumber(realPart=7.0, imaginaryPart=12.0)

                // llamada infix
                c1 add c2   // produce -> ComplexNumber(realPart=7.0, imaginaryPart=12.0)
