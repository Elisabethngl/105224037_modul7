import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<PerangkatPintar> daftarPerangkat = new ArrayList<>();
        daftarPerangkat.add(new LampuPintar());
        daftarPerangkat.add(new ACPintar());
        for (PerangkatPintar i : daftarPerangkat){
            i.aktifkan();
            if (i instanceof ACPintar){
                ((ACPintar )i).aturSuhuAC (16);
            }
        }

    PerangkatPintar alat1 = new LampuPintar();
    ((LampuPintar)alat1).aturKecerahan (75, "putih ");

    }
}


/* 
 analisis no 3
Program selalu menjalankan fungsi berdasarkan isi aslinya, bukan label luarnya. Karena isi aslinya adalah Lampu dan AC, maka fungsi milik Lampu dan AC-lah yang otomatis dijalankan.

analisis no 5
Fungsi aturKecerahan() tidak ada di kelas parentnya (PerangkatPintar). Karena kita mengakses melalui tipe kelas parentnya, kode program menganggap fungsi itu tidak pernah ada, sehingga langsung error.
*/