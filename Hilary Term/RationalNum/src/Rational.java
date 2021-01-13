class Rational {
    private int numerator;
    private int denominator;

    Rational() {
        numerator = 0;
        denominator = 1;
    }

    Rational (int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero.");
        } else {
            this.denominator = denominator;
        }
    }

    public String getRational() {
        return numerator + "/" + denominator;
    }
    

    
    public String add(Rational otherRational) {
       
        int a = this.numerator;
        int b = this.denominator;
        int c = otherRational.numerator;
        int d = otherRational.denominator;
        return ((a*d) + (c*b)) + "/" + (b*d);
    }

    public String subtract(Rational otherRational) {
        
        int a = this.numerator;
        int b = this.denominator;
        int c = otherRational.numerator;
        int d = otherRational.denominator;
        return ((a*d) - (c*b)) + "/" + (b*d);
    }

    public String multiply(Rational otherRational) {
       
        int a = this.numerator;
        int b = this.denominator;
        int c = otherRational.numerator;
        int d = otherRational.denominator;
        return (a*c) + "/" + (b*d);
    }

    public String divide(Rational otherRational) {
       
        int a = this.numerator;
        int b = this.denominator;
        int c = otherRational.numerator;
        int d = otherRational.denominator;
        return (a*d) + "/" + (b*c);
    }
    public boolean equals(Rational otherRational){
        if (this.numerator / this.denominator == otherRational.numerator / otherRational.denominator){
        	
        	return(true);
                }
        else {
        return(false);
            }
        }
    public boolean isLessThan(Rational otherRational){
        if (((this.numerator / this.denominator) <= (otherRational.numerator / otherRational.denominator))){
        return false;
        }
       
        else{
        return true;
            }    
        }
    static int gcd(int x, int y){
        int r;
        while (y != 0) {
        r = x % y;
        x = y;
        y = r;
            }
        return x;
        }
    public String simplify(Rational otherRational){
        int divisor;
        divisor = Rational.gcd(numerator, denominator);
        numerator = this.numerator / divisor;
        denominator = denominator / divisor;
        return numerator + "/" + denominator;
        }
}



