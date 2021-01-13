public class Harness {
	private final String makeModel;
	private final int modelNumber;
	private int noOfUses;
	private String instructorName, borrowerName;
	private boolean isOnLoan;
	
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
	
	public void checkHarness (String instructor)
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