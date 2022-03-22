
// HERENCIA

	// la clase que hereda de otra se llama: clase hija, clase derivada o sub-clase
	// la clase cuyas características son heredadas se llama: clase padre, clase base o super-clase.

	// todas las clase en Kotlin tiene una clase base llamada 'Any' -> se correspondería a la clase 'Object' de Java
		
       class Person	// toda clase creada en Kotlin por tanto hereda implícitamente de la super-clase 'Any':
	
	// la clase Any contiene tres métodos llamados 'equals()', 'hashCode()', y 'toString()', pudiendo cualquier clase de
	// proveer de su propia implementación


	  // CREANDO CLASES PADRES E HIJAS

		  // así se declara una clase padre y una clase hija en Kotlin:	
			  
          open class Computer {	// super-clase
			    }


			class Laptop: Computer() {	// sub-clase
			}

		// la clase hija tiene la responsabilidad de inicializar la clase padre -> si la clase hija tiene un constructor
		// primario -> entonces debe inicializarse la clase padre justo en el encabezado de la clase con los parámetros
		// pasados a su constructor primario:
			// clase padre
			open class Computer(val name: String,
								val brand: String) {
			}

			// clase hija (inicializa la clase padre)
			class Laptop(name: String, 
						 brand: String, 
						 val batteryLife: Double) : Computer(name, brand) {

			}

		// si la clase hija no tiene un constructor primario, entonces todos sus constructores secundarios tienen que
		// inicializar la clase padre, ya sea llamando a la palabra clase 'super' o sino delegando a otro constructor
		// primario o secundario que lo haga:
			class Laptop : Computer {
				
				val batteryLife: Double

				// llama a super() para inicializar la clase padre
				constructor(name: String, brand: String, batteryLife: Double): super(name, brand) {
					this.batteryLife = batteryLife
				}

				// llama a otro constructor (el cuál llama a super())
				constructor(name: String, brand: String): this(name, brand, 0.0) {

				}
			}
		// sólo hay que tener en cuenta que la clase padre necesita ser inicializada -> no importa cuál de sus constructores
		// se utilice para inicializarlo


	// EJEMPLO DE HERENCIA CON PROPIEDADES Y MÉTODOS DE CLASE

		// se trata de una aplicación de banca donde la gente tiene distintos tipos de cuentas bancarias como SavingsAccount,
		// CurrentAccount, etc.

		// tiene sentido crear una clase padre llamada 'BankAccount' y que clases com 'SavingsAccount' y 
		// 'CurrentAccount' hereden de ella:

			/**
			 * BankAccount (Base Class)
			 * @property accountNumber - Account Number (read-only)
			 * @property accountName -  Account Name (read-only)
			 * @property balance - Current Balance (Mutable)
			 */

			open class BankAccount(val accountNumber: String, val accountName: String) {
				var balance : Double = 0.0

				fun depositeMoney(amount: Double): Boolean {
					if(amount > 0) {
						balance += amount
						return true
					} else {
						return false
					}
				}

				fun withdrawMoney(amount: Double): Boolean {
					if(amount > balance) {
						return false
					} else {
						balance -= amount
						return true
					}
				}

			}

		// la clase 'SavingsAccount' (cuenta de ahorros) es ima cuenta bancaria con alguna tasa de interés sobre el monto
		// del saldo:

			/**
			 * SavingsAccount (Derived Class)
			 * @property interestRate - Interest Rate for SavingsAccount (read-only)
			 * @constructor - Primary constructor for creating a Savings Account
			 * @param accountNumber - Account Number (used to initialize BankAccount)
			 * @param accountName - Account Name (used to initialize BankAccount)
			 */

			class SavingsAccount (accountNumber: String, accountName: String, val interestRate: Double) :
					BankAccount(accountNumber, accountName) {

				fun depositInterest() {
					val interest = balance * interestRate / 100
					this.depositeMoney(interest);
				}
			}
			// la clase SavingsAccount está herendando de la clase padre:
				// atributos -> accountNumber, accountName, balance
				// métodos -> depositMoney, withdrawMoney

		// testeo de las clases:
			fun main(args: Array<String>) {
				
				// crea una cuenta de ahorro con un interés del 6%
				val savingsAccount = SavingsAccount("64524627", "Rajeev Kumar Singh", 6.0)

				savingsAccount.depositeMoney(1000.0)

				savingsAccount.depositInterest()

				println("Current Balance = ${savingsAccount.balance}")
			}


	// SOBREESCRIBIENDO MÉTODOS DE CLASE

		// al igual que con las clases, los métodos de una clase Kotlin también son finales por defecto -> para permitir que
		// una función de miembro sea anulada, es necesario marcarla con el modificador abierto

		// además, la clase hija que sobreescribe un método de una clase padre debe usar el modificador 'override' -> sino el
		// compilador generará un error

		// ejemplo:
			open class Teacher {
				// debe usar el modificador 'open' para permitir a una clase sobreescribir éste método
				open fun teach() {
					println("Teaching...")
				}
			}

			class MathsTeacher : Teacher() {
				// debe usar el modificador "override" para sobreescribir un método de una clase padre
				override fun teach() {
					println("Teaching Maths...")
				}
			}

			fun main(args: Array<String>) {
				val teacher = Teacher()
				val mathsTeacher = MathsTeacher()

				teacher.teach()  // Teaching...
				mathsTeacher.teach() // Teaching Maths..
			}

		// POLIMORFISMO DINÁMICO

			// existen dos tipos de polimorfismo en la programación oritentada a objetos:
				
				// A - polimorfismo estático -> en tiempo de compilación

					// ocurre cuando defines múltiples métodos sobreescritos con el mismo nombre pero diferentes firmas

					// se llama polimorfismo en tiempo de compilación porque el compilador puede decidir a qué método
					// llamar al compilar

				// B - polimorfismo dinámico -> en tiempo de ejecución

					// ocurre en caso de sobreescritura de método

					// en éste caso, la función que se llama se decide en tiempo de ejecución

			// ejemplo:

				fun main(args: Array<String>) {
					
					val teacher1: Teacher = Teacher()  		// Teacher referencia a Teacher y es objeto Teacher
					val teacher2: Teacher = MathsTeacher() 	// Teacher referencia a Teacher pero es objeto MathsTeacher

					teacher1.teach()	// Teaching...
					teacher2.teach() 	// Teaching Maths..
				}















