package com.mycompany.librarysystem;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            LibrarySystem librarySystem = new LibrarySystem();
            ManagementUser userManager = new ManagementUser();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Add Book");
                System.out.println("2. View Books");
                System.out.println("3. Borrow Book");
                System.out.println("4. Return Book");
                System.out.println("5. Add User");
                System.out.println("6. View Users");
                System.out.println("7. Update User");
                System.out.println("8. Delete User");
                System.out.println("9. Exit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.next();
                        System.out.print("Enter book author: ");
                        String author = scanner.next();
                        librarySystem.addBook(new Book(0, title, author, true));
                        break;
                    case 2:
                        librarySystem.viewBooks();
                        break;
                    case 3:
                        System.out.print("Enter book ID to borrow: ");
                        int bookId = scanner.nextInt();
                        System.out.print("Enter user ID: ");
                        int userId = scanner.nextInt();
                        librarySystem.borrowBook(bookId, userId);
                        break;
                    case 4:
                        System.out.print("Enter book ID to return: ");
                        int returnBookId = scanner.nextInt();
                        librarySystem.returnBook(returnBookId);
                        break;
                    case 5:
                        System.out.print("Enter user name: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.print("Enter user email: ");
                        String email = scanner.nextLine();
                        userManager.addUser(new User(0, name, email));
                        break;
                    case 6:
                        for (User user : userManager.getAllUsers()) {
                            System.out.println(user.getDetails());
                        }
                        break;
                    case 7:
                        System.out.print("Enter user ID to update: ");
                        int userIdUpdate = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        System.out.print("Enter new email: ");
                        String newEmail = scanner.nextLine();
                        userManager.updateUser(new User(userIdUpdate, newName, newEmail));
                        break;
                    case 8:
                        System.out.print("Enter user ID to delete: ");
                        int userIdDelete = scanner.nextInt();
                        userManager.deleteUser(userIdDelete);
                        break;
                    case 9:
                        System.out.println("Exiting...");
                        System.exit(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}