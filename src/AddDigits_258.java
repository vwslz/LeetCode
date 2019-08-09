public class AddDigits_258 {
    public int addDigits(int num) {
        //return (num-1)%9+1;
        if(num == 0) return 0;
        int res = num%9;
        return res == 0 ? 9 : res;
    }
}
