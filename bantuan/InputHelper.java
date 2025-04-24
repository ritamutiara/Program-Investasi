package bantuan;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner scanner = new Scanner(System.in);

    // Method untuk membaca integer
    public static int readNumber(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
            }
        }
    }

    // Method to read a double
    public static double readDouble(String pesan) {
        while (true) {
            try {
                System.out.print(pesan);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
            }
        }
    }

    // Method to read a string
    public static String readString(String pesan) {
        System.out.print(pesan);
        return scanner.nextLine();
    }

    // Static method to close the scanner when program ends
    public static void closeScanner() {
        scanner.close();
    }
}