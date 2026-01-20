import java.util.*;
public class TopKFrequentElements {
    public static int[] topK(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        // List<ArrayList<Integer>> buckets= new ArrayList<>(nums.length+1);
        // for(int i=0; i<=nums.length;i++) {
        //     buckets.add(new ArrayList<>());
        // }

        // for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
        //     buckets.get(entry.getValue()).add(entry.getKey());
        // }

        // int[] res= new int[k];
        // int idx=0;
        // for (int i=buckets.size()-1;i>=0;i--) {
        //     ArrayList<Integer> b= buckets.get(i);
        //     for (int num: b) {
        //         res[idx++]=num;
        //         if (idx==k) return res;
        //     }
        // }
        // return res;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->map.get(a)-map.get(b)); //min 默认最小堆，这里也是最小堆，但是根据freq比较的
        for (int key: map.keySet()) {
            pq.offer(key);
            if (pq.size()>k) pq.poll();
        }
        
        int[] res=new int[k];
        for (int i=0;i<k;i++) {
            res[i]=pq.poll();
        }
        return res;
    }
}