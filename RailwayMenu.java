import java.util.*;
import java.sql.*;

class RailwayMenu
{
	public static Passenger currentPassenger = null;
	public static String currentUsername = null;

	public static void main(String[] args) throws Exception
	{
		int i = 0;
		int ch;
		int rows;

		/***************************************************
		**                    Singleton                   **
		****************************************************/
		Railway railway = Railway.getInstance();  
		ResultSet rs = JavaSQL.executeSQL("SELECT * FROM train");  

		while(rs!=null && rs.next()) 
		{ 
			if(i == 0)
			{
				rs.last();
				rows = rs.getRow();
				rs.first();
				railway.trains = new Train[rows];
			}

			/***************************************************
			**                      Liskov                    **
			****************************************************/
			railway.trains[i++] = new PassengerTrain(rs.getString(1), rs.getString(2), rs.getInt(6));
		}
		do
		{
			displaySeparator();		
			System.out.println("-----Menu-----");
			System.out.println("1. See all trains");
			System.out.println("2. Book a ticket");
			System.out.println("3. Show ticket");
			System.out.println("9. Quit");
			displaySeparator();
			System.out.println("Enter your choice: ");

			Scanner sc = new Scanner(System.in);
			ch = sc.nextInt();
			displaySeparator();
			System.out.println("\n\n\n");
			
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

	public static void displaySeparator()
	{
		for(int i = 0; i < 100; ++i)
		{
			System.out.print("-");
		}
		System.out.println();
	}

}