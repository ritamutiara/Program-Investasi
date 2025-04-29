package program;

import akun.Admin;
import fitur.SahamFitur;
import fitur.SBNFitur;
import bantuan.InputHelper;

public class MenuAdmin {
    public static void tampilkan(Admin admin, SahamFitur sahamFitur, SBNFitur sbnFitur) {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("==================================");
            System.out.printf("| %-30s |\n", "MENU ADMIN");
            System.out.println("==================================");
            System.out.printf("| %-2s %-27s |\n", "1.", "Kelola Saham");
            System.out.printf("| %-2s %-27s |\n", "2.", "Kelola SBN");
            System.out.printf("| %-2s %-27s |\n", "3.", "Logout");
            System.out.println("==================================");

            int pilihan = InputHelper.readNumber("Pilih menu: ");

            switch (pilihan) {
                case 1: {
                    menuSaham(admin, sahamFitur);
                    break;
                }
                case 2: {
                    menuSBN(admin, sbnFitur);
                    break;
                }
                case 3: {
                    kembali = true;
                    System.out.println("Logout berhasil.");
                    break;
                }
                default: {
                    System.out.println("Pilihan tidak valid!");
                    break;
                }
            }
        }
    }

    private static void menuSaham(Admin admin, SahamFitur sahamFitur) {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n===== MENU ADMIN SAHAM =====");
            System.out.println("==================================");
            System.out.printf("| %-30s |\n", "MENU KELOLA SAHAM");
            System.out.println("==================================");
            System.out.printf("| %-2s %-27s |\n", "1.", "Tambah Saham");
            System.out.printf("| %-2s %-27s |\n", "2.", "Ubah Harga Saham");
            System.out.printf("| %-2s %-27s |\n", "3.", "Logout");
            System.out.println("==================================");

            int pilihan = InputHelper.readNumber("Pilih menu: ");

            switch (pilihan) {
                case 1: {
                    String kode = InputHelper.readString("Kode saham: ");
                    String nama = InputHelper.readString("Nama perusahaan: ");
                    double harga = InputHelper.readDouble("Harga saham: ");
                    admin.tambahSaham(sahamFitur, kode, nama, harga);
                    break;
                }
                case 2: {
                    sahamFitur.tampilDaftarSaham();
                    String kode = InputHelper.readString("Kode saham: ");
                    double hargaBaru = InputHelper.readDouble("Harga baru: ");
                    admin.ubahHargaSaham(sahamFitur, kode, hargaBaru);
                    break;
                }
                case 3: {
                    kembali = true;
                    break;
                }
                default: {
                    System.out.println("Pilihan tidak valid!");
                    break;
                }
            }
        }
    }

    private static void menuSBN(Admin admin, SBNFitur sbnFitur) {
        boolean kembali = false;
        while (!kembali) {
            System.out.println("\n===== MENU ADMIN SBN =====");
            System.out.println("==================================");
            System.out.printf("| %-30s |\n", "MENU KELOLA SBN");
            System.out.println("==================================");
            System.out.printf("| %-2s %-27s |\n", "1.", "Tambah SBN");
            System.out.printf("| %-2s %-27s |\n", "2.", "Kembali");
            System.out.println("==================================");

            int pilihan = InputHelper.readNumber("Pilih menu: ");

            switch (pilihan) {
                case 1: {
                    String nama = InputHelper.readString("Nama SBN: ");
                    double bunga = InputHelper.readDouble("Bunga: ");
                    int jangka = InputHelper.readNumber("Jangka waktu (tahun): ");
                    String jatuhTempo = InputHelper.readString("Tanggal jatuh tempo (dd-mm-yyyy): ");
                    double kuota = InputHelper.readDouble("Kuota nasional: ");
                    admin.tambahSBN(sbnFitur, nama, bunga, jangka, jatuhTempo, kuota);
                    break;
                }
                case 2: {
                    kembali = true;
                    break;
                }
                default: {
                    System.out.println("Pilihan tidak valid!");
                    break;
                }
            }
        }
    }
}
