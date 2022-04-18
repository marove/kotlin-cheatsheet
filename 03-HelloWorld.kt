package my.demo


// La función main() es el punto de entrada -> es lo primero que se llama cuando se ejecuta un programa Kotlin.
//    v
fun main(args: Array<String>) : Unit {  // Desde Kotlin 1.3 se puede obviar los argumentos como parámetros: fun main() {...}
                                        // Unit equivale a void en Java, y es omitible también -> cuando no se
                                        // específica un tipo de dato de retorno se asume Unit como tal.

    println("Hello World !!")   // el punto y coma es opcional, igual que los lenguajes modernos
                                // Kotlin provee de varios envoltorios sobre las librerías de Java, como println(), que
                                // envuelve el System.out.prinln de Java.
}

/*  main simplificado:

    fun main() {
        println("Hello World !!")
    }
*/
