package by.grodno.zagart.dataaccess.model;

import java.sql.Date;

public class BlackList {
	
	private long id;
	private long userId;
	private Date dateOfBlocking;
	private Date dateOfUnlocking;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
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
