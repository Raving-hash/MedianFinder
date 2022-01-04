import java.util.ArrayList;
import java.util.Comparator;

class MedianFinder {
    private ArrayList<Integer> list;
    /** initialize your data structure here. */
    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        list.add(num);
        list.sort(Comparator.comparingInt(v -> v));
    }

    public double findMedian() {
       if (list.isEmpty()){
           return 0;
       }
       return  (list.size() & 1) == 1 ? list.get(list.size() / 2) :
               (list.get(list.size() / 2 - 1) + list.get(list.size()/2)) / 2.0;
    }



    public static void main(String[] args) {
        MedianFinder me = new MedianFinder();
        me.addNum(1);
        me.addNum(3);
        me.findMedian();
        me.addNum(2);
        me.findMedian();
    }
}
