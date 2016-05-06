Create a stack to save the characters (try to keep it with ascending order).
also keep a map to count the number of appearance of each number.
scan all the chars, each time decrease the counter by one of each chars.
if the top element is greater than current char and counter is greater than 0, which means this char will still appear later, then pop.
if current element is in the stack, just skip it.