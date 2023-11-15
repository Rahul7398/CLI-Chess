package Recommendation;
import java.util.ArrayList;
import java.util.List;

public class KnightRecommend implements Recommend{

    @Override
    public List<int[]> available(int y, int x) {
        // TODO Auto-generated method stub
        int[] dy = new int[]{-2,0,2,0};
        int[] dx = new int[]{0,2,0,-2};
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<4;i++){
            if(dx[i]==0){
                res.add(new int[]{y+dy[i],x-1});
                res.add(new int[]{y+dy[i],x+1});
            }
            else{
                res.add(new int[]{y+1,x+dx[i]});
                res.add(new int[]{y-1,x+dx[i]});
            }
        }
        return res;
    }
    @Override
    public List<List<int[]>> availableList(int y, int x) {
        List<List<int[]>> res = new ArrayList<List<int[]>>();
        List<int[]> tl = new ArrayList<>();
        List<int[]> tr = new ArrayList<>();
        List<int[]> bl = new ArrayList<>();
        List<int[]> br = new ArrayList<>();

        List<int[]> lt = new ArrayList<>();
        List<int[]> lb = new ArrayList<>();
        List<int[]> rt = new ArrayList<>();
        List<int[]> rb = new ArrayList<>();

        tl.add(new int[]{y-2,x-1});
        tr.add(new int[]{y-2,x+1});
        bl.add(new int[]{y+2,x-1});
        br.add(new int[]{y+2,x+1});

        lt.add(new int[]{y-1,x-2});
        lb.add(new int[]{y+1,x-2});
        rt.add(new int[]{y-1,x+2});
        rb.add(new int[]{y+1,x+2});

        res.add(tl);
        res.add(tr);
        res.add(bl);
        res.add(br);

        res.add(lt);
        res.add(lb);
        res.add(rt);
        res.add(rb);

        return res;
    }
    
    
}
