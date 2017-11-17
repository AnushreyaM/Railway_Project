import java.util.*;

class BookTicket
{
	public Ticket ticket = null;

	public Ticket bookTicket()
	{
		// show all trains - user selects a train object
		// show seat availability in the train for all classes
		// take type of ticket
		int classPreference;
		int paymentPreference;
		int[] availableSeats;

		Scanner scanner = new Scanner(System.in);
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

		Passenger passenger; 
		String pname;
		System.out.print("Enter passenger name: ");
		pname = scanner.next();

		ticket = Ticket.createTicket(train, pname); ////////////////////
		System.out.println(train + " " + ticket);

		passenger = new Passenger(pname, PassengerType.INFANT);
		RailwayMenu.currentPassenger = passenger;
		try
		{
			train.updatePassengerList(passenger); ////////////////////
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
		if(payment.acceptPayment(100))
			passenger.setTicket(ticket); // need to register the fact that passenger has ticket
		return ticket;
	}
}

class Registration extends BookTicket
{
	BookTicket bookTicket_obj;
	
	public Ticket bookTicket()
	{
		bookTicket_obj = new BookTicket();
		String username = "abc";
		String psswd = "abc";
		ticket = null;
		System.out.println("Do you want to 1. sign up? or 2. log in?");
		Scanner sc = new Scanner(System.in);
		int choice ;
		choice = sc.nextInt();

		switch(choice)
		{
			case 1:
			break;
			case 2:
				String u = sc.next();
				String p = sc.next();
				System.out.println(u+ " "+ username + " " + p + " " + psswd);
				if (u.equals(username) && p.equals(psswd))
				{
					System.out.println("Access Granted");
					ticket = bookTicket_obj.bookTicket();
					ticket.display();
				}
			break;
		}
		return ticket;
	}


}