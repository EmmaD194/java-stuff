import java.util.ArrayList;
import java.util.Scanner;

public class HarnessRecords {
	
	private ArrayList<Harness> harnesses;

	
	public HarnessRecords()
	{
		harnesses = new ArrayList<Harness>();
		int noOfHarnesses = inputStream.readInt();
		harnesses = new ArrayList<Harness>(noOfHarnesses);
		for (int i = 0; i < noOfHarnesses; i++)
		{
			String makeModel;
			int modelNumber;
			int noOfUses;
			String instructorName;
			boolean isOnLoan;
			String borrowerName;
			String borrowerNameInput = borrowerName;
			if (borrowerNameInput == null)
			{
				borrowerName = null;
			}
			else borrowerName = borrowerNameInput;
			harnesses.add(i, (new Harness(makeModel, modelNumber, noOfUses, instructorName, isOnLoan, borrowerName)));
		}
		
	}
	
	public boolean isEmpty()
	{
		return harnesses.isEmpty();
	}
	
	public void addHarness(Harness harness)
	{
		harnesses.add(harness);
	}
	
	public Harness findHarness(String makeModel, int modelNumber)
	{
		Harness harness = null;
		for (int i = 0; i < harnesses.size(); i++)
		{
			if (harnesses.get(i).sameMakeAndModel(makeModel, modelNumber)))
			{
				harness = harnesses.get(i);
			}
		}
		return harness;
	}
	public Harness loanHarness(String borrowerName)
	{
		boolean harnessFound = false;
		Harness harness = null;
		for (int i = 0; i < harnesses.size() && !harnessFound; i++)
		{
			if (harnesses.get(i).canHarnessBeLoaned())
			{
				harnesses.get(i).loanHarness(borrowerName);
				harnessFound = true;
				harness = harnesses.get(i);
			}
		}
		return harness;
	}
	
	public Harness returnHarness(String makeModel, int modelNumber)
	{
		Harness harness = findHarness(makeModel, modelNumber);
		if (harness != null)
		{
			if (harness.harnessOnLoan())
			{
				harness.returnHarness();
			}
		}
		return harness;
	}
	
	public Harness removeHarness(String makeModel, int modelNumber)
	{
		Harness harness = findHarness(makeModel, modelNumber);
		if (harness != null)
		{
			harnesses.remove(harness);
			
		}
		return harness;
	}
	
	public Harness returnHarnessOnList(int index)
	{
		return harnesses.get(index);
	}
	public int harnessRecordsSize()
	{
		return harnesses.size();
	}
	
	
	
	
}
