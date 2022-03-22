
// CLASES

  // para crear una clase se usa la palabra clave 'class':
    
      class Person {
      }

  // las llaves se pueden omitir si la clase no tiene cuerpo:
    
      class Person

  // una instancia de objeto de la clase se puede crear usando el constructor por defecto:
    
      val person = Person() // no se necesita 'new' como en Java -> de hecho no es una palabra clave en Kotlin


  // PROPIEDADES DE CLASE

    // se pueden declarar las propiedades de la clase (variables de miembro) en el cuerpo de la clase de la misma manera
    // a como se declara cualquier otra variable de kotlin
    // dichas declaraciones pueden ser declaradas como mutables (con la palabra clave var) o inmutables y sólo lectura
    // (con la palabra clave val):

        class Person {
          // propiedades o variables de miembro
          var firstName: String
          var lastName: String
        }

    // si sólo están declaradas las propiedades sin definirse como se crearán, no compilará
    // se debe por tanto o bien declarar un constructor o proporcionar valores por defecto a las propiedades:

        class Person {
          var firstName: String = "Guest"
          var lastName: String = ""
        }


  // CONSTRUCTORES

    // un constructor es un tipo especial de función de miembro que es usado para inicializar el estado o propiedades
    // de objetos de recién creación de la clase -> es invocado cuando se crea una instancia de la clase

    // toda clase necesita tener un constructor -> si no se declara uno explícitamente, el compilador genera un
    // constructor por defecto

    // existen dos tipos de constructores en Kotlin:
      
      // A - CONSTRUCTOR PRIMARIO
      // B - CONSTRUCTOR SECUNDARIO

    // una clase Kotlin puede tener un constructor primario y uno o más constructores secundarios

    // CONSTRUCTOR PRIMARIO

      // es parte del encabezado de la clase y declarado despúes del nombre de ésta:
        
          class Person constructor(firstName: String, lastName: String) {
          }

      // se puede omitir la palabra clave 'constructor' del constructor primario si no contiene ninguna anotación o
      // modificador de visibilidad (public, private o protected)
        
          class Person(firstName: String, lastName: String) {
          }

      // BLOQUE INICIALIZADOR

        // el constructor primario no puede contener ningún código -> toda la lógica de inicialización está escrita
        // dentro de un bloque inicializador que contiene el prefijo 'init' (palabra clave):

            class Person(_firstName: String, _lastName: String) {
              // propiedades/atributos de clase (variables miembro)
              var firstName: String
              var lastName: String

              // bloque inicializador
              init {
                  this.firstName = _firstName
                  this.lastName = _lastName

                  println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
              }
            }

            // en vez de inicializar las propiedades en el bloque 'init', se pueden inicializar en el propio cuerpo de
            // la clase:
            class Person (_firstName: String, _lastName: String) {
              // propiedades/atributos de clase (variables miembro)
              var firstName: String = _firstName
              var lastName: String = _lastName

              // Initializer Block
              init {
                  println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
              }
            }

        // una instancia de la clase anterior se crea de la forma siguiente:
          
            val p = Person("Jack", "Dorsey")

      // SINTAXIS CONCISA DE KOTLIN PARA DECLARAR E INICIALIZAR PROPIEDADES

        // Kotlin tiene una sintaxis concisa para declarar propiedades e inicializarlas desde el constructor primario
        // la siguiente clase sería equivalente a la anterior:
          
            class Person(var firstName: String, var lastName: String) {
              // bloque inicializador
              init {
                  println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
              }
            }

        // ésta es sintaxis lo que hace es permitir declarar directamente las propiedades de la clase dentro del 
        // constructor primario usando las palabras clave 'val' o 'var'

      // VALORES POR DEFECTO EN EL CONSTRUCTOR

        // se puede también proporcionar valores por defecto a las propiedades de la clase justo dentro del constructor
        // primario:

            class Person(var firstName: String = "Guest", var lastName: String = "") {
              // bloque inicializador
              init {
                println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
              }
            }


        // esto permite omitir los parámetros de las propiedaes al crear el objeto, siendo las siguientes llamadas
        // permitidas ahora:

            val person1 = Person("Jack", "Dorsey")  // imprime: Initialized a new Person object with firstName = Jack and lastName = Dorsey
            val person2 = Person("Jack")            // imprime: Initialized a new Person object with firstName = Jack and lastName = 
            val person3 = Person()                  // imprime: Initialized a new Person object with firstName = Guest and lastName = 


    // CONSTRUCTOR SECUNDARIO

      // aparte del constructor primario, se puede declarar uno o más constructores secundarios en la clase

      // se prefijan con la palabra clave 'constructor' y se declaran dentro del cuerpo de la clase:
        
          class Person {
            // propiedades
            var firstName: String
            var lastName: String

            // constructor secundario
            constructor(firstName: String, lastName: String)  {
                this.firstName = firstName
                this.lastName = lastName
            }
          }

      // se pueden combinar a la vez el constructor primario y secundario en la misma clase

      // cada constructor secundario debe llamar al constructor primario, directa o indirectamente a través de otro
      // constructor secundario:

          class Person(var firstName: String, var lastName: String) {
            var age: Int? = null

            // constructor secundario
            constructor(firstName: String, lastName: String, age: Int): this(firstName, lastName)  {
                this.age = if(age > 0) age else throw IllegalArgumentException("Age must be greater than zero")
            }
          }

      // ahora se puede instanciar un objeto usando o el constructor primario o el secundario:
        
          val person1 = Person("Bill", "Gates")     // llama al constructor primario (la edad será nula en éste caso)
          val person2 = Person("Jeff", "Bezos", 53) // llama al constructor secundario
      

      // también se pueden tener múltiples constructores secundarios sobrebacargados en la clase:
        
          class Person(var firstName: String, var lastName: String) {
            var age: Int? = null
            var phoneNumber: String? = null

            // constructor secundario
            constructor(firstName: String, lastName: String, age: Int): this(firstName, lastName)  {
                this.age = if(age > 0) age else throw IllegalArgumentException("Age must be greater than zero")
            }

            // constructor secundario
            constructor(firstName: String, lastName: String, age: Int, phoneNumber: String): this(firstName, lastName, age)  {
                this.phoneNumber = phoneNumber
            }
          }


  // MOODIFICADORES DE VISIBILIDAD

    // nos ayudan a rescringir la accesibilidad a clases, objetos, constructores, funciones o propiedades

    // existen cuatro tipos de visibilidad en kotlin: 'public', 'private', 'protected' y 'internal'

    // ámbitos de acceso de los modificadores de visibilidad:

      // public

        // cualquier elemento declarado publico es accesible desde cualquier lugar

      // private 

        // clase / función (top-level) -> accesible desde sólo el fichero donde es declara
        // miembro de función/constructor/propiedad de clase -> accesible desde sólo la clase donde es declarado

      // protected

        // propiedad de clase / función -> accesile desde la misma clase o subclases

      // internal -> accesible desde el mismo módulo -> un módulo es un set de ficheros compilados juntos (por ejemplo
      //             un proyecto maven o gradle


  // ACCEDIENDO Y SETEANDO PROPIEDADES   

    // no se necesita definir getters y setters como en Java -> Kotlin automáticamente genera un getter implícito para
    // propiedades mutables, y únicamente un getter para propiedades inmutables/sólo lectura

    // se accede a las propiedades usando el punto (.) :
        
        val person = Person("John", "Smith")
        println(person.firstName) // John
        println(person.lastName)  // Smith

    // y para setear propiedades, simplemente se les asigna un nuevo valor:
      
        val person = Person("Steve", "Wozniak")
        person.lastName = "Jobs"
        println("Name = ${person.firstName} ${person.lastName}") // Name = Steve Jobs

    // ejemplo con propiedades inmutables/sólo lectura:

        class Student (val rollNumber: Int, val name: String)

        val student = Student(1, "John")
        println(student.rollNumber)
        println(student.name)

        student.name = "Jack" // Error: Val cannot be assigned

