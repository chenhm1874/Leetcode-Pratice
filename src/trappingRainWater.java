import java.util.ArrayDeque;
import java.util.Deque;

public class trappingRainWater {
    public static int trappingRainWater(int[] heights){
        //单调栈方法
        int water = 0;
        Deque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < heights.length; i++) {
            while (!queue.isEmpty() && heights[i] > heights[queue.peekLast()]) {
                int j = queue.pollLast();
                if (!queue.isEmpty()) {
                    int w = i - queue.peekLast() - 1;
                    water += w * (Math.min(heights[i], heights[queue.peekLast()]) - heights[j]);
                }
            }
            queue.offer(i);
        }
        return water;
    }
}
