import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
    private List<String> historial;

    public HistorialConversiones() {
        this.historial = new ArrayList<>();
    }

    // Metodo para agregar una nueva conversión al historial
    public void agregarConversion(String conversion) {
        historial.add(conversion);
    }

    // Metodo para mostrar el historial completo
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay conversiones en el historial.");
        } else {
            System.out.println("\n--- Historial de Conversiones ---");
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
            System.out.println("-------------------------------");
        }
    }
}
