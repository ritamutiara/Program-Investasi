package data;

import fitur.SahamFitur;
import java.util.ArrayList;
import java.util.List;

public class Portofolio {
    public class KepemilikanSaham {
        private String kode;
        private int jumlahLembar;
        private double hargaBeli;

        public KepemilikanSaham(String kode, int jumlahLembar, double hargaBeli) {
            this.kode = kode;
            this.jumlahLembar = jumlahLembar;
            this.hargaBeli = hargaBeli;
        }

        public String getKode() { return kode; }
        public int getJumlahLembar() { return jumlahLembar; }
        public void setJumlahLembar(int jumlahLembar) { this.jumlahLembar = jumlahLembar; }
        public double getHargaBeli() { return hargaBeli; }
    }

    public class KepemilikanSBN {
        private String nama;
        private double nominal;

        public KepemilikanSBN(String nama, double nominal) {
            this.nama = nama;
            this.nominal = nominal;
        }

        public String getNama() { return nama; }
        public double getNominal() { return nominal; }
        public void setNominal(double nominal) { this.nominal = nominal; }
    }

    private List<KepemilikanSaham> daftarSaham;
    private List<KepemilikanSBN> daftarSBN;

    public Portofolio() {
        daftarSaham = new ArrayList<>();
        daftarSBN = new ArrayList<>();
    }

    // Method untuk mencari saham dalam portofolio
    public KepemilikanSaham cariSaham(String kode) {
        for (KepemilikanSaham saham : daftarSaham) {
            if (saham.getKode().equals(kode)) {
                return saham;
            }
        }
        return null;
    }

    // Method untuk mencari SBN dalam portofolio
    public KepemilikanSBN cariSBN(String nama) {
        for (KepemilikanSBN sbn : daftarSBN) {
            if (sbn.getNama().equals(nama)) {
                return sbn;
            }
        }
        return null;
    }

    // Method untuk tambah saham
    public void tambahSaham(String kode, int jumlahLembar, double hargaBeli) {
        KepemilikanSaham kepemilikan = cariSaham(kode);

        if (kepemilikan != null) {
            int jumlahLama = kepemilikan.getJumlahLembar();
            double hargaLama = kepemilikan.getHargaBeli();

            int jumlahBaru = jumlahLama + jumlahLembar;
            double totalNilaiLama = jumlahLama * hargaLama;
            double totalNilaiBaru = jumlahLembar * hargaBeli;
            double hargaRataRataBaru = (totalNilaiLama + totalNilaiBaru) / jumlahBaru;

            kepemilikan.setJumlahLembar(jumlahBaru);
            kepemilikan.hargaBeli = hargaRataRataBaru;
        } else {
            daftarSaham.add(new KepemilikanSaham(kode, jumlahLembar, hargaBeli));
        }
    }

    // Method untuk jual saham
    public boolean jualSaham(String kode, int jumlahLembar) {
        for (int i = 0; i < daftarSaham.size(); i++) {
            KepemilikanSaham kepemilikan = daftarSaham.get(i);

            if (kepemilikan.getKode().equals(kode)) {
                if (kepemilikan.getJumlahLembar() >= jumlahLembar) {
                    int sisaLembar = kepemilikan.getJumlahLembar() - jumlahLembar;

                    if (sisaLembar == 0) {
                        daftarSaham.remove(i);
                    } else {
                        kepemilikan.setJumlahLembar(sisaLembar);
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    // Method untuk tambah SBN
    public void tambahSBN(String nama, double nominal) {
        KepemilikanSBN kepemilikan = cariSBN(nama);

        if (kepemilikan != null) {
            kepemilikan.setNominal(kepemilikan.getNominal() + nominal);
        } else {
            daftarSBN.add(new KepemilikanSBN(nama, nominal));
        }
    }

    // Method helper untuk mendapatkan informasi
    public int getJumlahSaham(String kode) {
        KepemilikanSaham kepemilikan = cariSaham(kode);
        return (kepemilikan != null) ? kepemilikan.getJumlahLembar() : 0;
    }

    public double getNominalSBN(String nama) {
        KepemilikanSBN kepemilikan = cariSBN(nama);
        return (kepemilikan != null) ? kepemilikan.getNominal() : 0.0;
    }

    public List<String> getDaftarKodeSaham() {
        List<String> kodes = new ArrayList<>();
        for (KepemilikanSaham saham : daftarSaham) {
            kodes.add(saham.getKode());
        }
        return kodes;
    }

    public List<String> getDaftarNamaSBN() {
        List<String> names = new ArrayList<>();
        for (KepemilikanSBN sbn : daftarSBN) {
            names.add(sbn.getNama());
        }
        return names;
    }

    public List<KepemilikanSaham> getDaftarSaham() {
        return daftarSaham;
    }

    public List<KepemilikanSBN> getDaftarSBN() {
        return daftarSBN;
    }

    // Method untuk menghitung total nilai pembelian saham
    public double hitungTotalNilaiPembelianSaham() {
        double total = 0;
        for (KepemilikanSaham saham : daftarSaham) {
            total += saham.getJumlahLembar() * saham.getHargaBeli();
        }
        return total;
    }

    // Method untuk menghitung total nilai pasar saham
    public double hitungTotalNilaiPasarSaham(SahamFitur sahamService) {
        double total = 0;
        for (KepemilikanSaham kepemilikan : daftarSaham) {
            Saham saham = sahamService.getSaham(kepemilikan.getKode());
            if (saham != null) {
                total += kepemilikan.getJumlahLembar() * saham.getHarga();
            }
        }
        return total;
    }

    // Method untuk menghitung total nominal SBN
    public double hitungTotalNominalSBN() {
        double total = 0;
        for (KepemilikanSBN sbn : daftarSBN) {
            total += sbn.getNominal();
        }
        return total;
    }

    // Method untuk menghitung total bunga bulanan SBN
    public double hitungTotalBungaBulananSBN(List<SuratBerhargaNegara> daftarSBNTersedia) {
        double total = 0;
        for (KepemilikanSBN kepemilikan : daftarSBN) {
            for (SuratBerhargaNegara sbn : daftarSBNTersedia) {
                if (sbn.getNama().equals(kepemilikan.getNama())) {
                    total += sbn.hitungBungaBulanan(kepemilikan.getNominal());
                    break;
                }
            }
        }
        return total;
    }
}