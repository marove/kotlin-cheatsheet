
// NULABILIDAD Y TIPOS 'NULABLES'

  // Kotlin apoya la nulabilidad como parte de su sistema de tipos -> el compilador puede detectar posibles errores de 'NullPointerException'
  // en tiempo de compilación y reducir la posibilidad de que sean lanzados en tiempo de ejecución.

  // Todas las variables en Kotlin son no-nulables por defecto -> si se intenta asignar un valor nulo a una variable regular,
  // el compilador lanzará un error:
  
        var greeting: String = "Hello, World"
        greeting = null   // error de compilación

  // Para permitir valores nulos -> se debe declarar una variable como nula añadiendo un signo de interrogación en su
  // declaración de tipo:

        var nullableGreeting: String? = "Hello, World"
        nullableGreeting = null   // funciona

  // Kotlin desactiva las llamadas a los métodos y el acceso a las propiedades de las variables nullables y, por lo
  // tanto, evita muchas posibles excepciones al NullPointerExceptions.
  // Por ejemplo, los siguientes métodos de acceso funcionan porque Kotlin sabe que la variable 'greeting' nunca puede
  // ser nula:

      val len = greeting.length 
      val upper = greeting.toUpperCase()

  // ... pero el siguiente método no funcionará con la variable 'nullableGreeting':

      val len = nullableGreeting.length           // error de compilación
      val upper = nullableGreeting.toUpperCase()  // error de compilación

  // En conclusión -> como Kotlin sabe de antemano qué variable puede ser nula y cuál no -> puede detectar y rechazar
  // llamadas que podrían resultar en NullPointerException en tiempo de compilación.


// TRABAJANDO CON TIPOS NULABLES

  // Formas:

    // A - Agregando un comprobación de valor nulo antes de acceder a un valor o método de la variable:

            val nullableName: String? = "John"

            if (nullableName != null) {
                println("Hello, ${nullableName.toUpperCase()}.")
                println("Your name is ${nullableName.length} characters long.")
            } else {
                println("Hello, Guest")
            }

      // una vez que realiza la comparación con null, el compilador lo recuerda y permite llamadas a toUpperCase() y length
      // dentro de la rama if.


    // B - Operador de suguridad '?' :

      // las comparaciones nulas son simples pero demasiado verbosos. Kotlin proporciona un operador de seguridad, '?'
      // que reduce esta verbosidad -> permite combinar una llamada a un método y una llamada a un método en una sola expresión.

      // ejemplo:
      
            val nullableName: String? = null
            
            nullableName?.toUpperCase()

      // es equivalente a:
      
            if (nullableName != null) 
              nullableName.toUpperCase()
            else
              null    


      // por tanto si se quiere mostrar el nombre en mayúsculas y su longitud de forma segura, se puede hacer lo siguiente:
         
            val nullableName: String? = null

            println(nullableName?.toUpperCase())
            println(nullableName?.length)
            // imprime por pantalla:
            null
            null

      // si en cambio se quiere realizar una operación si la variable es no null, se puede utilizar el operador de
      // llamada seguro 'let'
        
            val nullableName: String? = null

            nullableName?.let { println(it.toUpperCase()) } 
            nullableName?.let { println(it.length) }
            // no imprime nada -> las expresiones lambda dentro de let sólo se ejecutarán si la variabe 'nullableName' no es nula

      // se pueden también realizar múltiples llamadas en cadena:

            val currentCity: String? = user?.address?.city    // currentCity será nulo si alguna de las variables 'user', 'address' o 'city' es nula


    // C - Operador Elvis '?:' :

      // El operador Elvis se usa para proveer de un valor por defecto cuando la variable original es nula:
        
            val name = nullableName ?: "Guest"     

      // equivale a
        
            val name = if(nullableName != null) nullableName else "Guest"

      // El operador Elvis se utiliza a menudo con el operador de llamadas seguro '?' para proporcionar un
      // valor por defecto distinto de nulo cuando la variable en la que se llama a un método o propiedad es nula:
        
            val currentCity = user?.address?.city ?: "Unknown"


      // además, se puede usar expresiones throw y return en el lado derecho del operador de Elvis -> ésto es muy útil
      // cuando se verifican las condiciones previas de una función -> así que en lugar de proporcionar un valor por
      // defecto en el lado derecho del operador de Elvis, puedes lanzar una excepción como ésta:
        
            val name = nullableName ?: throw IllegalArgumentException("Name can not be null")


    // D - Operador aserción no nula '!!' :

      // el operador !! convierte un tipo nullable a un tipo no-nullable, y lanza un NullPointerException si el tipo
      // nulable contiene un valor nulo -> por tanto es una forma de pedir un NullPointerException explícitamente ->
      // RECOMENDABLE NO UTILIZAR ESTE OPERADOR:
          
            val nullableName: String? = null
            nullableName!!.toUpperCase() // lanza NullPointerException


