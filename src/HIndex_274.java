import java.util.Arrays;
// O(m)
public class HIndex_274 {
    public int hIndex(int[] citations) {
        int[] counts = new int[citations.length + 1];

        for (int citation: citations) {
            if (citation > citations.length)
                counts[citations.length]++;
            else
                counts[citation]++;
        }

        for (int i = citations.length; i >= 1; i--) {
            counts[i - 1] += counts[i];
            if (counts[i] >= i)
                return i;
        }

        return 0;
    }
}
