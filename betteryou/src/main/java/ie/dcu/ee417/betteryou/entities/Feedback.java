package ie.dcu.ee417.betteryou.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Feedback {

	@Id
	private String userName;
	private String name;
	private String email;
	private String subject;
	private String message;
	
	public Feedback() {}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

			
	
}
