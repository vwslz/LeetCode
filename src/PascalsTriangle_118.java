import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> pre = null;
        for(int i = 0; i < numRows; i++){
            List<Integer> line = new ArrayList<Integer>();
            line.add(1);
            for(int j = 1; j < i; j++)
                line.add(pre.get(j-1) + pre.get(j));
            if(i > 0)
                line.add(i,1);
            res.add(pre = line);
        }
        return res;
    }
}
