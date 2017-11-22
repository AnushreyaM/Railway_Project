import java.util.*;

class addFood extends Ticket
{
	public Ticket t;

}

class addFoodFirst extends addFood
{
	public addFoodFirst()
	{
		System.out.println("Choose one of these");
		System.out.println("1. Vegetarian");
		System.out.println("2. Non vegetarian");
		int ch;
		Scanner sc = new Scanner(System.in);

		ch = sc.nextInt();
		do
		{
			switch(ch)
			{
				case 1:
					price = 3500;
					break;
				case 2:
					price = 4000;
					break;
				default:
					System.out.println("Please select a valid option");
			}
		}while(ch!=1 && ch!=2);


	}


}