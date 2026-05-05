public class Ewallet extends MetodePembayaran {
    @Override
    public void bayar (double nominal){
    super.bayar(nominal);
    System.out.println(" Memotong saldo E-Wallet sebesar Rp" + nominal );
    }

    void bayar (double nominal, String nomorHp){
        System.out.println(" Memotong saldo E-Wallet sebesar Rp" + nominal + " dari nomor "+ nomorHp);
    }
    
}
