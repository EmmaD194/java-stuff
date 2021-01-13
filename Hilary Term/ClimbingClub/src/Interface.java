import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Interface {

	public static void main(String[] args) {
		
		try 
		{
			HarnessRecords  harnesses = new HarnessRecords();
			
			boolean finished = false;
			while (!finished)
			{
				Object[] harnessOptions = {"Add Harness", "Remove Harness", "Check Harness", "Loan Harness", "Return Harness", "Print record"};
				Object response =  JOptionPane.showInputDialog(null, "Choose an option", "Input", JOptionPane.INFORMATION_MESSAGE, null, harnessOptions, response);
				if (response.equals("Add Harness"))
				{
					JTextField makeModel = new JTextField(5);
					JTextField modelNumber = new JTextField(5);
					JTextField instructorName = new JTextField(5);
					JPanel newPanel = new JPanel();
					newPanel.add(new JLabel("Make: "));
					newPanel.add(makeModel);
					newPanel.add(new JLabel("Model: "));
					newPanel.add(modelNumber);
					newPanel.add(new JLabel("Instructor: "));
					newPanel.add(instructorName);
					
					int result = JOptionPane.showConfirmDialog(null, newPanel, "Input info of new harness", JOptionPane.INFORMATION_MESSAGE);
					if (result == JOptionPane.OK_OPTION)
					{
						String makeInput = makeModel.getText();
						int modelInput = Integer.parseInt(modelNumber.getText());
						String instructorInput = instructorName.getText();
						Harness harness = new Harness(makeInput, modelInput, instructorInput);
						harnesses.addHarness(harness);
					}
				}
				else if (response.equals("Remove Harness"))
				{
					JTextField makeModel = new JTextField(5);
					JTextField modelNumber = new JTextField(5);
					JPanel newPanel = new JPanel();
					newPanel.add(new JLabel("Make: "));
					newPanel.add(makeModel);
					newPanel.add(new JLabel("Model: "));
					newPanel.add(modelNumber);
					int result = JOptionPane.showConfirmDialog(null, newPanel, "Input info of harnes to remove", JOptionPane.INFORMATION_MESSAGE);
					if (result == JOptionPane.OK_OPTION)
					{
						String makeInput = makeModel.getText();
						int modelInput = Integer.parseInt(modelNumber.getText());
					
						harnesses.removeHarness(makeInput, modelInput);
					}
				}
				else if (response.equals("Check Harness"))
				{
					JTextField makeModel = new JTextField(5);
					JTextField modelNumber = new JTextField(5);
					JTextField instructorName = new JTextField(5);
					JPanel newPanel = new JPanel();
					newPanel.add(new JLabel("Make: "));
					newPanel.add(makeModel);
					newPanel.add(new JLabel("Model: "));
					newPanel.add(modelNumber);
					newPanel.add(new JLabel("Instructor: "));
					newPanel.add(instructorName);
					int result = JOptionPane.showConfirmDialog(null, newPanel, "Input info of harness to check", JOptionPane.INFORMATION_MESSAGE);
					if (result == JOptionPane.OK_OPTION)
					{
						String makeInput = makeModel.getText();
						int modelInput = Integer.parseInt(modelNumber.getText());
						String instructorInput = instructorName.getText();
						harnesses.checkHarness(instructorInput, makeInput, modelInput);
					}
				}
				else if (response.equals("Loan Harness"))
				{
					JTextField borrowerName = new JTextField(5);
					JPanel newPanel = new JPanel();
					newPanel.add(new JLabel("Borrower: "));
					newPanel.add(borrowerName);
					int result = JOptionPane.showConfirmDialog(null, newPanel, "Input name of borrower", JOptionPane.INFORMATION_MESSAGE);
					if (result == JOptionPane.OK_OPTION)
					{
						String nameInput = borrowerName.getText();
						harnesses.loanHarness(nameInput);
						
					}	
				}
				else if (response.equals("Return Harness"))
				{
					JTextField makeModel = new JTextField(5);
					JTextField modelNumber = new JTextField(5);
					JPanel newPanel = new JPanel();
					newPanel.add(new JLabel("Make: "));
					newPanel.add(makeModel);
					newPanel.add(new JLabel("Model: "));
					newPanel.add(modelNumber);
					int result = JOptionPane.showConfirmDialog(null, newPanel, "Input info of harness to return", JOptionPane.INFORMATION_MESSAGE);
					if (result == JOptionPane.OK_OPTION)
					{
						String makeInput = makeModel.getText();
						int modelInput = Integer.parseInt(modelNumber.getText());
					
						harnesses.returnHarness(makeInput, modelInput);
					}
				}
				else if (response.equals("Print record"))
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
				}
				else if (response.equals("null"))
				{
					finished = true;
				}
				
			}
		}
		catch(NullPointerException exception)
		{
			
		}
		catch (java.lang.NumberFormatException exception)
		{
			JOptionPane.showMessageDialog(null, "Error, no input");
		}

	}

}
