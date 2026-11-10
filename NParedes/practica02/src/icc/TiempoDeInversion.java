import java.util.Scanner;

/**
 * Clase para simular el tiempo y rendimiento de una inversión bancaria
 * @author Noé Paredes Morales
 * @version 1a edición
 */

public class TiempoDeInversion {
    
    /**
     * Método auxiliar para leer una fecha desde el parámetro ingresado en el teclado.
     * Permite ingresarla en una sola línea (por ejemplo: 07/noviembre/2026, 7-11-2026)
     * @param in - objeto Scanner para lectura de teclado
     * @return Fecha - el objeto Fecha creado con los datos del usuario
     */

    private static Fecha leerFecha(Scanner in) {
	int d, a;
	String mTexto;
	boolean fechaValida = false;

	do {
	    System.out.println("Ingrese el número de día (por ejemplo, 5, 31): ");
	    d = in.nextInt();
	    in.nextLine();

	    do {
		System.out.println("Ingrese el nombre del mes (por ejemplo, noviembre): ");
		mTexto = in.nextLine().trim();

		if (!esMesValido(mTexto)) {
		    System.out.println("Error: '" + mTexto + "' no es un mes válido. Por favor verifique la ortografía e intente nuevamente.");
		}
	    } while (!esMesValido(mTexto));

	System.out.println("Ingrese el anio en 4 dígitos numéricos (por ejemplo, 2026): ");
	a = in.nextInt();
	in.nextLine();

	int diasMaximos = obtenerDiasDelMes(mTexto, a);
	if (d >=1 && d <= diasMaximos) {
	    fechaValida = true;
	} else {
	    System.out.println("Error: el mes de " + mTexto + " de " + a + " solo tiene " + diasMaximos + " días (usted ingresó " + d + ").");
	    System.out.println("Por favor, ingrese los datos de la fecha nuevamente.");
	}

	} while (!fechaValida);
 
	return new Fecha(d, mTexto, a);
    }

    /**
     * Método auxiliar para verificar si una cadena correspone a un nombre de mes válido.
     * @param mesTexto - nombre del mes ingresado por el usuario
     * @return boolean - true si es un mes válido, false en caso contrario
     */

    private static boolean esMesValido(String mesTexto) {
	String m = mesTexto.trim().toLowerCase();
	return m.equals("enero") || m.equals("febrero") || m.equals("marzo") || m.equals("abril") ||
	       m.equals("mayo") || m.equals("junio") || m.equals("julio") || m.equals("agosto") ||
	    m.equals("septiembre") || m.equals("octubre") || m.equals("noviembre") || m.equals("diciembre");
    }

    /**
     * Método auxiliar para obtener la cantidad máxima de días de un mes
     * @param mesTexto - nombre del mes
     * @param anio - anio a evaluar
     * @return int - número máximo de días
     */

    private static int obtenerDiasDelMes(String mesTexto, int anio) {
	String m = mesTexto.trim().toLowerCase();

	if (m.equals("febrero")) {
	    if ((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)) {
		return 29;
	    }
	    return 28;
	}

	if (m.equals("abril") || m.equals("junio") || m.equals("septiembre") || m.equals("noviembre")) {
	    return 30;
	}

	return 31;
    }
    
    /**
     * Método auxiliar para determinar si la fecha final es cronológicamente posterior a la fecha de inicio.
     * @param fInicio - fecha inicial de comparación
     * @param fFin - fecha final de comparación
     * @return boolean - true si la fFin es posterior a fInicio, false en caso contrario
     */

    public static boolean esPosterior(Fecha fInicio, Fecha fFin) {
	if (fFin.obtenerAnio() != fInicio.obtenerAnio()) {
	    return fFin.obtenerAnio() > fInicio.obtenerAnio();
	}
	if (fFin.obtenerMes() != fInicio.obtenerMes()) {
	    return fFin.obtenerMes() > fInicio.obtenerMes();
	}
	return fFin.obtenerDia() > fInicio.obtenerDia();
    }
     
    /**
     * Método auxiliar para expresar una cantidad monetaria con centavos a dos decimales.
     * @param cantidad - valor numérico a expresar con dos decimales
     * @return String - texto con formato de pesos y centavos
     */

