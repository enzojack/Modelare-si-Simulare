import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerPetriNet extends PetriNet {

	public ProducerConsumerPetriNet() {
		super();
		initialize();
	}

	private void initialize() {
		Location producers = new Location(1, 20);
		Location elementReadyToBePutInQueue = new Location(2, 0);
		Location mutex = new Location(3, 1);
		Location freeSpots = new Location(4, 10);
		Location fullSpots = new Location(5, 0);
		Location elementReadyToBeConsumed = new Location(6, 0);
		Location consumers = new Location(7, 0);
		
		
		List<Arch> archs1 = new ArrayList<>();
		archs1.add(new Arch(1,producers, Direction.IN));
		archs1.add(new Arch(1, elementReadyToBePutInQueue, Direction.OUT));

		transitions.add(new Transition(1, archs1));

		List<Arch> archs2 = new ArrayList<>();
		archs2.add(new Arch(1, elementReadyToBePutInQueue, Direction.IN));
		archs2.add(new Arch(1,fullSpots, Direction.OUT));
		archs2.add(new Arch(1, elementReadyToBePutInQueue, Direction.IN));
		archs2.add(new Arch(1,producers, Direction.OUT));
		archs2.add(new Arch(1, freeSpots, Direction.IN));
		archs2.add(new Arch(1,fullSpots, Direction.OUT));
		archs2.add(new Arch(1, mutex, Direction.IN));
		archs2.add(new Arch(1,mutex, Direction.OUT));
		
		transitions.add(new Transition(2, archs2));

		List<Arch> archs3 = new ArrayList<>();
		archs3.add(new Arch(1, fullSpots, Direction.IN));
		archs3.add(new Arch(1, elementReadyToBeConsumed, Direction.OUT));
		archs3.add(new Arch(1, fullSpots, Direction.IN));
		archs3.add(new Arch(1, freeSpots, Direction.OUT));
		archs3.add(new Arch(1, consumers, Direction.IN));
		archs3.add(new Arch(1, elementReadyToBeConsumed, Direction.OUT));
		archs3.add(new Arch(1, mutex, Direction.IN));
		archs3.add(new Arch(1, mutex, Direction.OUT));
		

		transitions.add(new Transition(3, archs3));

		List<Arch> archs4 = new ArrayList<>();
		archs4.add(new Arch(1, elementReadyToBeConsumed, Direction.IN));
		archs4.add(new Arch(1, consumers, Direction.OUT));

		transitions.add(new Transition(4, archs4));

	}

}
