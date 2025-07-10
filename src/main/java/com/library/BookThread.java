package com.library;

public class BookThread extends Thread 
{
   private LibCustomer customer;
   private int bookId;
   public BookThread(LibCustomer customer, int bookId) {
	super();
	this.customer = customer;
	this.bookId = bookId;
   }
   
   public void run()
   {
	   synchronized(this)
	   {
		   customer.borrowbook(bookId);
	   }
   }
}
