import kotlin.math.abs
import kotlin.math.floor
import kotlin.math.roundToLong

object Depurar {
    val ROJO = "\u001B[31m"
    val RESET = "\u001B[0m"

    //Lee un número por teclado y repite hasta que sea válido
    fun leerDouble (mensaje:String): Double {
        var n : Double? = null;
        do {
            print(mensaje);
            n = readln().replace(",", ".").toDoubleOrNull();
            if (n == null) {
                println("$ROJO Error: entrada no válida, introduce un número $RESET")
            }
        } while (n == null)
        return n;
    }

    //Lee un número y repite hasta que sea mayor o igual que el mínimo indicado
    fun leerDoubleMinimo (mensaje:String, minimo:Double, mensajeError:String): Double {
        var n : Double = 0.0;
        do {
            n = leerDouble(mensaje);

            if (n < minimo) {
                println("$ROJO $mensajeError $RESET")
            }
        } while (n < minimo)
        return n;
    }

    //Cantidad que no puede ser negativa (divisas y distancias)
    fun leerCantidad (mensaje:String): Double {
        return leerDoubleMinimo(mensaje, 0.0, "Error: la cantidad no puede ser negativa.");
    }

    //Quita los decimales sobrantes: 10000.0 -> 10000 y 6.2137119 -> 6.2137
    fun formatear (numero:Double): String {
        val redondeado : Double = (numero * 10000).roundToLong() / 10000.0;
        if (redondeado == floor(redondeado) && abs(redondeado) < 1.0E15) {
            return redondeado.toLong().toString();
        }
        return redondeado.toString();
    }

}
