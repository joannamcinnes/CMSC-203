/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The SavingsAccount class extends BankAccount to include features specific to savings accounts, 
 * such as a 2.5% annual interest rate and a 'savingsNumber' to differentiate accounts. The constructor initializes
 * the account with a name and initial balance, modifying the account number by appending '-0'. It includes a 'postInterest'
 * method for monthly interest deposits and overrides the 'getAccountNumber' method. A copy constructor allows the creation 
 * of additional savings accounts with unique numbers, ensuring accurate interest calculation and account identification.
 * Due: 08/6/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

public class SavingsAccount extends BankAccount {
	
	// Instance variables
	private double rate = 0.025; // 2.5% annual interest rate
	private int savingsNumber = 0; // Initialized to 0
	private String accountNumber; // This hides the accountNumber from the superclass

	// Constructor that takes a name and an initial balance
	public SavingsAccount(String name, double initialBalance) {
		
		// Call the superclass constructor
		super(name, initialBalance);
		
		// Initialize accountNumber
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
	}

	// Method to post interest
	public void postInterest() {
		
		// Computing the interest for one month
		double monthlyInterest = (getBalance() * this.rate) / 12;
		
		// Deposit the interest
		deposit(monthlyInterest);
	}

	// Override the getAccountNumber method
	@Override
	public String getAccountNumber() {
		return this.accountNumber;
	}

	// Copy constructor that creates another savings account for the same person
	public SavingsAccount(SavingsAccount original, double initialBalance) {
		
		// Call the superclass copy constructor
		super(original, initialBalance);
		
		// Increment the savingsNumber
		this.savingsNumber = original.savingsNumber + 1;
		
		// Initialize the accountNumber
		this.accountNumber = super.getAccountNumber() + "-" + this.savingsNumber;
	}
}
