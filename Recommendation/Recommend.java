package Recommendation;
import java.util.List;
public interface Recommend {
    public List<int[]> available(int y, int x);
    public List<List<int[]>> availableList(int y, int x);
}
