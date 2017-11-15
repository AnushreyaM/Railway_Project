
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
	int current_firstclass_seats = 0;
	int current_secondclass_seats = 0;
	int max_firstclass_seats = 5;
	int max_secondclass_seats = 5;

	boolean check_firstclass_availability()
	{
		if(current_firstclass_seats < max_firstclass_seats)
			return true;
		return false;
	}

	boolean check_secondclass_availability()
	{
		if(current_secondclass_seats < max_secondclass_seats)
			return true;
		return false;
	}
}
