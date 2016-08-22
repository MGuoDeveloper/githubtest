package com.spring.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class LoginForm {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	
	@NotEmpty
	//@NotNull
	@Size(min = 1, max = 50)
	@Column(length = 50)
	public String username;
	
	@NotEmpty
	@Size(min = 1, max = 20)
	@Column(length = 20)
	public String password;
	
	public LoginForm() {
	}
	
	public LoginForm(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

}
