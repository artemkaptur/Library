package by.htp.libr.model;

public class Student {

	private String name;
	private String surname;
	private Book[] books;
	private int studentBooks;
	private int groupID;

	// Constructor without parameters
	public Student() {

	}

	// Constructor with parameters
	public Student(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public void addID(int x) {
		groupID = x;
	}

	// Student takes one book
	public void takeBook(Book book) {
		// Check NPE
		if (books != null) {
			if (studentBooks < books.length) {
				books[studentBooks] = book;
				book.addOwner(this);
				studentBooks++;
			} else {
				Book[] books = new Book[this.books.length + 10];
				for (int i = 0; i < this.books.length; i++)
					books[i] = this.books[i];
				this.books = books;
				this.books[studentBooks] = book;
				book.addOwner(this);
				studentBooks++;
			}
		} else {
			books = new Book[10];
			books[studentBooks] = book;
			book.addOwner(this);
			studentBooks++;
		}
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

}
