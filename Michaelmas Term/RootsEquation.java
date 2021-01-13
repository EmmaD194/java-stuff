import java.util.Scanner;
import javax.swing.JOptionPane;
import java.lang.Math;

public class RootsEquation {

	public static void main(String[] args) {
		boolean finished = false;
		do {
			String input = JOptionPane.showInputDialog("Enter the coefficients of your second order polynomial separated by spaces "
					+ "(or enter quit)");
			Scanner inputScanner = new Scanner( input );
			
			if (inputScanner.hasNextInt()) { 
				double a = inputScanner.nextInt();
				double b = inputScanner.nextInt();
				double c = inputScanner.nextInt();
				
				double answer1 = ((-(b))+ Math.sqrt((b*b) - (4*a*c)))/(2*a);
				double answer2 = ((-(b))- Math.sqrt((b*b) - (4*a*c)))/(2*a);
				
				JOptionPane.showMessageDialog(null, "The roots to this equation are x=" + answer1 + " and x= " + answer2 );
				
				} else if ((inputScanner.hasNext("quit"))) {
					finished = true;
			} else JOptionPane.showMessageDialog(null,"Not a number. Try again.");
			  inputScanner.close();
			  
			}  while (!finished);
	}

}
