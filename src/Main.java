import java.util.Scanner;

class Main {
    static Book[] bookList = {
            new Book("B001", "Harry Potter", "J.K. Rowling", 10),
            new Book("B002", "Lord of the Rings", "J.R.R. Tolkien", 8),
            new Book("B003", "The Hobbit", "J.R.R. Tolkien", 5)
    };
    static User[] userStudent = {
            new Student("S001", "John Doe", "Computer Science"),
            new Student("S002", "Jane Smith", "Engineering")
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Library Management System!");
        System.out.println("1. Login as Admin");
        System.out.println("2. Login as Student");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Login as admin
                Admin admin = new Admin();
                admin.menuAdmin();
                break;
            case 2:
                // Login as student
                Student student = new Student("dummy", "dummy", "dummy"); // Perlu memberikan parameter
                student.displayBooks();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}

class Book {
    String id;
    String title;
    String author;
    int stock;

    public Book(String id, String title, String author, int stock) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stock = stock;
    }
}

class User {
    String id;
    String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Student extends User {
    String programStudy;

    public Student(String id, String name, String programStudy) {
        super(id, name);
        this.programStudy = programStudy;
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : Main.bookList) {
            System.out.println("Title: " + book.title + ", Author: " + book.author + ", Stock: " + book.stock);
        }
    }

    public void logout() {
        System.out.println("Logged out successfully!");
    }
}

class Admin {
    public void menuAdmin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome Admin!");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                addStudent();
                break;
            case 2:
                displayStudents();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Adding a new student...");
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student NIM (15 digits): ");
        String nim = scanner.nextLine();
        if (nim.length() != 15) {
            System.out.println("Invalid NIM length! NIM must be 15 digits.");
            return;
        }
        System.out.print("Enter student faculty: ");
        String faculty = scanner.nextLine();
        System.out.print("Enter student program of study: ");
        String programStudy = scanner.nextLine();

        // Menambahkan mahasiswa ke daftar
        Student[] newStudents = new Student[Main.userStudent.length + 1];
        System.arraycopy(Main.userStudent, 0, newStudents, 0, Main.userStudent.length);
        newStudents[Main.userStudent.length] = new Student(nim, name, programStudy);
        Main.userStudent = newStudents;

        System.out.println("Student added successfully!");
    }

    public void displayStudents() {
        System.out.println("Registered Students:");
        for (User user : Main.userStudent) {
            System.out.println("Name: " + user.name + ", NIM: " + user.id);
        }
    }
}
