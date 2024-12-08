package numericalMethods;

public class Antidifferencing {
    public static void main(String[] args) {
        for (int m = 0; m <= 20; m++) {
            System.out.println("Antidifference of x^(-" + m + ") = " + antidifferentiate(m));
        }
    }

    public static String antidifferentiate(int m) {
        if (m == 0) {
            return "ln|x| + C";
        } else {
            return "x^(" + (-m + 1) + ") / " + (-m + 1) + " + C";
        }
    }
}