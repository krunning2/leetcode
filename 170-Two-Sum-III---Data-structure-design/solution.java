public class TwoSum {
    Map<Integer, Integer> map = new HashMap<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    if(map.containsKey(number)){
	        map.put(number, 2);
	    }else{
	        map.put(number, 1);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for(Map.Entry<Integer, Integer> entry : map.entrySet()){
	        int num1 = entry.getKey();
	        int num2 = value - num1;
	        if(map.containsKey(num2) && (num2 != num1 || entry.getValue() == 2)){
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