package by.grodno.zagart.dataaccess.model;

public class Country {
	
	private long id;
	private String name;
	private int isoCode;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIsoCode() {
		return isoCode;
	}
	public void setIsoCode(int isoCode) {
		this.isoCode = isoCode;
	}

}
