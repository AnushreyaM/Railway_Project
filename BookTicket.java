import java.util.*;
import java.sql.*;

class BookTicket
{
	public Ticket ticket = null;
	public static int pno = 0;
	public Ticket bookTicket() throws Exception
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
		
		int chk;
				
		switch(classPreference)
		{
			case 1: 
				ResultSet rl1 = JavaSQL.executeSQL("SELECT cur_first_class from train");
				rl1.next();
				chk = rl1.getInt(1);
				if(chk > 0)	
				{
					ticket = new FirstClass();
					String trainQuery1 = "UPDATE train SET cur_first_class = cur_first_class - 1 WHERE tno="+train.tno;
					JavaSQL.executeSQLUpdate(trainQuery1);					 
				}
				else
					System.out.println("No seats available in this class!");
				break;
		
			case 2: ResultSet rl2 = JavaSQL.executeSQL("SELECT cur_second_class from train");
				rl2.next();
				chk = rl2.getInt(1);
				if(chk > 0)	
				{
					ticket = new SecondClass();
					String trainQuery2 = "UPDATE train SET cur_second_class = cur_first_class - 1 WHERE tno="+train.tno;
					JavaSQL.executeSQLUpdate(trainQuery2); 
				}
				else
					System.out.println("No seats available in this class!");
				break;
		
			case 3: ResultSet rl3 = JavaSQL.executeSQL("SELECT cur_economy_class from train");
				rl3.next();
				chk = rl3.getInt(1);
				if(chk > 0)	
				{
					ticket = new EconomyClass();
					String trainQuery3 = "UPDATE train SET cur_economy_class = cur_first_class - 1 WHERE  tno="+train.tno;				
					JavaSQL.executeSQLUpdate(trainQuery3); 
				}
				else
					System.out.println("No seats available in this class!");
				
				break;
		
			default: System.out.println("Wrong class entered. Aborting.."); //use loop instead
		}

		Passenger passenger; 
		String pname;
		System.out.print("Enter passenger name: ");
		pname = scanner.next();

		
		
		

		ticket = Ticket.createTicket(train, pname); ////////////////////
		String ticketQuery = "INSERT INTO ticket(trainNo, pname) VALUES("+train.tno+", \""+pname+"\""+")";
		JavaSQL.executeSQLUpdate(ticketQuery);
		ticketQuery = "SELECT MAX(tid) FROM ticket";
		ResultSet resultSet = JavaSQL.executeSQL(ticketQuery);
		int ticketNumber = -1;
		if(resultSet != null)
		{
			resultSet.next();
			ticketNumber = resultSet.getInt(1);
		}

		ticket.setTicketNumber(ticketNumber);

		passenger = new Passenger(pname, PassengerType.INFANT);
		RailwayMenu.currentPassenger = passenger;
		RailwayMenu.currentPassenger.setTicket(ticket);
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
		if(payment.acceptPayment(ticket.price))
			passenger.setTicket(ticket); // need to register the fact that passenger has ticket

		System.out.println("Train number "+train.tno);
		/*String passengerQuery = "INSERT INTO passenger " + "VALUES("+pno+", \""+pname+
			"\","+ticketNumber+","+train.tno+")"; //SCHEMA CHANGED NOE
			*/
		String passengerQuery = "INSERT INTO passenger VALUES(\'" + RailwayMenu.currentUsername + "\', \'"
								+ pname + "\', " + ticketNumber + ")";
		System.out.println("====>" + passengerQuery);

		JavaSQL.executeSQLUpdate(passengerQuery);
		pno++;  // new passenger id
		return ticket;
	}
}

class Registration extends BookTicket
{
	BookTicket bookTicket_obj;
	String uname;
	String psswd;
	public Ticket bookTicket() throws Exception
	{
		bookTicket_obj = new BookTicket();
		
		String psswd = "abc";
		ticket = null;
		System.out.println("Do you want to 1. sign up? or 2. log in?");
		Scanner sc = new Scanner(System.in);
		int choice ;
		choice = sc.nextInt();

		switch(choice)
		{
			case 1:
				System.out.print("Enter a username:\t");
				uname = sc.next();
				System.out.print("Enter password:\t");
				psswd = sc.next();
				//RailwayMenu.currentUsername = uname;
				JavaSQL.executeSQLUpdate("INSERT INTO users VALUES(\""+uname+"\",\""+psswd+"\")");
				choice = 2; //unnecessary?
			case 2:
				boolean loginPending = true;

				do
				{
					System.out.println("Enter credentials for logging in");
					System.out.print("Enter a username:\t");
					String u = sc.next();
					RailwayMenu.currentUsername = u;
					System.out.print("Enter password:\t");
					String p = sc.next();

					ResultSet rs = JavaSQL.executeSQL("Select * from users where uname = \"" +u+ "\""+
						"and psswd =\""+p+"\"");
					if(rs.next())
						loginPending = false;
					else
					{
						System.out.println("Invalid credentials. Try again.");
					}
				}while(loginPending);
				
					System.out.println("Access Granted");
					System.out.println("Press 1 to go back to menu");
					char ch1 = sc.next().charAt(0);
					System.out.print("\033[2J\033[1;1H");
					ticket = bookTicket_obj.bookTicket();
					ticket.display();
				
			break;
		}
		return ticket;
	}


}
