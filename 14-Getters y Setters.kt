
// PROPIEDADES DE KOTLIN, BACKING FIELDS, GETTERS Y SETTERS

  // en Kotlin se pueden declarar variables dentro de las clases como cualquier otra variable -> éstas pueden ser
  // mutables (declaradas usando var), o inmutables (declaradas usando val)

  // ejemplo: clase User con un constructor primario que acepta tres parámetros:
      class User(_id: Int, _name: String, _age: Int) {
          // propiedades de la clase User
          val id: Int = _id               // Immutable (sólo lectura)
          var name: String = _name        // Mutable
          var age: Int = _age             // Mutable
      }

  // se pueden obtener o setear las propiedades de un objeto usando el punto (.):
    val user = User(1, "Jack Sparrow", 44)

    // obteniendo una propiedad
    val name = user.name

    // seteando una propiedad
    user.age = 46

    // no se pueden setear propiedades inmutables
    user.id = 2	// Error: Val cannot be assigned

  
  // GETTERS Y SETTERS

    // Kotlin internamente genere un getter y setter por defecto para las propiedades mutables, y únicamente un getter
    // para propiedades inmutables

    // Kotlin llama a éstos getters y setters internamente ya sea accediendo o modificando una propiedad usando la
    // notacion punto (.)

    // así es como la clase User se ve con los getters y setters por defecto:
      class User(_id: Int, _name: String, _age: Int) {
        val id: Int = _id
            get() = field

        var name: String = _name
            get() = field
            set(value) {
                field = value
            }

        var age: Int = _age
            get() = field
            set(value) {
                field = value
            }
      }

      // identificador 'value':

        // utilizamos 'value' como parámetro del setter -> es la convención por defecto de Kotlin pero se puede usar
        // cualquier otro si se prefiere

        // dicho parámetro 'value' contiene el valor que es asignado a una propiedad
        // por ejemplo cuando escribes user.name = "Bill Gates", el parámetro 'value' contiene el valor asignado "Bill Gates"
        // 

      // identificador 'field' (backing field)

        // el campo de respaldo (backing field) ayuda a referirse a la propiedad dentro de los métodos getter y setter
        
        // esto es necesario porque si usas la propiedad directamente dentro del getter o setter se lanzará una llamada recursiva
        // que generará un StackOverflowError

        // ejemplo: se modifica la clase User haciéndose referencia a las propiedades directamente dentro de los getters y setters
        // en lugar de usar el identificador 'field':
          class User(_name: String, _age: Int) {
            var name: String = _name
                get() = name		  // llama al getter recursivamente

            var age: Int = _age
                set(value) {
                    age = value   // llama al setter recursivamente
                }
          }

          fun main(args: Array<String>) {
            val user = User("Jack Sparrow", 44)

            // obteniendo una propiedad
            println("${user.name}") // genera StackOverflowError

            // seteando una propiedad
            user.age = 45           // genera StackOverflowError

          }
          
       // el programa anterior generará un StackOverflowError debido a las llamadas recursivas en los métodos getter y
       // setter -> por eso Kotlin tiene el concepto de campos de respaldo (backing field) -> permite almacenar el valor
       // de la propiedad en la memoria -> cuando se inicializa una propiedad con un valor en la clase, el valor del
       // inicializador se escribe en el campo de respaldo de esa propiedad:
         class User(_id: Int) {
           val id: Int	= _id   // el valor inicializador se escribe en el campo de respaldo (backing field) de la propiedad
         }

      // un campo de respaldo se genera para la propiedad si:
        // A - un getter/setter personalizado lo referencia a través del identificador 'field'
        // B - se utiliza la implementación por defecto de al menos uno de los getter o setter -> hay que recordar que el
        //     getter y setter por defecto hace referencia al identificador de campo en sí mismo

      // por ejemplo un campo de respaldo (backing field) no se genera para la propiedad 'id' en la siguiente clase porque ni
      // usa la implementación por defecto del getter ni se refiere al identificador 'field' en el getter personalizado:
        class User() {
          val id	// ningún campo de respaldo (backing field) se genera
          get() = 0
        }

      // como un campo de respaldo (backing field) no es generado, no se será capaz de inicializar la siguiente propiedad tampoco:
        class User(_id: Int) {
          val id: Int = _id	  // Error: inicializacion no posible porque no se genera un campo de respaldo que pueda grabar el valor inicializado en memoria
          get() = 0
        }


    // CREANDO GETTERS Y SETTERS PERSONALIZADOS

      // se puede definir un getter y setter personalizado para los atributos de las clases en Kotlin, y deshacerse del
      // getter/setter por defecto:
      class User(_id: Int, _name: String, _age: Int) {
        val id: Int = _id

        var name: String = _name 
            // Getter personalizado
            get() {     
                return field.toUpperCase()
            }     

        var age: Int = _age
            // Setter personalizado
            set(value) {
                field = if(value > 0) value else throw IllegalArgumentException("Age must be greater than zero")
            }
      }

      fun main(args: Array<String>) {
          val user = User(1, "Jack Sparrow", 44)

          println("${user.name}") // JACK SPARROW

          user.age = -1           // lanza excepción IllegalArgumentException: Age must be greater that zero
      }






