
class Train
{
	public String source;
	public String destination;
	public int tno;
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

class SeatsNotAvailableException extends Exception
{
    public SeatsNotAvailableException(String s)
    {
        super(s);
    }
}

class PassengerTrain extends Train
{
	int num_People = 0;
	int firstclass_seats;
	int secondclass_seats;
	int ecoclass_seats;
	int current_firstclass_seats = 0;
	int current_secondclass_seats = 0;
	int current_ecoclass_seats = 0;
	int max_firstclass_seats = 1;
	int max_secondclass_seats = 2;
	int max_ecoclass_seats = 2;
	int max_seats = 5
    public Passenger[] passengerList; //added by Ananya
	
    
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
	boolean check_ecoclass_availability()
	{
		if(current_ecoclass_seats < max_ecoclass_seats)
			return true;
		return false;
	}
    boolean check_availability()
    {
        return ((check_firstclass_availability() || check_secondclass_availability()) || (check_secondclass_availability() || check_ecoclass_availability()));
    }
   
   
   void addPassenger(Passenger p) throws SeatsNotAvailableException
   {
        try
        {
            if(num_People + 1 > max_seats)
                throw new SeatsNotAvailableException("Train full: Seats not available");
            passengerList[num_People + 1] = p;
            num_People++;
        }
   }
   
}
