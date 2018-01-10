import java.util.ArrayList;
import java.util.List;

public class Office {

	private List<String> services;
	private int timeOfficeWorking;
	private int timeUntilTheDeskIsBusy;
	private int officeId;

	public Office(List<String> serviciiPrestate, int id) {
		this.services = new ArrayList<>();
		for (String string : serviciiPrestate) {
			services.add(string);
		}
		this.timeOfficeWorking = 0;
		this.timeUntilTheDeskIsBusy = 0;
		this.officeId = id;
	}

	public void showServices() {
		for (String string : services) {
			System.out.println("Have services " + string);
		}

	}

	public void serveClient(int contor, int servingTime) {
		timeOfficeWorking += servingTime;
		timeUntilTheDeskIsBusy = contor + servingTime;

	}

	public boolean canServe(Client client) {
		for (String service : services) {
			if (client.hasSameService(service)) {
				return true;
			}
		}
		return false;
	}

	public boolean isFree(int contor) {
		if (contor > timeUntilTheDeskIsBusy) {
			return true;
		}
		return false;
	}

	public int getOfficeId() {
		return officeId;
	}

	public int getOfficeUssage() {
		return timeOfficeWorking;
	}

}
