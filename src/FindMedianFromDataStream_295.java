import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream_295 {
    /** initialize your data structure here. */
    /** initialize your data structure here. */
    private Queue<Integer> maxH;
    private Queue<Integer> minH;

    public FindMedianFromDataStream_295() {
        maxH = new PriorityQueue<>(Collections.reverseOrder());
        minH = new PriorityQueue<>();
    }

    public void addNum(int num) {
        minH.offer(num);
        maxH.offer(minH.poll());
        if (maxH.size() > minH.size())
            minH.offer(maxH.poll());
    }

    public double findMedian() {
        if (minH.size() > maxH.size())
            return minH.peek();
        else
            return (minH.peek() + maxH.peek()) / 2.0;
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
}
