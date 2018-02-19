package by.htp.libr.model;

import java.util.Date;

public class Author {

	public String name;
	public String surname;
	public Date birthDate;

	// Constructor without parameters
	public Author() {

	}

	// Constructor with parameters
	public Author(String name, String surname, Date birthDate) {
		this.name = name;
		this.surname = surname;
		this.birthDate = birthDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthdate() {
		return this.birthDate;
	}

	public void setBirthdate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
