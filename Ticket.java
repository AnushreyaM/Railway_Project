class Ticket
{
	//Aakansha: you can implement different types of tickets, like first class second class, you can choose attributes
	
	// refer to https://books.google.co.in/books?id=A5eZa7R17ZwC&pg=PT254&lpg=PT254&dq=attributes+for+train+oo&source=bl&ots=vhK4BsK6Ge&sig=l5jaUcMGKMa0mg7Q8Jee0pJjKAc&hl=en&sa=X&ved=0ahUKEwj6gKi0lbjXAhUKLY8KHYd1CDMQ6AEISTAH#v=onepage&q=attributes%20for%20train%20oo&f=false  
	
	// Pg. 235 of this link

	private Train train;
	private int ticketNumber;
	private static int ticketCount = 0; //use this to assign ticket numbers

	public int getTicketNumber()
	{
		return this.ticketNumber;
	}
}
