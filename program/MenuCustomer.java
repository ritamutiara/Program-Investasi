package program;

import akun.Customer;
import data.TransaksiView;
import fitur.SahamFitur;
import fitur.SBNFitur;
import bantuan.InputHelper;

public class MenuCustomer {
    public static void tampilkan(Customer customer, SahamFitur sahamFitur, SBNFitur sbnFitur) {
        boolean logout = false;
        TransaksiView transaksiView = new TransaksiView();

        while (!logout) {
            System.out.println("\n===== MENU CUSTOMER =====");
            System.out.println("==================================");
            System.out.printf("| %-30s |\n", "MENU CUSTOMER");
            System.out.println("==================================");
            System.out.printf("| %-2s %-27s |\n", "1.", "Beli Saham");
            System.out.printf("| %-2s %-27s |\n", "2.", "Jual Saham");
            System.out.printf("| %-2s %-27s |\n", "3.", "Beli SBN");
            System.out.printf("| %-2s %-27s |\n", "4.", "Simulasi SBN");
            System.out.printf("| %-2s %-27s |\n", "5.", "Portofolio");
            System.out.printf("| %-2s %-27s |\n", "6.", "Riwayat Transaksi");
            System.out.printf("| %-2s %-27s |\n", "7.", "Logout");
            System.out.println("==================================");


            int pilihan = InputHelper.readNumber("Pilih menu: ");

            switch (pilihan) {
                case 1 : {
                    sahamFitur.tampilDaftarSaham();
                    String kode = InputHelper.readString("Kode saham: ");
                    int lembar = InputHelper.readNumber("Jumlah lembar: ");
                    customer.beliSaham(sahamFitur, kode, lembar);
                }
                break;
                case 2 : {
                    customer.tampilkanSahamDimiliki(sahamFitur);
                    String kode = InputHelper.readString("Kode saham: ");
                    int lembar = InputHelper.readNumber("Jumlah lembar: ");
                    customer.jualSaham(sahamFitur, kode, lembar);
                }
                break;
                case 3 : {
                    sbnFitur.tampilDaftarSBN();
                    String nama = InputHelper.readString("Nama SBN: ");
                    double nominal = InputHelper.readDouble("Nominal pembelian: ");
                    customer.beliSBN(sbnFitur, nama, nominal);
                }
                break;
                case 4 : {
                    sbnFitur.tampilDaftarSBN();
                    String nama = InputHelper.readString("Nama SBN: ");
                    double nominal = InputHelper.readDouble("Nominal investasi: ");
                    sbnFitur.simulasiSBN(nama, nominal);
                }
                break;
                case 5 : customer.tampilkanPortofolio(sahamFitur);
                    break;
                case 6 : menuRiwayatTransaksi(customer, transaksiView);
                    break;
                case 7 : {
                    logout = true;
                    System.out.println("Logout berhasil.");
                }
                break;
                default : System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void menuRiwayatTransaksi(Customer customer, TransaksiView transaksiView) {
        boolean logout = false;

        while (!logout) {
            System.out.println("\n===== MENU RIWAYAT TRANSAKSI =====");
            System.out.println("===============================================");
            System.out.printf("| %-43s |\n", "MENU RIWAYAT TRANSAKSI");
            System.out.println("===============================================");
            System.out.printf("| %-2s %-40s |\n", "1.", "Lihat Semua Transaksi");
            System.out.printf("| %-2s %-40s |\n", "2.", "Cari Transaksi Berdasarkan Kode");
            System.out.printf("| %-2s %-40s |\n", "3.", "Logout");
            System.out.println("===============================================");


            int pilihan = InputHelper.readNumber("Pilih menu: ");

            switch (pilihan) {
                case 1 : transaksiView.tampilkanRiwayatLengkap(customer.getRiwayatTransaksi());
                    break;
                case 2 : {
                    String kode = InputHelper.readString("Masukkan kode saham/SBN: ");
                    transaksiView.tampilkanTransaksiKode(customer.getRiwayatTransaksi(), kode);
                }
                break;
                case 3 : logout = true;
                    break;
                default : System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
