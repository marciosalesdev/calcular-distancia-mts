import java.util.Locale;
import java.util.Scanner;

public class CalcularDistancia {

    public static double calcularGeolocalizacao(double lat1, double lon1, double lat2, double lon2) {
        final int R = 6371000;


        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(lon1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(lon2);


        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;

        // Fórmula de Haversine
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));


        double distance = R * c;

        return distance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);


        System.out.print("Digite a latitude do primeiro ponto: ");
        double latitude1 = scanner.nextDouble();
        System.out.print("Digite a longitude do primeiro ponto: ");
        double longitude1 = scanner.nextDouble();
        System.out.print("Digite a latitude do segundo ponto: ");
        double latitude2 = scanner.nextDouble();
        System.out.print("Digite a longitude do segundo ponto: ");
        double longitude2 = scanner.nextDouble();


        double distance = calcularGeolocalizacao(latitude1, longitude1, latitude2, longitude2);


        System.out.printf("A distância entre os pontos é: %.2f metros%n", distance);

        scanner.close();
    }
}
