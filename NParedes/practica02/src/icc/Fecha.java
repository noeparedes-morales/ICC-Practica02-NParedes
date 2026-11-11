/**
 * Clase para representar y manipular fechas en una institución bancaria
 * @author Noé Paredes Morales
 * @version 1a edición
 */

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

    // Métodos constructores para crear la fecha inicial

    /**
     * Constructor por omisión para crear la fecha inicial sin parámetros (1 de enero del 2000).
     */

    public Fecha(){
	this.dia = 1;
	this.mes = 1;
	this.anio = 2000;
    }

    /**
     * Constructor de una fecha a partir del día, el mes y el anio como enteros.
     * @param d - valor entero para el día
     * @param m - valor entero para el mes
     * @param a - valor entero para el anio
     */

    public Fecha(int d, int m, int a){
	asignarAnio(a);
	asignarMes(m);
	asignarDia(d);
    }

    /** Constructor de una fecha a partir del día y anio como enteros y una cadena con el nombre del mes.
     * @param d - valor entero para el día
     * @param nombreMes - cadena con el nombre del mes
     * @param a - valor entero para el anio
     */

    public Fecha(int d, String nombreMes, int a){
	asignarAnio(a);
	asignarMes(mesANumero(nombreMes));
	asignarDia(d);
    }

    // Métodos modificadores para asignar valor a los campos de una fecha.

    /**
     * Método para asignar el anio a la fecha.
     * @param a - anio para el objeto Fecha
     */

    public void asignarAnio(int a) {
	if (a > 0) {
	    anio = a;
	} else {
	    System.out.println("El valor " + a + " no es apropiado para el anio.");
	    anio = 2000;
	}
    }

    /** Método para asignar el mes a la fecha (número entero entre 1 y 12).
     * @param m - mes para el objeto Fecha
     */

    public void asignarMes(int m) {
	if (m >= 1 && m <= 12) {
	    mes = m;
	} else {
	    System.out.println("El valor " + m + " no es apropiado para el mes.");
	    mes = 1;
	}
    }

    /** Método para asignar el día validando el límite de días del mes actual.
     * @param d - el día pra el objeto Fecha
     */

    public void asignarDia(int d) {
	int maxDias = diasEnMes(mes, anio);
	if (d >= 1 && d <= maxDias) {
	    dia = d;
	} else {
	    System.out.println("El valor " + d + " no es apropiado para el día.");
	    dia = 1;
	}
    }

    // Métodos de acceso para obtener los campos de una fecha.

    /**
     * Método para obtener el día de la fecha.
     * @return int - el día del objeto Fecha
     */

    public int obtenerDia() {
	return dia;
    }

    /**
     * Método para obtener el mes de la fecha.
     * @return int - el mes del objeto Fecha
     */

    public int obtenerMes() {
	return mes;
    }

    /**
     * Método para obtener el anio de la fecha.
     * @return int - el anio del objeto Fecha
     */

    public int obtenerAnio() {
	return anio;
    }

    // Métodos calculadores para la conversión entre nombre de mes y número de mes.

    /**
     * Método que devuelve el número correspondiente a un mes a partir de que reciba una cadena con su nombre.
     * @param nombreMes - cadena con el nombre del mes
     * @return int - número del mes (1 al 12), o -1 si el nomnre no es válido
     */

    public int mesANumero(String nombreMes) {
	String m = nombreMes.trim().toLowerCase();
	int num = -1;

	if (m.equals("enero")) {
	    num = 1;
	} else if (m.equals("febrero")) {
	    num = 2;
	} else if (m.equals("marzo")) {
	    num = 3;
	} else if (m.equals ("abril")) {
	    num = 4;
	} else if (m.equals ("mayo")) {
	    num = 5;
	} else if (m.equals ("junio")) {
	    num = 6;
	} else if (m.equals ("julio")) {
	    num = 7;
	} else if (m.equals ("agosto")) {
	    num = 8;
	} else if (m.equals ("septiembre")){
	    num = 9;
	} else if (m.equals ("octubre")) {
	    num = 10;
	} else if (m.equals ("noviembre")){
	    num = 11;
	} else if (m.equals ("diciembre")){
	    num = 12;
	}
	return num;
    }

    /**
     * Método que devuelve la cadena correspondiente a un mes a partir de que reciba un número.
     * @param m - número del mes (1 a 12)
     * @return String - cadena con el nombre del mes
     */

    public String numeroAMes(int m) {
	String nombre = "mes invalido";

	if (m == 1) {
	    nombre = "enero";
	} else if (m == 2) {
	    nombre = "febrero";
	} else if (m == 3) {
	    nombre = "marzo";
	} else if (m == 4) {
	    nombre = "abril";
	} else if (m == 5) {
	    nombre = "mayo";
	} else if (m == 6) {
	    nombre = "junio";
	} else if (m == 7) {
	    nombre = "julio";
	} else if (m == 8) {
	    nombre = "agosto";
	} else if (m == 9) {
	    nombre = "septiembre";
	} else if (m == 10) {
	    nombre = "octubre";
	} else if (m == 11) {
	    nombre = "noviembre";
	} else if (m == 12) {
	    nombre = "diciembre";
	}
	return nombre;
    }

    // Métodos auxiliares

    /**
     * Método privado para determinar si un anio es bisiesto.
     */

    private boolean esBisiesto(int a) {
	return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
    }

    /**
     * Método privado que devuelve la cantidad de días que tiene un mes específico.
     */

    private int diasEnMes(int m, int a) {
	int dias = 31;
	if (m == 4 || m == 6 || m == 9 || m == 11) {
	    dias = 30;
	} else if (m == 2) {
	    if (esBisiesto(a)){
	    dias = 29;
	} else {
	    dias = 28;
	    }
	}
	return dias;
    }

    /**
     * Método privado que devuelve el total de días acumulados en los meses completos previos al mes m dentro del mismo anio.
     */

    private int diasAcumuladosAntesDelMes(int m, int a) {
	int acumulados = 0;
	if (m == 2) {
	    acumulados = 31;
	} else if (m == 3) {
	    acumulados = 59;
	} else if (m == 4) {
	    acumulados = 90;
	} else if (m == 5) {
	    acumulados = 120;
	} else if (m == 6) {
	    acumulados = 151;
	} else if (m == 7) {
	    acumulados = 181;
	} else if (m == 8) {
	    acumulados = 212;
	} else if (m == 9) {
	    acumulados = 243;
	} else if (m == 10) {
	    acumulados = 273;
	} else if (m == 11) {
	    acumulados = 304;
	} else if (m == 12) {
	    acumulados = 334;
	}

	if (m > 2 && esBisiesto(a)) {
	    acumulados ++;
	}
	return acumulados;
    }

    /**
     * Método privado para convertir una Fecha a un número entero que representa el total de días transcurridos desde el inicio del calendario.
     */

    private int enDias() {
	int aPrev = anio - 1;
	int diasAnios = aPrev * 365 + (aPrev / 4) - (aPrev / 100) + (aPrev / 400);
	return diasAnios + diasTranscurridos() + 1;
    }

    /**
     * Método privado para convertir un número entero en días totales en un objeto de la clase Fecha.
     */

    private Fecha enFecha(int totalDias) {
	int a = (totalDias / 366) + 1;
	int prev = a - 1;
	int diasHastaAnio = prev * 365 + (prev / 4) - (prev / 100) + (prev / 400);

	if (diasHastaAnio >= totalDias) {
	    do {
		a--;
		prev = a - 1;
		diasHastaAnio = prev * 365 + (prev / 4) - (prev / 100) + (prev / 400);
	    } while (diasHastaAnio >= totalDias);
	} else {
		int diasAnioActual = 365;
		if (esBisiesto(a)) {
		    diasAnioActual = 366;
		}
		if (totalDias - diasHastaAnio > diasAnioActual) {
		    do {
			a++;
			prev = a -1;
			diasHastaAnio = prev * 365 + (prev / 4) - (prev / 100) + (prev / 400);
			diasAnioActual = 365;
			if (esBisiesto(a)) {
			    diasAnioActual = 366;
			}
		    } while (totalDias - diasHastaAnio > diasAnioActual);
		}
	}

	int restantes = totalDias - diasHastaAnio;
	int m = 1;

	if (restantes > diasEnMes(m, a)) {
	    do {
		restantes -= diasEnMes(m, a);
		m++;
	    } while (restantes > diasEnMes(m, a));
	}

	return new Fecha (restantes, m, a);
    }

    // Métodos calculadores para fechas y días transcurridos.

    /**
     * Método para obtener la diferencia entre dos fechas (en días).
     * @param f - fecha a partir de la cual se calcula la diferencia
     * @return int - cantidad de días de diferencia entre ambas fechas
     */

    public int diferenciaEnDias(Fecha f) {
	return Math.abs(this.enDias() - f.enDias());
    }

    /**
     * Método que dada la fecha actual y un número entero que representa una cantidad de días, devuelve la nueva fecha que corresponde.
     * Por ejemplo: con 3-9-2013 y 5 devuelve 8-9-2013 y con -2 devuelve 1-9-2013
     * @param dias - cantidad de días a sumar o restar
     * @return Fecha - nuevo objeto Fecha con la fecha resultante
     */

    public Fecha obtenerFechaMasDias(int dias) {
	return enFecha(this.enDias() + dias);
    }

    /**
     * Método que especifica los días transcurridos en el anio hasta la fecha.
     * Por ejemplo, 30 de diciembre de 2013 devuelve 364
     * @return int - cantidad de dias transcurridos en el anio
     */

    public int diasTranscurridos() {
	return diasAcumuladosAntesDelMes(mes, anio) + (dia -1);
    }

    /**
     * Método para determinar si dos fechas son iguales.
     * @param obj - fecha contra la cual se va a comprara
     * @return boolean - true si tienen el mismo estado y false en otro caso
     */

    public boolean equals(Object obj) {
	Fecha otra = (Fecha) obj;
	return this.dia == otra.dia && this.mes == otra.mes && this.anio == otra.anio;
    }

    /**
     * Método para representar una fecha en el formado dd/mes/aaaa, donde dd es el día, mes es el nombre del mes y aaaa son cuatro dígitos que representan el anio.
     * @return String - la fecha en formato dd/mes/aaaa
     */

    public String toString() {
	String cadDia = "" + dia;
	if (dia < 10) {
	    cadDia = "0" + dia;
	}
	return cadDia + "/" + numeroAMes(mes) + "/" + anio;
    }

    // Métodos auxiliares para validar los datos de Fecha introducidos por el usuario
    
     /**
     * Método auxiliar para verificar si una cadena correspone a un nombre de mes válido.
     * @param mesTexto - nombre del mes ingresado por el usuario
     * @return boolean - true si es un mes válido, false en caso contrario
     */

    public static boolean esMesValido(String mesTexto) {
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

    public static int obtenerDiasDelMes(String mesTexto, int anio) {
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
     
}
