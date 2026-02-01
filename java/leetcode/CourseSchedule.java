import java.util.*;

public class CourseSchedule {
    private Map<Integer, List<Integer>> preMap=new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // List<List<Integer>> adj = new ArrayList<>();
        // int[] indegree = new int[numCourses];

        // for (int i=0;i<numCourses;i++) {
        //     adj.add(new ArrayList<>());
        // }

        // for (int[] pre: prerequisites) {
        //     int preC = pre[1];
        //     int curC = pre[0];
        //     adj.get(preC).add(curC);
        //     indegree[curC]++;
        // }

        // Queue<Integer> q = new LinkedList<>();
        // for (int i=0;i<numCourses;i++) {
        //     if (indegree[i]==0) {
        //         q.offer(i);
        //     }
        // }

        // int finish =0;
        // while (!q.isEmpty()) {
        //     int node = q.poll();
        //     finish++;
        //     List<Integer> neighbors = adj.get(node);
        //     for (int n: neighbors) {
        //         indegree[n]--;
        //         if(indegree[n]==0) {
        //             q.offer(n);
        //         }
        //     }
        // }
        // return finish==numCourses;
        for (int i=0; i<numCourses;i++) {
            preMap.put(i, new ArrayList<>());
        }
        for (int[] pres: prerequisites) {
            preMap.get(pres[1]).add(pres[0]);
        }

        for (int c=0;c<numCourses;c++) {
            if(!dfs(c)) {
                return false;
            }
        }
        return true;

    }

    private boolean dfs(int i) {
        if (visited.contains(i)) {return false;}
        if (preMap.get(i).isEmpty()) {
            return true;
        }
        visited.add(i);
        for (int pre : preMap.get(i)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visited.remove(i);
        preMap.put(i, new ArrayList<>());
        return true;
    }
}