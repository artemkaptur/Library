package by.htp.libr.run;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import by.htp.libr.model.Author;
import by.htp.libr.model.Book;
import by.htp.libr.model.Library;
import by.htp.libr.model.Student;
import by.htp.libr.model.StudentGroup;

public class LibrRunner {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		// Create dates of birth our authors
		Date date1 = df.parse("13-01-1972");
		Date date2 = df.parse("22-02-1976");
		Date date3 = df.parse("26-01-1981");
		Date date4 = df.parse("06-11-1955");
		Date date5 = df.parse("17-07-1906");

		// Create five authors with their Names, Surnames and dates of birth
		Author auth1 = new Author("John", "Smith", date1);
		Author auth2 = new Author("Bill", "Spector", date2);
		Author auth3 = new Author("Kate", "Gronkovski", date3);
		Author auth4 = new Author("Jim", "Anderson", date4);
		Author auth5 = new Author("Lili", "Perry", date5);

		// Create three books with titles and publishing year
		Book book1 = new Book("Your dream", 2000);
		Book book2 = new Book("Wrong turn", 1994);
		Book book3 = new Book("My favorite things", 2002);

		// Add authors to Book1
		Author[] authors = new Author[] { auth1 };
		book1.setAuthors(authors);
		book1.addAuthor(auth2);

		// Add author to Book2
		book2.addAuthor(auth3);

		// Add authors to Book3
		book3.addAuthor(auth4);
		book3.addAuthor(auth5);

		// Create new library and add it our books
		Book[] books = new Book[] { book1, book2 };
		Library libr = new Library(books);
		libr.addBook(book3);

		// Show all books situated in this library
		libr.showStatus();

		Student stud1 = new Student("John", "Dilinjer");
		Student stud2 = new Student("Bill", "Turner");
		Student stud3 = new Student("Kate", "Perry");
		Student stud4 = new Student("Hans", "Anderson");
		Student stud5 = new Student("Lili", "Potter");

		// Create the first student group and add students there
		Student[] students = new Student[] { stud1, stud2 };
		StudentGroup group1 = new StudentGroup(1);
		group1.setStudentGroup(students);

		// Create the second student group and add students there
		StudentGroup group2 = new StudentGroup(2);
		group2.addStudent(stud3);
		group2.addStudent(stud4);
		group2.addStudent(stud5);

		// Output to console students from each group
		group1.showStudentGroup();
		group2.showStudentGroup();

		// Student one and two take books
		stud1.takeBook(book1);
		stud2.takeBook(book2);
		stud2.takeBook(book3);
		libr.showStatus();

	}

}
