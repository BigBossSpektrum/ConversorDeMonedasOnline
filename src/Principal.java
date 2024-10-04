import java.util.Map;
import java.util.Scanner;

public class Principal {

    // Lista de 10 monedas populares (abreviaciones)
    private static final String[] MONEDAS_POPULARES = {
            "USD", "EUR", "CNY", "GBP", "JPY", "AUD", "CAD", "COP", "VES", "BRL"
    };

    // Nombres completos de las monedas
    private static final String[] NOMBRES_MONEDAS = {
            "Dólar estadounidense", "Euro", "Yuan chino", "Libra esterlina", "Yen japonés", "Dólar australiano",
            "Dólar canadiense", "Pesos Colombianos", "Bolivares", "Real Brasileño"
    };

    public static void main(String[] args) {
        // Instancia de la clase que consulta la API
        ConsultaAPI consulta = new ConsultaAPI();

        // Obtener las tasas de cambio
        Conversor conversor = consulta.consultaPrecio();
        Map<String, Double> rates = conversor.getConversionRates();

        // Crear el scanner para la entrada de datos del usuario
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una moneda a convertir: ");
            String monedaOrigen = seleccionarMoneda(scanner);

            if (monedaOrigen.equalsIgnoreCase("Salir")) {
                System.out.println("Saliendo del programa...");
                System.out.println("Gracias por usar nuestro servicio!");
                break;
            }

            System.out.println("Seleccione una opción para convertir: " + monedaOrigen);
            String monedaDestino = seleccionarMoneda(scanner);

            if (monedaDestino.equalsIgnoreCase("Salir")) {
                System.out.println("Saliendo del programa...");
                break;
            }

            // Validar si ambas monedas existen en las tasas de cambio
            if (rates.containsKey(monedaOrigen) && rates.containsKey(monedaDestino)) {
                System.out.println("Introduce la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();

                // Realizar la conversión
                double tasaCambioOrigen = rates.get(monedaOrigen);
                double tasaCambioDestino = rates.get(monedaDestino);
                double tasaConversion = tasaCambioDestino / tasaCambioOrigen;
                double resultado = cantidad * tasaConversion;

                // Mostrar el resultado de la conversión
                System.out.printf("%.2f %s equivalen a %.2f %s%n", cantidad, monedaOrigen, resultado, monedaDestino);
            } else {
                System.out.println("Una de las monedas no es válida.");
            }

            // Preguntar si el usuario desea realizar otra conversión o salir
            System.out.println("¿Deseas realizar otra conversión? (si/no)");
            String respuesta = scanner.next();
            if (respuesta.equalsIgnoreCase("no")) {
                System.out.println("Saliendo del programa...");
                System.out.println("Gracias por usar nuestro servicio!");
                break;
            }
        }

        // Cerrar el scanner
        scanner.close();
    }

    // Método para mostrar el menú y seleccionar la moneda
    private static String seleccionarMoneda(Scanner scanner) {
        while (true) {
            // Mostrar las monedas con sus nombres completos
            for (int i = 0; i < MONEDAS_POPULARES.length; i++) {
                System.out.printf("%d. %s (%s)%n", i + 1, MONEDAS_POPULARES[i], NOMBRES_MONEDAS[i]);
            }
            System.out.println("11. Salir");
            System.out.print("Seleccione una opción (1-11): ");

            int opcion = scanner.nextInt();

            if (opcion >= 1 && opcion <= 10) {
                return MONEDAS_POPULARES[opcion - 1];  // Devuelve la moneda seleccionada
            } else if (opcion == 11) {
                return "Salir";  // Opción de salir
            } else {
                System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
