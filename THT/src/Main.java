import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        /*ArrayList ini bisa nyimpen banyak jenis layanan sekaligus, karena semua kelas layanan itu masih anak dari LayananEkspedisi,
        jadi walaupun jenisnya beda-beda tetap bisa masuk ke dalam satu ArrayList*/
        ArrayList<LayananEkspedisi> daftarLayanan = new ArrayList<>();

        // --- Tambah data paket ---

        /*
        Paket Reguler ini memiliki berat aktual sebesar 2 kg dengan ukuran dimensi 50x50x50 cm.
        Untuk menghitung biaya pengiriman, juga dihitung berat volumetrik dengan rumus (panjang * lebar * tinggi) / 6000.
        Jadi, berat volumetriknya adalah (50 * 50 * 50) / 6000 = 20.83 kg.
        Karena dalam sistem pengiriman yang digunakan, berat yang dipakai adalah yang paling besar antara berat aktual dan berat volumetrik,
        maka berat efektif yang dipakai adalah 20.83 kg, bukan 2 kg. 
        Ini terjadi karena paket yang besar secara ukuran bisa memakan ruang lebih banyak dibanding berat aslinya, sehingga biaya dihitung berdasarkan volumetrik.
        */
        LayananReguler reguler = new LayananReguler("REG-11", 2, 50, 50, 50);

        /*
        Paket Express punya berat asli 5 kg dan ukuran 10*10*10 cm.
        Berat volumetriknya hanya 0,17 kg, jadi lebih kecil dari berat aslinya
        Karena itu, yang dipakai adalah berat 5 kg (berat aktual yang menang).
        */
        LayananExpress express = new LayananExpress("EXP-22", 5, 10, 10, 10);

        /* 
        Paket Internasional berat 3 kg dengan dimensi 20 * 20* 20 cm, tujuan Korea, dan nilai barang $100. 
        Berat yang dipakai dihitung dari perbandingan berat aktual dan volumetrik sesuai aturan.
        */

        LayananInternasional internasional = new LayananInternasional(
            "INT-33", 3, 20, 20, 20, "Korea", 100);

        // Masukkan semua ke ArrayList (ini disebut Upcasting:
        // objek anak disimpan sebagai tipe induk)
        daftarLayanan.add(reguler);
        daftarLayanan.add(express);
        daftarLayanan.add(internasional);

        // Variabel untuk menghitung total pendapatan perusahaan
        double totalPendapatanPerusahaan = 0.0;

        System.out.println("===== LAPORAN PENGIRIMAN =====\n");

        // Perulangan untuk menelusuri semua isi ArrayList
        for (LayananEkspedisi layanan : daftarLayanan) {

            // Panggil cetakResi() → tampilkan nomor resi & berat efektif
            layanan.cetakResi();

            // Tambahkan ongkir dasar (tanpa parameter) ke total pendapatan
            // hitungOngkir() tanpa parameter = tarif dasar masing-masing layanan
            totalPendapatanPerusahaan += layanan.hitungOngkir();

            // instanceof = cek tipe objek sebenarnya (meski disimpan sebagai induk)
            // Downcasting = ubah kembali ke tipe anak supaya bisa akses metode khusus

            if (layanan instanceof LayananReguler) {
                // Downcast ke LayananReguler dulu baru panggil hitungOngkir(member, jarak)
                LayananReguler lr = (LayananReguler) layanan;
                double hargaMember = lr.hitungOngkir(true, 25);
                System.out.println("Harga dengan Member + 25km: Rp " + hargaMember);

            } else if (layanan instanceof LayananExpress) {
                LayananExpress le = (LayananExpress) layanan;
                le.klaimAsuransi(1500000); // Nilai barang Rp 1.500.000 → VIP

            } else if (layanan instanceof LayananInternasional) {
                LayananInternasional li = (LayananInternasional) layanan;
                li.cetakManifest();
            }

            System.out.println(); // Baris kosong pemisah antar paket
        }

        // Cetak total pendapatan dari semua ongkir dasar
        System.out.println("===================================");
        System.out.println("Total Pendapatan Perusahaan (ongkir dasar): Rp "
            + totalPendapatanPerusahaan);
    }
}