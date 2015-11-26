package by.grodno.zagart.dataaccess.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.stereotype.Repository;

public class User {

	private long id;
	private String firstName;
	private String lastName;
	private String login;
	private String email;
	private String password;
	private BigDecimal balance;
	private	long countryId;
	private Date dateOfCreation;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public Long getCountryId() {
		return countryId;
	}
	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}
	public Object getCreationDate() {
		return dateOfCreation;
	}
	public void setCreationDate(Date date) {
		dateOfCreation = date;	
	}
	
}
