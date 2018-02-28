
public class ATM
{
	/**
	 * ATM determines the max amount of cash withdraw
	 * ATM has bank and the max amount of cash withdraw value
	 */
	private Bank bank;
	private double maxCash;

	/**
	 * Contructor that takes inititive variables
	 * @param bank
	 * @param maxCash
	 */
	public ATM(Bank bank, double maxCash)
	{
		this.bank = bank;
		this.maxCash = maxCash;
	}

	/**
	 * Getter that return the bank
	 * @return bank
	 */
	public Bank getBank()
	{
		return bank;
	}

	/**
	 * the maximum amount of cash a customer can withdraw
	 * @return maxCash
	 */
	public double getMaxCash()
	{
		return maxCash;
	}
}
