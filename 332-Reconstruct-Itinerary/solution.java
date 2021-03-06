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
            PriorityQueue<String> arrivals = map.get(stack.peek());
            while(arrivals != null && !arrivals.isEmpty()){
                stack.push(arrivals.poll());
                // need to update the next arrivals
                arrivals = map.get(stack.peek());
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