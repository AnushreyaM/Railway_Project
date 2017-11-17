import java.util.*;

class RailwayMenu
{
	//private static Passenger currentPassenger;
	public static void main(String[] args)
	{
		/***************************************************
		**                    Singleton                   **
		****************************************************/
		Railway railway = Railway.getInstance();

		/***************************************************
		**                      Liskov                    **
		****************************************************/
		Train t1 = new PassengerTrain("A", "B", 1); ///////////move this part to Railway.java
												///////read this info from a file (database)
		
		Train t2 = new PassengerTrain("C", "D", 2);
		
		Train t3 = new PassengerTrain("E", "F", 3);
		
		railway.trains[0] = t1;
		railway.trains[1] = t2;
		railway.trains[2] = t3;
		int ch;

		do
		{
		
			System.out.println("Enter your choice: ");
			System.out.println("1. See all trains");
			System.out.println("2. Book a ticket");
			System.out.println("3. Show ticket");
			System.out.println("9. Quit");

			Scanner sc = new Scanner(System.in);
			ch = sc.nextInt();
			
			
			switch( ch )
			{
				case 1:
					railway.showTrains();
					break;
				case 2:
					railway.bookTicket();
					break;
				case 3:
					railway.showTicket();
					break;
				case 4:
					System.out.println("Enter train number and ticket number:\t");
					railway.getPassengerDetails(sc.nextInt(), sc.nextInt());
					break;
			}
		
		}while(ch != 9);
	}

}