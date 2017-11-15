import java.util.*;

/*class Payment
{
	int amount;
	Passenger passenger;
	
	public static void gateway()
	{

		Scanner scanner = new Scanner();
		int choice;

		System.out.println("Select Payment Method");
		System.out.println("1. Card");
		System.out.println("2. Wallet");
		System.out.print("Enter your choice (1/2):\t");

		choice = scanner.nextInt();

		switch(choice)
		{
			case 1: acceptcardPayment(); break;
			case 2: accept
		}
	}
}*/

interface Payment
{
	public void acceptPayment(int amount);
	public void displayDetails();
}

class CardPayment implements Payment
{
	private int cardNumber;
	private String nameOnCard;
	private int amount;
	private static Scanner scanner = new Scanner(System.in);

	public void acceptPayment(int amount)
	{
		this.amount = amount;
		System.out.println("\t\tProcessing Payment for INR" + amount);
		System.out.println("\nEnter card number:");
		cardNumber = scanner.nextInt();
		System.out.println("\nEnter name on card:");
		nameOnCard = scanner.next();
		System.out.println("\n\n\t\tPayment accepted.");
	}

	public void displayDetails()
	{
		System.out.println("Payee Name: " + nameOnCard);
		System.out.println("Card number: " + cardNumber);
		System.out.println("Amount: " + amount);
	}
}

class WalletPayment implements Payment
{
	private String walletName;
	private int payeePhoneNumber;
	private int amount;
	private static Scanner scanner = new Scanner(System.in);

	public void acceptPayment(int amount)
	{
		this.amount = amount;
		System.out.println("\t\tProcessing Payment for INR" + amount);
		System.out.println("\nEnter wallet name:");
		walletName = scanner.next();
		System.out.println("\nEnter phone number:");
		payeePhoneNumber = scanner.nextInt();
		System.out.println("\n\n\t\tPayment accepted.");
	}

	public void displayDetails()
	{
		System.out.println("Payee Phone Number: " + payeePhoneNumber);
		System.out.println("Wallet Name: " + walletName);
		System.out.println("Amount: " + amount);
	}
}