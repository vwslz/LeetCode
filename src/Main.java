import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        BasicCalculator_224 test = new BasicCalculator_224();
        System.out.println(test.calculate("1 + 1"));
        System.out.println(test.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(test.calculate("2-(5-6) + (4 - 6)"));

    }
}