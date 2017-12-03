import java.util.ArrayList;
import java.util.List;

public class ReaderWriterPetriNet extends PetriNet {

	public ReaderWriterPetriNet() {
		super();
		initialize();
	}

	private void initialize() {
		Location memory = new Location(1, 10);
		Location someoneRead = new Location(2, 0);
		Location someoneWrite = new Location(3, 0);
		
		List<Arch> archs1 = new ArrayList<>();
		archs1.add(new Arch(10, memory, Direction.IN));
		archs1.add(new Arch(1, someoneWrite, Direction.OUT));

		transitions.add(new Transition(1, archs1));

		List<Arch> archs2 = new ArrayList<>();
		archs2.add(new Arch(1, someoneWrite, Direction.IN));
		archs2.add(new Arch(10, memory, Direction.OUT));

		transitions.add(new Transition(2, archs2));

		List<Arch> archs3 = new ArrayList<>();
		archs3.add(new Arch(1, memory, Direction.IN));
		archs3.add(new Arch(1, someoneRead, Direction.OUT));

		transitions.add(new Transition(3, archs3));

		List<Arch> archs4 = new ArrayList<>();
		archs4.add(new Arch(1, someoneRead, Direction.IN));
		archs4.add(new Arch(1, memory, Direction.OUT));

		transitions.add(new Transition(4, archs4));

	}

}
