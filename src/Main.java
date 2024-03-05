import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> lib1 = new ArrayList<>();
        Library lib = new Library(lib1);

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("*".repeat(80));
            System.out.println("\nWelcome to library........................");
            System.out.println("1. Display Available books");
            System.out.println("2. Display all books");
            System.out.println("3. Borrow a book");
            System.out.println("4. Return a book");
            System.out.println("5. Add book to library");
            System.out.println("6. Quit\n");
            System.out.println("*".repeat(80));

            int userInput;
            try {
                System.out.print("Enter Your input: ");
                userInput = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter valid Integer");
                continue;
            }

            switch (userInput) {

                case 1:
                    lib.displayAvailableBooks();
                    lib.continueOrQuit();
                    break;

                case 2:
                    lib.displayAllBooks();
                    break;
                case 3:
                    System.out.print("Enter Your Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Book Name: ");
                    String bookName = scanner.nextLine();
                    lib.borrowBook(name, bookName);
                    break;

                case 4:
                    System.out.print("Enter name of the book: ");
                    String returnBookName = scanner.nextLine();
                    System.out.print("Enter his name: ");
                    String customerName = scanner.nextLine();
                    lib.returnBook(returnBookName, customerName);
                    break;

                case 5:
                    System.out.print("Add book Name: ");
                    String newBookName = scanner.nextLine();
                    System.out.print("Input Author Name: ");
                    String authorName = scanner.nextLine();
                    int bookCopy = 0;
                    while (true) {
                        try {
                            System.out.print("How many copies of books: ");
                            bookCopy = Integer.parseInt(scanner.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid Input....");
                        }
                    }
                    lib.addBookToLibrary(newBookName, authorName, bookCopy);
                    lib.continueOrQuit();
                    break;
                case 6:
                    lib.quit();
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}