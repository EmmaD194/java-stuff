/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code?  
       Mark out of 5: 5
       Comment: I used constants in my code instead of numbers making it easier to calculate the answer.
   2. Did I use easy-to-understand, meaningful CONSTANT names? 
       Mark out of 5: 5
       Comment: I used CONSTANT names that were relevant to the task eg. MINIMUM_AGE.
   3. Did I format the CONSTANT names properly (in UPPERCASE)? 
       Mark out of 5: 5
       Comment: I formatted the CONSTANT names all in uppercase.
   4. Did I use easy-to-understand meaningful variable names? 
       Mark out of 10: 10
       Comment: I used easy and meaningful variable names like ageSquared and age.
   5. Did I format the variable names properly (in lowerCamelCase)? 
       Mark out of 10: 10
       Comment: I formatted the variable names properly in lowerCamelCase eg. ageSquared.
   6. Did I indent the code appropriately? 
       Mark out of 10: 10
       Comment: I think I indented to code properly
   7. Did I use an appropriate for loop to test all possibilities?  There should be only one. 
       Mark out of 20:  20
       Comment: I used one for loop to test the possibilities.
   8. Did I correctly check if people alive today were or could be alive in a year that is the square of their age in that year. 
       Mark out of 30:  28
       Comment: I checked if anyone alive today will be alive in a year that is a square of their age.
   9. How well did I complete this self-assessment? 
       Mark out of 5: 5
       Comment: I completed the self assessment honestly.
   Total Mark out of 100 (Add all the previous marks): 98
*/
public class SquareAges {
	public static final int MINIMUM_AGE = 0;
	public static final int MAXIMUM_AGE = 123;
	public static final int MINIMUM_YEAR = 1895;
	public static final int MAXIMUM_YEAR = 2141;

	public static void main(String[] args) {
		System.out.println("A person is alive in a year that is the square of their age if:");
		for (int age = MINIMUM_AGE; (age <= MAXIMUM_AGE); age++) {
			int ageSquared = age * age;
			if (((ageSquared - age) > MINIMUM_YEAR) && ((age + ageSquared) < MAXIMUM_YEAR)) {
				System.out.println("They are " + age + " years old in the year " + ageSquared);
				
			}
		}
		

	}

}
