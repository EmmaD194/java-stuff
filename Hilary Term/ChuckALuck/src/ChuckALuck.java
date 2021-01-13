/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7:7 ].
Comment:I made a resolveBet function using the correct parameters  
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment:My program asks the user to enter how much money they have and then displays the cash amount
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5:5 ].
Comment:the program checks if the bet amount and prints an error if there is insufficient funds 
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15: 12]..
Comment:My program uses the dice class to create 3 dice objects and uses .roll() to roll them and prints the total of the dice roll
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20: 15].
Comment:
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: ].
Comment:

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: ]
Comment:
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: ]
Comment:
I ask the user to enter any of the four bet types or quit [Mark out of 5: ].
Comment:
My program calls resolveBet for each bet type entered [Mark out of 5: ].
Comment:
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: ]
Comment:

 Total Mark out of 100 (Add all the previous marks):
*/


import java.util.Scanner;

public class ChuckALuck {

	public static void main(String[] args) {

		boolean finished = false;
		Wallet wallet = new Wallet();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount of cash:");
		do
		{
			if(scanner.hasNextDouble())
			{
				double startingCash = scanner.nextDouble();
				wallet.put(startingCash);
				boolean ended = false;
				do
				{
					Scanner scanner2 = new Scanner(System.in);
					System.out.println("Your current : " + wallet.toString());
					System.out.println("Please enter your bet type 'field', 'triple', 'low', or 'high' or type 'quit': ");
					if(scanner2.hasNext("quit"))
					{
						System.out.println("You have " + wallet.toString());
						ended = true;
						scanner2.close();
					}
					else if(wallet.check() <= 0 || !scanner2.hasNextLine())
					{
						ended = true;
					}
					else if(  scanner2.hasNext("low") ||  scanner2.hasNext("high") ||
							 scanner2.hasNext("field") || scanner2.hasNext("triple"))
					{
						String typeOfBet = scanner2.nextLine();
						resolveBet(typeOfBet, wallet);
						if(wallet.check() == 0)
						{
							System.out.println("You have run out of money.");
							ended = true;
						}
					}
					else
					{
						System.out.println("Error invalid input.");
					}
				}
				while(!ended);
				System.out.println("You started with: " + startingCash + " and you finished with: " + wallet.check());
				if(startingCash < wallet.check())
				{
					System.out.println("You won: " + (wallet.check() - startingCash) + " euro");
				}
				else if(startingCash > wallet.check())
				{
					System.out.println("You lost: " + (startingCash - wallet.check()) + " euro");
				}
				else
				{
					System.out.println("You ended with the same amount of money you started with: " + startingCash);
				}
				finished = true;
			}
			else if(scanner.hasNext("quit"))
			{
				finished = true;
				scanner.close();
			}
			else
			{
				System.out.println("Invalid input.");
			}
			
		}
		while(!finished);
		System.out.println("Game Over");
	}

	public static void resolveBet(String typeOfBet, Wallet wallet) {
		String string1;
		String string2;
		String string3;
		System.out.println("Your current : " + wallet.toString());		
		Scanner scanner3 = new Scanner(System.in);
		System.out.println("Enter bet amount");
		if(scanner3.hasNextDouble())
		{
			double betCash = scanner3.nextDouble();
			if(wallet.get(betCash))
			{
				Dice dice1 = new Dice();
				Dice dice2 = new Dice();
				Dice dice3 = new Dice();
				dice1.roll();
				dice2.roll();
				dice3.roll();
				int face1 = dice1.topFace();
				int face2 = dice2.topFace();
				int face3 = dice3.topFace();
				int total = face1 + face2 + face3;
				
				if(typeOfBet.equals("triple"))
				{
					if(face1 == face2 && face2 == face3 && face1 != 1 
							&& face1 != 6)
					{
						wallet.put(31 * betCash);
						string1 = dice1.toString();
						string2 = dice2.toString();
						string3 = dice3.toString();
						System.out.println(string1 + " | " + string2 + " | " + string3);
						System.out.println("All three dices have" + face1 + " on the top face "
								+ "and the total is: " + total);
						System.out.println("Congratulations, you won the Triple bet!");
					}
					else
					{
						string1 = dice1.toString();
						string2 = dice2.toString();
						string3 = dice3.toString();
						System.out.println(string1 + " | " + string2 + " | " + string3);
						if(face1 != face2 || face2 != face3)
						{
							System.out.println("All three dices have not landed on the same face and the "
									+ "total is: " 
						+ total);
						}
						else if(face1 == face2 && face2 == face3)
						{
							System.out.println("All three dices have " + face1 + " as top face and the total is:"  
									 + total);
						}
						System.out.println("Sorry, you lost the Triple bet.");
					}
				}
				else if(typeOfBet.equals("field"))
				{
					if(total < 8 || total > 12)
					{
						wallet.put(2 * betCash);
						string1 = dice1.toString();
						string2 = dice2.toString();
						string3 = dice3.toString();
						System.out.println(string1 + " | " + string2 + " | " + string3);
						System.out.println("The total of the top faces are: " + total);
						System.out.println("Congratulations, you won the Field bet!");
					}
					else
					{
						string1 = dice1.toString();
						string2 = dice2.toString();
						string3 = dice3.toString();
						System.out.println(string1 + " | " + string2 + " | " + string3);
						System.out.println("The total of the top faces is: " + total);
						System.out.println("Sorry, You lost the Field bet.");
					}
				}
				else if(typeOfBet.equals("high"))
				{
					if(total > 10)
					{
						wallet.put(2 * betCash);
						string1 = dice1.toString();
						string2 = dice2.toString();
						string3 = dice3.toString();
						System.out.println(string1 + " | " + string2 + " | " + string3);
						System.out.println("The total of the top faces is: " + total);
						System.out.println("Congratulations, you won the High bet!");
					}
					else
					{
						string1 = dice1.toString();
						string2 = dice2.toString();
						string3 = dice3.toString();
						System.out.println(string1 + " | " + string2 + " | " + string3);
						System.out.println("The total of the top faces is: " + total);
						System.out.println("That's too bad, you lost the High bet.");
					}
				}
				else if(typeOfBet.equals("low"))
				{
					if(total < 11)
					{
						wallet.put(2 * betCash);
						string1 = dice1.toString();
						string2 = dice2.toString();
						string3 = dice3.toString();
						System.out.println(string1 + " | " + string2 + " | " + string3);
						System.out.println("The total of the top faces are: " + total);
						System.out.println("Congratulations, you won the Low bet!");
					}
					else
					{
						string1 = dice1.toString();
						string2 = dice2.toString();
						string3 = dice3.toString();
						System.out.println(string1 + " | " + string2 + " | " + string3);
						System.out.println("The total of the top faces are: " + total);
						System.out.println("sorry, you lost the Low bet.");
					}
				}
			}
			else
			{
				System.out.println("Error you don't have enough money to bet.");
			}
		}
		else if(scanner3.hasNext("quit"))
		{
			scanner3.close();
		}

	}
}

