

public class Client {
	private String billOrder;
	private int clientId;
	private int arrivingTime;
	private int waitInQueueTime;
	private int timeLeftTheOffice;

	public Client(String billOrder, int id, int arrivingTime) {
		this.arrivingTime = arrivingTime;
		this.clientId = id;
		this.billOrder = billOrder;
	}

	public void setTimeWhenClientLeaveQueue(int timeArrivedAtOffice) {
		this.waitInQueueTime = timeArrivedAtOffice;
	}

	public void show() {
		System.out.println("For client with id " + clientId + " which arrived at " + arrivingTime + " request services " + billOrder);
		
	}

	public boolean hasSameService(String service) {
		if(billOrder.equalsIgnoreCase(service)) {
			return true;
		}
		return false;
	}

	public void setTimeWhenClientLeave(int i) {
		this.timeLeftTheOffice = i;
		
	}
	
	public int getTimeWaitingInQueue() {
		return waitInQueueTime - arrivingTime;
	}
	
	public int getTimeStayingInInstitution() {
		return timeLeftTheOffice - arrivingTime;
	}
	
	public int getTimeArrivedInInstitution() {
		return arrivingTime;
	}
	
	public int getClientId() {
		return clientId;
	}

	public String getOffice() {
		
		return billOrder;
	}

}
