package program;

import akun.Customer;
import data.Transaksi;
import data.TransaksiView;
import fitur.SahamFitur;
import fitur.SBNFitur;
import bantuan.InputHelper;

public class MenuCustomer {
    public static void tampilkan(Customer customer, SahamFitur sahamFitur, SBNFitur sbnFitur) {
        boolean logout = false;
        TransaksiView transaksiView = new TransaksiView();

        while (!logout) {
            System.out.println("\n===== MENU NASABAH =====");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Riwayat Transaksi");
            System.out.println("7. Logout");

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
            System.out.println("1. Lihat Semua Transaksi");
            System.out.println("2. Cari Transaksi Berdasarkan Kode");
            System.out.println("3. Logout");

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
