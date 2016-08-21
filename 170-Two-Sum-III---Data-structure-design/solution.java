public class TwoSum {
    Map<Integer, Integer> map;
    // Add the number to an internal data structure.
	public void add(int number) {
	    map = new HashMap<>();
	    if(map.containsKey(number)){
	        map.put(number, 2);
	    }else{
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
	        int cur = entry.getKey();
	        if(map.containsKey(value - cur) && (map.get(value - cur) != cur || map.get(value - cur) == 2 && map.get(value - cur) == cur)){
	            return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);