package com.library;

import java.sql.SQLException;
import java.util.Scanner;

public class LibraryApp {

	public static void main(String[] args) throws SQLException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to The Library Managemebt System");
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Are you a:\n 1.Admin\n2.Customer\nEnter your choice:");
		int choice=sc.nextInt();
		System.out.println("-------------------------------------------------------------------------");
		if(choice ==1)
		{
			Admin admin=new Admin();
			admin.userLogin();
			while(true)
			{
			System.out.println("---------------------welcome to Admin menu-------------------------------");
			System.out.println("-------------------------------------------------------------------------");
			System.out.println("Choose your operation\n1.View books\n2.Add books\n3.remove books\n4.Exit\nEnter your choice:");
			int admchoice=sc.nextInt();
			switch(admchoice)
			{
			case 1:admin.viewBooks();break;
			case 2:
				System.out.println("Enter book name:");
				String bkname=sc.next();
				System.out.println("Enter book auther:");
				String auth=sc.next();
				System.out.println("Enter book gener:");
				String bkgener=sc.next();
				System.out.println("Enter Quantity:");
				int bkqun=sc.nextInt();
				LibBook book= new LibBook(1,bkqun,auth,bkgener,bkname);
				admin.addBook(book);break;
			case 3:System.out.print("Enter book Id to remove book:");
			      int bookid=sc.nextInt();
			      admin.removeBook(bookid);
			case 4:System.out.println("Exiting from Admin Menu");
	                    return;
			default:System.out.println("Invalid choice.....please try again");
			}
			}
		}
		else if(choice==2)
		{
			LibCustomer customer=new LibCustomer();
			customer.userLogin();
			while(true)
			{
				System.out.println("---------------------welcome to Customer menu-------------------------------");
				System.out.println("1.View books\n2.Borow Book\n3.ReturnBook\n4.Exit\nEnter your choice:");
				int cstmchoice=sc.nextInt();
				switch(cstmchoice)
				{
				case 1:customer.viewBooks();break;
				case 2:System.out.println("Enter book ID to borrow book:");
				        int bookId=sc.nextInt();
				        BookThread borrow=new BookThread(customer,bookId);
				        borrow.start();
				        try {
				        	borrow.join();
				        }
				        catch(Exception e)
				        {
				        	e.printStackTrace();
				        }
				        break;
				case 3:System.out.println("Enter book ID to return book:");
				        int returnbk=sc.nextInt();
				        customer.returnBook(returnbk);
				        break;
				case 4:System.out.println("Exiting from Customer Menu");
				        return;
				default:System.out.println("Invalid choice.....please try again");
				}
				
			}
		}
		else
		{
		System.out.println("Incorrect choice.....Please try again");
		
	}
		sc.close();
}
}