public class Solution {
    
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap();
        LinkedList<String> path = new LinkedList();
        for (String[] oneway: tickets) {
            flights.putIfAbsent(oneway[0], new PriorityQueue());
            flights.get(oneway[0]).add(oneway[1]);
        }
        dfs("JFK", flights, path);
        return path;
    }
    public void dfs(String departure, Map<String, PriorityQueue<String>>flights, LinkedList<String> path) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()){
            dfs(arrivals.poll(), flights, path);
        }
        path.addFirst(departure);
    }
}