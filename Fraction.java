public class Fraction {
    private int numerator;
    private int denominator;

    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction UN = new Fraction(1, 1);

    public Fraction(int numerator,int denominator){
        if(denominator==0){
            throw new IllegalArgumentException(
                "Le dénominateur ne peut pas être nul.");
        }
        this.numerator = numerator;
        this.denominator = denominator;
        
    }

    public Fraction(int numerator) {
        this(numerator, 1);
    }

    public Fraction() {
        this(0, 1);
    }

    public int getNumerator() {
    return numerator;
    }

    public int getDenominator() {
    return denominator;
    }
    
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}