package by.epam.grodno.training.java.zagart.dbtask;

import java.sql.Date;

public class BlackList {
	
	private int id;
	private int userId;
	private Date dateOfBlocking;
	private Date dateOfUnlocking;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Date getDateOfBlocking() {
		return dateOfBlocking;
	}
	public void setDateOfBlocking(Date dateOfBlocking) {
		this.dateOfBlocking = dateOfBlocking;
	}
	public Date getDateOfUnlocking() {
		return dateOfUnlocking;
	}
	public void setDateOfUnlocking(Date dateOfUnlocking) {
		this.dateOfUnlocking = dateOfUnlocking;
	}

}
