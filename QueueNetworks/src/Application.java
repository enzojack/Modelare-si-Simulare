import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Application {

	public static void main(String[] args) {

		List<String> functiiGhiseu = new ArrayList<>();
		functiiGhiseu.add("preluare colet");
		functiiGhiseu.add("livrare colet");
		Office preluareLivrareColet = new Office(functiiGhiseu, 1);

		functiiGhiseu.clear();

		functiiGhiseu.add("scrisori recomandate");
		functiiGhiseu.add("mandate postale");
		Office scrisoriMandatePostale = new Office(functiiGhiseu, 2);

		functiiGhiseu.clear();

		functiiGhiseu.add("plati facturi");

		Office platiFacturi = new Office(functiiGhiseu, 3);

		functiiGhiseu.clear();

		functiiGhiseu.add("preluare colet");

		Office preluareColet = new Office(functiiGhiseu, 4);

		List<Office> offices = new ArrayList<>();
		offices.add(preluareLivrareColet);
		offices.add(scrisoriMandatePostale);
		offices.add(platiFacturi);
		offices.add(preluareColet);

		Agency postalAgency = new Agency(offices);
		postalAgency.agencyStart(480);

	}

}
