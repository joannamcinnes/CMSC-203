/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The CheckingAccount class extends BankAccount. This class uses a 
 * static constant 'FEE' set to 0.15, which is the cost of clearing a check. 
 * The constructor accepts a 'name' and an 'initial amount,' calls the superclass 
 * constructor, and modifies the'account number' to include the suffix '-10'.
 * The withdraw method is overridden to add the check clearing fee to include the
 * withdrawal amount before calling the superclass's 'withdraw' method and returning its result.
 * Due: 08/6/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

public class CheckingAccount extends BankAccount {
	
	// Static constant for the fee
	private static final double FEE = 0.15;

	// Constructor that takes a name and an initial amount
	public CheckingAccount(String name, double initialAmount) {
		
		// Call the superclass constructor
		super(name, initialAmount);
		
		// Modify the accountNumber
		setAccountNumber(getAccountNumber() + "-10");
	}

	// Overriding the withdraw method
	@Override
	public boolean withdraw(double amount) {
		
		// Adding the fee to the withdrawal amount
		amount += FEE;
		
		// Call the withdraw method from the superclass
		return super.withdraw(amount);
	}
}