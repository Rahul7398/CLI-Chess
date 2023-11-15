package Recommendation;

import java.util.ArrayList;
import java.util.List;

public class KingRecommend implements Recommend{
    @Override
    public List<int[]> available(int y, int x) {
        // TODO Auto-generated method stub
        List<int[]> res = new ArrayList<>();
        
        res.add(new int[]{y+1,x+1});
        res.add(new int[]{y+1,x-1});
        res.add(new int[]{y-1,x+1});
        res.add(new int[]{y-1,x-1});

        res.add(new int[]{y-1,x});
        res.add(new int[]{y+1,x});
        res.add(new int[]{y,x+1});
        res.add(new int[]{y,x-1});
        
        return res;
    }
    @Override
    public List<List<int[]>> availableList(int y, int x) {
        List<List<int[]>> res = new ArrayList<List<int[]>>();
        List<int[]> tl = new ArrayList<>();
        List<int[]> tr = new ArrayList<>();
        List<int[]> bl = new ArrayList<>();
        List<int[]> br = new ArrayList<>();

        List<int[]> t = new ArrayList<>();
        List<int[]> b = new ArrayList<>();
        List<int[]> l = new ArrayList<>();
        List<int[]> r = new ArrayList<>();

        tl.add(new int[]{y-1,x-1});
        tr.add(new int[]{y-1,x+1});
        bl.add(new int[]{y+1,x-1});
        br.add(new int[]{y+1,x+1});

        t.add(new int[]{y-1,x});
        b.add(new int[]{y+1,x});
        r.add(new int[]{y,x+1});
        l.add(new int[]{y,x-1});

        res.add(tl);
        res.add(tr);
        res.add(bl);
        res.add(br);

        res.add(t);
        res.add(b);
        res.add(l);
        res.add(r);

        return res;
    }
    
}
