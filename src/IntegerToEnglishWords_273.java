public class IntegerToEnglishWords_273 {
    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        String[] pre = new String[]{"", " Thousand", " Million", " Billion"};
        String res = "";
        int cnt = 0;
        while (num > 0) {
            if (num % 1000 != 0)
                res = numberToWordsThreeDigits(num % 1000) + pre[cnt] + res;
            cnt++;
            num = num / 1000;
        }
        return res.trim();
    }

    public String numberToWordsThreeDigits(int num) {
        if (num >= 100)
            return numberToWordsOneDigit(num / 100) + " Hundred" + numberToWordsTwoDigits(num % 100);
        else
            return numberToWordsTwoDigits(num % 100);
    }

    public String numberToWordsTwoDigits(int num) {
        if (num >= 90)
            return " Ninety" + numberToWordsOneDigit(num % 10);
        else if (num >= 80)
            return " Eighty" + numberToWordsOneDigit(num % 10);
        else if (num >= 70)
            return " Seventy" + numberToWordsOneDigit(num % 10);
        else if (num >= 60)
            return " Sixty" + numberToWordsOneDigit(num % 10);
        else if (num >= 50)
            return " Fifty" + numberToWordsOneDigit(num % 10);
        else if (num >= 40)
            return " Forty" + numberToWordsOneDigit(num % 10);
        else if (num >= 30)
            return " Thirty" + numberToWordsOneDigit(num % 10);
        else if (num >= 20)
            return " Twenty" + numberToWordsOneDigit(num % 10);
        else if (num >= 10) {
            if (num == 10)
                return " Ten";
            else if (num == 11)
                return " Eleven";
            else if (num == 12)
                return " Twelve";
            else if (num == 13)
                return " Thirteen";
            else if (num == 14)
                return " Fourteen";
            else if (num == 15)
                return " Fifteen";
            else if (num == 16)
                return " Sixteen";
            else if (num == 17)
                return " Seventeen";
            else if (num == 18)
                return " Eighteen";
            else if (num == 19)
                return " Nineteen";
            else
                return "";
        }
        else
            return numberToWordsOneDigit(num);
    }

    public String numberToWordsOneDigit(int num) {
        if (num == 1)
            return " One";
        else if (num == 2)
            return " Two";
        else if (num == 3)
            return " Three";
        else if (num == 4)
            return " Four";
        else if (num == 5)
            return " Five";
        else if (num == 6)
            return " Six";
        else if (num == 7)
            return " Seven";
        else if (num == 8)
            return " Eight";
        else if (num == 9)
            return " Nine";
        else
            return "";
    }
}
