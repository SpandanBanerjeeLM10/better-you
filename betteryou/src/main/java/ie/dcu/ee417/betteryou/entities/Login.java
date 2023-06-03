package ie.dcu.ee417.betteryou.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Login {

	@Id
	private String userName;
	private String password;
	private String role;
	
	
	public Login() {}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
}
