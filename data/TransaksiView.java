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

        System.out.println("\n----- TRANSAKSI SAHAM -----");
        System.out.println("No  | Tanggal               | Deskripsi");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        int indexSaham = 1;
        boolean adaTransaksiSaham = false;

        for (Transaksi transaksi : riwayatTransaksi) {
            if (transaksi.getJenis() == Transaksi.JenisTransaksi.BELI_SAHAM ||
                    transaksi.getJenis() == Transaksi.JenisTransaksi.JUAL_SAHAM) {
                System.out.printf("%-3d | %-22s | %s%n",
                        indexSaham++, transaksi.getTanggalFormatted(), transaksi.getDeskripsi());
                adaTransaksiSaham = true;
            }
        }

        if (!adaTransaksiSaham) {
            System.out.println("Tidak ada transaksi saham.");
        }

        System.out.println("\n----- TRANSAKSI SBN -----");
        System.out.println("No  | Tanggal               | Deskripsi");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        int indexSBN = 1;
        boolean adaTransaksiSBN = false;

        for (Transaksi transaksi : riwayatTransaksi) {
            if (transaksi.getJenis() == Transaksi.JenisTransaksi.BELI_SBN) {
                System.out.printf("%-3d | %-22s | %s%n",
                        indexSBN++, transaksi.getTanggalFormatted(), transaksi.getDeskripsi());
                adaTransaksiSBN = true;
            }
        }

        if (!adaTransaksiSBN) {
            System.out.println("Tidak ada transaksi SBN.");
        }

        System.out.println("\n===== RINGKASAN TRANSAKSI =====");
        System.out.println("Transaksi Saham:");
        System.out.println("- Pembelian: " + jumlahBeliSaham + " transaksi (Rp " + String.format("%,.0f", totalBeliSaham) + ")");
        System.out.println("- Penjualan: " + jumlahJualSaham + " transaksi (Rp " + String.format("%,.0f", totalJualSaham) + ")");
        System.out.println("- Posisi bersih saham: Rp " + String.format("%,.0f", (totalBeliSaham - totalJualSaham)));

        System.out.println("\nTransaksi SBN:");
        System.out.println("- Pembelian: " + jumlahBeliSBN + " transaksi (Rp " + String.format("%,.0f", totalBeliSBN) + ")");

        double totalInvestasi = totalBeliSaham - totalJualSaham + totalBeliSBN;
        System.out.println("\nTotal investasi bersih: Rp " + String.format("%,.0f", totalInvestasi));
    }

    public void tampilkanTransaksiKode(List<Transaksi> riwayatTransaksi, String kode) {
        System.out.println("\n===== RIWAYAT TRANSAKSI UNTUK " + kode + " =====");

        boolean adaTransaksi = false;
        int index = 1;
        double totalBeli = 0;
        double totalJual = 0;
        int jumlahBeli = 0;
        int jumlahJual = 0;

        System.out.println("No  | Tanggal               | Deskripsi");
        System.out.println("---------------------------------------------------------------------------------------------------------------");

        for (Transaksi transaksi : riwayatTransaksi) {
            if (transaksi.getKode().equalsIgnoreCase(kode)) {
                System.out.printf("%-3d | %-22s | %s%n",
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

        System.out.println("---------------------------------------------------------------------------------------------------------------");
        System.out.println("\nRingkasan untuk " + kode + ":");
        System.out.println("- Pembelian: " + jumlahBeli + " transaksi (Rp " + String.format("%,.0f", totalBeli) + ")");
        if (jumlahJual > 0) {
            System.out.println("- Penjualan: " + jumlahJual + " transaksi (Rp " + String.format("%,.0f", totalJual) + ")");
            System.out.println("- Posisi bersih: Rp " + String.format("%,.0f", (totalBeli - totalJual)));
        } else {
            System.out.println("- Total investasi: Rp " + String.format("%,.0f", totalBeli));
        }
    }
}
