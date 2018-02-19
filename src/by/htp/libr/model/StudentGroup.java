package by.htp.libr.model;

import java.util.Arrays;

public class StudentGroup {
	private Student[] students;
	private int CountOfStudents;
	private int groupID;

	// Constructor without parameters
	public StudentGroup() {

	}

	// Constructor with parameters
	public StudentGroup(int x) {
		students = new Student[15];
		groupID = x;
	}

	// Add array of students to this group
	public void setStudentGroup(Student[] students) {
		if ((students != null) && ((CountOfStudents + students.length) < 16)
				&& ((CountOfStudents + students.length) > 4)) {
			for (int i = CountOfStudents, j = 0; i < (CountOfStudents + students.length); i++, j++) {
				this.students[i] = students[j];
				this.students[i].setID(this.groupID);
			}
			CountOfStudents += students.length;
		} else {
			System.out.println("You try add invalid number of students to group, change number and try again");
		}
	}

	// Add one student to this group
	public void addStudent(Student student) {
		// Check NPE
		if ((students != null) && (CountOfStudents < 16)) {
			if (CountOfStudents < students.length) {
				students[CountOfStudents] = student;
				student.setID(this.groupID);
				CountOfStudents++;
			} else {
				Student[] students = new Student[this.students.length + 10];
				for (int i = 0; i < this.students.length; i++)
					students[i] = this.students[i];
				this.students = students;
				this.students[CountOfStudents] = student;
				student.setID(this.groupID);
				CountOfStudents++;
			}
		} else {
			if (CountOfStudents > 15) {
				System.out.println("You try add invalid number of students to group, change number and try again");
			} else {
				students = new Student[10];
				students[CountOfStudents] = student;
				student.setID(this.groupID);
				CountOfStudents++;
			}
		}
	}

	// Output to console all students from this group
	public void showStudentGroup() {
		System.out.println("These students study at " + groupID + " group:");
		for (int i = 0; i < this.CountOfStudents; i++) {
			System.out.print(students[i].getName());
			System.out.print(" " + students[i].getSurname());
			System.out.println();
		}
		System.out.println("==================================================");
	}

	// Bubble sort
	public void bubbleSort() {
		for (int i = CountOfStudents - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (students[j].getAge() > students[j + 1].getAge()) {
					Student temp = students[j];
					students[j] = students[j + 1];
					students[j + 1] = temp;
				}
			}
		}

	}

	// Selection sort
	public void selectionSort() {
		for (int i = 0; i < CountOfStudents - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < CountOfStudents; j++) {
				if (students[j].getAge() < students[minIdx].getAge()) {
					minIdx = j;
				}
			}
			if (minIdx != i) {
				Student temp = students[i];
				students[i] = students[minIdx];
				students[minIdx] = temp;
			}

		}

	}

	// Insertion sort
	public void insertionSort() {

		for (int i = 1; i < CountOfStudents; i++) {
			Student key = students[i];
			int j = i - 1;
			while (j >= 0 && students[j].getAge() > key.getAge()) {
				students[j + 1] = students[j];
				j = j - 1;
			}
			students[j + 1] = key;
		}

	}

	// Quick sort
	public void quickSort() {
		int startIndex = 0;
		int endIndex = CountOfStudents - 1;
		doSort(startIndex, endIndex);
	}

	private void doSort(int start, int end) {
		if (start >= end)
			return;
		int i = start, j = end;
		int cur = i - (i - j) / 2;
		while (i < j) {
			while (i < cur && (students[i].getAge() <= students[cur].getAge())) {
				i++;
			}
			while (j > cur && (students[cur].getAge() <= students[j].getAge())) {
				j--;
			}
			if (i < j) {
				Student temp = students[i];
				students[i] = students[j];
				students[j] = temp;
				if (i == cur)
					cur = j;
				else if (j == cur)
					cur = i;
			}
		}
		doSort(start, cur);
		doSort(cur + 1, end);
	}

	// Find and return year in which entered the biggest number of students
	public int findBiggestYear() {
		int[] arr = new int[CountOfStudents];
		for (int i = 0; i < CountOfStudents; i++) {
			arr[i] = students[i].getYear();
		}
		Arrays.sort(arr);

		int prev = arr[0];
		int popular = arr[0];
		int count = 1;
		int maxCount = 1;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == prev) {
				count++;
			} else {
				if (count > maxCount) {
					popular = arr[i - 1];
					maxCount = count;
				}
				prev = arr[i];
				count = 1;
			}
		}
		int temp = 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i + 1] == arr[i]) {
				temp++;
			}
			if (temp == maxCount)
				return arr[i];
		}
		return 0;
	}

	// Find and return number of students who entered this year
	public int getNumbStudOfYear(int x) {
		int count = 0;
		for (int i = 0; i < CountOfStudents; i++) {
			if (students[i].getYear() == x) {
				count++;
			}
		}
		return count;
	}

	public double getAverageAge() {
		int temp = 0;
		for (int i = 0; i < CountOfStudents; i++) {
			temp += students[i].getAge();
		}
		double d = (double) temp / CountOfStudents;
		return d;
	}

	// Output to the console average age of students in this group
	public void showAverageAge() {
		System.out.println("Avarage age of students from group 2 is " + getAverageAge() + " years");
		System.out.println("==================================================");
	}

	// Output to the console number of students who entered in this year
	public void showNumbStudOfYear(int year) {
		System.out.println("Number of students entered in 2015 is " + getNumbStudOfYear(year));
		System.out.println("==================================================");
	}

	// Find and output to the console the biggest number of students entered in one year
	public void showBiggestYear() {
		System.out.println("The max number of student (" + getNumbStudOfYear(findBiggestYear()) + ") entered in "
				+ findBiggestYear());
		System.out.println("==================================================");
	}

}
