import java.util.HashMap;

public class HappyNumber_202 {
    public boolean isHappy(int n) {
        HashMap hash = new HashMap();
        while(n != 1){
            n = isHappy_rec(n);
            if(hash.containsKey(n))
                return false;
            hash.put(n, 0);
        }
        return true;
    }

    public int isHappy_rec(int n){
        if(n == 0)
            return 0;
        return (n%10)*(n%10) + isHappy_rec(n/10);
    }
}
