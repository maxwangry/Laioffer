package com.laioffer.lab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;

public class Bipartite {

    public class GraphNode {
        public int key;
        public List<GraphNode> neighbors;

        public GraphNode(int key) {
            this.key = key;
            this.neighbors = new ArrayList<>();
        }
    }

    public boolean isBipartite(List<GraphNode> graph) {
        if (graph == null || graph.size() <= 1) {
            return true;
        }

        HashMap<GraphNode, Integer> visited = new HashMap<>();
        for (GraphNode node : graph) {
            if (!BFS(node, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean BFS(GraphNode node, HashMap<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        visited.put(node, 0);
        Queue<GraphNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()) {
            GraphNode curr = queue.poll();
            Integer currGroup = visited.get(curr);
            Integer belong = currGroup == 0 ? 1 : 0;
            for (GraphNode neig : curr.neighbors) {
                if (!visited.containsKey(neig)) {
                    visited.put(neig, belong);
                    queue.offer(neig);
                } else {
                    if (visited.get(neig) == currGroup) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
