class Pelicula(var nombrePelicula: String, var creadorPelicula: String, var edadMinima: Int) {
    constructor() : this("", "", 0)

    override fun toString(): String {
        return "Nombre: $nombrePelicula, Creador: $creadorPelicula, Edad Minima: $edadMinima"
    }
}

fun main() {
    val peliculas = mutableMapOf<Int, Pelicula>()
    var contador = 1

    while (true) {
        println("┌───────────── Menu ─────────────┐")
        println("│  1: Insertar nueva película    │")
        println("│  2: Buscar película por clave  │")
        println("│  3: Borrar película por clave  │")
        println("│  4: Editar película            │")
        println("│  5: Mostrar peliculas          │")
        println("│  6: Cerrar sesion              │")
        println("└────────────────────────────────┘")
        print("─ Selecciona una opción: ")


        when (readLine()?.toIntOrNull()) {
            1 -> {
                val pelicula = Pelicula()
                print("Introduce el nombre: ")
                pelicula.nombrePelicula = readLine()!!
                print("Introduce el creador : ")
                pelicula.creadorPelicula = readLine()!!
                print("Introduce la edad minima para ver esta pelicula: ")
                pelicula.edadMinima = readLine()?.toIntOrNull() ?: 0

                peliculas[contador] = pelicula
                contador++
            }
            2 -> {
                print("Introduce la clave de la película (si no la sabes ve a la opcion 5): ")
                val clave = readLine()?.toIntOrNull()
                val pelicula = peliculas[clave]
                if (pelicula != null) {
                    println("┌───────────────────── Pelicula Encontrada ─────────────────────┐")
                    println("  " + pelicula)
                    println("└───────────────────────────────────────────────────────────────┘")
                } else {
                    println("┌──────────────────────────────────────────────┐")
                    println("|  No se ha encontrado pelicula con esa clave  |")
                    println("└──────────────────────────────────────────────┘")
                }
            }
            3 -> {
                print("Introduce la clave de la película a borrar (si no la sabes ve a la opcion 5): ")
                val clave = readLine()?.toIntOrNull()
                if (peliculas.remove(clave) != null) {
                    println("┌───────────────────────────────────┐")
                    println("|  Película borrada correctamente.  |")
                    println("└───────────────────────────────────┘")
                } else {
                    println("┌────────────────────────────────────────────────────────┐")
                    println("   No se ha encontrado pelicula con la clave $clave")
                    println("└────────────────────────────────────────────────────────┘")
                }
            }
            4 -> {
                print("Introduce la clave de la película a editar (si no la sabes ve a la opcion 5): ")
                val codigo = readLine()?.toIntOrNull()
                val pelicula = peliculas[codigo]
                if (pelicula != null) {
                    print("Introduce el nuevo nombre (actual: ${pelicula.nombrePelicula}): ")
                    pelicula.nombrePelicula = readLine()!!
                    print("Introduce el nuevo creador (actual: ${pelicula.creadorPelicula}): ")
                    pelicula.creadorPelicula = readLine()!!
                    print("Introduce la nueva edad minima (actual: ${pelicula.edadMinima}): ")
                    pelicula.edadMinima = readLine()?.toIntOrNull() ?: 0
                    println("Película editada correctamente.")
                } else {
                    println("┌───────────────────────────┐")
                    println("|  Película no encontrada.  |")
                    println("└───────────────────────────┘")
                }
            }
            5 -> {
                println("┌───────────────────── Lista de Películas ─────────────────────┐")
                peliculas.forEach { (key, value) ->
                    println("    $key: $value                                               ")
                }
                println("└──────────────────────────────────────────────────────────────┘")

            }
            6 -> {
                println("┌───────────────────┐")
                println("|  SESION CERRADA.  |")
                println("└───────────────────┘")
                return
            }
            else -> println("Seleccione un numero del 1 al 6")
        }
    }
}
