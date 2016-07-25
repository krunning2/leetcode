public class TwoSum {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    // Add the number to an internal data structure.
	public void add(int num) {
	    if(map.containsKey(num)){
	        map.put(num, 2);
	    }else{
	        map.put(num, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    Iterator<Integer> it = map.keySet().iterator();
	    while(it.hasNext()){
	        int num1 = it.next();
	        int num2 = value - num1;
	        if(map.containsKey(num2) && (map.get(num2) > 1 || num1 != num2)){
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