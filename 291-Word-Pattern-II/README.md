back tracking.
should have two cases : 
1. map.containsKey(cur) && map.get(cur).equals(sub) :  we shouldn't put into map and set.
2. !map.containsKey(cur) && !set.contains(sub) : we should put value into map and set, also to remove them when tracking back