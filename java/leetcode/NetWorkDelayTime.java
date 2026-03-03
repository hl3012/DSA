import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetWorkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        //create graph <node, {nextnode, weight}>
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int[] time: times) {
            graph.computeIfAbsent(time[0], x->new ArrayList<>())
                .add(new int[]{time[1], time[2]});
        }

        //map to record the min dist map<node, dist>
        Map<Integer, Integer> dist = new HashMap<>();

        //have minHeap to poll the min dist from start node to curr// int[]{node, dist}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0], time = curr[1];

            if (dist.containsKey(node)) continue;

            dist.put(node, time);

            if(graph.containsKey(node)) {
                for(int[] edge: graph.get(node)) {
                    int nextNode = edge[0], travelTime = edge[1];

                    if (!dist.containsKey(nextNode)) {
                        pq.offer(new int[]{nextNode, travelTime+time});
                    }
                }
            }            
        }

        return dist.size()==n? Collections.max(dist.values()): -1;







        // //create graph (node, {nextNode, weight})
        // Map<Integer, List<int[]>> graph = new HashMap<>();
        // for(int[] time: times) {
        //     graph.computeIfAbsent(time[0], x->new ArrayList<>())
        //     .add(new int[]{time[1], time[2]});
        // }

        // //record min dist from start <node, dist>
        // Map<Integer, Integer> dist = new HashMap<>();

        // //minHeap to poll the min dist
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->a[1]-b[1]);
        // pq.offer(new int[]{k, 0});
        // while(!pq.isEmpty()) {
        //     int[] curr = pq.poll();
        //     int node = curr[0], time = curr[1];

        //     //min dist has alreay exist
        //     if (dist.containsKey(node)) continue;

        //     dist.put(node, time);

        //     //about the next node
        //     if (graph.containsKey(node)) {
        //         for (int[] edge: graph.get(node)) {
        //             int nextNode = edge[0], travelTime = edge[1];
        //             if (!dist.containsKey(nextNode)) {
        //                 pq.offer(new int[]{nextNode, time + travelTime});
        //             }
        //         }
        //     }

        // }
        // return dist.size()==n? Collections.max(dist.values()): -1;
    }


//     class Solution {
//     public int networkDelayTime(int[][] times, int n, int k) {
//         // 构建邻接表 - 空间 O(E)
//         List<int[]>[] graph = new ArrayList[n + 1];
//         for (int i = 1; i <= n; i++) {
//             graph[i] = new ArrayList<>();
//         }
//         for (int[] time : times) {
//             int u = time[0], v = time[1], w = time[2];
//             graph[u].add(new int[]{v, w});
//         }
        
//         // 距离数组 - 空间 O(V)
//         int[] dist = new int[n + 1];
//         Arrays.fill(dist, Integer.MAX_VALUE);
//         dist[k] = 0;
        
//         // 优先队列 - 最多包含 V 个节点
//         PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
//         pq.offer(new int[]{k, 0});
        
//         while (!pq.isEmpty()) {
//             int[] curr = pq.poll();
//             int node = curr[0], time = curr[1];
            
//             // 如果当前距离大于已知最短距离，跳过
//             if (time > dist[node]) continue;
            
//             // 遍历邻居节点
//             for (int[] edge : graph[node]) {
//                 int neighbor = edge[0], travelTime = edge[1];
//                 int newTime = time + travelTime;
                
//                 // 找到更短路径
//                 if (newTime < dist[neighbor]) {
//                     dist[neighbor] = newTime;
//                     pq.offer(new int[]{neighbor, newTime});
//                 }
//             }
//         }
        
//         // 计算最大延迟时间
//         int maxTime = 0;
//         for (int i = 1; i <= n; i++) {
//             if (dist[i] == Integer.MAX_VALUE) return -1;
//             maxTime = Math.max(maxTime, dist[i]);
//         }
        
//         return maxTime;
//     }
// }
}
