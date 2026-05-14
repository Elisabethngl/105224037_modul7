public class LayananExpress extends LayananEkspedisi {

    public LayananExpress(String nomorResi, double beratAktualKg,
    double panjang, double lebar, double tinggi) {
        super(nomorResi, beratAktualKg, panjang, lebar, tinggi);
    }

    // Tarif Express lebih mahal: Rp 30.000 per Kg
    @Override
    public double hitungOngkir() {
        return hitungBeratEfektif() * 30000;
    }

    // ini merupakan metode khusus Express: untuk ngecek, apakah nilai barang layak untuk klaim asuransi
    public void klaimAsuransi(double nilaiBarang) {
        if (nilaiBarang > 1000000) {
            // Barang mahal → maka asuransi VIP dan diproses prioritas
            System.out.println("Klaim Asuransi VIP Rp" + nilaiBarang +
                " untuk resi " + nomorResi + " sedang diproses prioritas.");
        } else {
            // Barang biasa → maka asuransi standar
            System.out.println("Klaim Asuransi Standar diproses dalam 7 hari kerja.");
        }
    }
}