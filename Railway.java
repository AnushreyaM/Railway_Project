import java.util.*;
import java.io.*;

class Railway
{

	private static Railway railway;
	public Train[] trains;// = new Train[3]; //size taken care of in RailwayMenu class
	
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
	
	public void bookTicket() throws Exception
	{
		
		Registration r = new Registration();
		Ticket t = r.bookTicket();
		t.display();
	}
	
	public void showTicket() // this should be present in passenger class
	{
		RailwayMenu.currentPassenger.getTicket().display();
	}

	public void getPassengerDetails(int trainNumber, int ticketNumber)
	{

	}
	
	public PassengerTrain getTrain(int trainNumber)
	{
		for (int i = 0; i < 3; i++)
		{
			if ( trains[i].tno == trainNumber )
				return (PassengerTrain)trains[i];
		}
		return null;
	}
}