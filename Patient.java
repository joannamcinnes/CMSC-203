/*
 * Class: CMSC 203 CRN: 40398
 * Instructor: Professor Eivazi
 * Description: The Patient class stores and manages patient information including their full name, address, phone number, 
 * and emergency contact. This class provides a way to organize and retrieve patient data, and displays this information using various methods. 
 * Due: 07/01/2024
 * Platform/compiler: Eclipse IDE/ Eclipse Compiler for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. I have not given my 
 * code to any student. 
 * Print your name here: Joanna McInnes
 */

import java.util.Scanner;

public class Patient {
	Scanner stringScanner = new Scanner(System.in);
	// Patient attributes
	private String firstName;
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNumber;
	private String emergencyContactName;
	private String emergencyContactPhone;

	// No-arg constructor
	public Patient() {
	}
	// Parameterized constructor for patient's name
	public Patient(String firstNameInput, String middleNameInput, String lastNameInput) {
		this.firstName = firstNameInput;
		this.middleName = middleNameInput;
		this.lastName = lastNameInput;
	}
	// Parameterized constructor for all attributes
	public Patient(String firstNameInput, String middleNameInput, String lastNameInput, 
			String streetAddressInput, String cityInput, String stateInput, String zipCodeInput, 
			String phoneNumberInput, String emergencyContactNameInput, String emergencyContactPhoneInput) {
		this.firstName = firstNameInput;
		this.middleName = middleNameInput;
		this.lastName = lastNameInput;
		this.streetAddress = streetAddressInput;
		this.city = cityInput;
		this.state = stateInput;
		this.zipCode = zipCodeInput;
		this.phoneNumber = phoneNumberInput;
		this.emergencyContactName = emergencyContactNameInput;
		this.emergencyContactPhone = emergencyContactPhoneInput;
	}
	// Accessors and mutators for each attribute
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstNameInput) {
		this.firstName = firstNameInput;
	}

	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleNameInput) {
		this.middleName = middleNameInput;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName (String lastNameInput) {
		this.lastName = lastNameInput;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddressInput) {
		this.streetAddress = streetAddressInput;
	}
	public String getCity() {
		return city;
	}
	public void setCity (String cityInput) {
		this.city = cityInput;
	}
	public String getState() {
		return state;
	}
	public void setState(String stateInput) {
		this.state = stateInput;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCodeInput) {
		this.zipCode = zipCodeInput;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumberInput) {
		this.phoneNumber = phoneNumberInput;
	}
	public String getEmergencyContactName() {
		return emergencyContactName;
	}
	public void setEmergencyContactName(String emergencyContactNameInput) {
		this.emergencyContactName = emergencyContactNameInput;
	}
	public String getEmergencyContactPhone() {
		return emergencyContactPhone;
	}
	public void setEmergencyContactPhone(String emergencyContactPhoneInput) {
		this.emergencyContactName = emergencyContactPhoneInput;
	}
	// buildFullName method
	public String buildFullName() {
		return firstName + " " + middleName + " " + lastName;
	}
	// buildAddress method
	public String buildAddress() {
		return streetAddress + " " + city + " " + state + " " + zipCode;
	}
	// buildEmergencyContact method
	public String buildEmergencyContact() {
		return emergencyContactName + " " + emergencyContactPhone;
	}
	// toString method to display information
	public String toString() {
		return "Patient Information:" + "\nFull Name: " +buildFullName() +"\nAddress: " + buildAddress() 
		+ "\nPhone Number: " + phoneNumber + "\nEmergency Contact: " + buildEmergencyContact();
	}
}
