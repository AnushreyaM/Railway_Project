import java.util.*;
import java.lang.*;
import java.io.*;
/*
class OOMD
{
	public static void main (String[] args) 
	{
		
		String passengerName = "Abc";
		
		TicketCreator tc = new TicketCreator();
		Ticket t = tc.createTicketOnClass("Eco", passengerName);
		System.out.println("Ticket name:" +t.name);
		System.out.println("Ticket price:" +t.price);
	}
}
*/

class Ticket 
{
	int price;
	String name; //passengername
	private Train train;
	private int ticketNumber;
	private static int ticketCount = 0; //use this to assign ticket numbers

	public int getTicketNumber()
	{
		return this.ticketNumber;
	}

	protected Ticket()
	{

	}
	protected Ticket(int price, String passengerName, Train train)
	{
		this.price = price;
		this.name = passengerName;
		this.train = train;
	}
	
	public static Ticket createTicket(Train t, String passengerName) //useless
	{
		/*t = new Ticket(1000, passengerName);
		System.out.println("called base class");
		return t;*/
		return new Ticket(1000, passengerName, t);
	}

	public void display()
	{ 
		System.out.println("----------------Ticket-------------");
		System.out.println("Ticket Price: "+price);
		System.out.println("Ticket Number: "+ ticketNumber);
		System.out.println("Source: "+train.source);
		System.out.println("Destination: "+train.destination);

	}
	
}


class FirstClass extends Ticket
{
	//Ticket t; //not needed, FirstClass already extends Ticket
	

	public static Ticket createTicket(Train t, String passengerName)
	{

		return new Ticket(3000, passengerName, t);
		//System.out.println("called firstclass");
		//return t;
	}
}

class SecondClass extends Ticket
{
	//Ticket t;
	

	public static Ticket createTicket(Train t, String passengerName)
	{
		return new Ticket(2000, passengerName, t);
		//System.out.println("called secondclass");
		//return t;
	}
	
}

class EconomyClass extends Ticket
{
	//Ticket t;
	
	public static Ticket createTicket(Train t, String passengerName)
	{
		return new Ticket(500, passengerName, t);
		//System.out.println("called economyclass");
		//return t;
	}
}

/*
class TicketCreator 
{
	Ticket ticket;
	Ticket ticketType;
	public Ticket createTicketOnClass(String className, String passengerName){
		if(className.equalsIgnoreCase("First"))
		{
			ticketType = new FirstClass();	
		}
		else if(className.equalsIgnoreCase("Second"))
		{
			ticketType = new SecondClass();
			ticket = ticketType.createTicket(passengerName);
		}
		else if(className.equalsIgnoreCase("Eco"))
		{
			ticketType = new EconomyClass();
			ticket = ticketType.createTicket(passengerName);
		}
		else
		{
			ticketType = new Ticket();
			ticket = ticketType.createTicket(passengerName);
		}
		return ticket;
	
	}
	
}
*/