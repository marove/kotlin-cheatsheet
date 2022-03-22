
// NULABILIDAD

  // declaracion
  
    var name: String = "Manuel Romero"
    name = null   // error de compilación


    var nullableName: String? = "Manuel Romero"
    nullableName = null   // funciona

  // tratamiento
  
    // llamadas en cadena
    user?.address?.city                                 

    // metodo de dominio
    nullableName?.toUpperCase()

    // operacion
    nullableName?.let { 
      println(it.toUpperCase())
    }

    // operador elvis (if-else)
    nullableName ?: "Guest"                                                   
    nullableName ?: throw IllegalArgumentException("Name can not be null")


// CLASES Y OBJETOS

    
