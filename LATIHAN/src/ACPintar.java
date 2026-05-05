//no 1
public class ACPintar extends PerangkatPintar{
    @Override
    public void aktifkan() {
    super.aktifkan();
        System.out.println("AC menyala dan mulai mendinginkan ruangan.");
    }

    //no 4
    public void aturSuhuAC (int suhu){
    System.out.println("suhu ruangan diatur menjadi suhu " + suhu + "derajat");
}
}


