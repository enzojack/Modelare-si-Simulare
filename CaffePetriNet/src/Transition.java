import java.util.List;

public class Transition {

	private TypeOfTransition tag;
	private List<Arch> archs;
	
	public Transition(TypeOfTransition tag, List<Arch> archs) {
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

	public boolean hasSameName(TypeOfTransition theTransition) {
		if(tag.equals(theTransition)) {
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
