import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        long pre = 1;
        for(int i = 1; i <= rowIndex; i++){
            pre = pre * (rowIndex - i + 1) / i;
            res.add((int)pre);
        }
        return res;
    }
}
