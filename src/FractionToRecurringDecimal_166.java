import java.util.HashMap;

public class FractionToRecurringDecimal_166 {
    public String fractionToDecimal(int numerator, int denominator) {
        boolean isNeg = (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0);
        StringBuilder res = new StringBuilder(isNeg ? "-" : "");

        long longNumerator = (long)numerator;
        long longDenominator = (long)denominator;
        if (longNumerator < 0)
            longNumerator = -longNumerator;
        if (longDenominator < 0)
            longDenominator = -longDenominator;

        long integer = longNumerator / longDenominator;
        long fraction = longNumerator - integer * longDenominator;
        res.append(integer);
        if (fraction == 0)
            return res.toString();
        else
        {
            res.append(".");
            HashMap<Long, Integer> digits = new HashMap<Long, Integer>();
            while (fraction != 0)
            {
                if (digits.containsKey(fraction)) {
                    res.insert(digits.get(fraction) - 1, "(");
                    res.append(")");
                    break;
                }
                long digit = fraction * 10 / longDenominator;
                res.append(digit);
                digits.put(fraction, res.length());
                fraction = (fraction * 10 - digit * longDenominator);
            }
            return res.toString();
        }
    }
}
