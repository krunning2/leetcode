1. keep two maps, targetMap and sourceMap, and one counter.
2. Use two pointers, firstly, move one pointer to the position where it satisfies or the end, meanwhile increase value sourceMap for each key and increase the counter if ( ....).
3. then check the window size.
4. move the slow pointer and decrease the counter and the value of sourceMap

Solution two with one HashMap
1. use HashMap to store the number of each targeted character
2. keep two pointers window, moving j to satisfy the condition, then calculate the length.
3. keep a counter to count the remaining number of targeted characters.
4. VERY IMPORTANT 
    only decrease the total when map.get(char) > 0 when moving j
    only increase the total when map.get(char) >= 0 when moving i
    always increase/decrease counter for each character seen or removed.

e.g. bba, ab 