import java.util.ArrayList;
import java.util.List;

public class PetriNet {
	protected List<Transition> transitions;

	public PetriNet() {
		transitions = new ArrayList<>();

	}

	public void exec(TypeOfTransition theTransition) {
		List<Transition> possibleTransition = new ArrayList<>();
		for (Transition transition : transitions) {
			if (transition.hasSameName(theTransition))
				if (transition.isValid()) {
					possibleTransition.add(transition);

				}
		}
		if (possibleTransition.isEmpty()) {
			System.out.println("Nu se poate executa actiunea dorita!");
		} else {
			for (Transition transition : possibleTransition) {
				transition.update();
			}
			possibleTransition.clear();

		}

	}

}
