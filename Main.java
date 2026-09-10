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

        System.out.println("Tous les tests ont réussi.");
    }
}