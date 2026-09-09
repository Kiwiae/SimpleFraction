public class Main {
    public static void main(String[] args) {
        Fraction fraction = new Fraction();

        assert "Je suis une fraction.".equals(fraction.toString())
                : "Résultat incorrect pour toString";

        System.out.println(fraction);
        System.out.println("Test réussi.");
    }
}