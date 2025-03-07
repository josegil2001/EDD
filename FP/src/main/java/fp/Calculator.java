package fp;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class Calculator {
	/*
	 * este metodo devuelve el Class del object que le pasamos
	 */
	public static Class classTypeOf(Object x) {
		return x.getClass();
	}


	/*
	 * devuelve una lista con los n números de la serie de fibonacci.
	 */
	public static List<Integer> fibonacci(int n) {
		List<Integer> fibonnaciList = new ArrayList<Integer>();
		Integer n1 = 0, n2 = 1;
		fibonnaciList.add(1);

		for (int i = 0; i < n - 1; i++) {
			Integer summa = n1 + n2;
			n1 = n2;
			n2 = summa;
			fibonnaciList.add(summa);
		}

		return fibonnaciList;
	}

	/*
	 * Escribir todos los números del number al 0 de step en step.
	 */
	public static int[] stepThisNumber(int number, int step) {
		List<Integer> cadena = new ArrayList<>();
		while (number - step > 0){
			cadena.add(number = number - step);
		}
		return Conversor(cadena);
	}

	public static int[] Conversor(List<Integer> list) {
		int[] cadena = new int[list.size()];
		for (int i=0; i< list.size(); i++){
			cadena[i]= list.get(i);
		}
		return cadena;
	}

	/*
	 * Módulo al que se le pasa un número entero del 0 al 20 y devuelve los
	 * divisores que tiene.
	 */
	public static int[] divisors(int n) {
		List<Integer> list = new ArrayList<>();
		if (n == 0)
			return null;
		if (n >= 0 && n <= 20) {
			int counter = 0;
			for (int i = 20; i > 0; i--) {
				if (n % i == 0) {
					list.add(i);
				}
			}

			return Conversor(list);
		}
		return new int[]{-1};
	}

	/*
	 * Toma como parámetros una cadena de caracteres y devuelve cierto si la cadena resulta ser un palíndromo
	 */
	public static boolean checkIsPalindrome(String _cadena) {
		if (_cadena == null) {
			return false;
		}
		String cadena = StringUtils.stripAccents(_cadena).toLowerCase();
		cadena = cadena.replaceAll(" ", "");
		cadena = cadena.replaceAll("\\.", "");
		cadena = cadena.replaceAll(",", "");
		cadena = cadena.replaceAll("\\?", "");
		cadena = cadena.replaceAll("\\¿", "");
		cadena = cadena.replaceAll(":", "");
		cadena = cadena.replaceAll("·", "");

		int i = 0, j = cadena.length() - 1;
		while (i < j) {
			if (cadena.charAt(i) != cadena.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;
	}

	/*
	 * Pedir un número de 0 a 99 y mostrarlo escrito. Por ejemplo, para 56
	 * mostrar: cincuenta y seis
	 */
	public static String speakToMe(int n) {
		int iUnidad = n % 10;
		n = n / 10;
		String sTexto = unidadEnTexto(iUnidad);
		int iDecena = n % 10;
		n = n / 10;

		if ((iUnidad == 0) && (iDecena > 0)) {
			sTexto = decenaEnTexto(iDecena);
		} else if (iDecena == 1) {
			sTexto = decenas(10 + iUnidad);
		} else if (iDecena > 1) {
			sTexto = decenaEnTexto(iDecena) + " y " + sTexto.toLowerCase();
		}
		return sTexto;
	}

	public static String unidadEnTexto (int num){
		switch (num){
			case 0:
				return "Cero";
			case 1:
				return "Uno";
			case 2:
				return "Dos";
			case 3:
				return "Tres";
			case 4:
				return "Cuatro";
			case 5:
				return "Cinco";
			case 6:
				return "Seis";
			case 7:
				return "Siete";
			case 8:
				return "Ocho";
			case 9:
				return "Nueve";
			default:
				return "";
		}
	}
	public static String decenaEnTexto(int num) {
		switch (num) {
			case 1:
				return "Diez";
			case 2:
				return "Veinte";
			case 3:
				return "Treinta";
			case 4:
				return "Cuarenta";
			case 5:
				return "Cincuenta";
			case 6:
				return "Sesenta";
			case 7:
				return "Setenta";
			case 8:
				return "Ochenta";
			case 9:
				return "Noventa";
			default:
				return "";
		}
	}
	public static String decenas(int num){
		switch (num) {
			case 11:
				return "Once";
			case 12:
				return "Doce";
			case 13:
				return "Trece";
			case 14:
				return "Catorce";
			case 15:
				return "Quince";
			case 16:
				return "Dieciseis";
			case 17:
				return "Diecisiete";
			case 18:
				return "Dieciocho";
			case 19:
				return "Diecinueve";
			default:
				return "";
		}
	}

	/*
	 * este metodo devuelve cierto si el año de la fecha es bisiesto fecha
	 * dd-MM-yyyy
	 */
	public static boolean isLeapYear(String fecha) {
		if (fecha == "")
			return false;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return LocalDate.parse(fecha, formatter).isLeapYear();
	}

	/*
	 * este metodo devuelve cierto si la fecha es válida
	 */
	public static boolean isValidDate(String date) {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		dateFormat.setLenient(false);
		try {
			dateFormat.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
}