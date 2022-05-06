
// NULABILIDAD

  // declaracion
  
    var name: String = "Manuel Romero"
    name = null           // error de compilación


    var nullableName: String? = "Manuel Romero"
    nullableName = null   // funciona

  // tratamiento
  
    // llamadas en cadena
    user?.address?.city                                 

    // metodo de dominio  -> se ejecuta toUpperCase() tanto como si es nulo como que no nullableName
    nullableName?.toUpperCase()

    // operacion          -> se ejecuta toUpperCase() solo si no es nulo nullableName
    nullableName?.let { 
      println(it.toUpperCase())
    }

    // operador elvis (if-else)
    nullableName ?: "Guest"                                                   
    nullableName ?: throw IllegalArgumentException("Name can not be null")
    nullableName ?: run {
      // ejecutar algun codigo
    }


// CLASES Y OBJETOS

    
