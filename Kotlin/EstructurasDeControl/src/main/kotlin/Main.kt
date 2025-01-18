
//Declaración de valores de nuestras respuestas
const val RESPUESTA_AFRIMATIVA = "O"
const val RESPUESTA_NEGATIVA = "X"
const val RESPUESTA_DUDOSA = "?"

//Unimos las respuestas con los valores
val respuestas = mapOf(
    "Si" to RESPUESTA_AFRIMATIVA,
    "Es totalmente cierto" to RESPUESTA_AFRIMATIVA,
    "Totalmente" to RESPUESTA_AFRIMATIVA,
    "Sin duda" to RESPUESTA_AFRIMATIVA,
    "Pregunta en otro momento" to RESPUESTA_DUDOSA,
    "No puedo decirte en este momento" to RESPUESTA_DUDOSA,
    "Puede que si o puede que no" to RESPUESTA_DUDOSA,
    "No va a suceder" to RESPUESTA_NEGATIVA,
    "No cuentes con ello" to RESPUESTA_NEGATIVA,
    "Definitivamente no " to RESPUESTA_NEGATIVA,
    "No lo creo" to RESPUESTA_NEGATIVA,

)

fun main(args: Array<String>) {
    println("Hola soy tu bola 8 magica. Caul de estas opciones deseas realizar?")
    println("1.Realizar una pregunta")
    println("2.Realizar todas las respuestas")
    println("3.Salir")

    val  valorIngresado = readLine()
    when(valorIngresado){
        "1" -> realizarPregunta()
        "2" -> mostrarRespuestas()
        "3" -> salir()
        else -> mostrarError()
    }

}

fun mostrarError() {
    println("Vaya parece que has elegido una opcion no valida, intenta de nuevo")
}

fun salir() {
    println("Hasta Luego")
}

fun mostrarRespuestas() {
    println("Selecciona un opción: ")
    println("1.Revisar todas las respuestas")
    println("2.Revisar solo las respuestas afirmativas")
    println("3.Revisar solas las respuestas dudosas")
    println("4.Revisar solo las respuestas negativas")

    val opcionIngresada = readLine()
    when(opcionIngresada){
        "1" ->mostrarRespuestaPorTipo()
        "2" ->mostrarRespuestaPorTipo(tipoDeRespuesta = RESPUESTA_AFRIMATIVA)
        "3" ->mostrarRespuestaPorTipo(tipoDeRespuesta = RESPUESTA_NEGATIVA)
        "4" ->mostrarRespuestaPorTipo(tipoDeRespuesta = RESPUESTA_DUDOSA)
        else -> println("Repuesta no valida... Adios")
    }
}

fun mostrarRespuestaPorTipo(tipoDeRespuesta : String = "Todos") {
    when(tipoDeRespuesta){
        "Todos" -> respuestas.keys.forEach{ respuesta -> println(respuesta)}

        RESPUESTA_AFRIMATIVA -> respuestas.filterValues {
            values -> values == RESPUESTA_AFRIMATIVA
        }.also { respuestasPositivas -> println(respuestasPositivas.keys)}

        RESPUESTA_NEGATIVA -> respuestas.filterValues {
                values -> values == RESPUESTA_NEGATIVA
        }.also { respuestasNegativas -> println(respuestasNegativas.keys)}

        RESPUESTA_DUDOSA -> respuestas.filterValues {
                values -> values == RESPUESTA_DUDOSA
        }.also { respuestasDudosas -> println(respuestasDudosas.keys)}
    }

}

fun realizarPregunta(){
    println("Que pregunta deseas realizar?")
    readLine()
    println("Asi que esa era tu pregunta... ")
    val respuestaGenerada = respuestas.keys.random()
    println(respuestaGenerada)
}

//Estrucutra de Control If
//    val nombre = "Maria"
//
//    if(nombre.isNotEmpty()) println("El largo de nuestra variable es ${nombre.length}") else println("Error, la variable esta vacia")
//
//    var mensaje : String = if (nombre.length>4){
//        "Tu nombre es largo"
//    }else if (nombre.isEmpty()){
//        "Nombre no esta vacio"
//    }
//    else{
//        "Tienes un nombre corto"
//    }
//    println(mensaje)

//Estrucutra de control While y Do while
//    val nombreColor = "Amarillo"
//
//    when(nombreColor){
//        "Amarillo" -> println("El amarillo es el color de la alegria")
//        "Rojo", "Carmesi" -> println("El rojo simboliza el calor")
//        else -> println("Error. No tengo Info del color")
//    }

