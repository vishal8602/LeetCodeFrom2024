package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int inDegree[]=new int[n];
        Map<Integer,List<Integer>> graph=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            inDegree[edges[i][1]]++;
            graph.putIfAbsent(edges[i][0],new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
        }
        Map<Integer,Set<Integer>> map=new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        while (!queue.isEmpty()){
            Integer front=queue.poll();
            map.putIfAbsent(front, new HashSet<>());
            if (!graph.containsKey(front)) continue;
            for(int neighbor:graph.get(front)){
                inDegree[neighbor]--;
                map.putIfAbsent(neighbor, new HashSet<>());
                map.get(neighbor).add(front);
                map.get(neighbor).addAll(map.get(front));
                if(inDegree[neighbor]==0){
                    queue.add(neighbor);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> ancestors = new ArrayList<>(map.getOrDefault(i, new HashSet<>()));
            Collections.sort(ancestors);
            result.add(ancestors);
        }
        
        return result;
    }
}