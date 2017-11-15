enum PassengerType
{
	INFANT, ADULT, SENIOR_CITIZEN;
}

class Passenger
{
	//ANANYA - You can have different types of passengers like adult, child .
	// You need to implement search in two ways
	
	//Search s = new BinarySearch();
	// or new LinearSearch();
	private String name;
	private PassengerType type;
 	private Ticket ticket; //change to list of ticketNumber

	public Passenger(String name, PassengerType type)
	{
		this.name = name;
		this.type = type;
	}

	public Passenger(String name, PassengerType type, Ticket ticket)
	{
		this(name, type);
		this.ticket = ticket;
	}

	public String getName()
	{
		return this.name;
	}

	public PassengerType getType()
	{
		return this.type;
	}

	public Ticket getTicket()
	{
		return this.ticket;
	}

	public void setTicket(Ticket ticket)
	{
		this.ticket = ticket;
	}

}

interface Search
{
	public int search(Passenger[] list, int ticketNumber);
}

class LinearSearch implements Search
{
	public int search(Passenger[] list, int ticketNumber)
	{
		int index = -1;
		for(int i = 0; i < list.length && index == -1; ++i)
		{
			if(list[i].getTicket().getTicketNumber() == ticketNumber)
			{
				index = i;
			}
		}
		return index;
	}
}

class BinarySearch implements Search
{
	public int search(Passenger[] list, int ticketNumber)
	{
		int index = -1;
		int l = 0;
		int r = list.length - 1;

		while(l <= r && index == -1)
		{
			int m = (l + r) / 2;
			int t = list[m].getTicket().getTicketNumber();
			if(t == ticketNumber)
			{
				index = m;
			}
			else
			{
				if(t < ticketNumber)
				{
					l = m + 1;
				}
				else
				{
					r = m - 1;
				}
			}
		}

		return index;
	}
}