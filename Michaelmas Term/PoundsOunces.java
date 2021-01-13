import java.util.Scanner;
public class PoundsOunces {

	public static final int POUNDS_IN_A_STONE = 14;
	public static final int OUNCES_IN_A_POUND = 16;
	public static final double OUNCE_TO_KG = 0.2834952;
	public static final int STONE_TO_OUNCES = 224;
	public static final int POUND_TO_OUNCES = 16;
	

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		boolean finished = false;
		
		do{
			System.out.print("Enter the number of Stones, Pounds and Ounces separated by spaces (or enter 'quit')");
			if (Scanner.hasNextInt())
			{
				int stone = Scanner.nextInt();
				int pound = Scanner.nextInt();
				int ounce = Scanner.nextInt();
				
				
			} else if (Scanner.hasNext("quit"))
			{
				System.out.print("bye!");
				finished = true;
			}else 
			{
				System.out.print("Please enter a valid number" );
			}	
			
		}while (!finished);
		
		

	}
	public static double convertToKilograms(int stone, int pound, int ounce){
		
		int stoneToOunce = stone*(STONE_TO_OUNCES);
		int poundToOunce = pound*(POUND_TO_OUNCES);
		double weightInKg = ((stoneToOunce)+(poundToOunce)+(ounce))*(OUNCE_TO_KG);
		return weightInKg;
	}
	public static String getFormattedWeightString(int stone, int pound, int ounce){
		
	}

}
