import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking implements StrukBooking {
    String id, nama, noHP, alamat, namaKucing;
    int jenisGrooming, totalBayar;
    double beratKucing;

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNoHP() {
        return noHP;
    }

    public String getAlamat() {
        return alamat;
    }
    
    public String getNamaKucing() {
        return namaKucing;
    }

    public double getBeratKucing() {
        return beratKucing;
    }

    public int getJenisGroom() {
        return jenisGrooming;
    }

    @Override
    public void Struk() {
    }

    //date
        Date date = new Date();
        SimpleDateFormat hari = new SimpleDateFormat("'Hari/Tanggal \t:' EEEEEEEEEE dd-mm-yyyy");
        SimpleDateFormat jam =  new SimpleDateFormat("'Waktu \t\t:' hh:mm:ss z");

    //method untuk mengisi data pelanggan
    public void inputDataPelanggan() {
    }

    
}
