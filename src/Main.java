import java.util.Scanner;

public class Main {
    static Book[] books = new Book[100]; // maksimum 100 kitab saxlamaq olar
    static int bookCount = 0; // neçə kitab olduğunu izləmək üçün
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        addBook("Zeynal and Kenan", "Rena");
        addBook("Zeynalin kesfleri ", "Renicka");
        addBook("Kenanin lenete gelmisi", "Reyn");
        int choice;
        do {
            System.out.println("\n--- 📚 Kitabxana Sistemi ---");
            System.out.println("1. Bütün Kitabları Göstər");
            System.out.println("2. Yeni Kitab Əlavə Et");
            System.out.println("3. Kitab Qaytar (Return )");
            System.out.println("4. Kitab Götür (Borrow)");
            System.out.println("5. Statistikaya Bax");
            System.out.println("6. Çıxış");
            System.out.print("Seçiminizi daxil edin: ");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    showBook();
                    break;
                case 2:
                    System.out.println("Kitab adi");
                    String title = scan.nextLine();
                    System.out.println("Yazici adi");
                    String author = scan.nextLine();
                    addBook(title, author);
                    break;
                case 3:
                    System.out.println("Qaytarmaq istediyiniz kitabinin adini yazin");
                    String returntitle = scan.nextLine();
                    returnBook(returntitle);
                    break;
                case 4:
                    System.out.println("Almaq istediyiniz kitabi yazin");
                    String borrowtitle = scan.nextLine();
                    borrowBook(borrowtitle);
                    break;
                case 5:
                    showStatic();
                    break;
                case 6:
                    System.out.println("Cixis ");
                    break;
                default:
                    System.out.println("yalnis seciminiz");
            }
        } while (choice != 6);
    }

    static void addBook(String title, String author) {
        books[bookCount] = new Book(title, author);
        bookCount++;
        System.out.println("Book added: " + title);
    }

    static void showBook() {
        if (bookCount == 0) {
            System.out.println("No books added");
            return;
        }
        for (int i = 0; i < bookCount; i++) {
            String status = books[i].isBorrowed ? "Borrowed" : "Movcuddur";
            System.out.println(status + (i + 1) + books[i].title + books[i].author);
        }
    }

    static void borrowBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                if (!books[i].isBorrowed) {
                    books[i].isBorrowed = true;
                    System.out.println("Book Borrowed: " + title);
                } else {
                    System.out.println("Bu kitab yoxdu");
                }
                return;
            }

        }
        System.out.println("Bele kitab yoxdur");

    }

    static void returnBook(String title) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].title.equalsIgnoreCase(title)) {
                if (books[i].isBorrowed) {
                    books[i].isBorrowed = false;
                    System.out.println("Qaytarildi kitab" + title);
                } else {
                    System.out.println("Bu kitab yoxdu");
                }
                return;
            }
        }
            System.out.println("bu kitab yoxdur ");
        }
        static void showStatic() {
            int borrowCount = 0;
            for (int i = 0; i < bookCount; i++) {
                if (books[i].isBorrowed) {
                    borrowCount++;
                }
            }

                    int available = bookCount - borrowCount;
                    System.out.println("umumi kitab sayi" + bookCount);
                    System.out.println("göturulmüş kitab" + borrowCount);
                    System.out.println("Hal-hazirdaki kitab sayi" + available);

                    // faiz hesabla: borrowed * 100 / bookCount
                }
            }