// LA SEGURIDAD DE NULOS Y SU INTEROPERABILIDAD CON JAVA

  // Kotlin es totalmente interoperable con Java, pero Java no soporta la nulabilidad en su sistema de tipos -> ¿entonces
  // qué pasa cuando llamas a código Java con Kotlin?

  // Los tipos Java son tratados especialmente en Kotlin: se llaman 'platform types' (tipos de plataforma) -> dado que
  // Kotlin no tiene ninguna información sobre la nulabilidad de un tipo declarado en Java, relaja las comprobaciones de
  // nulabilidad en tiempo de compilación para estos tipos -> el compilador permitirá todas las operaciones y por lo tanto,
  // no se obtiene ninguna garantía de 'null safety' para los tipos declarados en Java

  // Si se sabe que la variable Java puede ser nula -> habrá que compararla con null antes de usarla, de lo contrario, al igual
  // que con Java, se obtendrá un NullPointerException en tiempo de ejecución si el valor es nulo.
  
  // ejemplo:

      public class User {
          private final String name;

          public User(String name) {
              this.name = name;
          }

          public String getName() {
              return name;
          }
      }

      // Como Kotlin no sabe acerca de la nulabilidad de la variable miembro 'name', permite todas las operaciones en esta variable -> 
      // se puede tratar como nulable o no, pero el compilador no forzará a nada.

      // en este ejemplo, tratamos la variable 'name' como  no-nulable y llamamos a métodos y propiedades suyas
        
            val javaUser = User(null)

            println(javaUser.name.toUpperCase()) // permitido -> lanzaria NullPointerException
            println(javaUser.name.length)        // permitido -> lanzaria NullPointerException

      // la otra opcion es tratarla como nulable y usar el operador de seguridad para llamar a sus métodos y propiedades:
        
          val javaUser = User(null)
       
          println(javaUser.name?.toUpperCase()) // permitido -> imprimiría null
          println(javaUser.name?.length)        // permitido -> imprimiria null


  // ANOTACIONES DE NULABILIDAD

    // Aunque java no soporta en su sistema de tipos la nulabilidad, se pueden usar las anotaciones @Nullable y @NotNull
    // proporcionadas por paquetes externos como javax.validation.constraints, org.jetbrains.annotations etc, para marcar
    // la variable como nulable o not-null.

    // El compilador de java no usa estas anotaciones, pero sí IDEs, ORMs y otras herramientas y librerias externas para
    // proporcionar asistencia mientras se trabaja con valores nulos.

    // Kotlin también respeta éstas anotaciones cuando están presentes en código Java -> los tipos de Java que tienen dichas
    // anotaciones se representan como tipos nulables o no-nulables de Kotlin en vez de tipos de plataforma Java.

// COLECCIONES Y NULABILIDAD

  // El API de colecciones de Kotlin está construido sobre el API de colleciones de Java, y soporta la nulabilidad en sus colecciones

  // Como las variables son no-nulables por defecto, una colección normal también no puede contener valores nulos:
    
        val regularList: List<Int> = listOf(1, 2, null, 3)  // error de compilación

  // COLECCION DE TIPOS NULABLES

    // Declaración:
      
        val listOfNullableTypes: List<Int?> = listOf(1, 2, null, 3)   // funciona

    // Para filtrar valores no nulos de una lista de tipos nulables, puedes usar la funcion filterNotNull():
      
        val notNullList: List<Int?> = listOfNullableTypes.filterNotNull()

    // COLECCION NULABLE

      // La diferencia entre una colección de tipos nulables y una colección nulable es que -> una colección de tipos
      // nulables pueden tener valores nulos pero la colección en sí misma no puede ser nula:

            var listOfNullableTypes: List<Int?> = listOf(1, 2, null, 3) // funciona
            listOfNullableTypes = null // error de compilación

      // se puede declarar una colección nulable así:

            var nullableList: List<Int>? = listOf(1, 2, 3)
            nullableList = null // funciona

