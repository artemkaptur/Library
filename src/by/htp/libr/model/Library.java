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

	// Show all books situated in this library and information about them
	public void showStatus() {
		if (books != null) {
			System.out.println("There are these books in library:");
			for (int i = 0; i < CountOfBooks; i++) {
				System.out.print("\"" + books[i].getTitle() + "\" " + books[i].getYear() + " year, by ");
				books[i].showAuthors();
				System.out.println();
				books[i].showBookOwner();
			}
			System.out.println("==================================================");
		} else {
			System.out.println("There are no books in library yet ");
		}
	}

	// Quick sort
	public void quickSort() {
		int startIndex = 0;
		int endIndex = CountOfBooks - 1;
		doSort(startIndex, endIndex);
	}

	private void doSort(int start, int end) {
		if (start >= end)
			return;
		int i = start, j = end;
		int cur = i - (i - j) / 2;
		while (i < j) {
			while (i < cur && (books[i].getYear() <= books[cur].getYear())) {
				i++;
			}
			while (j > cur && (books[cur].getYear() <= books[j].getYear())) {
				j--;
			}
			if (i < j) {
				Book temp = books[i];
				books[i] = books[j];
				books[j] = temp;
				if (i == cur)
					cur = j;
				else if (j == cur)
					cur = i;
			}
		}
		doSort(start, cur);
		doSort(cur + 1, end);
	}

	// Find and return all books by author
	public Book[] findAuthorBooks(Author author) {
		Book[] localBooks = new Book[books.length];
		int count = 0;
		for (int i = 0; i < CountOfBooks; i++) {
			for (int j = 0; j < books[i].getAuthorCounter(); j++)
				if (books[i].getAuthors()[j] == author) {
					localBooks[count] = books[i];
					count++;
				}
		}
		return localBooks;
	}
	
}
