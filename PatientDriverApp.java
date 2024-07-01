/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The PatientDriverApp class manages patient and medical procedure data. 
 * It uses methods to display patient and procedure information as well as calculate the total charges of the procedures.
 * Due: 07/01/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

public class PatientDriverApp {

	// displayPatient method
	public static void displayPatient(Patient patient) {
		System.out.println("Patient Info:");
		System.out.println("Name: " + patient.buildFullName());
		System.out.println("Address: " + patient.buildAddress());
		System.out.println("Phone Number: " + patient.getPhoneNumber());
		System.out.println("Emergency Contact: " + patient.buildEmergencyContact());
		//System.out.println(); 
	}

	// displayProcedure method
	public static void displayProcedure(Procedure procedure) {
		System.out.println("\n\tProcedure: " + procedure.getProcedureName());
		System.out.println("\tProcedure Date: " + procedure.getProcedureDate());
		System.out.println("\tPractitioner: " + procedure.getPractitionerName());
		System.out.println("\tCharge: " + procedure.getProcedureCharges());
	}
	// calculateTotalCharges method
	// ** The total charges of the three procedures displayed in comma separated with two decimal points!
	public static double calculateTotalCharges(Procedure procedure1, Procedure procedure2, Procedure procedure3) {
		return procedure1.getProcedureCharges() + procedure2.getProcedureCharges() + procedure3.getProcedureCharges();
	}
	// Creating a sample patient and sample procedures
	public static void main(String[] args) {
		Patient patient = new Patient("Jenny", "Elaine", "Santori", "123 Main Street", "MyTown", "CA", "01234", 
				"000-000-0000", "Bill Santori", "777-555-1212");
		// Three sample procedures
		Procedure procedure1 = new Procedure();
		procedure1.setProcedureName("Physical Exam");
		procedure1.setProcedureDate("7/20/2019");
		procedure1.setPractitionerName("Dr. Irvine");
		procedure1.setProcedureCharges(3250.0); 
		Procedure procedure2 = new Procedure("X-Ray", "7/20/2019");
		procedure2.setPractitionerName("Dr. Jamison");
		procedure2.setProcedureCharges(5500.43);
		Procedure procedure3 = new Procedure("Blood Test", "7/20/2019", "Dr. Smith", 1400.75);
		// Display patient's information
		displayPatient(patient);
		// Display information about all three procedures
		displayProcedure(procedure1);
		displayProcedure(procedure2);
		displayProcedure(procedure3);
		// Display total charges of the three procedures
		double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
		System.out.printf("\nTotal Charges: $%,.2f%n", totalCharges);
		System.out.println("\nStudent Name: Joanna McInnes");
		System.out.println("MC#: M21059656");
		System.out.println("Due Date: 07/01/2024");
	}
}
