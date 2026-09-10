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
        
        System.out.println("Tests des constructeurs réussis.");
    }
}