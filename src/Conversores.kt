object Conversores {
    //Factores de conversión fijos
    val dolar = 1.08
    val libra = 0.86
    val yen = 163.0
    val francoSuizo = 0.95

    val metrosPorKm = 1000.0
    val cmPorMetro = 100.0
    val kmPorMilla = 1.609344

    val kelvinCero = 273.15

    fun menuPrincipal () {
        var salirValido : Boolean = false;

        while (!salirValido) {
            pintarMenu();
            val opcion = readln();
            when (opcion) {
                "1" -> {
                    menuDivisas();
                }

                "2" -> {
                    menuDistancias();
                }

                "3" -> {
                    menuTemperaturas();
                }

                "4" -> {
                    println("Saliendo del programa...")
                    salirValido = true;
                }
                else -> println("${Depurar.ROJO} Error: opción no válida. ${Depurar.RESET}")
            }
        }

    }

    fun pintarMenu () {
        println("===== CONVERSOR DE UNIDADES =====\n" +
                "1. Conversor de divisas\n" +
                "2. Conversor de distancias\n" +
                "3. Conversor de temperaturas\n" +
                "4. Salir\n" +
                "Seleccione una opción:")
    }

    //Muestra el resultado de cualquier conversión: 10 kilómetros equivalen a 10000 metros.
    fun mostrarResultado (cantidad : Double, origen : String, res : Double, destino : String) {
        println("${Depurar.formatear(cantidad)} $origen equivalen a ${Depurar.formatear(res)} $destino.")
    }

    // ===================== DIVISAS =====================

    fun menuDivisas () {
        var volverValido : Boolean = false;
        var cantidad : Double = 0.0;
        var res : Double = 0.0;
        val mensaje = "Introduzca la cantidad en euros: ";

        while (!volverValido) {
            pintarMenuDivisas();
            val opcion = readln();
            when (opcion) {
                "1" -> {
                    //Euros a dólares
                    cantidad = Depurar.leerCantidad(mensaje);

                    res = eurosADolares(cantidad);

                    mostrarResultado(cantidad, "euros", res, "dólares")
                }

                "2" -> {
                    //Euros a libras
                    cantidad = Depurar.leerCantidad(mensaje);

                    res = eurosALibras(cantidad);

                    mostrarResultado(cantidad, "euros", res, "libras esterlinas")
                }

                "3" -> {
                    //Euros a yenes
                    cantidad = Depurar.leerCantidad(mensaje);

                    res = eurosAYenes(cantidad);

                    mostrarResultado(cantidad, "euros", res, "yenes")
                }

                "4" -> {
                    //Euros a francos suizos
                    cantidad = Depurar.leerCantidad(mensaje);

                    res = eurosAFrancos(cantidad);

                    mostrarResultado(cantidad, "euros", res, "francos suizos")
                }

                "5" -> {
                    volverValido = true;
                }
                else -> println("${Depurar.ROJO} Error: opción no válida. ${Depurar.RESET}")
            }
        }
    }

    fun pintarMenuDivisas () {
        println("===== CONVERSOR DE DIVISAS =====\n" +
                "1. Euros a dólares\n" +
                "2. Euros a libras esterlinas\n" +
                "3. Euros a yenes\n" +
                "4. Euros a francos suizos\n" +
                "5. Volver al menú principal\n" +
                "Seleccione una opción:")
    }

    fun eurosADolares(euros : Double) : Double {
        var res : Double = euros * dolar;
        return res;
    }

    fun eurosALibras(euros : Double) : Double {
        var res : Double = euros * libra;
        return res;
    }

    fun eurosAYenes(euros : Double) : Double {
        var res : Double = euros * yen;
        return res;
    }

    fun eurosAFrancos(euros : Double) : Double {
        var res : Double = euros * francoSuizo;
        return res;
    }

    // ===================== DISTANCIAS =====================

    fun menuDistancias () {
        var volverValido : Boolean = false;
        var distancia : Double = 0.0;
        var res : Double = 0.0;

        while (!volverValido) {
            pintarMenuDistancias();
            val opcion = readln();
            when (opcion) {
                "1" -> {
                    //Kilómetros a metros
                    distancia = Depurar.leerCantidad("Introduzca la distancia en kilómetros: ");

                    res = kmAMetros(distancia);

                    mostrarResultado(distancia, "kilómetros", res, "metros")
                }

                "2" -> {
                    //Metros a kilómetros
                    distancia = Depurar.leerCantidad("Introduzca la distancia en metros: ");

                    res = metrosAKm(distancia);

                    mostrarResultado(distancia, "metros", res, "kilómetros")
                }

                "3" -> {
                    //Kilómetros a millas
                    distancia = Depurar.leerCantidad("Introduzca la distancia en kilómetros: ");

                    res = kmAMillas(distancia);

                    mostrarResultado(distancia, "kilómetros", res, "millas")
                }

                "4" -> {
                    //Millas a kilómetros
                    distancia = Depurar.leerCantidad("Introduzca la distancia en millas: ");

                    res = millasAKm(distancia);

                    mostrarResultado(distancia, "millas", res, "kilómetros")
                }

                "5" -> {
                    //Centímetros a metros
                    distancia = Depurar.leerCantidad("Introduzca la distancia en centímetros: ");

                    res = cmAMetros(distancia);

                    mostrarResultado(distancia, "centímetros", res, "metros")
                }

                "6" -> {
                    volverValido = true;
                }
                else -> println("${Depurar.ROJO} Error: opción no válida. ${Depurar.RESET}")
            }
        }
    }

    fun pintarMenuDistancias () {
        println("===== CONVERSOR DE DISTANCIAS =====\n" +
                "1. Kilómetros a metros\n" +
                "2. Metros a kilómetros\n" +
                "3. Kilómetros a millas\n" +
                "4. Millas a kilómetros\n" +
                "5. Centímetros a metros\n" +
                "6. Volver al menú principal\n" +
                "Seleccione una opción:")
    }

    fun kmAMetros(km : Double) : Double {
        var res : Double = km * metrosPorKm;
        return res;
    }

    fun metrosAKm(metros : Double) : Double {
        var res : Double = metros / metrosPorKm;
        return res;
    }

    fun kmAMillas(km : Double) : Double {
        var res : Double = km / kmPorMilla;
        return res;
    }

    fun millasAKm(millas : Double) : Double {
        var res : Double = millas * kmPorMilla;
        return res;
    }

    fun cmAMetros(cm : Double) : Double {
        var res : Double = cm / cmPorMetro;
        return res;
    }

    // ===================== TEMPERATURAS =====================

    fun menuTemperaturas () {
        var volverValido : Boolean = false;
        var temperatura : Double = 0.0;
        var res : Double = 0.0;

        //Mínimos posibles de cada escala (cero absoluto)
        val minimoCelsius = -kelvinCero;
        val minimoFahrenheit = -459.67;

        while (!volverValido) {
            pintarMenuTemperaturas();
            val opcion = readln();
            when (opcion) {
                "1" -> {
                    //Celsius a Fahrenheit
                    temperatura = Depurar.leerDoubleMinimo("Introduzca la temperatura en Celsius: ", minimoCelsius,
                        "Error: la temperatura en Celsius no puede ser inferior a -273.15.");

                    res = celsiusAFahrenheit(temperatura);

                    mostrarResultado(temperatura, "grados Celsius", res, "grados Fahrenheit")
                }

                "2" -> {
                    //Fahrenheit a Celsius
                    temperatura = Depurar.leerDoubleMinimo("Introduzca la temperatura en Fahrenheit: ", minimoFahrenheit,
                        "Error: la temperatura en Fahrenheit no puede ser inferior a -459.67.");

                    res = fahrenheitACelsius(temperatura);

                    mostrarResultado(temperatura, "grados Fahrenheit", res, "grados Celsius")
                }

                "3" -> {
                    //Celsius a Kelvin
                    temperatura = Depurar.leerDoubleMinimo("Introduzca la temperatura en Celsius: ", minimoCelsius,
                        "Error: la temperatura en Celsius no puede ser inferior a -273.15.");

                    res = celsiusAKelvin(temperatura);

                    mostrarResultado(temperatura, "grados Celsius", res, "Kelvin")
                }

                "4" -> {
                    //Kelvin a Celsius
                    temperatura = Depurar.leerDoubleMinimo("Introduzca la temperatura en Kelvin: ", 0.0,
                        "Error: la temperatura en Kelvin no puede ser inferior a 0.");

                    res = kelvinACelsius(temperatura);

                    mostrarResultado(temperatura, "Kelvin", res, "grados Celsius")
                }

                "5" -> {
                    volverValido = true;
                }
                else -> println("${Depurar.ROJO} Error: opción no válida. ${Depurar.RESET}")
            }
        }
    }

    fun pintarMenuTemperaturas () {
        println("===== CONVERSOR DE TEMPERATURAS =====\n" +
                "1. Celsius a Fahrenheit\n" +
                "2. Fahrenheit a Celsius\n" +
                "3. Celsius a Kelvin\n" +
                "4. Kelvin a Celsius\n" +
                "5. Volver al menú principal\n" +
                "Seleccione una opción:")
    }

    fun celsiusAFahrenheit(celsius : Double) : Double {
        var res : Double = celsius * 9 / 5 + 32;
        return res;
    }

    fun fahrenheitACelsius(fahrenheit : Double) : Double {
        var res : Double = (fahrenheit - 32) * 5 / 9;
        return res;
    }

    fun celsiusAKelvin(celsius : Double) : Double {
        var res : Double = celsius + kelvinCero;
        return res;
    }

    fun kelvinACelsius(kelvin : Double) : Double {
        var res : Double = kelvin - kelvinCero;
        return res;
    }

}
