import java.util.HashMap;
import java.util.Map;

public class Device {
	private BasicFSM caffeMachine ;
	
	public Device() {
		Map<State, Map<Action,State> > outerMap = new HashMap<State,Map<Action,State>>();
		
		Map<Action,State> innerMap1 = new HashMap<Action,State>();
		innerMap1.put(Action.FIVE, State.FIVE);
		innerMap1.put(Action.TEN, State.TEN);
		
		Map<Action,State> innerMap2 = new HashMap<Action,State>();
		innerMap2.put(Action.FIVE, State.TEN);
		innerMap2.put(Action.TEN, State.FIFTEEN);
		
		Map<Action,State> innerMap3 = new HashMap<Action,State>();
		innerMap3.put(Action.FIVE, State.FIFTEEN);
		innerMap3.put(Action.TEN, State.TWENTY);
		innerMap3.put(Action.CAFFE_TEN, State.ZERO);
		
		Map<Action,State> innerMap4 = new HashMap<Action,State>();
		innerMap4.put(Action.FIVE, State.TWENTY);
		innerMap4.put(Action.CAFFE_TEN, State.FIVE);
		innerMap4.put(Action.CAFFE_FIFTEEN, State.ZERO);
		
		Map<Action,State> innerMap5 = new HashMap<Action,State>();
		innerMap5.put(Action.CAFFE_TEN, State.TEN);
		innerMap5.put(Action.CAFFE_FIFTEEN,State.FIVE);
		
		outerMap.put(State.ZERO, innerMap1);
		outerMap.put(State.FIVE,innerMap2);
		outerMap.put(State.TEN,innerMap3);
		outerMap.put(State.FIFTEEN,innerMap4);
		outerMap.put(State.TWENTY,innerMap5);
		
		caffeMachine = new CaffeMachine(outerMap);
		
	}
	
	public void takeOrder(Action action) {
		
		caffeMachine.transition(action);
		
	}

	public String getCurrentState() {
		
		return caffeMachine.getCurrentState().toString();
	}

}
