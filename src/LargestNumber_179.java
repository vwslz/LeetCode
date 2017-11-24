import java.util.Arrays;

public class LargestNumber_179 {
    public String largestNumber(int[] nums) {
        if (nums.length == 0)
            return "";
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strNums[i] = String.valueOf(nums[i]);
        largestNumberSort(strNums, 0, nums.length - 1);

        StringBuilder res = new StringBuilder("");
        for (String s: strNums) {
            if (!(res.toString().isEmpty() && s.equals("0")))
                res.append(s);
        }
        if (res.toString().isEmpty())
            return "0";
        else
            return res.toString();
    }

    public void largestNumberSort(String[] strNums, int left, int right)
    {
        if (left < right)
        {
            int middle = (left + right) / 2;
            largestNumberSort(strNums, left, middle);
            largestNumberSort(strNums, middle + 1, right);
            largestNumbermerge(strNums, left, middle, right);
        }
    }

    public void largestNumbermerge(String[] strNums, int left, int middle, int right)
    {
        int lenLeft = middle - left + 1;
        int lenRight = right - middle;
        String[] lefts = new String[lenLeft];
        String[] rights = new String[lenRight];

        for (int i = 0; i < lenLeft; i++)
            lefts[i] = strNums[left + i];
        for (int i = 0; i < lenRight; i++)
            rights[i] = strNums[middle + 1+ i];

        int iLeft= 0, iRight = 0;

        int iArr = left;
        while (iLeft < lenLeft && iRight < lenRight)
        {
            if (largestNumberCompare(lefts[iLeft], rights[iRight]))
                strNums[iArr++] = lefts[iLeft++];
            else
                strNums[iArr++] = rights[iRight++];
        }

        while (iLeft < lenLeft)
            strNums[iArr++] = lefts[iLeft++];

        while (iRight < lenRight)
            strNums[iArr++] = rights[iRight++];
    }

    public boolean largestNumberCompare(String str1, String str2)
    {
        int len = str1.length() > str2.length() ? str1.length() : str2.length();
        char char1;
        char char2;
        int index = 0;
        while (index < str1.length() + str2.length())
        {
            char1 = str1.charAt(index % str1.length());
            char2 = str2.charAt(index % str2.length());

            if (char1 != char2)
                return char1 > char2;
            index++;
        }
        return str1.length() <= str2.length();
    }
}
