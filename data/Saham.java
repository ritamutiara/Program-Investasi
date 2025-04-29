package data;

public class Saham {
    private String kode;
    private String namaPerusahaan;
    private double harga;

    public Saham(String kode, String namaPerusahaan, double harga) {
        this.kode = kode;
        this.namaPerusahaan = namaPerusahaan;
        this.harga = harga;
    }

    public Saham(String kode, double harga) {
        this(kode, "Perusahaan tidak diketahui", harga);
    }

    public String getKode() {
        return kode;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga > 0) {
            this.harga = harga;
        } else {
            System.out.println("Harga saham tidak bisa negatif atau nol!");
        }
    }

    public void tampilInfo() {
        System.out.println("================================================================================");
        System.out.printf("| Kode: %-6s | Perusahaan: %-25s | Harga: Rp %-11s |\n", kode, namaPerusahaan, String.format("%,.0f", harga));
        System.out.println("================================================================================");
    }
}
