public class Solution {
    Map<String, PriorityQueue<String>> flights = new HashMap();
    LinkedList<String> path = new LinkedList();
    public List<String> findItinerary(String[][] tickets) {
        for (String[] oneway: tickets) {
            flights.putIfAbsent(oneway[0], new PriorityQueue());
            flights.get(oneway[0]).add(oneway[1]);
        }
        dfs("JFK");
        return path;
    }
    public void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) dfs(arrivals.poll());
        path.addFirst(departure);
    }
}