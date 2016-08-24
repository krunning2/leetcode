BFS
Try to remove each parentheses if the current string is not valid. also keep a set to avoid the duplicates. if it is not present on the set then should push into the queue.
If at same level we find the valid string, then we shouldn't go further because it requires the minimum operation on deletion.


Time complicity is n * 2^n-1. each character has two states: 1. remove/remain

