package myCW2;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction(int num, int denom) {
        if(denom < 0){
            denom = Math.abs(denom);
            num = -num;
        }
        if (denom == 0) {
            throw new IllegalArgumentException("Invalid fraction with denominator 0");
        }
        int gcd = myGcd(num, denom);
        setNumerator(num / gcd);
        setDenominator(denom / gcd);
    }

    public static Fraction parseFraction(String s){
        if(s.contains("/")){
            String[] vals = s.split("/");
            int num = Integer.parseInt(vals[0]);
            int denom = Integer.parseInt(vals[1]);
            return new Fraction(num,denom);
        }
        else{
            int num = Integer.parseInt(s);
            int denom = 1;
            return new Fraction(num,denom);
        }
    }
    
    @Override
    public String toString() {
        if(denominator == 1){
            return "" + getNumerator();
        }
        else{
            return "" + getNumerator() + '/' + getDenominator();
        }
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int num) {
        numerator = num;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int num) {
        denominator = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Fraction fraction = (Fraction) o;

        if (getDenominator() != fraction.getDenominator()) {
            return false;
        }
        if (getNumerator() != fraction.getNumerator()) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = numerator;
        result = 31 * result + denominator;
        return result;
    }

    public Fraction multiply(Fraction other) {
        int num = this.getNumerator() * other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }
    
    public Fraction add(Fraction other) {
        int num = this.getNumerator() * other.getDenominator() + this.getDenominator()*other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }
    public Fraction subtract(Fraction other) {
        int num = this.getNumerator() * other.getDenominator() - this.getDenominator()*other.getNumerator();
        int denom = this.getDenominator() * other.getDenominator();
        return new Fraction(num, denom);
    }
    
    public Fraction divide(Fraction other) {
        int num = this.getNumerator() * other.getDenominator();
        int denom = this.getDenominator() * other.getNumerator();
        return new Fraction(num, denom);
    }
    
    public Fraction abs(){
        int num = Math.abs(numerator);
        int denom = Math.abs(denominator);
        return new Fraction(num,denom);
    }
    
    public Fraction negate(){
        int num = -numerator;
        int denom = Math.abs(denominator);
        return new Fraction(num,denom);
    }
    
    private int myGcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
