public class RandomizedCollection {
    Map<Integer, LinkedHashSet<Integer>> map;
    List<Integer> result;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        result = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean existed = map.containsKey(val);
        if(!existed){
            map.put(val, new LinkedHashSet<>());
        }
        map.get(val).add(result.size());
        result.add(val);
        return existed;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else{
            LinkedHashSet<Integer> value = map.get(val);
            int toBeRemoved = value.iterator().next();
            int lastValue = result.get(result.size() - 1);
            LinkedHashSet<Integer> lastValues = map.get(lastValue);
            if(toBeRemoved != result.size() - 1){
                result.set(toBeRemoved, lastValue);
                lastValues.remove(result.size() - 1);
                value.remove(toBeRemoved);
                lastValues.add(toBeRemoved);
                result.remove(result.size() - 1);
            }else{
                lastValues.remove(result.size() - 1);
                result.remove(result.size() - 1);
            }
            if(value.isEmpty()){
                map.remove(val);
            }
        }
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return result.get(random.nextInt(result.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */