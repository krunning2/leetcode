public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        LinkedList<String> res = new LinkedList<String>();
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ticket : tickets){
            map.putIfAbsent(ticket[0], new PriorityQueue<String>());
            map.get(ticket[0]).add(ticket[1]);
        }
        //DFS("JFK", res, map);
        Stack<String> stack = new Stack<>();
        stack.push("JFK");
        while(!stack.isEmpty()){
            while(map.get(stack.peek()) != null && !map.get(stack.peek()).isEmpty()){
                stack.push(map.get(stack.peek()).poll());
            }
            res.addFirst(stack.pop());
        }
        
        
        return res;
    }
    private void DFS(String departure, LinkedList<String> res, HashMap<String, PriorityQueue<String>> map){
        PriorityQueue<String> arrivals = map.get(departure);
        while(arrivals != null && !arrivals.isEmpty()){
            DFS(arrivals.poll(), res, map);
        }
        res.addFirst(departure);
    }
}