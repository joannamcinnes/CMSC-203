/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The Procedure class holds information about a medical procedure, including its name, date, the practitioner's name, 
 * and the charges for the procedure. This class organizes medical procedure data, making it easier to store and access this information as well as display it.
 * This program should take in the procedure's name and date as well as the name of the practitioner of the procedure.
 * Due: 07/01/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import java.util.Scanner;

public class Procedure {
	Scanner stringScanner = new Scanner(System.in);
	// Procedure attributes
	private String procedureName;
	private String procedureDate;
	private String practitionerName;
	private double procedureCharges;
	// No-arg constructor
	public Procedure() {
	}
	// Parameterized constructor for procedure's name and date
	public Procedure(String procedureNameInput, String procedureDateInput) {
		this.procedureName = procedureNameInput;
		this.procedureDate = procedureDateInput;
	}
	// Parameterized constructor for all attributes
	public Procedure(String procedureNameInput, String procedureDateInput, String practitionerNameInput, 
			double procedureChargesInput) {
		this.procedureName = procedureNameInput;
		this.procedureDate = procedureDateInput;
		this.practitionerName = practitionerNameInput;
		this.procedureCharges = procedureChargesInput;
	}
	// Accessors and mutators for each attribute
	public String getProcedureName() {
		return procedureName;
	}
	public void setProcedureName(String procedureNameInput) {
		this.procedureName = procedureNameInput;
	}
	public String getProcedureDate() {
		return procedureDate;
	}
	public void setProcedureDate(String procedureDateInput) {
		this.procedureDate = procedureDateInput;
	}
	public String getPractitionerName() {
		return practitionerName;
	}
	public void setPractitionerName(String practitionerNameInput) {
		this.practitionerName = practitionerNameInput;
	}
	public double getProcedureCharges() {
		return procedureCharges;
	}
	public void setProcedureCharges(double procedureChargesInput) {
		this.procedureCharges = procedureChargesInput;
	}
	// toString method that displays information
	public String toString() {
		return "Procedure Info:" + "\nProcedure Name" + procedureName + "\nProcedure Date: " 
				+ procedureDate + "\nPractitioner Name: " + practitionerName + "\nProcedure Charges: " + procedureCharges;
	}
}
