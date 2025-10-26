import java.util.Collections;
import java.util.PriorityQueue;

class Heaps8 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int stone : stones) {
            maxHeap.add(stone);
        }
        
        while (maxHeap.size() > 1) {
            int y = maxHeap.poll(); // heaviest
            int x = maxHeap.poll(); // second heaviest
            
            if (y != x) {
                maxHeap.add(y - x);
            }
        }
        
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        Heaps8 obj = new Heaps8();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Last stone weight: " + obj.lastStoneWeight(stones));
    }
}
