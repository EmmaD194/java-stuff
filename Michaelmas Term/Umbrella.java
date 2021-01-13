/* SELF ASSESSMENT 
   1. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
       Comment: I used easy and meaningful variable names like rainingNow and forecastToRain
   2. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 10: 10
       Comment: I formatted the variable names properly in lowerCamelCase eg. rainingNow
   3. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment: I think I indented to code properly 
   4. Did I read the input correctly from the user using appropriate questions? 
       Mark out of 20: 20
       Comment: I read the input from the user correctly using yes/no options and by using relevant questions like "Is it currently raining outside?"
   5. Did I use an appropriate (i.e. not more than necessary) series of if statements? 
       Mark out of 30: 30 
       Comment: I used two if statements, one inside he other, which I feel is enough to get the correct answer
   6. Did I output the correct answer for each possibility in an easy to read format? 
       Mark out of 15: 15
       Comment: The answer for each possibility is a to-the-point fact about bringing an umbrella out.
   7. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment: I completed this self assessment very well I think.
   Total Mark out of 100 (Add all the previous marks): 
*/

import javax.swing.JOptionPane;

public class Umbrella {

	public static void main(String[] args) {
		int answer = JOptionPane.showConfirmDialog(null, "Is it curently raining outside?");
		boolean rainingNow = (answer == JOptionPane.YES_OPTION);
		
		if (!rainingNow)
		{
			answer = JOptionPane.showConfirmDialog(null, "Is it forecast to rain later today?");
		    boolean forecastToRain = (answer == JOptionPane.YES_OPTION);
		    if (forecastToRain)
		     JOptionPane.showMessageDialog(null, "Bring an umbrella but do not put it up.");
		    else JOptionPane.showMessageDialog(null, "You do not need to bring an umbrella.");
		    
		} 
		else 
		{
			JOptionPane.showMessageDialog(null, "You need to bring an umbrella and put it up");
		}
	}

}
