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
	String name;
	private Train train;
	private int ticketNumber;
	private static int ticketCount = 0; //use this to assign ticket numbers

	public int getTicketNumber()
	{
		return this.ticketNumber;
	}
	Ticket(int price, String passengerName) {
		this.price = price;
		this.name = passengerName;
	}
}


class BaseTicket 
{
	Ticket t;
	public Ticket createTicket(String passengerName)
	{
		t = new Ticket(1000, passengerName);
		System.out.println("called base class");
		return t;
	}
}

class FirstClass extends BaseTicket
{
	Ticket t;
	public Ticket createTicket(String passengerName)
	{
		t = new Ticket(3000, passengerName);
		System.out.println("called firstclass");
		return t;
	}
}

class SecondClass extends BaseTicket
{
	Ticket t;
	public Ticket createTicket(String passengerName)
	{
		t = new Ticket(2000, passengerName);
		System.out.println("called secondclass");
		return t;
	}
	
}

class EconomyClass extends BaseTicket
{
	Ticket t;
	public Ticket createTicket(String passengerName)
	{
		t = new Ticket(500, passengerName);
		System.out.println("called economyclass");
		return t;
	}
}


class TicketCreator 
{
	Ticket ticket;
	BaseTicket ticketType;
	public Ticket createTicketOnClass(String className, String passengerName){
		if(className.equalsIgnoreCase("First")) {
			ticketType = new FirstClass();
			
		}
		else if(className.equalsIgnoreCase("Second")) {
			ticketType = new SecondClass();
			ticket = ticketType.createTicket(passengerName);

		}
		else if(className.equalsIgnoreCase("Eco")) {
			ticketType = new EconomyClass();
			ticket = ticketType.createTicket(passengerName);

		}else {
			ticketType = new BaseTicket();
			ticket = ticketType.createTicket(passengerName);

		}
		return ticket;
	
	}
	
}



