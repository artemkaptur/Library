package by.htp.libr.model;

import java.util.Date;

public class Author {

	public String name;
	public String surname;
	public Date birthDate;

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public Date getBirthdate() {
		return this.birthDate;
	}
	
	// Constructor without parameters
	public Author() {

	}

	// Constructor with parameters
	public Author(String name, String surname, Date birthDate) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
	}
}
