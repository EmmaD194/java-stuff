import java.util.Scanner;
import javax.swing.JOptionPane;

public class ReverseDigits {

	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("Enter number to reverse:");
		Scanner scanner = new Scanner( input );
		int number = scanner.nextInt();

	    int reversedNumber = 0;
	    int remainingNumber = number;
	    while (remainingNumber > 0)
	    {
	      reversedNumber = reversedNumber*10 +
					 remainingNumber%10;
	      remainingNumber = remainingNumber/10;
	    }

	    JOptionPane.showMessageDialog(null, "The reverse of " + number + " is " + reversedNumber);
	}

}
