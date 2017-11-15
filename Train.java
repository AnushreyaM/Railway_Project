class SeatsNotAvailableException extends Exception
{
    public SeatsNotAvailableException(String s)
    {
        super(s);
    }
}

class MaxSeats
{
	public static final int NUMOFCLASSES = 3;
	public static final int FIRSTCLASS = 1;
	public static final int SECONDCLASS = 2;
	public static final int ECONOMYCLASS = 2;
	public static final int TOTAL = 5;
}

class Train
{
	public String source;
	public String destination;
	public int tno;

	public Train(String source, String destination, int tno)
	{
		this.source = source;
		this.destination = destination;
		this.tno = tno;
	}

	public void display()
	{
		System.out.println("Train no: " + tno);
		System.out.println("Train source: " + source);
		System.out.println("Train destination: " + destination);
		System.out.println();
	}	
}

class PassengerTrain extends Train
{
	int num_People = 0; // = total # seats taken
	int[] seatsTaken = new int[4];
    public Passenger[] passengerList;
	
	public PassengerTrain(String source, String destination, int tno)
	{
		super(source, destination, tno);
		for(int i = 0; i <= MaxSeats.NUMOFCLASSES; ++i)
		{
			seatsTaken[i] = 0;
		}
	}

    int[] getAvailableSeats()
    {
    	int[] seats = new int[4];
    	seats[1] = MaxSeats.FIRSTCLASS - seatsTaken[1];
    	seats[2] = MaxSeats.SECONDCLASS - seatsTaken[2];
    	seats[3] = MaxSeats.ECONOMYCLASS - seatsTaken[3];
    	return seats;
    }
   
   void updatePassengerList(Passenger p) throws SeatsNotAvailableException
   {
        try
        {
            if(num_People + 1 > MaxSeats.TOTAL)
                throw new SeatsNotAvailableException("Train full: Seats not available");
            passengerList[num_People + 1] = p;
            num_People++;
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
   }
   
}