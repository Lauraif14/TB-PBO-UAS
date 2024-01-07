import java.util.InputMismatchException;
import java.util.Scanner;

public class Kucing extends Booking {

    public void inputDataPelanggan() {
        
        Scanner scanStr = new Scanner(System.in);
        Scanner scanIn = new Scanner(System.in);

        System.out.print("Id pelanggan \t= ");
        id = scanStr.next();
        System.out.print("Nama pelanggan \t= ");
        nama = scanStr.next();
        System.out.print("No HP \t\t= ");
        noHP = scanStr.next();
        System.out.print("Alamat \t\t= ");
        alamat = scanStr.next();
        System.out.print("Nama Kucing \t= ");
        namaKucing = scanStr.next();

        // Exception handling for invalid input
        try {
            System.out.print("Berat Kucing \t= ");
            beratKucing = scanIn.nextDouble();

            System.out.println("1. Basic Grooming");
            System.out.println("2. Basic Grooming + Anti Kutu / Anti Jamur");
            System.out.println("3. Grooming Lengkap");
            System.out.print("Pilih jenis grooming = ");
            jenisGrooming = scanIn.nextInt();

            if (jenisGrooming < 1 || jenisGrooming > 3 || beratKucing <= 0) {
                throw new InputMismatchException();
            }

            double totalBayar = calculateGroomingCost(jenisGrooming, beratKucing);
        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Pastikan memasukkan angka dengan benar.");
        }
    }

    public static double calculateGroomingCost(int jenisGrooming, double beratKucing) {
        double totalBayar;

        if (beratKucing <= 5.2) {
            totalBayar = jenisGrooming == 1 ? 30000 : jenisGrooming == 2 ? 50000 : 75000;
        } else if (beratKucing <= 5.3) {
            totalBayar = jenisGrooming == 1 ? 40000 : jenisGrooming == 2 ? 80000 : 110000;
        } else {
            totalBayar = jenisGrooming == 1 ? 45000 : jenisGrooming == 2 ? 90000 : 120000;
        }

        return totalBayar;
    }

    @Override
    public void Struk() {
        System.out.println("\n\n\n");
        System.out.println("============= CAT GROOMING =============");
        System.out.println(hari.format(date));
        System.out.println(jam.format(date));
        System.out.println("Id Pelanggan \t = " + id);
        System.out.println("============ DATA PELANGGAN ============");
        System.out.println("Nama Pelanggan \t: " + nama);
        System.out.println("No HP \t\t: " + noHP);
        System.out.println("Alamat \t\t: " + alamat);
        System.out.println("========= DATA KUCING =========");
        System.out.println("Nama Kucing \t: " + namaKucing);
        System.out.println("Berat Kucing \t: " + beratKucing);
        System.out.println("Jenis Grooming \t: " + jenisGrooming);

        try {
            // Calculate and print total biaya grooming
            double totalBayar = calculateGroomingCost(jenisGrooming, beratKucing);
            System.out.println("Total biaya grooming: Rp " + totalBayar + ",-");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan dalam menghitung total biaya grooming.");
        }

        System.out.println("========================================");
        System.out.println("Kasir \t\t: Laura Iffa Razitta\n");

    
        //method string
        System.out.println("Ini Method String");
        System.out.println("toLowercase\t: " + nama.toLowerCase() );
        System.out.println("toUperrcase\t: " + namaKucing.toUpperCase() );
        System.out.println("length\t\t: " + namaKucing.length() );

    }


}
