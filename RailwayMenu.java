import java.util.*;
import java.sql.*;

class RailwayMenu
{
	public static Passenger currentPassenger;
	public static void main(String[] args) throws Exception
	{
		/***************************************************
		**                    Singleton                   **
		****************************************************/
		Railway railway = Railway.getInstance();  
		ResultSet rs = JavaSQL.executeSQL("select * from train");  
		int i = 0;
		while(rs!=null && rs.next()) 
		{ 
				/***************************************************
				**                      Liskov                    **
				****************************************************/
			railway.trains[i++] = new PassengerTrain(rs.getString(1), rs.getString(2), rs.getInt(6));
		}

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