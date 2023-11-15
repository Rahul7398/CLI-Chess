package Recommendation;

import java.util.ArrayList;
import java.util.List;

public class RookRecommend implements Recommend{

    @Override
    public List<int[]> available(int y, int x) {
        // TODO Auto-generated method stub
        List<int[]> res = new ArrayList<>();
        for(int i=1;i<=8;i++){
            res.add(new int[]{y+i,x});
            res.add(new int[]{y-i,x});
            res.add(new int[]{y,x+i});
            res.add(new int[]{y,x-i});
        }
        return res;
    }
    
    @Override
    public List<List<int[]>> availableList(int y, int x) {
        List<List<int[]>> res = new ArrayList<List<int[]>>();
        List<int[]> t = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        List<int[]> l = new ArrayList<>();
        List<int[]> r = new ArrayList<>();
        for(int i=1;i<=8;i++)
            t.add(new int[]{y-i,x});
        for(int i=1;i<=8;i++)
            b.add(new int[]{y+i,x});
        for(int i=1;i<=8;i++)
            l.add(new int[]{y,x-i});
        for(int i=1;i<=8;i++)
            r.add(new int[]{y,x+i});
        res.add(t);
        res.add(b);
        res.add(l);
        res.add(r);
        return res;
    }

    
    
}
