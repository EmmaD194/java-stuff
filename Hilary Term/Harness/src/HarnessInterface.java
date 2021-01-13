import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.util.Scanner;

public class HarnessInterface {
	
	public static String makeInput;
	static String instructorInput;
	static int modelInput;
	static String nameInput;

	public static void main(String[] args) {
		
		try 
		{
			HarnessRecords  harnesses = new HarnessRecords();
			Scanner scanner = new Scanner(System.in);
			
			boolean finished = false;
			while (!finished)
			{
				
				System.out.println("Enter 1-add harness, 2- remove harness, 3-register safety check, 4-loan harness, 5- return harness");
				if (scanner.hasNextInt())
				{
				int response = scanner.nextInt();
				if (response == 1)
				{
					System.out.println("Enter make");
					makeInput = scanner.nextLine();
					System.out.println("Enter model number");
					modelInput = scanner.nextInt(); 
					System.out.print("Enter instructor");
					instructorInput = scanner.nextLine();
					
					Harness harness = new Harness(makeInput, modelInput, instructorInput);
					harnesses.addHarness(harness);
					
					System.out.println("Harness added!");
					
					
					
				}
				else if (response == 2)
				{
					System.out.println("Enter make");
					 makeInput = scanner.nextLine();
					System.out.println("Enter model number");
					 modelInput = scanner.nextInt();
					harnesses.removeHarness(makeInput, modelInput);
					
					System.out.println("Harness removed!");
					
					
				}
				else if (response == 3)
				{
					System.out.println("Enter make");
					makeInput = scanner.nextLine();
					System.out.println("Enter model number");
					modelInput = scanner.nextInt(); 
					System.out.print("Enter instructor");
					instructorInput = scanner.nextLine();
					
					harnesses.checkHarness(instructorInput, makeInput, modelInput);
					
					
				}
				else if (response == 4)
				{
					System.out.println("Enter borrower name");
					nameInput = scanner.nextLine();
					harnesses.loanHarness(nameInput);
						
				}
				else if (response == 5)
				{
					System.out.println("Enter make");
					 makeInput = scanner.nextLine();
					System.out.println("Enter model number");
					 modelInput = scanner.nextInt();
					
					harnesses.returnHarness(makeInput, modelInput);
					
				}
				/*else if (response.equals("Print record"))
				{
					if(!harnesses.isEmpty())
					{
						String list = "";
						for (int i = 0; i < harnesses.harnessRecordsSize(); i++)
						{
							Harness harnessToBePrinted = harnesses.returnHarnessOnList(i);
							list += (harnessToBePrinted.toString());
							Object textArea;
							JScrollPane scrollPane = new JScrollPane((Component) textArea);
							//((Object) textArea).setLineWrap(true);
							//((Object) textArea).setWrapStyleWord(true);
							scrollPane.setPreferredSize(new Dimension(400, 500));
							JOptionPane.showMessageDialog(null, scrollPane, "Current Records", JOptionPane.PLAIN_MESSAGE);
							
						}
					}
					else 
					{
						JOptionPane.showMessageDialog(null, "No current haresses recorded");
						
					}
				}*/
				
				
			}
				
		}
		
		
	}
		catch(NullPointerException exception)
		{
			
		}
		

	}

}

