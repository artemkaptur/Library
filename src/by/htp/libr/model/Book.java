package by.htp.libr.model;

public class Book {

	private String title;
	private int year;
	private Author[] authors;
	private int authorCounter;
	private Student bookOwner; // Student who take this book

	// Constructor without parameters
	public Book() {
	}

	// Constructor with parameters
	public Book(String title, int year) {
		this.title = title;
		this.year = year;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return this.year;
	}

	// Add array of authors to our book
	public void setAuthors(Author[] authors) {
		if (authors != null) {
			this.authors = authors;
			authorCounter = authors.length;
		}
	}

	public Author[] getAuthors() {
		return authors;
	}

	public int getAuthorCounter() {
		return this.authorCounter;
	}

	// Add one author to our book
	public void addAuthor(Author author) {
		// Check NPE
		if (authors != null) {
			if (authorCounter < authors.length) {
				authors[authorCounter] = author;
				authorCounter++;
			} else {
				Author[] authors = new Author[this.authors.length + 10];
				for (int i = 0; i < this.authors.length; i++)
					authors[i] = this.authors[i];
				this.authors = authors;
				this.authors[authorCounter] = author;
				authorCounter++;
			}
		} else {
			authors = new Author[10];
			authors[authorCounter] = author;
			authorCounter++;
		}
	}

	public void showAuthors() {
		if (authors != null) {
			for (int i = 0; i < authorCounter; i++) {
				System.out.print(
						authors[i].getName() + " " + authors[i].getSurname() + " - " + authors[i].getBirthdate() + " ");
			}
		} else {
			System.out.println("There are no authors ");
		}
	}

	public void addOwner(Student stud) {
		bookOwner = stud;
	}

	// Show who has this book now
	public void showBookOwner() {
		if (bookOwner != null) {
			System.out.print("In current moment student ");
			System.out.print(bookOwner.getName() + " " + bookOwner.getSurname());
			System.out.println(" has this book");
		}
	}
}
