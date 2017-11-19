import java.util.*;
import java.io.*;
import java.sql.*;

class Railway
{

	private static Railway railway;
	public Train[] trains;// = new Train[3]; //size taken care of in RailwayMenu class
	
	public static Railway getInstance()
	{
		if(railway == null)
		{
			railway = new Railway();
		}
		return railway;
	}
	
	private Railway()
	{
	
	}
	
	public void showTrains()
	{
		for(Train t: trains)
		{
			t.display();
		}
	}
	
	public void bookTicket() throws Exception
	{
		
		Registration r = new Registration();
		Ticket t = r.bookTicket();
		t.display();
	}

	public void displayTicket(ResultSet result) throws Exception
	{
		if(result == null)
		{
			return;
		}
		result.next();
		
		int ticketNumber = result.getInt(1);
		int trainNumber = result.getInt(2);
		String passengerName = result.getString(3);

		String query = "SELECT * FROM train WHERE tno = " + trainNumber;
		ResultSet trainData = JavaSQL.executeSQL(query);
		trainData.next();
		String source = trainData.getString(1);
		String destination = trainData.getString(2);


		printStars();
		System.out.println("Ticket Number: " + ticketNumber);
		System.out.println("Passenger Name: " + passengerName);
		System.out.println("Train Number: " + trainNumber);
		System.out.println("Source: " + source);
		System.out.println("Destination: " + destination);
		printStars();
	}
	
	public void showTicket() throws Exception
	{
		if(RailwayMenu.currentPassenger != null)
		{
			RailwayMenu.currentPassenger.getTicket().display();
		}
		else
		{
			Scanner scanner = new Scanner(System.in);
			String username;
			String password;
			String query;
			ResultSet result;
			int ticketNumber;

			System.out.println("Enter username: ");
			username = scanner.next();
			System.out.println("Enter password: ");
			password = scanner.next();

			query = "SELECT * FROM users WHERE uname = \'" + username + "\' AND psswd = \'" + password + "\'";
			result = JavaSQL.executeSQL(query);
			if(result != null && result.next())
			{
				System.out.println("Access granted.");
				query = "SELECT * FROM passenger WHERE pid = \'" + username + "\'";
				result = JavaSQL.executeSQL(query);
				if(result != null && result.next())
				{
					ticketNumber = result.getInt(3);
					query = "SELECT * FROM ticket WHERE tid = " + ticketNumber;
					result = JavaSQL.executeSQL(query);
					displayTicket(result);
					System.out.println("-------");
				}
				else
				{
					System.out.println("You have not booked any tickets.");
				}
			}
			else
			{
				System.out.println("Error: Invalid Credentials / User does not exist");
			}
		}
	}

	public void printStars()
	{
		for(int i = 0; i < 40; ++i)
		{
			System.out.print("**");
		}
		System.out.println();
	}

	public void getPassengerDetails(int trainNumber, int ticketNumber)
	{

	}
	
	public PassengerTrain getTrain(int trainNumber)
	{
		for (int i = 0; i < 3; i++)
		{
			if ( trains[i].tno == trainNumber )
				return (PassengerTrain)trains[i];
		}
		return null;
	}
}