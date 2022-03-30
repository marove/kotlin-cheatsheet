
// COMPROBACION DE TIPOS Y SMART CASTS

    // Cuando se trabaja con tipos mixtos, a menudo necesitamos saber el tipo de un objeto en tiempo de ejecución para
    // poder hacer un casting seguro del objeto al tipo deseado y llamar a métodos o acceder a propiedades en él.

    // COMPROBACION DE TIPOS (TYPE CHECK)

        // En Kotlin, puedes comprobar si un objeto es de un determinado tipo en tiempo de ejecución utilizando el
        // operador `is.

        // Ejemplo:

                fun main(args: Array<String>) {
                    val mixedTypeList: List<Any> = listOf("I", "am", 5, "feet", 9.5, "inches", "tall")

                    for (value in mixedTypeList) {
                        if (value is String) {
                            println("String: '$value' of length ${value.length} ")
                        } else if (value is Int) {
                            println("Integer: '$value'")
                        } else if (value is Double) {
                            println("Double: '$value' with Ceil value ${Math.ceil(value)}")
                        } else {
                            println("Unknown Type")
                        }
                    }
                }

        // Se puede simplificar aún más el programa anterior sustituyendo el bloque if-else por una
        // expresión when como la siguiente:

                fun main(args: Array<String>) {
                    val mixedTypeList: List<Any> = listOf("I", "am", 5, "feet", 9.5, "inches", "tall")

                    for (value in mixedTypeList) {
                        when (value) {
                            is String -> println("String: '$value' of length ${value.length} ")
                            is Int -> println("Integer: $value")
                            is Double -> println("Double: $value with Ceil value ${Math.ceil(value)}")
                            else -> println("Unknown Type")
                        }
                    }
                }

        // El operador `is` también tiene una forma negada `!is`:

                if (value !is String) {
                    println("Not a String")
                }

    // CASTING INTELIGENTE (SMART CASTS)

        // Los ejemplos anteriores con `is` usan una caracteristica de Konlin llamada Smart Cast.

        // Para comprender como Smart Cast funciona en Kotlin, vamos a comparar cómo hacemos los casting
        // de clases en Java comparado a cómo lo hacemos en Kotlin:

            // En Java primero comprobamos el tipo de la variable utilizando el operador instanceof y luego la
            // convertimos al tipo de destino de la siguiente manera:


                    Object obj = "The quick brown fox jumped over a lazy dog";
                    if (obj instanceof String) {
                        // casting explícito a tipo `String`
                        String str = (String) obj;
                        System.out.println("Found a String of length " + str.length());
                    }

            // Pero en Kotlin, cuando realizas una comprobación is o !is en una variable, el compilador rastrea esta
            // información y automáticamente convierte la variable al tipo de destino en el ámbito donde la comprobación
            // is o !is es verdadera.

                    val obj: Any = "The quick brown fox jumped over a lazy dog"
                    if (obj is String) {
                        // la variable obj es automáticamente casteada a tipo String en éste ámbito y no es necesario por
                        // tanto un casting explícito
                        println("Found a String of length ${obj.length}")
                    }

            // similarmente para `is`:

                    val obj: Any = "The quick brown fox jumped over a lazy dog"
                    if(obj !is String) {
                        println("Not a String")
                    } else {
                        // obj es automáticamente casteado a un String en éste ámbito
                        println("Found a String of length ${obj.length}")
                    }


            // Los smart casts también funcionan con los los operadores && y ||:
                
                    
                    // obj se convierte automáticamente en String en el lado derecho de "&&" y dentro del "if"
                    if (obj is String && obj.length > 0) {
                        println("Found a String of length greater than zero - ${obj.length}")
                    }
                    
                    // obj es automáticamente casteado a String en el lado derecho de "||"
                    if (obj !is String || obj.length > 0) {
                        return
                    }

            // Hay que tener en cuenta que los smart casts sólo funcionan si el compilador puede garantizar que la
            // variable no ha cambiado después de la comprobación is o !is. -> por ejemplo, Smart cast no funciona para
            // las propiedades mutables de una clase, sólo funciona para propiedades inmutables que no tienen un getter
            // personalizado.


        // CASTING EXPLICITO

            // 1. Operador inseguro de casting: as

                // Puedes utilizar el operador Type Cast de Kotlin `as` para castear manualmente una variable a un tipo
                // concreto:

                        val obj: Any = "The quick brown fox jumped over a lazy dog"
                        val str: String = obj as String
                        println(str.length)

                // Si la variable no se puede castear al tipo de destino, el operador cast lanza una excepción. Por eso
                // se le llama al operador `as` "inseguro":

                        val obj: Any = 123
                        val str: String = obj as String 
                        // lanza java.lang.ClassCastException: java.lang.Integer cannot be cast to java.lang.String

                // Hay que tener en cuenta que si la variable que está tratando de lanzar es anulable, entonces tampoco
                // no se puede castear a un tipo no nulo:

                        val obj: Any? = null
                        val str: String = obj as String
                        // lanza kotlin.TypeCastException: null cannot be cast to non-null type kotlin.String

                        // el tipo objetivo del cating debería ser anulable para que el casting funcione:

                        val obj: Any? = null
                        val str: String? = obj as String?   // funciona y no lanza ninguna excepción
                        println(str)                        // imprime null

            // 2. Operador serguro de casting: as?

                // Como se comentó en la sección anterior, el operador de cast de tipo as lanza una ClassCastException
                // en tiempo de ejecución si el casting no es posible.

                // Kotlin también proporciona un operador de casting segura `as?` que devuelve null en lugar de lanzar
                // una ClassCastException si el casting no es posible:

                        val obj: Any = 123
                        val str: String? = obj as? String   // funciona
                        println(str)                        // imprime null

    // EJEMPLO

        // El siguiente ejemplo demuestra los conceptos de Type Check y Smart Cast de Kotlin utilizando clases definidas
        // por el usuario y herencia:

                open class Animal

                class Cat: Animal() {
                    fun meow() {
                        println("Meow Meow Meow...")
                    }
                }

                class Dog: Animal() {
                    fun bark() {
                        println("Woof Woof Woof...")
                    }
                }

                fun main(args: Array<String>) {
                    val animal: Animal = Cat()

                    if (animal is Cat) {
                        // no se necesita casting explicito para `Cat`
                        println(animal.meow())
                    } else if (animal is Dog) {
                        // no se necesita casting explicito para `Dog`
                        println(animal.bark())
                    }
                }

                // output:
                // Meow Meow Meow...