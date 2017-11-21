/*Opdracht:
 * Write a program that has a year as input and then checks if this year is a leap year.

A year is a leap year when:

every fourth year is a leap year.
a new century is only a leap year when it is dividable by 400.
Do not use the standard date functionality to perform the check.
 */
import java.util.*;
import java.io.IOException;
import java.io.Console;

public class Opdr1LeapYear {
	public static void main(String[] args) throws IOException
	{
		String input;
		int yearGiven = 0;
		Boolean isLeapYear = false;
		Boolean isBC = false;
		Console c = System.console();
		Boolean isQuitting = false;
		
		//check for console
		if (c == null)
			{
				System.err.println("Error: No console");
				System.exit(1);
			}
			

		while(!isQuitting)
		{
			input = c.readLine("Input a year - To input a year before 0 use 'BC' or '-': ");

			if (input.matches("(.*)BC(.*)") || input.matches("(.*)-(.*)"))
			{
				isBC = true;
			}

			yearGiven = Integer.parseInt(input.replaceAll("[\\D]", ""));
			
			//calculate
			if(yearGiven % 4 == 0)
			{
				if(yearGiven % 100 == 0 && (yearGiven % 400 != 0))
				{
					isLeapYear = false; 
				}	
				else
				{
					isLeapYear = true;
				}
				
			}
			
			System.out.print("The year " + yearGiven);

			if (isBC)
			{
				System.out.print(" BC");
			}

			if(isLeapYear)
			{
				System.out.println(" is a leap year");
			}
			else {
				System.out.println(" is not a leap year");
			}
			
			Boolean isAnswered = false;

			while (!isAnswered)
			{
				input = c.readLine("Check another? Y/N: ");

				isAnswered = true; 

				if(input.matches("(.*)Y(.*)") || input.matches("(.*)y(.*)") )
				{
					isQuitting = false;
				}
				else if(input.matches("(.*)N(.*)") || input.matches("(.*)n(.*)"))
				{
					isQuitting = true;
				}
				else
				{
					isAnswered = false;
					System.out.print("I don't understand... ");
				}
			}
			

		}
		
	}
	
	
}
