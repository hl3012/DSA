import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;

    public FindMedianFromDataStream() {
        maxheap=new PriorityQueue<>((a,b)->(b-a));
        minheap=new PriorityQueue<>();
    }

    void addNum(int num) {
        if(maxheap.isEmpty()||maxheap.peek()>num) {
            maxheap.offer(num);
        } else {
            minheap.offer(num);
        }
        if (maxheap.size()>minheap.size()+1) {
            minheap.offer(maxheap.poll());
        } else if (minheap.size()>minheap.size()) {
            minheap.offer(minheap.poll());
        }

    }

    double findMedian() {
        if (maxheap.size()>minheap.size()) {
            return maxheap.peek();
        }
        return (minheap.peek()+maxheap.peek())/2;
    }
}
