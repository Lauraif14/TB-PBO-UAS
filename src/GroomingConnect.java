import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroomingConnect {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/dbgrooming";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //polymorphisme
        Kucing Kucing = new Kucing();

        Login Kasir = new Login();
        Kasir.login();

        //inputkan data
        Kucing.inputDataPelanggan();
        
        //mencetak struk
        Kucing.Struk();

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();

            String sql = "INSERT INTO pelanggan (id_pelanggan, nama_pelanggan, no_hp, alamat) VALUE ('%s', '%s', '%s', '%s' )";
            sql = String.format(sql, Kucing.getId(), Kucing.getNama(), Kucing.getNoHP(), Kucing.getAlamat());
            stmt.execute(sql);

            while (!conn.isClosed()) {
               showMenu();
            }

            stmt.close();
            conn.close();
        } catch (Exception e) {
        e.printStackTrace();
        }

        scanner.close();

    }

    static Scanner scanner = new Scanner(System.in); 
    
    static void showMenu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Show Data");
        System.out.println("2. Edit Data");
        System.out.println("3. Delete Data");
        System.out.println("0. Keluar");
        System.out.println("");
        System.out.print("PILIHAN> ");

        try {
            Integer pilihan = Integer.parseInt(scanner.nextLine());

            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    showData();
                    break;
                case 2:
                    updateData();
                    break;
                case 3:
                    deleteData();
                    break;
                default:
                    System.out.println("Pilihan salah!");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        static void showData() {
            String sql = "SELECT * FROM pelanggan";

            try {
                rs = stmt.executeQuery(sql);

                System.out.println("|          GROOMING CAT          |");
                System.out.println("+--------------------------------+");

                while (rs.next()) {
                    String namaPelanggan = rs.getString("nama_pelanggan");
                    String noHP = rs.getString("no_hp");
                    String alamat = rs.getString("alamat");

                    System.out.printf("| %s | %s | %s |\n", namaPelanggan, noHP, alamat);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        static void updateData() {
            try {
                // Ambil input dari user
                System.out.print("ID Pelanggan yang akan diupdate: ");
                String id = scanner.nextLine();
                System.out.print("Nama pelanggan: ");
                String namaPelanggan = scanner.nextLine().trim();
                System.out.print("No Hp: ");
                String noHP = scanner.nextLine();
                System.out.print("Alamat: ");
                String alamat = scanner.nextLine().trim();
        
                // Query update
                String sql = "UPDATE pelanggan SET nama_pelanggan='%s', no_hp='%s', alamat='%s' WHERE id_pelanggan='%s'";
                sql = String.format(sql, namaPelanggan, noHP, alamat, id);
        
                // Update data
                int rowsAffected = stmt.executeUpdate(sql);
        
                if (rowsAffected > 0) {
                    System.out.println("Data berhasil diupdate.");
                } else {
                    System.out.println("ID Pelanggan tidak ditemukan atau tidak ada perubahan data.");
                }
        
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        static void deleteData() {
        try {
            
            // ambil input dari user
            System.out.print("id_Pelanggan yang mau dihapus : ");
            String id = (scanner.nextLine());
            // buat query hapus
            String sql = String.format("DELETE FROM pelanggan WHERE id_Pelanggan='%s'", id);

            // hapus data
            stmt.execute(sql);
            
            System.out.println("Data telah terhapus...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}