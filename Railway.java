class Railway
{

	private static Railway railway;
	public Train[] trains = new Train[3];
	
	public static Railway getInstance()
	{
		if(railway == null)
		{
			railway = new Railway();
		}
		return railway;
	}
	
	private Railway()
	{
	
	}
	
	public void showTrains()
	{
		for(Train t: trains)
		{
			t.display();
		}
	}
	
	public void bookTicket()
	{
	
	}
	
	public void showTicket()
	{
	
	}

	public void getPassengerDetails(int trainNumber, int ticketNumber)
	{

	}
	
}

