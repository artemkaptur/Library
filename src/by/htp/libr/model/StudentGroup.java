package by.htp.libr.model;

public class StudentGroup {
	private Student[] students;
	private int CountOfStudents;
	private int groupID;

	// Constructor
	public StudentGroup(int x) {
		groupID = x;
	}
	
	// Add array of students to this group
	public void setStudentGroup(Student[] students) {
		if (students != null) {
			this.students = students;
			CountOfStudents = students.length;
			for (int i = 0; i < CountOfStudents; i++) {
				students[i].addID(this.groupID);
			}
		}

	}

	// Add one student to this group
	public void addStudent(Student student) {
		// Check NPE
		if (students != null) {
			if (CountOfStudents < students.length) {
				students[CountOfStudents] = student;
				student.addID(this.groupID);
				CountOfStudents++;
			} else {
				Student[] students = new Student[this.students.length + 10];
				for (int i = 0; i < this.students.length; i++)
					students[i] = this.students[i];
				this.students = students;
				this.students[CountOfStudents] = student;
				student.addID(this.groupID);
				CountOfStudents++;
			}
		} else {
			students = new Student[10];
			students[CountOfStudents] = student;
			student.addID(this.groupID);
			CountOfStudents++;
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
	}
}
