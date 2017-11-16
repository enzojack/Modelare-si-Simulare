
import java.util.HashMap;
import java.util.Map;

public class BasicFSM {
	private State currentState;
	private Map<State, Map<Action,State> > transitionTable = new HashMap<State, Map<Action,State> >();
	
	public BasicFSM(Map<State, Map<Action, State>> outerMap2) {
		this.currentState = State.ZERO;
		this.transitionTable = outerMap2;
	}


	public void transition(Action action) {
		this.currentState = transitionTable.get(currentState).get(action);
	}

	public State getCurrentState() {
		
		return currentState;
	}
	
	

	
	
}
