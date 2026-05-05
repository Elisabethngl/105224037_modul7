public class KartuKredit extends MetodePembayaran {
    @Override
    public void bayar (double nominal){
        super.bayar(nominal);
        System.out.println("Mencetak Tagihan Kartu Kredit sebesar Rp" + nominal);
    }

    void verifikasiPIN (String PIN){
        System.out.println("Memverifikasi PIN Kartu Kredit " + PIN + " Berhasil");
    }
}
