public class Main {
    public static void main(String[] args) {
        assert "3/4".equals(new Fraction(3, 4).toString());
        assert "5/1".equals(new Fraction(5).toString());
        assert "0/1".equals(new Fraction().toString());

        boolean zeroDenominatorRejected = false;
        try {
            new Fraction(1, 0);
        } catch (IllegalArgumentException e) {
            zeroDenominatorRejected = true;
        }
        assert zeroDenominatorRejected
                : "Un dénominateur nul doit être refusé.";

        assert "0/1".equals(Fraction.ZERO.toString());
        assert "1/1".equals(Fraction.UN.toString());

        Fraction fractionToTest = new Fraction(3, 4);
        assert fractionToTest.getNumerator() == 3;
        assert fractionToTest.getDenominator() == 4;

        assert new Fraction().getNumerator() == 0;
        assert new Fraction().getDenominator() == 1;
        assert Math.abs(new Fraction(3, 4).doubleValue() - 0.75) < 1E-8;
        assert Math.abs(new Fraction(1, 3).doubleValue() - 1.0 / 3.0) < 1E-8;
        assert Math.abs(new Fraction(-1, 2).doubleValue() + 0.5) < 1E-8;
        assert new Fraction().doubleValue() == 0.0;


        Fraction left = new Fraction(1, 2);
        Fraction right = new Fraction(1, 3);
        Fraction sum = left.add(right);

        assert sum.getNumerator() == 5;
        assert sum.getDenominator() == 6;

        // Vérifier que les fractions initiales ne sont pas modifiées.
        assert "1/2".equals(left.toString());
        assert "1/3".equals(right.toString());

        assert "3/4".equals(new Fraction(3, 4).add(Fraction.ZERO).toString());
        assert new Fraction(1, 2).add(new Fraction(-1, 2))
         .getNumerator() == 0;

        Fraction half = new Fraction(1, 2);
        Fraction equivalentHalf = new Fraction(2, 4);

        assert half.equals(half);
        assert half.equals(equivalentHalf);
        assert equivalentHalf.equals(half);

        assert new Fraction(-1, 2).equals(new Fraction(1, -2));
        assert new Fraction(-1, -2).equals(half);
        assert new Fraction(0, 5).equals(Fraction.ZERO);

        assert !half.equals(new Fraction(1, 3));
        assert !half.equals(null);
        assert !half.equals("1/2");

        assert half.hashCode() == equivalentHalf.hashCode();

        assert new Fraction(1, 3)
                .compareTo(new Fraction(1, 2)) < 0;
        assert new Fraction(3, 4)
                .compareTo(new Fraction(1, 2)) > 0;
        assert new Fraction(1, 2)
                .compareTo(new Fraction(2, 4)) == 0;
        assert new Fraction(-1, 2)
                .compareTo(Fraction.ZERO) < 0;
        assert new Fraction(1, -2)
                .compareTo(new Fraction(1, 3)) < 0;
        assert new Fraction(-1, -2)
                .compareTo(new Fraction(1, 2)) == 0;
        
        Number aNumber = java.math.BigDecimal.ONE;
        Number anotherNumber = new Fraction(1, 2);

        assert Math.abs(
            aNumber.doubleValue() + anotherNumber.doubleValue() - 1.5)
            < 1E-8;

        assert anotherNumber.intValue() == 0;
        assert anotherNumber.longValue() == 0L;
        assert Math.abs(anotherNumber.floatValue() - 0.5f) < 1E-6f;

        System.out.println("Tous les tests ont réussi.");
    }
}