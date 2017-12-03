import java.util.List;

public class Transition {

	private int tag;
	private List<Arch> archs;
	
	public Transition(int tag, List<Arch> archs) {
		super();
		this.tag = tag;
		this.archs = archs;
	}

	public boolean isValid() {
		for (Arch arch : archs) {
			if(!(arch.isValid())) {
				return false;
			}
		}
		return true;
	}

	public boolean hasSameName(int theTransition) {
		if(tag == theTransition) {
			return true;
		}
		return false;
	}

	public void update() {
		for (Arch arch : archs) {
			arch.update();
		}
		
	}
	
	
	
}
