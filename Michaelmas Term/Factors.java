import java.util.Scanner;
public class Factors {

	public static void main(String[] args) {
		boolean finished = false;
		System.out.print("Please enter a positive whole number or type 'quit':");

		do {
			Scanner Scanner = new Scanner(System.in);
			if (Scanner.hasNextInt()){
				 int numberToFactorise = Scanner.nextInt();
				 
				 for (int divisor = 1 ; (divisor <= numberToFactorise); divisor++){
				 int factorial = (numberToFactorise)/(divisor);
				 if ((numberToFactorise)%(divisor)==))
				 
				
				
				System.out.println("The factors of " + numberToFactorise + " are " + divisor + "x" + factorial  );
				
				if (((numberToFactorise)% 2) == 0 ){
					System.out.println(numberToFactorise + " is not a prime number.");
					
				}else System.out.println(numberToFactorise + "is a prime number");
				
				 }
			}else if (Scanner.hasNext("quit")){
				finished = true;
			}
			else System.out.println("Not a whole number try again");
			Scanner.close();
		} while (!finished);
		  System.out.print("bye!");

	}

}
