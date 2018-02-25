import java.util.Scanner;

public class ATMSystem
{
	public static void main(String[] args)
	{

		/**
		 * There are 4 instances of credit cards in total for this assignment
		 * Exp date, account number, password, balance
		 * The account balance is assumed to a specific number
		 */
		ATMCard card1= new ATMCard(11, 2021, 11, "gospartans", 750.1);
		ATMCard card2 = new ATMCard(05,2029, 12, "cs151", 2000);
		ATMCard card3= new ATMCard(01,2018, 111, "spring18", 1350.25);
		ATMCard card4= new ATMCard(04,2029, 112, "computer", 1105.5);

		/**
		 * Create an array list of ATMCard to easy modulate
		 */
		ATMCard[] cards = {card1, card2, card3, card4};  // to print out all the cards
		ATMCard[] cardsB1 = {card1, card2};						// cards belong to bank 1
		ATMCard[] cardsB2 = {card3, card4};				// cards belong to bank 2

		/**
		 *  Display all the cards and their info
		 */
		System.out.print("Here is all the cards and their information: \n");
		System.out.println("----------------------------------------------------------");
		for(int i = 0; i < 4; i++)
		{
			System.out.print("Card: " + (i+1) + "\t Expiration date: " + cards[i].getExpMo() + "/" + cards[i].getExpYr());
			System.out.print("\t account number: " + cards[i].getBankID());
			System.out.print("\t password: " +cards[i].getPassword());
			System.out.println("\t balance: " +cards[i].getBalance());
		}

		/**
		 * 2 instances of 2 banks
		 */
		Bank usbank = new Bank("US Bank", cardsB1);
		Bank citi = new Bank("Citi Bank", cardsB2);


		/**
		 * There are 4 instances for atm in total for 2 banks and
		 * each atm has its own bank and its max cash withdrawal
		 */

		ATM usAtmNum1 = new ATM(usbank, 2000);		// $2000 is max withdraw
		ATM usAtmNum2 = new ATM(usbank, 1500);		// $1500
		ATM citiAtmNum1 = new ATM(citi, 500);		// $500
		ATM citiAtmNum2 = new ATM(citi, 1000);		// $1000

		/**
		 * Create an array list for atm to easy modulate
		 */
		ATM[] atm = {usAtmNum1, usAtmNum2, citiAtmNum1, citiAtmNum2};

		/**
		 *  Display all the ATMs and their info
		 */
		System.out.print("Here is all the ATMs and their max cash withdrawal: \n");
		for(int i = 0; i < 4; i++)
			System.out.println("ATM number " + (i +1) + " from " + atm[i].getBank().getBankName() + "\t Max cash withdrawal: " + atm[i].getMaxCash());

		/**
		 *  Prompt user for their desired ATM
		 *  Create an instance temporary variable for the atmUsed
		 */
		Scanner input = new Scanner(System.in);
		System.out.println("----------------------------------------------------------");
		System.out.print("Enter your choice of ATM from 1 to 4: ");
		int atmNum = input.nextInt();
		ATM atmUsed = atm[atmNum -1];
		System.out.println(atmUsed.getBank().getBankName() + " is being used.");

		/**
		 *  Prompt user for their card
		 *  Create an instance temporary variable for atmcard used
		 */
		System.out.print("Enter your card by the account number: ");
		int acctNum = input.nextInt();
		ATMCard cardUsed = cards[0];  // Initialized variable
		for(int i = 0; i < 4; i++)
		{
			if(acctNum == cards[i].getBankID())
				cardUsed = cards[i];
		}

		/**
		 * Check for the validation date by using while loop. COmpare the expiration date with 02/2018
		 */
		while(cardUsed.getExpYr() <= 2018 && cardUsed.getExpMo() <= 2)
		{
			System.out.println("This card has expired and is returned to you.");
			System.out.print("Enter your card by the account number: ");
			acctNum = input.nextInt();
			for(int i = 0; i < 4; i++)
			{
				if(acctNum == cards[i].getBankID())
					cardUsed = cards[i];
			}
		}

		/**
		 *  Check the card with the right atm by using a while loop
		 *  if the bank account is the same as the bank account from the bank
		 *  Check for the valid date again
		 */
		while(cardUsed.getBankID() != atmUsed.getBank().getCard()[0].getBankID()
				&& cardUsed.getBankID() != atmUsed.getBank().getCard()[1].getBankID())
		{
			System.out.println("The card is not supported by this ATM.");
			System.out.print("Enter your card by the account number: ");
			acctNum = input.nextInt();
			for(int j = 0; j < 4; j++)
			{
				if(acctNum == cards[j].getBankID())
					cardUsed = cards[j];
			}
			while(cardUsed.getExpYr() <= 2018 && cardUsed.getExpMo() <= 2)
					{
						System.out.println("This card has expired and is returned to you.");
						System.out.print("Enter your card by the account number: ");
						acctNum = input.nextInt();
						for(int i = 0; i < 4; i++)
						{
							if(acctNum == cards[i].getBankID())
								cardUsed = cards[i];
						}
		}
		}

		/**
		 * Perform a message for successful authorization
		 * Check for the password of the card by comparing the input of the user and the password of the card
		 */
		System.out.println("The card is accepted. Please enter your passsword.");
		input.nextLine();
		String pwd = input.nextLine();

		while(!(cardUsed.getPassword().equals(pwd)))
		{
			System.out.print("This passsword is wrong. Please re-enter: ");
			pwd = input.nextLine();
		}

		System.out.println("Authorization is accepted. Start your transaction by entering the amount to withdraw.");
		double amt = input.nextDouble();

		/**
		 * Prompt the user to enter the amount of cash withdrawal and
		 * make sure the cash is not over the limit
		 */
		while(atmUsed.getMaxCash() < amt && amt != 0)
		{
			System.out.println("The amount exceeds the maximum amount you can withdraw per transaction. Please enter the amount again or quit by entering 0");
			amt = input.nextDouble();
		}

		/**
		 * Show the balance after the cash withdrawal. The balance of the account should be lowered now
		 * Give the user an option to exit after the transaction
		 */
		while(amt != 0){
		System.out.print("\\$" + amt + " is withdrawn from your account. The remaining balance of this is $" );
		System.out.println((cardUsed.getBalance() - amt));
		cardUsed.setBalance(cardUsed.getBalance() - amt);
		System.out.println("If you have more transactions, enter the amount or quit by entering 0.");
		amt = input.nextDouble();}
	}
}
