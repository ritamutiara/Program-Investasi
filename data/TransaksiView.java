package data;

import java.util.List;

public class TransaksiView {

    public void tampilkanRiwayatLengkap(List<Transaksi> riwayatTransaksi) {
        System.out.println("\n===== RIWAYAT TRANSAKSI =====");

        if (riwayatTransaksi.isEmpty()) {
            System.out.println("Belum ada transaksi.");
            return;
        }

        int jumlahBeliSaham = 0;
        int jumlahJualSaham = 0;
        int jumlahBeliSBN = 0;
        double totalBeliSaham = 0;
        double totalJualSaham = 0;
        double totalBeliSBN = 0;

        for (Transaksi transaksi : riwayatTransaksi) {
            switch (transaksi.getJenis()) {
                case BELI_SAHAM:
                    jumlahBeliSaham++;
                    totalBeliSaham += transaksi.getNominal();
                    break;
                case JUAL_SAHAM:
                    jumlahJualSaham++;
                    totalJualSaham += transaksi.getNominal();
                    break;
                case BELI_SBN:
                    jumlahBeliSBN++;
                    totalBeliSBN += transaksi.getNominal();
                    break;
            }
        }

        System.out.println("\n===== TRANSAKSI SAHAM ======");
        System.out.println("=============================================================================================");
        System.out.println("| No  | Tanggal               | Deskripsi                                                   |");
        System.out.println("=============================================================================================");

        int indexSaham = 1;
        boolean adaTransaksiSaham = false;

        for (Transaksi transaksi : riwayatTransaksi) {
            if (transaksi.getJenis() == Transaksi.JenisTransaksi.BELI_SAHAM ||
                    transaksi.getJenis() == Transaksi.JenisTransaksi.JUAL_SAHAM) {
                System.out.printf("| %-3d | %-21s | %-59s |%n",
                        indexSaham++, transaksi.getTanggalFormatted(), transaksi.getDeskripsi());
                adaTransaksiSaham = true;
                System.out.println("=============================================================================================");
            }
        }

        if (!adaTransaksiSaham) {
            System.out.println("Tidak ada transaksi saham.");
        }

        System.out.println("\n===== TRANSAKSI SBN =====");
        System.out.println("=============================================================================================");
        System.out.println("| No  | Tanggal               | Deskripsi                                                   |");
        System.out.println("=============================================================================================");

        int indexSBN = 1;
        boolean adaTransaksiSBN = false;

        for (Transaksi transaksi : riwayatTransaksi) {
            if (transaksi.getJenis() == Transaksi.JenisTransaksi.BELI_SBN) {
                System.out.printf("| %-3d | %-21s | %-59s |%n",
                        indexSaham++, transaksi.getTanggalFormatted(), transaksi.getDeskripsi());
                adaTransaksiSBN = true;
                System.out.println("=============================================================================================");
            }
        }

        if (!adaTransaksiSBN) {
            System.out.println("Tidak ada transaksi SBN.");
        }

        System.out.println("\n===== RINGKASAN TRANSAKSI =====");
        System.out.println("\n===== Transaksi Saham =====");
        System.out.println("======================================================================================");
        System.out.printf("| %-10s | %-18s | %-25s | %-20s |%n", "Jenis", "Jumlah Transaksi", "Keterangan", "Nilai (Rp)");
        System.out.println("======================================================================================");
        System.out.printf("| %-10s | %18d | %-25s | %,20.0f |%n", "Pembelian", jumlahBeliSaham, "Total pembelian saham", totalBeliSaham);
        System.out.printf("| %-10s | %18d | %-25s | %,20.0f |%n", "Penjualan", jumlahJualSaham, "Total penjualan saham", totalJualSaham);
        System.out.printf("| %-10s | %18s | %-25s | %,20.0f |%n", "Bersih", "-", "Posisi bersih saham", (totalBeliSaham - totalJualSaham));
        System.out.println("======================================================================================");

        System.out.println("\n===== Transaksi SBN =====");
        System.out.println("======================================================================================");
        System.out.printf("| %-10s | %-18s | %-25s | %-20s |%n", "Jenis", "Jumlah Transaksi", "Keterangan", "Nilai (Rp)");
        System.out.println("======================================================================================");
        System.out.printf("| %-10s | %18d | %-25s | %,20.0f |%n", "Pembelian", jumlahBeliSBN, "Total pembelian SBN", totalBeliSBN);
        System.out.println("======================================================================================");

        System.out.println("\n===== Total Investasi =====");
        double totalInvestasi = totalBeliSaham - totalJualSaham + totalBeliSBN;
        System.out.println("===================================================================================");
        System.out.printf("| %-56s | %,20.0f |%n", "TOTAL INVESTASI BERSIH", totalInvestasi);
        System.out.println("===================================================================================");
    }

    public void tampilkanTransaksiKode(List<Transaksi> riwayatTransaksi, String kode) {
        System.out.println("\n===== RIWAYAT TRANSAKSI UNTUK " + kode + " =====");

        boolean adaTransaksi = false;
        int index = 1;
        double totalBeli = 0;
        double totalJual = 0;
        int jumlahBeli = 0;
        int jumlahJual = 0;

        System.out.println("=========================================================================================================");
        System.out.printf("| %-3s | %-22s | %-70s |%n", "No", "Tanggal", "Deskripsi");
        System.out.println("=========================================================================================================");

        for (Transaksi transaksi : riwayatTransaksi) {
            if (transaksi.getKode().equalsIgnoreCase(kode)) {
                System.out.printf("| %-3d | %-22s | %-70s |%n",
                        index++, transaksi.getTanggalFormatted(), transaksi.getDeskripsi());
                adaTransaksi = true;

                if (transaksi.getJenis() == Transaksi.JenisTransaksi.BELI_SAHAM ||
                        transaksi.getJenis() == Transaksi.JenisTransaksi.BELI_SBN) {
                    totalBeli += transaksi.getNominal();
                    jumlahBeli++;
                } else if (transaksi.getJenis() == Transaksi.JenisTransaksi.JUAL_SAHAM) {
                    totalJual += transaksi.getNominal();
                    jumlahJual++;
                }
            }
        }

        if (!adaTransaksi) {
            System.out.println("Tidak ada transaksi untuk kode " + kode);
            return;
        }
        System.out.println("=========================================================================================================");

        System.out.println("\n===== Ringkasan untuk " + kode + " =====");
        System.out.println("============================================================================================================");

        System.out.printf("| %-12s | %-3d transaksi  | %-72s |%n", "Pembelian", jumlahBeli,
                String.format("Rp %-,15.0f", totalBeli));

        if (jumlahJual > 0) {
            System.out.printf("| %-12s | %-3d transaksi  | %-72s |%n", "Penjualan", jumlahJual,
                    String.format("Rp %-,15.0f", totalJual));
            System.out.printf("| %-12s | %-14s | %-72s |%n", "Bersih", "-",
                    String.format("Rp %-,15.0f", totalBeli - totalJual));
        } else {
            System.out.printf("| %-12s | %-14s | %-72s |%n", "Total", "-",
                    String.format("Rp %-,15.0f", totalBeli));
        }
        System.out.println("============================================================================================================");

    }
}
