package fitur;

import data.Saham;
import java.util.ArrayList;
import java.util.List;

public class SahamFitur {
    private static List<Saham> daftarSaham = new ArrayList<>();

    public boolean tambahSaham(String kode, String namaPerusahaan, double harga) {
        for (Saham saham : daftarSaham) {
            if (saham.getKode().equals(kode)) {
                return false;
            }
        }
        Saham sahamBaru = new Saham(kode, namaPerusahaan, harga);
        daftarSaham.add(sahamBaru);
        return true;
    }

    public boolean tambahSaham(String kode, double harga) {
        return tambahSaham(kode, "Perusahaan tidak diketahui", harga);
    }

    public boolean ubahHargaSaham(String kode, double hargaBaru) {
        for (Saham saham : daftarSaham) {
            if (saham.getKode().equals(kode)) {
                saham.setHarga(hargaBaru);
                return true;
            }
        }
        return false;
    }

    public Saham getSaham(String kode) {
        for (Saham saham : daftarSaham) {
            if (saham.getKode().equals(kode)) {
                return saham;
            }
        }
        return null;
    }

    public void tampilDaftarSaham() {
        System.out.println("\n===== DAFTAR SAHAM =====");
        if (daftarSaham.isEmpty()) {
            System.out.println("Tidak ada saham yang tersedia.");
            return;
        }

        for (Saham saham : daftarSaham) {
            saham.tampilInfo();
        }
    }

    public List<Saham> getAllSaham() {
        return daftarSaham;
    }
}