public class LayananInternasional extends LayananEkspedisi {

    // ini atribut tambahan khusus pengiriman internasional
    private String negaraTujuan;
    private double nilaiBarangUSD;

    public LayananInternasional(String nomorResi, double beratAktualKg,
    double panjang, double lebar, double tinggi,
    String negaraTujuan, double nilaiBarangUSD) {
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
        this.negaraTujuan = negaraTujuan;
        this.nilaiBarangUSD = nilaiBarangUSD;
    }

    // Tarif Internasional = Rp 200.000 per Kg
    // Ditambah pajak bea cukai 20% jika nilai barang > 50 USD
    @Override
    public double hitungOngkir() {
        double ongkirDasar = hitungBeratEfektif() * 200000;

        double pajak = 0;
        if (nilaiBarangUSD > 50) {
            // Kena pajak 20% dari ongkir dasar
            pajak = ongkirDasar * 0.20;
        }

        // Total = ongkir dasar + pajak (jika ada)
        return ongkirDasar + pajak;
    }

    // ini metode khusus untuk mencetak manifest (dokumen pengiriman internasional)
    public void cetakManifest() {
        System.out.println("Manifest Internasional ke " + negaraTujuan +
            " - Deklarasi Nilai: $" + nilaiBarangUSD);
    }
}