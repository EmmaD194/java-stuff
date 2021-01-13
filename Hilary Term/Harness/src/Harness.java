/* SELF ASSESSMENT

Harness Class: Member variables (8 marks)
All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.
Comment:

Harness Class: Harness constructor 1 & constructor 2 (6 marks)
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment:

Harness Class: checkHarness method (5 marks)
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment:

Harness Class: isHarnessOnLoan method (2 marks)
My method has no parameters and returns the value of the loan status variable.
Comment:

Harness Class: canHarnessBeLoaned method (4 marks)
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment:

Harness Class: loanHarness method (6 marks)
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment:
 
Harness Class: returnHarness method (5 marks)
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment:

Harness Class: toString method (3 marks)
My method returns a String representation of all the member variables.
Comment:

HarnessRecords Class: member variables (3 marks)
I declare the member variable as a private collection of Harnesses 
Comment:

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks)
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the set of characteristics in the list to create Harness objects and add them to the collection. 
Comment:

HarnessRecords Class: isEmpty method (1 marks)
I return true if the collection is null/empty and, false otherwise.
Comment:

HarnessRecords Class: addHarness method (5 marks)
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment:

HarnessRecords Class: findHarness method (6 marks)
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment:

HarnessRecords Class: checkHarness method (6 marks)
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment:

HarnessRecords Class: loanHarness method (7 marks)
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. If there's no available harness null is returned.
Comment:

HarnessRecords Class: returnHarness method (7 marks)
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment:

HarnessRecords Class: removeHarness method (8 marks)
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. It returns the harness object if it is found, otherwise returns null.
Comment:

GUI (Java main line) (5 marks)
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment:

*/public class Harness {
	public  String makeModel;
	public  int modelNumber;
	public int noOfUses;
	public String instructorName, borrowerName;
	public boolean isOnLoan;
	
	public Harness (String make, int number, int uses, String instructor, boolean onLoan, String borrower)
	{
		makeModel = make;
		modelNumber = number;
		noOfUses = uses;
		borrowerName = borrower;
		isOnLoan = onLoan;
		
	}
	
	public Harness (String make, int number, String instructor)
	{
		makeModel = make;
		modelNumber = number;
		noOfUses = 0;
		instructorName = instructor;
		borrowerName = null;
		isOnLoan = false;
	}
	
	public void checkHarness (String instructor, int makeModel, int modelNumber)
	{
		if(!isOnLoan)
		{
			instructorName = instructor;
			noOfUses = 0;
		}
	}
	
	public boolean harnessOnLoan()
	{
		boolean harnessOnLoan = false;
		if (isOnLoan)
		{
			harnessOnLoan = true;
		}
		return harnessOnLoan;
	}
	
	public boolean canHarnessBeLoaned()
	{
		boolean canBeLoaned = false;
		boolean onLoan = false;
		if (!onLoan && noOfUses < 25)
		{
			canBeLoaned = true;
		}
		return canBeLoaned;
	}
	public void loanHarness(String borrower)
	{
		boolean canBeLoaned = canHarnessBeLoaned();
		if (canBeLoaned)
		{
			borrowerName = borrower;
			isOnLoan = true;
		}
	}
	
	public void returnHarness()
	{
		boolean onLoan = harnessOnLoan();
		if (onLoan)
		{
			noOfUses++;
			borrowerName = null;
		}
	}
	
	public String toString()
	{
		String harness = "Make: " + makeModel + " Model Number: " + modelNumber + " Number of uses: " + noOfUses;
		if (noOfUses < 25)
		{
			harness += noOfUses;
		}
		else 
		{
			harness += "The harness has been used over 25 times. Now it needs a safety check";
		}
		harness  += "Last checked by: " + instructorName;
		if (isOnLoan)
		{
			harness += "Is on loan to: " + borrowerName;
		}
		else
		{
			harness += "Not on loan at the moment.";
		}
		return harness;
	}
	

	
	
	
	
	
	
	
	
	
}