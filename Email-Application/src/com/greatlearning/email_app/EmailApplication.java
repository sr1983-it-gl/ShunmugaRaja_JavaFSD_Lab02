package com.greatlearning.email_app;

import java.util.Scanner;

public class EmailApplication {

	public void init() {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your first name");		
		String firstname = input.nextLine();
		
		System.out.println("Enter your last name");		
		String lastname = input.nextLine();
		
		System.out.println("Enter your department");
		System.out.println("Specify the following department code values");
		System.out.println("1. Technical");
		System.out.println("2. Admin");
		System.out.println("3. Human Resource");
		System.out.println("4. Legal");
		
		int departmentCode = input.nextInt();

		
		// Integrate the email address generation
		// emailAddress
		
		CredentialsManagerServiceImpl serviceObj = 
			new CredentialsManagerServiceImpl();
		
		String emailAddress  = serviceObj.generateEmailAddress(
				firstname, lastname, departmentCode);
		
		System.out.println(emailAddress);
		
		// Integrate the password
		// password
		
		String password = serviceObj.generatePassword();
		System.out.println(password);
		
		Employee empObj 
			= new Employee(firstname, lastname, emailAddress);
		empObj.setPassword(password);
		
		serviceObj.displayGeneratedCredentials(empObj);
	}
}
