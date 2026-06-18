package com.tester;

import java.util.List;
import java.util.Scanner;

import com.dal.BookDAO;
import com.pojo.Book;

public class TestCRUD {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BookDAO dao = new BookDAO();

        while (true) {

            System.out.println("\n1.Show All Books");
            System.out.println("2.Add Book");
            System.out.println("3.Edit Book");
            System.out.println("4.Remove Book");
            System.out.println("5.Get Book By Id");
            System.out.println("6.Exit");

            int ch = sc.nextInt();

            switch (ch) {
 
            case 1:

                List<Book> books = dao.getAllBooks();

                books.forEach(System.out::println);

                break;

            case 2:

                System.out.print("Id : ");
                int id = sc.nextInt();

                sc.nextLine();

                System.out.print("Title : ");
                String title = sc.nextLine();

                System.out.print("Author : ");
                String author = sc.nextLine();

                System.out.print("Price : ");
                double price = sc.nextDouble();

                dao.addBook(
                        new Book(id, title, author, price));

                System.out.println("Book Added");

                break;

            case 3:

                System.out.print("Enter Book Id : ");
                id = sc.nextInt();

                Book b = dao.getBookById(id);

                if (b != null) {

                    sc.nextLine();

                    System.out.print("New Title : ");
                    b.setTitle(sc.nextLine());

                    System.out.print("New Author : ");
                    b.setAuthor(sc.nextLine());

                    System.out.print("New Price : ");
                    b.setPrice(sc.nextDouble());

                    dao.updateBook(b);

                    System.out.println("Book Updated");
                }

                break;

            case 4:

                System.out.print("Enter Id : ");
                id = sc.nextInt();

                dao.deleteBook(id);

                System.out.println("Book Deleted");

                break;

            case 5:

                System.out.print("Enter Id : ");
                id = sc.nextInt();

                System.out.println(
                        dao.getBookById(id));

                break;

            case 6:

                System.exit(0);

            default:

                System.out.println("Invalid Choice");
            }
        }
    }
}