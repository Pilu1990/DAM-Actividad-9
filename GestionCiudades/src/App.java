import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private List<String> cities;
    private Scanner scanner;

    public App() {
        cities = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = getIntInput("Seleccione una opción: ");
            switch (choice) {
                case 1:
                    addCity();
                    break;
                case 2:
                    showCities();
                    break;
                case 3:
                    searchCity();
                    break;
                case 4:
                    removeCity();
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    exit = true;
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
            System.out.println(); // Línea en blanco para separar iteraciones
        }
        scanner.close();
    }

    private void printMenu() {
        System.out.println("===== Gestión de Ciudades =====");
        System.out.println("1. Agregar ciudad");
        System.out.println("2. Mostrar todas las ciudades");
        System.out.println("3. Buscar ciudad");
        System.out.println("4. Eliminar ciudad");
        System.out.println("5. Salir");
    }

    private void addCity() {
        System.out.print("Ingrese el nombre de la ciudad a agregar: ");
        String city = scanner.nextLine().trim();
        if (city.isEmpty()) {
            System.out.println("El nombre de la ciudad no puede estar vacío.");
            return;
        }
        if (cities.contains(city)) {
            System.out.println("Error: La ciudad '" + city + "' ya existe en la lista.");
        } else {
            cities.add(city);
            System.out.println("Ciudad '" + city + "' agregada correctamente.");
        }
    }

    private void showCities() {
        if (cities.isEmpty()) {
            System.out.println("La lista de ciudades está vacía.");
        } else {
            System.out.println("Ciudades almacenadas:");
            for (int i = 0; i < cities.size(); i++) {
                System.out.println((i + 1) + ". " + cities.get(i));
            }
        }
    }

    private void searchCity() {
        System.out.print("Ingrese el nombre de la ciudad a buscar: ");
        String city = scanner.nextLine().trim();
        if (cities.contains(city)) {
            System.out.println("La ciudad '" + city + "' se encuentra en la lista.");
        } else {
            System.out.println("Error: La ciudad '" + city + "' no existe en la lista.");
        }
    }

    private void removeCity() {
        System.out.print("Ingrese el nombre de la ciudad a eliminar: ");
        String city = scanner.nextLine().trim();
        if (cities.remove(city)) {
            System.out.println("Ciudad '" + city + "' eliminada correctamente.");
        } else {
            System.out.println("Error: La ciudad '" + city + "' no existe en la lista.");
        }
    }

    private int getIntInput(String prompt) {
        int num = -1;
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                num = Integer.parseInt(line);
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
            }
        }
    }

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }
}
    
