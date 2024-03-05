import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Library {

    private ArrayList<String> booksList;
    private ArrayList<String> availableBookList;
    private HashMap<String, String> booksLent;
    private HashMap<String, String> authorWithBook;
    private HashMap<String, Integer> bookCopies;


    public Library(ArrayList<String> list) {
        this.booksList = new ArrayList<>(list);
        this.availableBookList = new ArrayList<>(list);
        this.booksLent = new HashMap<>();
        this.authorWithBook = new HashMap<>();
        this.bookCopies = new HashMap<>();
    }

    public void displayAvailableBooks() {
        for (String book : availableBookList) {
            if (bookCopies.containsKey(book) && bookCopies.get(book) == 0) {
                availableBookList.remove(book);
            }
        }

        if (availableBookList.isEmpty()) {
            System.out.println("There are no Books...");
        } else {
            for (String book : availableBookList) {
                System.out.println("book name : " + book + " copies available : " + bookCopies.get(book));
            }
        }

    }

    public void displayAllBooks() {
        if (booksList.isEmpty()) {
            System.out.println("There are no books.");
        } else {
            for (String book : booksList) {
                System.out.println(book);
            }
        }
    }

    public void borrowBook(String name, String book) {
        if (!booksList.contains(book)) {
            System.out.println("Incorrect Book Name");
            return;
        }
        if (bookCopies.containsKey(book) && bookCopies.get(book) > 0) {
            bookCopies.put(book, bookCopies.get(book) - 1);
            booksLent.put(book, name);
            System.out.println("You can take the book. Author name: " + authorWithBook.get(book));
        } else {
            System.out.println("The book is already taken by " + booksLent.get(book));
        }
    }

    public void returnBook(String book, String customerName) {
        if (booksLent.containsKey(book)) {
            if (booksLent.get(book).equals(customerName)) {
                booksLent.remove(book);
                availableBookList.add(book);
                bookCopies.put(book, bookCopies.getOrDefault(book, 0) + 1);
                System.out.println("Added to library");
            } else {
                System.out.println("Name and lend book do not match");
            }
        } else {
            System.out.println("The book is not currently borrowed.");
        }
    }


    public void addBookToLibrary(String book, String authorName, int bookCopy) {
        booksList.add(book);
        availableBookList.add(book);
        authorWithBook.put(book, authorName);
        bookCopies.put(book, bookCopy);
        System.out.println("Book Added");
    }

    public void quit() {
        System.out.println("Program End................");
        System.exit(0);
    }

    public void continueOrQuit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to continue? Enter 'y' to continue or 'q' to quit: ");
        String continues = scanner.nextLine();
        while (!continues.equals("y") && !continues.equals("q")) {
            System.out.println("Invalid input. Please enter 'y' to continue or 'q' to quit: ");
            continues = scanner.nextLine();
        }
        if (continues.equals("y")) {
            return;
        } else if (continues.equals("q")) {
            quit();
        }
    }
}