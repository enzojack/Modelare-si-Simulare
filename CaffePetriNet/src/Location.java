
public class Location {

	private TypeOfLocation tag;
	private int jetoane;
	
	public Location(TypeOfLocation tag, int jetoane) {
		super();
		this.tag = tag;
		this.jetoane = jetoane;
	}

	public boolean hasEnoughCounters(int capacity) {
		
		return jetoane >= capacity;
	}

	

	public void substractCounters(int capacity) {
		this.jetoane -= capacity;
		
	}

	public void addCounters(int capacity) {
		this.jetoane +=capacity;
		System.out.println("The new location is : " + tag);
		
	}
	
	
	
}
