import java.util.ArrayList;
import java.util.List;

public class CaffeePetriNet extends PetriNet {

	public CaffeePetriNet() {
		super();
		initialize();
	}

	private void initialize() {
		Location coins0 = new Location(1, 1);
		Location coins5 = new Location(2, 0);
		Location coins10 = new Location(3, 0);
		Location coins15 = new Location(4, 0);
		Location coins20 = new Location(5, 0);

		List<Arch> archs1 = new ArrayList<>();
		archs1.add(new Arch(1, coins0, Direction.IN));
		archs1.add(new Arch(1, coins5, Direction.OUT));

		transitions.add(new Transition(1, archs1));

		List<Arch> archs2 = new ArrayList<>();
		archs2.add(new Arch(1, coins0, Direction.IN));
		archs2.add(new Arch(1, coins10, Direction.OUT));

		transitions.add(new Transition(2, archs2));

		List<Arch> archs3 = new ArrayList<>();
		archs3.add(new Arch(1, coins5, Direction.IN));
		archs3.add(new Arch(1, coins10, Direction.OUT));

		transitions.add(new Transition(1, archs3));

		List<Arch> archs4 = new ArrayList<>();
		archs4.add(new Arch(1, coins5, Direction.IN));
		archs4.add(new Arch(1, coins15, Direction.OUT));

		transitions.add(new Transition(2, archs4));

		List<Arch> archs5 = new ArrayList<>();
		archs5.add(new Arch(1, coins10, Direction.IN));
		archs5.add(new Arch(1, coins15, Direction.OUT));

		transitions.add(new Transition(1, archs5));

		List<Arch> archs6 = new ArrayList<>();
		archs6.add(new Arch(1, coins10, Direction.IN));
		archs6.add(new Arch(1, coins20, Direction.OUT));

		transitions.add(new Transition(2, archs6));

		List<Arch> archs7 = new ArrayList<>();
		archs7.add(new Arch(1, coins15, Direction.IN));
		archs7.add(new Arch(1, coins20, Direction.OUT));

		transitions.add(new Transition(1, archs7));

		List<Arch> archs8 = new ArrayList<>();
		archs8.add(new Arch(1, coins20, Direction.IN));
		archs8.add(new Arch(1, coins10, Direction.OUT));

		transitions.add(new Transition(3, archs8));

		List<Arch> archs9 = new ArrayList<>();
		archs9.add(new Arch(1, coins20, Direction.IN));
		archs9.add(new Arch(1, coins5, Direction.OUT));

		transitions.add(new Transition(4, archs9));

		List<Arch> archs10 = new ArrayList<>();
		archs10.add(new Arch(1, coins15, Direction.IN));
		archs10.add(new Arch(1, coins5, Direction.OUT));

		transitions.add(new Transition(3, archs10));

		List<Arch> archs11 = new ArrayList<>();
		archs11.add(new Arch(1, coins15, Direction.IN));
		archs11.add(new Arch(1, coins0, Direction.OUT));

		transitions.add(new Transition(4, archs11));

		List<Arch> archs12 = new ArrayList<>();
		archs12.add(new Arch(1, coins10, Direction.IN));
		archs12.add(new Arch(1, coins0, Direction.OUT));

		transitions.add(new Transition(3, archs12));

	}

}
