import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		CaffeePetriNet caffeeMachine = new CaffeePetriNet();
		caffeeMachine.exec(TypeOfTransition.INSERT_COIN_5B);
		caffeeMachine.exec(TypeOfTransition.INSERT_COIN_10B);
		caffeeMachine.exec(TypeOfTransition.TAKE_10B_CAFFEE);
		caffeeMachine.exec(TypeOfTransition.INSERT_COIN_5B);
		caffeeMachine.exec(TypeOfTransition.INSERT_COIN_10B);
		caffeeMachine.exec(TypeOfTransition.TAKE_15B_CAFFEE);
		caffeeMachine.exec(TypeOfTransition.TAKE_10B_CAFFEE);
	}

}
