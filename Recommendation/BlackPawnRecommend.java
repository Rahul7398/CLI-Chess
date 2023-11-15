package Recommendation;

import java.util.ArrayList;
import java.util.List;

public class BlackPawnRecommend implements Recommend{
    
    public boolean first = true;
    @Override
    public List<int[]> available(int y, int x) {
        // TODO Auto-generated method stub
        List<int[]> res = new ArrayList<>();
        res.add(new int[]{y+1,x});
        res.add(new int[]{y+1,x-1});
        res.add(new int[]{y+1,x+1});
        if(first){
            res.add(new int[]{y+2,x});
        }
        return res;
    }
    @Override
    public List<List<int[]>> availableList(int y, int x) {
        List<List<int[]>> res = new ArrayList<List<int[]>>();
        List<int[]> d = new ArrayList<>();
        List<int[]> dd = new ArrayList<>();
        List<int[]> br = new ArrayList<>();
        List<int[]> bl = new ArrayList<>();
        d.add(new int[]{y+1,x});
        br.add(new int[]{y+1,x+1});
        bl.add(new int[]{y+1,x-1});
        if(first){
            dd.add(new int[]{y+2,x});
        }
        res.add(d);
        res.add(dd);
        res.add(bl);
        res.add(br);
        return res;
    }
    
}
