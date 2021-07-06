package RomanArabicCalculatorJavaMentor;

public class ConverterForResult {

    enum ArabicToRoman {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100);

        int value;

        ArabicToRoman(int value) {
            this.value = value;
        }
    }

    public static String converterForResult(int number) {

        StringBuilder sb = new StringBuilder();

        ArabicToRoman[] values = ArabicToRoman.values();
        for (int i = values.length - 1; i >= 0; i--) {
            while (number >= values[i].value) {
                sb.append(values[i]);
                number -= values[i].value;
            }
        }
        return sb.toString();
    }
}
