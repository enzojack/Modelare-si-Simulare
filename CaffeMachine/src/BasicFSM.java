
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
		Map<Action,State> nextState = new HashMap<Action, State>();
		if(transitionTable.get(currentState) == null) {
			return;
		}
		nextState = transitionTable.get(currentState);
		
		if(nextState.get(action) == null) {
			return;
		}
		this.currentState = nextState.get(action);
	}

	public State getCurrentState() {
		
		return currentState;
	}
	
	

	
	
}
