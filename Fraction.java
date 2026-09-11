public class Fraction implements Comparable<Fraction>{
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

    public double doubleValue() {
    return (double) numerator / denominator;
    }

    public Fraction add(Fraction other) {
    int sumNumerator =
            this.numerator * other.denominator
            + other.numerator * this.denominator;
    int sumDenominator = this.denominator * other.denominator;

    return new Fraction(sumNumerator, sumDenominator);
    }
    
    @Override
    public int compareTo(Fraction other) {
    long thisNumerator = numerator;
    long thisDenominator = denominator;
    long otherNumerator = other.numerator;
    long otherDenominator = other.denominator;

    if (thisDenominator < 0) {
        thisNumerator = -thisNumerator;
        thisDenominator = -thisDenominator;
    }

    if (otherDenominator < 0) {
        otherNumerator = -otherNumerator;
        otherDenominator = -otherDenominator;
    }

    return Long.compare(
            thisNumerator * otherDenominator,
            otherNumerator * thisDenominator);
    }

    @Override
    public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (!(obj instanceof Fraction)) {
        return false;
    }

    Fraction other = (Fraction) obj;
    return (long) numerator * other.denominator
            == (long) other.numerator * denominator;
    }

    @Override
    public int hashCode() {
    long n = numerator;
    long d = denominator;

    // Placer le signe dans le numérateur.
    if (d < 0) {
        n = -n;
        d = -d;
    }

    // Calculer le PGCD pour obtenir une forme réduite.
    long a = Math.abs(n);
    long b = d;
    while (b != 0) {
        long remainder = a % b;
        a = b;
        b = remainder;
    }

    n /= a;
    d /= a;

    return 31 * Long.hashCode(n) + Long.hashCode(d);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}