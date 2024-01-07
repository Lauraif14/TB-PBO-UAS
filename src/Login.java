import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Login {
    private Set<User> users;

    public Login() {
        this.users = new HashSet<>();
        // Add sample user to the set
        users.add(new User("Laura", "111"));
    }

    // Inner class to represent a user
    private static class User {
        String username;
        String password;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }
    }

    // Method to check if the given credentials are valid
    private boolean isValidCredentials(String inputUsername, String inputPassword) {
        for (User user : users) {
            if (user.username.equals(inputUsername) && user.password.equals(inputPassword)) {
                return true;
            }
        }
        return false;
    }

    // Method to perform login
    public void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=============== L O G I N ===============");

        // Password
        while (true) {
            System.out.println("Inputkan Username");
            String inputUser = scanner.next();
            System.out.println("Inputkan Password");
            String inputPassword = scanner.next();

            if (isValidCredentials(inputUser, inputPassword)) {
                System.out.println("_______  L O G I N   S U K S E S  _______\n\n");
                break;
            } else {
                System.out.println("Username atau password anda salah \n");
            }
        }

        // Captcha
        String captcha = generateCaptcha();
        System.out.println("Kode captcha = " + captcha);
        System.out.println("Masukkan captcha");
        String inputCaptcha = scanner.next();

        while (!inputCaptcha.equalsIgnoreCase(captcha)) {
            System.out.println("Kode captcha salah!!!!!\n");
            System.out.println("Masukkan captcha");
            inputCaptcha = scanner.next();
        }

        System.out.println("CAPTCHA YANG DIMASUKKAN BENAR\n\n");
    }

    // Method to generate a simple captcha (you can replace this with a more complex logic)
    private String generateCaptcha() {
        return "zxcvbnm";
    }

    public static void main(String[] args) {
        Login login = new Login();
        login.login();
    }
}
