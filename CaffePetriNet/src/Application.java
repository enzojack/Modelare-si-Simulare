import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		//caffeePetriNet();
		//readerWriterPetriNet();
		producerConsumerPetriNet();

	}

	static void caffeePetriNet() {
		CaffeePetriNet caffeeMachine = new CaffeePetriNet();
		Scanner option = new Scanner(System.in);
		int number;
		do {
			displayCaffeePetriNet();
			System.out.println("Type a number");
			number = option.nextInt();
			if (number >=0  || number <= 4) {
				caffeeMachine.exec(number);
			} else {
				System.out.println("Invalid transition");
			}
		} while (number != 0);
	}
	
	static void readerWriterPetriNet() {
		ReaderWriterPetriNet readerWriter = new ReaderWriterPetriNet();
		Scanner option = new Scanner(System.in);
		int number;
		do {
			displayReaderWriter();
			System.out.println("Type a number");
			number = option.nextInt();
			if (number >=0  || number <= 4) {
				readerWriter.exec(number);
			} else {
				System.out.println("Invalid transition");
			}
		} while (number != 0);
	}
	
	static void producerConsumerPetriNet() {
		ProducerConsumerPetriNet producerConsumer = new ProducerConsumerPetriNet();
		Scanner option = new Scanner(System.in);
		int number;
		do {
			displayProducerConsumer();
			System.out.println("Type a number");
			number = option.nextInt();
			if (number >=0  || number <= 4) {
				producerConsumer.exec(number);
			} else {
				System.out.println("Invalid transition");
			}
		} while (number != 0);
	}

	static void displayCaffeePetriNet() {
		System.out.println();
		System.out.println("Location 1 reprezent 0 bani");
		System.out.println("Location 2 reprezent 5 bani");
		System.out.println("Location 3 reprezent 10 bani");
		System.out.println("Location 4 reprezent 15 bani");
		System.out.println("Location 5 reprezent 20 bani");
		System.out.println("----------------------------------");
		System.out.println("Type 0 to exit");
		System.out.println("Type 1 to deposit 5 bani");
		System.out.println("Type 2 to deposit 10 bani");
		System.out.println("Type 3 to take cheap caffee");
		System.out.println("Type 3 to take expensive caffee");
		System.out.println();
	}
	
	static void displayProducerConsumer() {
		System.out.println("Location 1 reprezent producers");
		System.out.println("Location 2 reprezent element ready to put in queue");
		System.out.println("Location 3 reprezent mutex");
		System.out.println("Location 4 reprezent free spots");
		System.out.println("Location 5 reprezent full spots");
		System.out.println("Location 6 reprezent element ready to be consumed");
		System.out.println("Location 7 reprezent consumers");
		System.out.println("----------------------------------");
		System.out.println("Type 0 to exit");
		System.out.println("Type 1 to produce");
		System.out.println("Type 2 to push in queue");
		System.out.println("Type 3 to pop from queue");
		System.out.println("Type 4 to consume");
		System.out.println();
	}
	
	static void displayReaderWriter() {
		System.out.println("Location 1 reprezent memory");
		System.out.println("Location 2 reprezent someoneRead");
		System.out.println("Location 3 reprezent someoneWrite");
		System.out.println("----------------------------------");
		System.out.println("Type 0 to exit");
		System.out.println("Type 1 to startWrite");
		System.out.println("Type 2 to endWrite");
		System.out.println("Type 3 to startRead");
		System.out.println("Type 4 to endRead");
		System.out.println();
	}

}
