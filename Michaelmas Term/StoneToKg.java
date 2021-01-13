import java.util.Scanner;
public class StoneToKg {

	public static final int POUNDS_IN_A_STONE = 14;
	public static final int OUNCES_IN_A_POUND = 16;
	public static final double OUNCE_TO_KG = 0.02834952;
	public static final int STONE_TO_OUNCES = 224;
	public static final int POUND_TO_OUNCES = 16;
	

	public static void main(String[] args) {
		Scanner Scanner = new Scanner(System.in);
		boolean finished = false;
		
		do{
			System.out.println("Enter the number of Stones, Pounds and Ounces separated by spaces (or enter 'quit')");
			if (Scanner.hasNextInt())
			{
				int stone = Scanner.nextInt();
				int pound = Scanner.nextInt();
				int ounce = Scanner.nextInt();
				double kg = convertToKilograms(stone, pound, ounce);
				String format = getFormattedWeightString(stone, pound, ounce);
				System.out.println(format + " is equal to " + kg + "kg");
				
				
			} else if (Scanner.hasNext("quit"))
			{
				System.out.println("bye!");
				finished = true;
			}else 
			{
				System.out.println("not a valid number, please restart." );
				finished = true;
				
			}	
			
		}while (!finished);
		Scanner.close();
		

	}
	public static double convertToKilograms(int stone, int pound, int ounce){
		
		int stoneToOunce = stone*(STONE_TO_OUNCES);
		int poundToOunce = pound*(POUND_TO_OUNCES);
		double weightInKg = ((stoneToOunce)+(poundToOunce)+(ounce))*(OUNCE_TO_KG);
		return weightInKg;
	}
	public static String getFormattedWeightString(int stone, int pound, int ounce){
		String printWeight = "";
		if ((stone == 0)&&(pound ==0)&&(ounce==0))
		{
			printWeight = "0 ounces";
		}else if ((stone > 1) && (pound > 1) && (ounce > 1))
		{
			printWeight =  "stones, pounds, ounces";
		}
		
		
		return printWeight;
	}

}
