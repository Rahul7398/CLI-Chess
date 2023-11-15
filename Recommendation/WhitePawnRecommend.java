package Recommendation;

import java.util.ArrayList;
import java.util.List;

public class WhitePawnRecommend implements Recommend{
    
    public boolean first = true;
    @Override
    public List<int[]> available(int y, int x) {
        // TODO Auto-generated method stub
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{y-1,x});
        res.add(new int[]{y-1,x-1});
        res.add(new int[]{y-1,x+1});
        if(first){
            res.add(new int[]{y-2,x});
        }
        return res;
    }
    @Override
    public List<List<int[]>> availableList(int y, int x) {
        List<List<int[]>> res = new ArrayList<List<int[]>>();
        List<int[]> u = new ArrayList<>();
        List<int[]> uu = new ArrayList<>();
        List<int[]> tr = new ArrayList<>();
        List<int[]> tl = new ArrayList<>();
        u.add(new int[]{y-1,x});
        tr.add(new int[]{y-1,x+1});
        tl.add(new int[]{y-1,x-1});
        if(first){
            uu.add(new int[]{y-2,x});
        }
        res.add(u);
        res.add(uu);
        res.add(tl);
        res.add(tr);
        return res;
    }
    
}
