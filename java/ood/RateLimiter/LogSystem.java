package RateLimiter;
//635 design log storage system

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

// boolean allowRequest(userId, timestamp)  每个用户每 60 秒最多 5 次请求
// 你需要考虑

// Sliding window 还是 fixed window？

// 用 Queue 存时间戳

// 每次请求清理过期时间


public class LogSystem {
    //在60s内每个id最多100次数请求
    Long timeWindow=60000L;
    int limit=100;
    ConcurrentHashMap<String, Queue<Long>> map = new ConcurrentHashMap<>();
    boolean allow(String userId, long timestampMs){
        Queue<Long> q = map.computeIfAbsent(userId, f->new ArrayDeque<>());

        synchronized(q) {
            Long start = timestampMs-timeWindow;
            while(!q.isEmpty()&&q.peek()<=start) {
                q.poll();
            }

            if(q.size()>=limit) return false;
            q.offer(timestampMs);
            return true;
        }
    
    }
}
