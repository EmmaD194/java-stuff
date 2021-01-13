/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10 
       Comment: I used easy and relevant variable names like previousVariance
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 5: 5
       Comment: I typed the variable names correctly in lowerCamelCase e.g previousVariance
   3. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment: I fee like I have indented the code properly
   4. Did I input the numbers one at a time from the command line?
       Mark out of 10:  10
       Comment: The numbers were input one at a time in the command line.
   5. Did I check the input to ensure that invalid input was handled appropriately?
       Mark out of 10:  10
       Comment: I checked the input to ensure that an invalid input was handled appropriately so that no errors occured.
   6. Did I use an appropriate while or do-while loop to allow the user to enter numbers until they entered exit/quit?
       Mark out of 20:  20
       Comment: I used a do-while loop to let the user enter as many numbers they want until they enter 'quit'.
   7. Did I implement the loop body correctly so that the average and variance were updated and output appropriately?
       Mark out of 30:  30
       Comment: I implemented the loop body so the average and variance were updated and output properly
   8. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment: I completed the self assessment goodly
   Total Mark out of 100 (Add all the previous marks): 100
*/
import java.util.Scanner;

public class IncrementalStatistics {

	public static void main(String[] args) {
		double previousAverage = 0.0, previousVariance = 0.0, currentAverage, currentVariance;
		int numberCount = 0, number;
		
		boolean finished = false;
		System.out.println("This program computes the average and variance of all numbers entered.");
		System.out.println("Enter a number or type 'quit'");
		do {
			Scanner scanner = new Scanner(System.in);
			
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				numberCount++;
				
				currentAverage = previousAverage + (((double) number) - previousAverage) / numberCount;
				currentVariance = ((previousVariance * (((double) numberCount) - 1) + (((double) number) - previousAverage) * 
				       (((double) number) - currentAverage))) / numberCount;
				
				System.out.println("So far the average is " + currentAverage + " and the variance is " + currentVariance);
				System.out.println("Enter another number or type 'quit':");
				
				previousAverage = currentAverage;
				previousVariance = currentVariance;
				
				
			} else if ((scanner.hasNext("quit"))) {
				finished = true;
			} else System.out.println("Not a whole number. Try again.");
			  scanner.close();
			
		} while (!finished);
		
		
		System.out.println("Goodbye!");
		

	}

}
