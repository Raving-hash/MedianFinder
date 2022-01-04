import java.util.PriorityQueue;

class MedianFinder2 {
    private PriorityQueue<Integer> a = new PriorityQueue<>();       //小根堆，存储数据流后半部分，peek即为中位数较大的哪个
    private PriorityQueue<Integer> b = new PriorityQueue<>((v1,v2) -> v2 - v1);       //大根堆，存储数据流前半部分分，peek即为中位数较小的一个
    /** initialize your data structure here. */
    public MedianFinder2() {

    }

    public void addNum(int num) {
        if (a.size() != b.size()) {
            b.add(num);
            a.add(b.poll());
        } else {
            a.add(num);
            b.add(a.poll());
        }
    }

    public double findMedian() {
        if (b.isEmpty()){
            return 0;
        }
        return ((a.size() + b.size()) & 1) == 1? (double) b.peek(): (b.peek() + a.peek()) / 2.0;
    }



    public static void main(String[] args) {
        MedianFinder2 me = new MedianFinder2();
        me.addNum(1);
        me.addNum(2);
        double median = me.findMedian();
        me.addNum(3);
        double median1 = me.findMedian();
    }
}
