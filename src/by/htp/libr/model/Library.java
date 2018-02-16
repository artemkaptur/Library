package by.htp.libr.model;

public class Library {

	private Book[] books;
	private int CountOfBooks;

	// Constructor without parameters
	public Library() {
	};

	// Constructor with parameters
	public Library(Book[] books) {
		this.books = books;
		CountOfBooks = books.length;
	};

	// Show all books situated in this library and information about them
	public void showStatus() {
		System.out.println("There are these books in library:");
		for (int i = 0; i < CountOfBooks; i++) {
			System.out.print("\"" + books[i].getTitle() + "\" " + books[i].getYear() + " year, by ");
			books[i].showAuthors();
			System.out.println();
			books[i].showBookOwner();
		}
	}

	// Add array of books to our library
	public void setBooks(Book[] books) {
		if (books != null) {
			this.books = books;
			CountOfBooks = books.length;
		}
	}
	
	public Book[] getBooks() {
		return this.books;
	}

	// Add one book to our library
	public void addBook(Book book) {
		// Check NPE
		if (books != null) {
			if (CountOfBooks < books.length) {
				books[CountOfBooks] = book;
				CountOfBooks++;
			} else {
				Book[] books = new Book[this.books.length + 10];
				for (int i = 0; i < this.books.length; i++)
					books[i] = this.books[i];
				this.books = books;
				this.books[CountOfBooks] = book;
				CountOfBooks++;
			}
		} else {
			books = new Book[10];
			books[CountOfBooks] = book;
			CountOfBooks++;
		}
	}

}
