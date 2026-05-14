// ini Superclass atau parentnya, guna nya untuk semua jenis layanan ekspedisi
//Abstract class, artinya kelas ini tidak bisa dibuat objeknya langsung dan hanya bisa dipakai sebagai "blueprint" untuk kelas turunan
public abstract class LayananEkspedisi {

    // saya pakai protected, yang artinya atribut ini bisa diakses oleh kelas turunan (anak), tapi ini tidak bisa diakses dari luar kelas secara langsung
    protected String nomorResi;
    protected double beratAktualKg;
    protected double panjang;
    protected double lebar;
    protected double tinggi;

    // Konstruktor: ini dipanggil saat objek dibuat, untuk mengisi semua atribut
    public LayananEkspedisi(String nomorResi, double beratAktualKg,
    double panjang, double lebar, double tinggi) {
        this.nomorResi = nomorResi;
        this.beratAktualKg = beratAktualKg;
        this.panjang = panjang;
        this.lebar = lebar;
        this.tinggi = tinggi;
    }

    // Metode ini menghitung berat mana yang lebih besar
    // berat asli (aktual) vs berat volumetrik
    // Berat volumetrik = (P x L x T) / 6000 
    public double hitungBeratEfektif() {
        double beratVolumetrik = (panjang * lebar * tinggi) / 6000;
        // Math.max()ini untuk memilih nilai terbesar antara dua angka
        return Math.max(beratAktualKg, beratVolumetrik);
    }

    // ini merupakan metode untuk mencetak nomor resi dan berat efektif ke layar
    public void cetakResi() {
        System.out.println("Nomor Resi: " + nomorResi);
        System.out.println("Berat Efektif: " + hitungBeratEfektif() + " Kg");
    }

    // abstract artinya metode ini wajib dioverride oleh setiap subclass (anak)
    public abstract double hitungOngkir();
}