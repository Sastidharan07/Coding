//Question : https://leetcode.com/problems/minimum-cost-to-convert-string-ii/description/
import java.util.*;

public class Solution {
    private Map<String, Integer> indices;
    private List<List<Long>> costs;

    private void assignIndices(List<String> original, List<String> changed) {
        Set<String> distinctStrings = new HashSet<>(original);
        distinctStrings.addAll(changed);

        int index = 0;
        for (String str : distinctStrings) {
            indices.put(str, index++);
        }
    }

    private void buildGraph(List<String> original, List<String> changed, List<Integer> cost, Map<String, Integer> indices, List<List<Pair<Integer, Integer>>> graph) {
        int n = original.size();

        for (int i = 0; i < n; ++i) {
            int u = indices.get(original.get(i));
            int v = indices.get(changed.get(i));
            int w = cost.get(i);
            graph.get(u).add(new Pair<>(v, w));
        }
    }

    private List<Long> dijkstra(List<List<Pair<Integer, Integer>>> graph, int source, int n) {
        List<Long> dist = new ArrayList<>(Collections.nCopies(n, 1000000000000L));
        dist.set(source, 0L);

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(p -> -p.first));
        pq.add(new Pair<>(0, source));

        while (!pq.isEmpty()) {
            int u = pq.peek().second;
            int cost = -pq.peek().first;
            pq.poll();

            if (cost > dist.get(u)) continue;

            for (Pair<Integer, Integer> neighbor : graph.get(u)) {
                int v = neighbor.first;
                int edgeCost = neighbor.second;

                if (dist.get(u) + edgeCost < dist.get(v)) {
                    dist.set(v, dist.get(u) + edgeCost);
                    pq.add(new Pair<>(-dist.get(v).intValue(), v));
                }
            }
        }

        return dist;
    }

    private List<List<Long>> minCostMatrix(List<String> original, List<String> changed, List<Integer> cost) {
        assignIndices(original, changed);
        int n = indices.size();

        // Build graph with integer indices
        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }
        buildGraph(original, changed, cost, indices, graph);

        // Initialize cost matrix with all distances set to infinity
        List<List<Long>> costMatrix = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) {
            costMatrix.add(new ArrayList<>(Collections.nCopies(n, 1000000000000L)));
        }

        // Run Dijkstra's algorithm for each node
        for (int i = 0; i < n; ++i) {
            List<Long> distances = dijkstra(graph, i, n);

            // Update the cost matrix
            for (int j = 0; j < n; ++j) {
                costMatrix.get(i).set(j, distances.get(j));
            }
        }

        return costMatrix;
    }

    private long minCost(String source, String target) {
        int n = source.length();

        // Collect unique lengths present in the indices map
        Set<Integer> uniqueLengths = new HashSet<>(indices.size());
        for (Map.Entry<String, Integer> entry : indices.entrySet()) {
            uniqueLengths.add(entry.getKey().length());
        }

        // Initialize dp array
       
       List<Long> dp = new ArrayList<>(Collections.nCopies(n + 1, 1e12).stream().map(Double::longValue).collect(Collectors.toList()));


        // Base case: converting an empty string to an empty string costs 0
        dp.set(0, 0L);

        for (int i = 1; i <= n; ++i) {
            for (int len : uniqueLengths) {
                if (i - len >= 0) {
                    String substrSource = source.substring(i - len, i);
                    String substrTarget = target.substring(i - len, i);

                    if (substrSource.equals(substrTarget)) {
                        dp.set(i, Math.min(dp.get(i), dp.get(i - len)));
                    } else if (indices.containsKey(substrSource) && indices.containsKey(substrTarget)) {
                        int u = indices.get(substrSource);
                        int v = indices.get(substrTarget);
                        dp.set(i, Math.min(dp.get(i), dp.get(i - len) + costs.get(u).get(v)));
                    }
                }
            }
            if (source.charAt(i - 1) == target.charAt(i - 1))
                dp.set(i, Math.min(dp.get(i), dp.get(i - 1)));
        }

        return (dp.get(n) >= 1e12) ? -1 : dp.get(n);
    }

    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        indices = new HashMap<>();
        costs = minCostMatrix(Arrays.asList(original), Arrays.asList(changed), Arrays.stream(cost).boxed().collect(Collectors.toList()));
        return minCost(source, target);
    }

    // Pair class for simplicity
    static class Pair<A, B> {
        A first;
        B second;

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }
    }
}