public class Candy_135 {
    public int candy(int[] ratings) {
        if (ratings.length == 0)
            return 0;

        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < ratings.length; i++)
            candy[i] = (ratings[i] > ratings[i-1]) ? candy[i] = candy[i-1] + 1: 1;
        int res = candy[ratings.length - 1];
        for (int i = ratings.length - 2; i > -1; i--) {
            if (ratings[i] > ratings[i+1] && candy[i+1] + 1 > candy[i])
                candy[i] = candy[i+1] + 1;
            res += candy[i];
        }
        return res;
    }
}
