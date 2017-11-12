import java.util.*;

class RailwayMenu
{

	public static void main(String[] args)
	{
		Railway railway = Railway.getInstance(); //Singleton done

		Train t1 = new PassengerTrain();
		t1.populate("Bangalore", "Kharagpur", 1);
		
		Train t2 = new PassengerTrain(); //Liskov done - wherever a superclass object can be used a subclass object can replace it
		t2.populate("Yeshwanthpur", "Vishakapatnam", 2);
		
		Train t3 = new PassengerTrain();
		t3.populate("Sangolli Rayana", "Howrah", 3);
		
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
			System.out.println("4. Quit");

			Scanner sc = new Scanner(System.in);
			ch = sc.nextInt();
			
			
			switch( ch )
			{
				case 1:
					railway.showTrains();
					break;
				case 2:
					railway.bookTicket();;
					break;
				case 3:
					railway.showTicket();
					break;
				
			}
		
		}while(ch != 4);
	}

}














