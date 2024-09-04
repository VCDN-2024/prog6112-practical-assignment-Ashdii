package librarytest;

import java.util.Scanner;

// Base class representing a general item
class Item {
    protected String title;
    protected int id;

    public Item(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }
}

// Derived class representing a book
class Book extends Item {
    private String author;
    private boolean isBorrowed;

    public Book(String title, int id, String author) {
        super(title, id);
        this.author = author;
        this.isBorrowed = false;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
        } else {
            System.out.println("Book already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
        } else {
            System.out.println("Book is not borrowed.");
        }
    }

    public String getStatus() {
        return isBorrowed ? "Borrowed" : "Available";
    }
}

// Library class to manage books
class Library {
    private Book[] books;
    private int count;

    public Library(int capacity) {
        books = new Book[capacity];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count++] = book;
        } else {
            System.out.println("Library is full.");
        }
    }

    public void borrowBook(int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                books[i].borrowBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void returnBook(int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].getId() == id) {
                books[i].returnBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void generateReport() {
        System.out.println("Library Report:");
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + books[i].getId() + ", Title: " + books[i].getTitle() + ", Status: " + books[i].getStatus());
        }
    }
}

// Main class to run the application
public class LibraryTest {

    public static void main(String[] args) {
        Library library = new Library(5);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Generate Report");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    Book newBook = new Book(title, id, author);
                    library.addBook(newBook);
                    System.out.println("Book added successfully.");
                    break;
                case 2:
                    System.out.print("Enter book ID to borrow: ");
                    int borrowId = scanner.nextInt();
                    library.borrowBook(borrowId);
                    break;
                case 3:
                    System.out.print("Enter book ID to return: ");
                    int returnId = scanner.nextInt();
                    library.returnBook(returnId);
                    break;
                case 4:
                    library.generateReport();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

//Referencing list

// Online site
//Title: Java Tutorials
//Author: Oracle
//Date: 2024
//URL: https://docs.oracle.com/javase/tutorial/
//Accessed: 4 September 2024