import java.util.Map;

public class CaffeMachine extends BasicFSM {

	

	public CaffeMachine(Map<State, Map<Action, State>> outerMap2) {
		
		super(outerMap2);
	}

}
