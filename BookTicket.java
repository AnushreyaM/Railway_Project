import java.util.*;

class BookTicket
{
	public static Ticket bookTicket()
	{
		// show all trains - user selects a train object
		// show seat availability in the train for all classes
		// take type of ticket
		int classPreference;
		int paymentPreference;
		int[] availableSeats;

		Scanner scanner = new Scanner(System.in);
		Ticket ticket = null;
		PassengerTrain train = null;
		Railway railway = Railway.getInstance();
		
		railway.showTrains();
		System.out.print("Enter Train ID:\t");
		train = railway.getTrain(scanner.nextInt());
		availableSeats = train.getAvailableSeats();
		
		System.out.print("Seat availability for First (1), Second (2) and Economy (3) classes:\t");
		System.out.println(availableSeats[1] + ", " + availableSeats[2] + ", " + availableSeats[3]);
		System.out.print("Enter class preference (1/2/3):\t");
		classPreference = scanner.nextInt();

		switch(classPreference)
		{
			case 1: ticket = new FirstClass(); break;
			case 2: ticket = new SecondClass(); break;
			case 3: ticket = new EconomyClass(); break;
			default: System.out.println("Wrong class entered. Aborting.."); //use loop instead
		}

		ticket = Ticket.createTicket("Passenger Name Goes Here"); ////////////////////
		try
		{
			train.updatePassengerList(new Passenger("ABCD", PassengerType.INFANT)); ////////////////////
		}
		catch(Exception e)
		{
			System.out.println(e);
		}

		System.out.println("1. Card");
		System.out.println("2. Wallet");
		System.out.print("Enter payment preference:\t");
		paymentPreference = scanner.nextInt();
		Payment payment = null;
		switch(paymentPreference)
		{
			case 1: payment = new CardPayment(); break;
			case 2: payment = new WalletPayment(); break;
		}
		payment.acceptPayment(100);

		return ticket;
	}
}

class Registration extends BookTicket
{
	public static void login()
	{

	}
	public static void signup()
	{
		
	}
}