    private static String redondearCentavos(double cantidad) {
	long totalCentavos = (long)(cantidad * 100.0 + 0.5);
	long pesos = totalCentavos / 100;
	long centavos = totalCentavos % 100;

	String cadCentavos = "" + centavos;
	if (centavos < 10) {
	    cadCentavos = "0" + centavos;
	}
	
	return pesos + "." + cadCentavos;
    }

    /**
     * Método principal donde se inicia la ejecución de la simulación
     * @param pps - parámetros del método main
     */

    public static void main(String[] pps) {
	Scanner in = new Scanner(System.in);
	String inversionista;
	String respuesta;
	double monto;
	Fecha fechaInicio;
	Fecha fechaFin;
	int diasInversion;
	double rendimiento;

	// Brindar la bienvenida y solicitar el nombre del inversionista
	System.out.println(" ** Bienvenido al Simulador Bancario de Inversión **");
	System.out.println("Por favor, escriba su nombre: ");

	// Recabar el nombre del inversionista
	inversionista = in.nextLine().trim();

	// Ciclo do-while para repetir los siguientes pasos 1 al 7

	do {
	    
	    // Paso 1. Saludar al inversionista y preguntar por el monto a invertir
	    System.out.println("Hola " + inversionista + ", ¿cuál es el monto que desea invertir? Por favor escriba el monto numérico sin signo de pesos:");

	    // Paso 2. Recabar monto
	    monto = in.nextDouble();
	    in.nextLine();

	    // Paso 3. Preguntar por una fecha de inicio de inversión
	    System.out.println("Por favor proporcione la fecha de incio de la inversión.");

	    // Paso 4. Recabar la fecha de inicio de inversión
	    fechaInicio = leerFecha(in);

	    //Paso 5. Preguntar por una fecha de finalización de la inversión
	    System.out.println("Finalmente, por favor proporcione la fecha de finalización de la inversión.");

	    // Paso 6. Recabar la fecha de finalización de la inversión y solcitar nuevamente los datos en caso de error en fechas
	    do {
		fechaFin = leerFecha(in);

		if (!esPosterior(fechaInicio, fechaFin)){
		    System.out.println("Error. La fecha de finalización debe ser posterior a la fecha de inicio (" + fechaInicio + "). Intente nuevamente ingresando la fecha de finalización de la inversión.");
		}
	    
	    } while (!esPosterior(fechaInicio, fechaFin));

	    //Paso 7. Mostrar al usuario cuántos días duraría su inversión y su rendimiento al 12%
	    diasInversion = fechaInicio.diferenciaEnDias(fechaFin);

	    //Cálculo proporcional del rendimiento al 12% anual por lo días de inversión en 365 días
	    rendimiento = monto * 0.12 * ((double) diasInversion / 365.0);

	    //Cálculo del monto total
	    double montoTotal = monto + rendimiento;

	    //Imprimir resultados
	    System.out.println("** Resumen de la simulación **");
	    System.out.println("Inversionista: " + inversionista);
	    System.out.println("Fecha de inicio: " + fechaInicio);
	    System.out.println("Fecha de término: " + fechaFin);
	    System.out.println("Días de inversion: " + diasInversion + " dias");
	    System.out.println("Monto invertido: $" + redondearCentavos(monto));
	    System.out.println("Rendimiento al 12% anual: $" + redondearCentavos(rendimiento));
	    System.out.println("Monto final al finalizar el periodo de inversión (monto inicial + rendimiento): $" + redondearCentavos(montoTotal));

	    // Preguntar si el usuario desea hacer otra simulación. Si responde sí, volver al Paso 1
	    boolean respuestaValida = false;
	    do {
		System.out.print("¿Desea realizar otra simulación? (si / no): ");
		respuesta = in.nextLine().trim().toLowerCase();

		if (respuesta.equals("si") || respuesta.equals("sí") ||
		    respuesta.equals("no")) {
		    
		    respuestaValida = true;
		    
		} else {
		    System.out.println("Opción no válida. Por favor responda 'si' o 'no'.");
		}
		
	    } while (!respuestaValida);

	} while (respuesta.equals("si") || respuesta.equals("sí"));
	
	System.out.println("Gracias por utilizar el simulador, " + inversionista + ". ¡Hasta luego!");
    }
}
