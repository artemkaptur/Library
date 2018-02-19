package by.htp.libr.model;

public class Student {

	private String name;
	private String surname;
	private Book[] books;
	private int studentBooks;
	private int groupID;
	private int age;
	private int enteringYear;

	// Constructor without parameters
	public Student() {

	}

	// Constructor with parameters
	public Student(String name, String surname, int age, int enteringYear) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.enteringYear = enteringYear;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setID(int x) {
		groupID = x;
	}

	public double getID() {
		return this.groupID;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getAge() {
		return this.age;
	}

	public void setYear(int enteringYear) {
		this.enteringYear = enteringYear;
	}

	public int getYear() {
		return this.enteringYear;
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

}
