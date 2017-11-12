
class Train
{
	public String source;
	public String destination;
	public int tno;
	public Passenger[] passengerList; //added by Ananya
	
	public void display()
	{
		System.out.println("Train no: "+tno+" Train source: "+source+" Train destination: "+destination);
		System.out.println();
	}
	
	public void populate( String source, String destination, int tno)
	{
		this.source = source;
		this.destination = destination;
		this.tno = tno;
	}
	
}

class PassengerTrain extends Train
{
	int num_People;
	int firstclass_seats;
	int secondclass_seats;
	
	// ANJALI - write a populate function here which populates all attributes of train and passenger train
	
}
