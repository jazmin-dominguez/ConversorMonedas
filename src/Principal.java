import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConvertidorApp api = new ConvertidorApp();

        // ¡IMPORTANTE! Reemplaza esto con tu API Key real
        String apiKey = "1f352c5b005ec32b669b6815";

        int opcion = 0;

        while (opcion != 7) {
            System.out.println("*********************************************************");
            System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
            System.out.println("\n1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("\nElija una opción válida:");
            System.out.println("*********************************************************");

            opcion = lectura.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.println("Ingrese el valor que deseas convertir:");
                double cantidad = lectura.nextDouble();
                String base = "";
                String target = "";

                // Asignamos las monedas según la opción elegida
                switch (opcion) {
                    case 1 -> { base = "USD"; target = "ARS"; }
                    case 2 -> { base = "ARS"; target = "USD"; }
                    case 3 -> { base = "USD"; target = "BRL"; }
                    case 4 -> { base = "BRL"; target = "USD"; }
                    case 5 -> { base = "USD"; target = "COP"; }
                    case 6 -> { base = "COP"; target = "USD"; }
                }

                try {
                    // Llamamos a nuestra API
                    double resultado = api.obtenerConversion(base, target, cantidad, apiKey);
                    System.out.println("\nEl valor " + cantidad + " [" + base + "] corresponde al valor final de =>>> " + resultado + " [" + target + "]\n");
                } catch (Exception e) {
                    System.out.println("Ocurrió un error: " + e.getMessage());
                }
            } else if (opcion != 7) {
                System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        System.out.println("Gracias por usar el conversor de monedas. ¡Hasta luego!");
        lectura.close();
    }
}
