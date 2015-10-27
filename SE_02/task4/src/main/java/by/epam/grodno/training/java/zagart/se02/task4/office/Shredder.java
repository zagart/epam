package by.epam.grodno.training.java.zagart.se02.task4.office;

public class Shredder extends OfficeInstruments {

	private int securityLevel = 0;
	private int volume = 0;

	public int getSecurityLevel() {
		return securityLevel;
	}

	public void setSecurityLevel(int securityLevel) {
		this.securityLevel = securityLevel;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public Shredder() {
		super();
	}

	public Shredder(String name, int cost) {
		super(name, cost);
	}
	
}
