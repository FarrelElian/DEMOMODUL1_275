import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String adminNama = "admin";
        String adminSandi = "admin123";

        // Meminta user untuk memilih jenis user
        System.out.println("Selamat datang di sistem login library.");
        System.out.println("Silakan pilih jenis user:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilihan Anda: ");
        int pilihanUser = scanner.nextInt();
        scanner.nextLine(); // Membersihkan buffer

        // Proses login sesuai dengan jenis user
        if (pilihanUser == 1) {
            System.out.print("Masukkan username: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            if (username.equals(adminNama) && password.equals(adminSandi)) {
                System.out.println("Login berhasil sebagai admin.");
            } else {
                System.out.println("Username atau password salah. Login gagal.");
            }
        } else if (pilihanUser == 2) {
            System.out.print("Masukkan NIM: ");
            String nim = scanner.nextLine();

            // Memeriksa panjang NIM
            if (nim.length() == 15) {
                System.out.println("Login berhasil sebagai mahasiswa.");
                // Tambahkan aksi setelah login berhasil sebagai mahasiswa
            } else {
                System.out.println("Panjang NIM harus 15 karakter. Login gagal.");
            }
        } else {
            System.out.println("Pilihan tidak valid. Silakan pilih 1 atau 2.");
        }

        scanner.close();
    }
}