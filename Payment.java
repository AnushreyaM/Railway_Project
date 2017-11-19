import java.util.*;

interface Payment
{
	public boolean acceptPayment(int amount); // changed return type to boolean, need to see if accepted or not
	public void displayDetails();
}

class CardPayment implements Payment
{
	private int cardNumber;
	private String nameOnCard;
	private int amount;
	private static Scanner scanner = new Scanner(System.in);

	public boolean acceptPayment(int amount)
	{
		this.amount = amount;
		System.out.println("\t\tProcessing Payment for INR" + amount);
		System.out.println("\nEnter card number:");
		cardNumber = scanner.nextInt();
		System.out.println("\nEnter name on card:");
		nameOnCard = scanner.next();
		System.out.println("\n\n\t\tPayment accepted.");
		return true;
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

	public boolean acceptPayment(int amount)
	{
		this.amount = amount;
		System.out.println("\t\tProcessing Payment for INR" + amount);
		System.out.println("\nEnter wallet name:");
		walletName = scanner.next();
		System.out.println("\nEnter phone number:");
		payeePhoneNumber = scanner.nextInt();
		System.out.println("\n\n\t\tPayment accepted.");
		return true;
	}

	public void displayDetails()
	{
		System.out.println("Payee Phone Number: " + payeePhoneNumber);
		System.out.println("Wallet Name: " + walletName);
		System.out.println("Amount: " + amount);
	}
}