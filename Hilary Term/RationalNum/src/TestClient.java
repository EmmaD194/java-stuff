import java.util.Scanner;
class TestClient {
    public static void main(String[] args) {
    	
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Enter first fraction separated by a space eg. enter '1 2' for 1/2");
    	int numerator1 = scanner.nextInt();
    	int denominator1 = scanner.nextInt();
    	System.out.println("Enter second fraction separated by a space eg. enter '1 2' for 1/2");
    	int numerator2 = scanner.nextInt();
    	int denominator2 = scanner.nextInt();
    	scanner.close();
    	
    	Rational fraction1 = new Rational(numerator1,denominator1);
    	Rational fraction2 = new Rational(numerator2,denominator2);

        System.out.println("F1: " + fraction1.getRational());
        System.out.println("F2: " + fraction2.getRational() );
        System.out.println("F1 + F2: " + fraction1.add(fraction1));
        System.out.println("F2 + F1: " + fraction2.add(fraction1) );
        System.out.println("F1 - F2: " + fraction1.subtract(fraction2));
        System.out.println("F2 - F1: " + fraction2.subtract(fraction1) );
        System.out.println("F1 * F2: " + fraction1.multiply(fraction2));
        System.out.println("F2 * F1: " + fraction2.multiply(fraction1) );
        System.out.println("F1 / F2: " + fraction1.divide(fraction2));
        System.out.println("F2 / F1: " + fraction2.divide(fraction1));
        System.out.println("Is F2 = F1 ? : " + fraction1.equals(fraction1));
        
        System.out.println("Is F2 < F1 ? : " + fraction1.isLessThan(fraction1));
        System.out.println("F1 simplified is " + fraction1.simplify(fraction1));
        System.out.println("F2 simplified is " + fraction2.simplify(fraction2));
    	
    	
    }
}