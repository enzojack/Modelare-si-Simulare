import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Agency {
	private static final int MAXNUMBEROFCLIENTSINAMINUTE = 2;
	private final int MINIMUMSERVINGTIME = 3;
	private final int MAXIMUMSERVINGTIME = 5;
	private Random rand;
	private int clientId;
	private List<Client> clientsQueue = new ArrayList<>();
	private List<Client> clientsHistory;
	private List<Office> offices;
	private List<String> poolServices;
	private int maxNumberOfClientsInQueue;

	public Agency(List<Office> offices) {
		this.rand = new Random();
		this.clientId = 0;
		this.offices = new ArrayList<>();
		this.offices = offices;
		poolServices = new ArrayList<>();
		poolServices.add("preluare colet");
		poolServices.add("livrare colet");
		poolServices.add("scrisori recomandate");
		poolServices.add("mandate postale");
		poolServices.add("plati facturi");
		this.clientsHistory = new ArrayList<>();

	}

	public void agencyStart(int minutes) {
		int contor = 0;
		int mediumClientsNumber = 0;
		while (contor < minutes) {
			int numberOfClientsArrivedInOneMinute = rand.nextInt(MAXNUMBEROFCLIENTSINAMINUTE + 1);

			generateClients(contor, numberOfClientsArrivedInOneMinute);
			if (maxNumberOfClientsInQueue < clientsQueue.size()) {
				maxNumberOfClientsInQueue = clientsQueue.size();
			}
			if(contor % 30 == 0) {
				mediumClientsNumber += clientsQueue.size();
			}
			
			serveClients(contor);
			contor++;
		}
		while (!clientsQueue.isEmpty()) {
			serveClients(contor);
			contor++;
		}

		int waitingTimeSum = 0;
		int totalTime = 0;
		for (Client client : clientsHistory) {
			waitingTimeSum += client.getTimeWaitingInQueue();
			totalTime += client.getTimeStayingInInstitution();
		}
		System.out.println();
		for (Office office : offices) {
			int coeficient = (100 * office.getOfficeUssage())/480;
			System.out.println("Coeficientul de utilizare al ghiseului " + office.getOfficeId() + " este "+coeficient + "%" );
		}
		System.out.println("Timpul mediu de stat in coada este : " + (double) waitingTimeSum / clientsHistory.size());
		System.out.println(
				"Timpul petrecut de clientii in institutie este : " + (double) totalTime / clientsHistory.size());
		System.out.println("Coada a avut lungimea maxima de " + maxNumberOfClientsInQueue);
		System.out.println("Numarul mediu de clientii in sistem este : " + (double)mediumClientsNumber/17);

	}

	private void generateClients(int startTimeStayingInQueue, int numberOfClientsArrivedInOneMinute) {
		if (numberOfClientsArrivedInOneMinute != 0) {
			for (int i = 0; i < numberOfClientsArrivedInOneMinute; i++) {
				clientId++;
				int officeNumber = rand.nextInt(poolServices.size());
				String billOrder = poolServices.get(officeNumber);
				Client newClient = new Client(billOrder, clientId, startTimeStayingInQueue);
				clientsQueue.add(newClient);
			}
		}

	}

	private void serveClients(int contor) {
		for (Office office : offices) {
			if (!clientsQueue.isEmpty()) {
				for (int i = 0; i < clientsQueue.size(); i++) {
					Client client = clientsQueue.get(i);
					if (office.isFree(contor) &&  office.canServe(client) ) {
						int clientOnOfficeTime = MINIMUMSERVINGTIME
								+ rand.nextInt(MAXIMUMSERVINGTIME - MINIMUMSERVINGTIME);
						office.serveClient(contor, clientOnOfficeTime);
						client.setTimeWhenClientLeaveQueue(contor);
						client.setTimeWhenClientLeave(contor + clientOnOfficeTime);
						System.out.println("Clientul cu id-ul " + client.getClientId() + " care are treaba la ghiseul "
								+ client.getOffice() + " ajuns la minutul " + client.getTimeArrivedInInstitution()
								+ " este servit de ghiseul cu id-ul " + office.getOfficeId() + " a stat la coada "
								+ client.getTimeWaitingInQueue() + " minute si a terminat treaba in  "
								+ client.getTimeStayingInInstitution() + " minute de la intrarea in institutie!");
						clientsHistory.add(client);
						clientsQueue.remove(i);

					}
				}
			}
		}
	}
}
