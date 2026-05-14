public class LayananReguler extends LayananEkspedisi {

// Konstruktor LayananReguler, jadi langsung kasih data ke induknya pakai "super" biar parentnya yang ngurus
    public LayananReguler(String nomorResi, double beratAktualKg,
                           double panjang, double lebar, double tinggi) {
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
    }
    
    // Override: jadi cara hitung ongkirnya diganti dari punya parentnya
    // Kalau Reguler, ongkirnya jadi Rp15.000 buat tiap 1 Kg barang 
    @Override
    public double hitungOngkir() {
        return hitungBeratEfektif() * 15000;
    }

    // Overloading: metode dengan nama sama tapi parameternya yang beda
    // Ini versi lengkap dengan parameter isMember dan jarakKm
    public double hitungOngkir(boolean isMember, int jarakKm) {
        // Ambil tarif dasar dari metode override di atas
        double tarif = hitungOngkir();

        // Kalau dia itu member, maka di kasih diskon 10%
        if (isMember) {
            tarif = tarif * 0.90; // 90% dari harga = diskon 10%
        }

        // Tambah surcharge (biaya tambahan) jika jarak jauh, yaitu sebesar Rp 500 per Km
        tarif = tarif + (500 * jarakKm);

        return tarif;
    }
}