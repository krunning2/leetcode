public class TwoSum {
    Map<Integer, Integer> map;
    // Add the number to an internal data structure.
	public void add(int num) {
	    map = new HashMap<Integer, Integer>();
	    map.putIfAbsent(num, 1);
	    map.put(num, map.get(num) + 1);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    Iterator<Integer> it = map.keySet().iterator();
	    while(it.hasNext()){
	        int cur = it.next();
	        int val = map.get(cur);
	        int target = value - val;
	        if(!map.containsKey(target)){
	            return false;
	        } else {
	          if(cur == map.get(target) && map.get(target) > 1 || cur != map.get(target)){
	              return true;
	          }  
	          return false;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);