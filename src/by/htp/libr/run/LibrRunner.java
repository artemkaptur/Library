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
		System.out.println("==================================================");

		// Create ten student objects
		Student stud1 = new Student("John", "Dilinjer", 17, 2015);
		Student stud2 = new Student("Bill", "Turner", 20, 2017);
		Student stud3 = new Student("Kate", "Perry", 21, 2015);
		Student stud4 = new Student("Hans", "Anderson", 18, 2017);
		Student stud5 = new Student("Lili", "Potter", 19, 2015);
		Student stud6 = new Student("Jack", "Crowford", 30, 1999);
		Student stud7 = new Student("Will", "Gram", 28, 2002);
		Student stud8 = new Student("Clarissa", "Starling", 25, 2002);
		Student stud9 = new Student("Agata", "Kristi", 40, 1945);
		Student stud10 = new Student("Gannibal", "Lector", 39, 1972);

		// Create the first student group and add students there
		Student[] students = new Student[] { stud1, stud2, stud3, stud4, stud5 };
		StudentGroup group1 = new StudentGroup(1);
		group1.setStudentGroup(students);

		// Create the second student group and add students there
		StudentGroup group2 = new StudentGroup(2);
		group2.addStudent(stud1);
		group2.addStudent(stud2);
		group2.addStudent(stud3);
		group2.addStudent(stud4);
		group2.addStudent(stud5);
		
		// Create the third and fourth student group and add students there
		Student[] students2 = new Student[] { stud6, stud7, stud8, stud9, stud10 };
		StudentGroup group3 = new StudentGroup(3);
		StudentGroup group4 = new StudentGroup(4);
		group3.setStudentGroup(students2);
		group4.setStudentGroup(students2);

		// Output to console students from each group
		group1.showStudentGroup();
		System.out.println("==================================================");
		group2.showStudentGroup();
		System.out.println("==================================================");
		group3.showStudentGroup();
		System.out.println("==================================================");
		group4.showStudentGroup();
		System.out.println("==================================================");
		
		// Student one and two take books
		stud1.takeBook(book1);
		stud2.takeBook(book2);
		stud2.takeBook(book3);
		libr.showStatus();
		System.out.println("==================================================");
		
		// Output average age of students from the second group
		double averA = group2.getAverageAge();
		System.out.println("Avarage age of students from group 2 is " + averA + " years");
		System.out.println("==================================================");
		
		// Output to the console number of students who entered in 2015
		int count2015 = group2.getNumbStudOfYear(2015);
		System.out.println("Number of students entered in 2015 is " + count2015);
		System.out.println("==================================================");
		
		int maxYear = group2.findBiggestYear();
		System.out.println("The max number of student (" + group2.getNumbStudOfYear(maxYear) + ") entered in " + maxYear);
		System.out.println("==================================================");
		
		group2.bubbleSort();
		group2.showStudentGroup();
		System.out.println("==================================================");
		
		group1.selectionSort();
		group1.showStudentGroup();
		System.out.println("==================================================");
		
		group3.insertionSort();
		group3.showStudentGroup();
		System.out.println("==================================================");
		
		group4.quickSort();
		group4.showStudentGroup();

	}

}
