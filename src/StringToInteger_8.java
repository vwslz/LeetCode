// O(n)

public class StringToInteger_8 {
    public int myAtoi(String str) {
        double value = 0;
        int index = -1, i;
        boolean isNeg = false;
        char[] arr = str.toCharArray();

        for (i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                if (arr[i] == '-' || arr[i] == '+') {
                    if (arr[i] == '-')  isNeg = true;
                    index = i + 1;
                    break;
                }
                else if (arr[i] >= '0' && arr[i] <= '9') {
                    index = i;
                    break;
                }
                else
                    return 0;
            }
        }

        if (index == -1)    return 0;

        for(i = index; i < arr.length; i++){
            if (arr[i] >= '0' && arr[i] <= '9') value = value * 10 + (arr[i] - '0');
            else    break;
        }

        if(isNeg == true){
            value *= -1;
        }

        if(value > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(value < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int)value;
    }
}
