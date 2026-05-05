//no 1
public class LampuPintar extends PerangkatPintar {
    @Override
    public void aktifkan(){
        super.aktifkan();
        System.out.println("Lampu Menyala");
    }
    
//no 2
public void aturKecerahan(int level) {
        System.out.println("Kecerahan lampu diatur ke level " + level + "%.");
    }

public void aturKecerahan(int level, String warna) {
        System.out.println("Kecerahan lampu diatur ke level " + level + "% dengan warna cahaya " + warna + ".");
    }

}


