// O(log n)
public class HIndexII_275 {
    public int hIndex(int[] citations) {
        int l = 0;
        int r = citations.length - 1;
        int res = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            int h1 = citations[mid];
            int h2 = citations.length - mid;
            if (h1 < h2)
                l = mid + 1;
            else if (h1 >= h2) {
                res = h2;
                r = mid - 1;
            }
        }

        return res;
    }
}
