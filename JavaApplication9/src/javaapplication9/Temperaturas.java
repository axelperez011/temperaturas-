import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Temperaturas {
    public static void main(String[] args) {
        String archivo = "temperaturas.txt"; // Cambia el nombre del archivo a .txt
        int[] temperaturas = new int[24];
        
        // Aqui se lee las temperaturas desde el archivo
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            for (int i = 0; i < 24; i++) {
                temperaturas[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return;
        }

        
        System.out.println("Temperaturas para 24 horas:");
        System.out.println("-30 0 30 60 90 120");
        
      
        for (int t = -30; t <= 120; t += 3) {
            System.out.printf("%3d |", t);
            int count = 0;

            for (int temp : temperaturas) {
                if (temp >= t && temp < t + 3) {
                    count++;
                }
            }

            int numAsteriscos = count; // Cada asterisco representa un intervalo de 3 grados
            for (int i = 0; i < numAsteriscos; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
