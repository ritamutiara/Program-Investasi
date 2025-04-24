package program;

import akun.Customer;
import fitur.SahamFitur;
import fitur.SBNFitur;
import bantuan.InputHelper;

public class MenuCustomer {
    public static void tampilkan(Customer customer, SahamFitur sahamFitur, SBNFitur sbnFitur) {
        boolean kembali = false;

        while (!kembali) {
            System.out.println("\n===== MENU NASABAH =====");
            System.out.println("1. Beli Saham");
            System.out.println("2. Jual Saham");
            System.out.println("3. Beli SBN");
            System.out.println("4. Simulasi SBN");
            System.out.println("5. Portofolio");
            System.out.println("6. Logout");

            int pilihan = InputHelper.readNumber("Pilih menu: ");

            switch (pilihan) {
                case 1:
                    sahamFitur.tampilDaftarSaham();
                    String kodeBeli = InputHelper.readString("Kode saham: ");
                    int lembarBeli = InputHelper.readNumber("Jumlah lembar: ");
                    customer.beliSaham(sahamFitur, kodeBeli, lembarBeli);
                    break;
                case 2:
                    customer.tampilkanSahamDimiliki(sahamFitur);
                    String kodeJual = InputHelper.readString("Kode saham: ");
                    int lembarJual = InputHelper.readNumber("Jumlah lembar: ");
                    customer.jualSaham(sahamFitur, kodeJual, lembarJual);
                    break;
                case 3:
                    sbnFitur.tampilDaftarSBN();
                    String namaSBNBeli = InputHelper.readString("Nama SBN: ");
                    double nominalBeli = InputHelper.readDouble("Nominal pembelian: ");
                    customer.beliSBN(sbnFitur, namaSBNBeli, nominalBeli);
                    break;
                case 4:
                    sbnFitur.tampilDaftarSBN();
                    String namaSBNSimulasi = InputHelper.readString("Nama SBN: ");
                    double nominalSimulasi = InputHelper.readDouble("Nominal investasi: ");
                    sbnFitur.simulasiSBN(namaSBNSimulasi, nominalSimulasi);
                    break;
                case 5:
                    customer.tampilkanPortofolio(sahamFitur);
                    break;
                case 6:
                    kembali = true;
                    System.out.println("Logout berhasil.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        }
    }
}
