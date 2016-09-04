We should start with each building and run a BFS to get the distances to each empty place.
1. keep counting the number of the buildings.
2. keep a matrix of counters for each empty places, each time reach an empty place, we need to increase the count;
3. keep a matrix of distances, each time we reach an empty place from a building, we need to add this distance.
4. after going through all the buildings, we need to find the shortest path from the distance matrix, which satisfies the count[i][j] == num.