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

        // Crear el historial de conversiones
        HistorialConversiones historial = new HistorialConversiones();

        while (true) {
            // Mostrar el menú principal
            System.out.println("Seleccione una opción:");
            System.out.println("1. Convertir moneda");
            System.out.println("2. Ver historial de conversiones");
            System.out.println("3. Salir");

            int opcionMenu = scanner.nextInt();

            switch (opcionMenu) {
                case 1:
                    // Proceso de conversión de moneda
                    realizarConversion(scanner, rates, historial);
                    break;

                case 2:
                    // Mostrar el historial
                    historial.mostrarHistorial();
                    break;

                case 3:
                    // Salir del programa
                    System.out.println("Saliendo del programa...");
                    System.out.println("Gracias por usar nuestro servicio!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }

    // Método para realizar la conversión de moneda
    private static void realizarConversion(Scanner scanner, Map<String, Double> rates, HistorialConversiones historial) {
        System.out.println("Seleccione la moneda de origen:");
        String monedaOrigen = seleccionarMoneda(scanner);

        System.out.println("Seleccione la moneda de destino:");
        String monedaDestino = seleccionarMoneda(scanner);

        // Validar si ambas monedas existen en las tasas de cambio
        if (rates.containsKey(monedaOrigen) && rates.containsKey(monedaDestino)) {
            System.out.println("Introduce la cantidad a convertir: ");
            double cantidad = scanner.nextDouble();

            // Realizar la conversión usando las tasas proporcionadas por la API
            double tasaOrigen = rates.get(monedaOrigen);
            double tasaDestino = rates.get(monedaDestino);
            double resultado = (cantidad / tasaOrigen) * tasaDestino;

            // Mostrar el resultado de la conversión
            System.out.printf("%.2f %s equivalen a %.2f %s%n", cantidad, monedaOrigen, resultado, monedaDestino);

            // Agregar al historial
            String conversion = String.format("%.2f %s equivalen a %.2f %s", cantidad, monedaOrigen, resultado, monedaDestino);
            historial.agregarConversion(conversion);

        } else {
            System.out.println("Una de las monedas seleccionadas no está disponible en las tasas de cambio.");
        }
    }

    // Metodo para mostrar el menú y seleccionar la moneda
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