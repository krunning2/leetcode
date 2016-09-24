public class TwoSum {
    HashMap<Integer, Boolean> map = new HashMap<>();
    List<Integer> list = new ArrayList<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(map.containsKey(number)){
	        map.put(number, true);
	    }else{
	        map.put(number, false);
	        list.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(int x : list){
	        if(value - x == x){
	            if(map.containsKey(x) && map.get(x)) return true;
	        }else{
	            if(map.containsKey(value - x)) return true;
	        }
	    }
	    return false;
	}
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);