//Estrucutra de control while
//var contador = 10
//    while (contador>0){
//        println("El valor del contador es $contador")
//        contador --
//    }

//Estructura de control Do/While
//do{
//    println(" Numero aleatorio")
//    val aleatorio = (0..100).random()
//    println("El numero aleatorio es $aleatorio")
//}while (aleatorio>50)

//Estrutura de control For
//val listaDeFrutas = listOf("Manzana", "Bananno", "Papaya", "Uva")
//    for (fruta in listaDeFrutas) println("La fruta a comer es: $fruta")

//Estrutura de control forEach
//val listaDeFrutas = listOf("Manzana", "Bananno", "Papaya", "Uva")
//listaDeFrutas.forEach { fruta -> println("Semana 2 fruta a comer: $fruta")}

//Map /filter
//val listaDeFrutas = listOf("Manzana", "Bananno", "Papaya", "Uva")
//val carateriticas: List<Int> = listaDeFrutas.map { fruta->fruta.length }
//println(carateriticas)
//
//val listaFiltrada = carateriticas.filter { tamanoFruta -> tamanoFruta >5 }
//println(listaFiltrada)

//Try/Catch
//var nombre: String? = null
//println(nombre?.length)
//try {
//    throw NullPointerException("Referncia nula")
//    nombre!!.length
//}catch (exception:NullPointerException){
//    println("Ha ocurrido un error")
//}finally {
//    println("Finalmente ha " +
//            "ocurrido un error..Cerrando aplicación")
//}
//val number1 = 10
//val number2 = 0
//val resultado: Int = try { number1/number2
//
//}catch (exception:Exception){
//    0
//}
//println(resultado)

//listas
//LISTA DE NOMBRE INMUTABLE
//val listaDeNombres = listOf("Ricardo", "Julian", "Felipe")
//println(listaDeNombres)
////LISTA DE NOMBRE MUTABLE
//val listaDeFrutas = mutableListOf<String>()
//println(listaDeFrutas)
//listaDeFrutas.add("Manzana")
//println(listaDeFrutas)
//
//// Operadores para obtener valores de una lista
//val valorUsandoGet = listaDeFrutas.get(0)
//println(valorUsandoGet)
//val valorUsandoOperador = listaDeFrutas[0]
//println(valorUsandoOperador)
//
//val primeValor = listaDeFrutas.firstOrNull()
//println(primeValor)
//
////remover elementos de una lista vacia
//listaDeFrutas.removeAt(0)
//println(listaDeFrutas)
//
//listaDeFrutas.add("Banano")
//println(listaDeFrutas)
//listaDeFrutas.removeIf{caracteres ->caracteres.length>3}
//println(listaDeFrutas)
//
////Convertir una array en list
//val myArray = arrayOf(5,7,9,3)
////println("Nuestro array $myArray")
//println("Array cmo lista ${myArray.toList()}")

//Ordenar listas con las funciones
//
//val numeroAleatorio = listOf(65,54,77,38,10)
//
//val numberSorted = numeroAleatorio.sorted()
//println(numberSorted)
//
//val numerosDecendientes = numeroAleatorio.sortedDescending()
//println(numerosDecendientes)
//
//val ordenarMultiplos = numeroAleatorio.sortedBy { numero -> numero<50 }
//println(ordenarMultiplos)
//
//val numberAletorio = numeroAleatorio.shuffled()
//println(numberAletorio)
//
//val numerosReversa = numeroAleatorio.reversed()
//println(numerosReversa)
//
//val mensajeNumero = numeroAleatorio.map { numero ->
//    "Tu numero de loteria es $numero"
//}
//println(mensajeNumero)
//
//val nuemroFiltrado = numeroAleatorio.filter { numero ->numero <50 }
//println(nuemroFiltrado)

//Funciones
//Como llamar función
//val fraseNormal = "Nunca pares de crecer"
//val ordenada = randomCase(fraseNormal)
//println(ordenada)
//fun randomCase(frase:String):String {
//    val numeroAleatorio = 0..99
//    val resultadoAleatorio = numeroAleatorio.random()
//    return if (resultadoAleatorio.rem(2) ==0){
//        frase.toUpperCase()
//    }else {
//        frase.toLowerCase()
//    }
//}

//Lambdas
//val myLamba : (String) -> Int = {valor ->valor.length}
//val lambaEjecutada : Int = myLamba ("Hello testers")
//println(lambaEjecutada)
//
//val saludos = listOf("Hello", "Good Bye", "See you leter")
//val longitudDeSaludos = saludos.map(myLamba)
//println(longitudDeSaludos)