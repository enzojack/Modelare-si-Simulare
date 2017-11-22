
public class Arch {
	private int capacity;
	private Location location;
	private Direction direction;
	
	public Arch(int capacity, Location location, Direction direction) {
		super();
		this.capacity = capacity;
		this.location = location;
		this.direction = direction;
	}

	public boolean isValid() {
		if(direction.equals(Direction.IN)) {
			if(location.hasEnoughCounters(capacity)) {
				return true;
			}
		}else if(direction.equals(Direction.OUT)) {
			return true;
		}
		return false;
	}

	public void update() {
		if(direction.equals(Direction.IN)) {
			location.substractCounters(capacity);
		}
		else if(direction.equals(Direction.OUT)) {
			location.addCounters(capacity);
		}
		
	}
	
	
}
